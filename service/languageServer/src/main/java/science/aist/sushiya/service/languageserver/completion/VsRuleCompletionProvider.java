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
 * <p>This is the provider for the some valueSet rules.</p>
 *
 * @author SophieBauernfeind
 */
public class VsRuleCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(VsRuleCompletionProvider.class);
    private final List<CompletionItem> completionItems = new ArrayList<>();
    private List<String> definedAliases = new ArrayList<>();
    private boolean newRule = false;
    private boolean includeExcludeRule = false;
    private boolean valueSetRule = false;
    private boolean systemRule = false;
    private boolean insertRule = false;

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        if (newRule) {
            completionItems.add(new CompletionItem("include"));
            completionItems.add(new CompletionItem("exclude"));
            completionItems.add(new CompletionItem("insert"));
            completionItems.addAll(definedAliases.stream()
                    .map(name -> new CompletionItem(name.split("\\s")[0] + "#"))
                    .collect(Collectors.toList()));
        } else if (insertRule) {
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.RULESET)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        } else if (includeExcludeRule) {
            completionItems.add(new CompletionItem("codes from valueset"));
            completionItems.add(new CompletionItem("codes from system"));
        } else if (valueSetRule) {
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.VALUESET)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        } else if (systemRule) {
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.CODESYSTEM)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }
        return completionItems;
    }

    @Override
    //test if this provider is responsible. Only if this function returns true the List of Completion make sense for the completion.
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if (textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return ValueSetRules(textDocumentItem, completionParams)
                    //check if the trigger character is space, then this provider is responsible
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals(" ");
        }
        return false;
    }

    //check if the current entity is a Value Set. If it is a Value Set the completion provider is responsible.
    private boolean ValueSetRules(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try {
            definedAliases = FSHFileHandler.getInstance().getEntities(Entity.ALIAS, textDocumentItem);
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if (isRule(line)
                    && textDocumentItem.getText().contains("ValueSet")) {
                String[] lines = textDocumentItem.getText().split("\\n");
                //check from current line above to the next empty line or the start of the text
                for (int i = completionParams.getPosition().getLine(); i >= 0; i--) {
                    if (lines[i].matches("\\s*") || i == 0) {
                        //check the first line or the line after the empty line for the keyword
                        int index = i == 0 ? 0 : i + 1;
                        return lines[index].trim().matches("\\s*ValueSet\\s*:(\\s*|\\s+\\S+)\\s*");
                    }
                }
            }
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean isRule(String line) {
        newRule = line.matches("\\s*\\*\\s+");
        includeExcludeRule = line.matches("\\s*\\* (include|exclude)\\s*");
        systemRule = line.matches("\\s*\\* (include|exclude) codes from system\\s*");
        valueSetRule = line.matches("\\s*\\* (include|exclude) codes from valueset\\s*");
        insertRule = line.matches("\\s*\\*\\s+insert\\s+");
        return line.matches("\\s*\\*\\s+(\\s|\\S)*");
    }
}
