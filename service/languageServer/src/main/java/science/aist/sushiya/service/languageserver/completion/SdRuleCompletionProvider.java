/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.CompletionTriggerKind;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>This is the provider for rules for profile and extensions.</p>
 *
 * @author SophieBauernfeind
 */
public class SdRuleCompletionProvider implements ICompletionProvider{
    private static final Logger LOGGER = LoggerFactory.getLogger(SdRuleCompletionProvider.class);
    private final List<CompletionItem> completionItems = new ArrayList<>();
    private final List<String> components = new ArrayList<>();
    private boolean newRule = false;
    private boolean rulePathDefined = false;
    private boolean cardRule = false;
    private boolean valueSetRule = false;
    private boolean fixedValueRule = false;
    private boolean insertRule = false;
    private boolean obeysRule = false;
    //simple version for flag rules and contain rules
    private boolean generalInRule = false;

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        if (newRule){
            //obeysRule
            completionItems.add(new CompletionItem("obeys"));
            //insertRule
            completionItems.add(new CompletionItem("insert"));
            completionItems.addAll(components
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }else if(insertRule){
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.RULESET)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }else if(obeysRule){
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.INVARIANT)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }else if (valueSetRule){
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.VALUESET)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
            completionItems.add(new CompletionItem("(example)"));
            completionItems.add(new CompletionItem("(preferred)"));
            completionItems.add(new CompletionItem("(extensible)"));
            completionItems.add(new CompletionItem("(required)"));
        }else if(rulePathDefined){
            //valueSetRule
            completionItems.add(new CompletionItem("units"));
            completionItems.add(new CompletionItem("from"));
            //containsRule
            completionItems.add(new CompletionItem("contains"));
            //onlyRule
            completionItems.add(new CompletionItem("only"));
            //obeysRule
            completionItems.add(new CompletionItem("obeys"));
            //caretValueRule
            completionItems.add(new CompletionItem("^"));
            //fixedValueRule
            completionItems.add(new CompletionItem("="));
        }else if(fixedValueRule){
            completionItems.add(new CompletionItem("(exactly)"));
        }else if(cardRule || generalInRule){
            //completions for flag rules, contain rules and card rules
            completionItems.add(new CompletionItem("?!"));
            completionItems.add(new CompletionItem("MS"));
            completionItems.add(new CompletionItem("SU"));
            completionItems.add(new CompletionItem("TU"));
            completionItems.add(new CompletionItem("N"));
            completionItems.add(new CompletionItem("D"));
            completionItems.add(new CompletionItem("and"));
            completionItems.add(new CompletionItem("named"));
        }
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkRuleConditions(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals(" ");
        }
        return false;
    }

    private boolean checkRuleConditions(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if(isRule(line) &&
                    (textDocumentItem.getText().contains("Extension")
                            || textDocumentItem.getText().contains("RuleSet")
                            || textDocumentItem.getText().contains("Profile"))){
                String[]lines = textDocumentItem.getText().split("\\n");

                components.clear();

                //check from current line above to the next empty line or the start of the text
                for(int linePos = completionParams.getPosition().getLine(); linePos >= 0 ; linePos --){
                    //safe components from contains rule for better completion
                    if(lines[linePos].contains("contains")){
                        String[]words = lines[linePos].split("\\s+");
                        for (int wordPos = 0; wordPos < words.length ; wordPos++){
                            if(words[wordPos].matches("contains") && wordPos != 0){
                                components.add(words[wordPos-1]);
                            }
                        }
                    }

                    if(lines[linePos].matches("\\s*")|| linePos == 0){

                        //check the first line or the line after the empty line for the keyword
                        int index = linePos == 0 ? 0 : linePos +1;

                        return lines[index].trim().matches("\\s*Extension\\s*:(\\s*|\\s+\\S+)\\s*")
                                || lines[index].trim().matches("\\s*Profile\\s*:(\\s*|\\s+\\S+)\\s*")
                                || lines[index].trim().matches("\\s*RuleSet\\s*:(\\s*|\\s+\\S+)\\s*");
                    }
                }
            }
        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean isRule(String line){
        newRule = line.matches("\\s*\\*\\s+");
        rulePathDefined = line.matches("\\s*\\*\\s+\\S+\\s+");
        cardRule = line.matches("\\s*\\*\\s+\\S+\\s+([0-9]+)?\\.\\.([0-9]+|\\*)?");
        valueSetRule = line.matches("\\s*\\*\\s+\\S+\\s+(units\\s+)?from\\s+(\\s|\\S)*");
        fixedValueRule = line.matches("\\s*\\*\\s+\\S+\\s+=\\s+\\S+\\s*");
        insertRule = line.matches("\\s*\\*\\s+insert\\s+");
        obeysRule = line.matches("\\s*\\*\\s+(obeys|\\S*\\s+obeys)\\s+");
        //simple version for flag rule & containsRule
        generalInRule = line.matches("\\s*\\*\\s+(\\S|\\s)*");
        return line.matches("\\s*\\*\\s+(\\s|\\S)*");
    }

    @Override
    public String toString() {
        return "SdRuleCompletionProvider";
    }
}
