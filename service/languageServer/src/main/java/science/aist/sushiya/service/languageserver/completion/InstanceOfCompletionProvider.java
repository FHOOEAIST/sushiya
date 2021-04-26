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
 * <p>This is the provider for the entity 'InstanceOf'.</p>
 *
 * @author SophieBauernfeind
 */
public class InstanceOfCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = Logger.getInstance(InstanceOfCompletionProvider.class);
    private final List<CompletionItem> completionItems = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();

        //adding all Resources which are for sure used
        completionItems.addAll(FHIRResources.getInstance().getAllBase());
        completionItems.addAll(FHIRResources.getInstance().getAllClinical());
        completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE)
                .stream().map(CompletionItem::new).collect(Collectors.toList()));

        return completionItems.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkKeywordInstanceOf(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals(" ");
        }
        return false;
    }

    private boolean checkKeywordInstanceOf(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("InstanceOf:")
                    && line.lastIndexOf("InstanceOf:") < completionParams.getPosition().getCharacter()
                    && completionParams.getContext().getTriggerCharacter().equals(" ");

        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "InstanceOfCompletionProvider";
    }
}
