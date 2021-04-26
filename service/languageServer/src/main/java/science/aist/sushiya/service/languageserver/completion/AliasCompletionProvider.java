/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.completion;

import at.fh.hagenberg.aist.seshat.Logger;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.CompletionTriggerKind;
import org.eclipse.lsp4j.TextDocumentItem;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>This is the completion provider for the entity 'alias'.</p>
 * <p>It contains common used aliases.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class AliasCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = Logger.getInstance(AliasCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();

        completionItems.add(new CompletionItem("LNC = http://loinc.org"));
        completionItems.add(new CompletionItem("SCT = http://snomed.info/sct"));
        completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS)
                .stream().map(CompletionItem::new).collect(Collectors.toList()));

        return completionItems.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null){
            return checkKeywordAlias(textDocumentItem,completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals(" ");
        }
        return false;
    }

    private boolean checkKeywordAlias(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("Alias:")
                    && line.lastIndexOf("Alias:") < completionParams.getPosition().getCharacter();

        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "AliasCompletionProvider";
    }
}
