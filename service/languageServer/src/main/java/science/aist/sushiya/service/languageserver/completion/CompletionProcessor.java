/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>For a better structure of the server, the completion requests will be handled here.</p>
 * <p>The CompletionProcessor has a collection of different CompletionProvider.</p>
 * <p>Each CompletionProvider, provides a different list of CompletionItems for a special case.</p>
 *
 * @author SophieBauernfeind
 */
public class CompletionProcessor implements Function<CompletionParams, Either<List<CompletionItem>, CompletionList>> {
    private static final List<ICompletionProvider> COMPLETION_PROVIDERS = new ArrayList<>();
    private static final ICompletionProvider DEFAULT_PROVIDER = new FSHKeywordCompletionProvider();
    private static final Logger LOGGER = LoggerFactory.getLogger(CompletionProcessor.class);

    public CompletionProcessor() {
        COMPLETION_PROVIDERS.add(new AliasCompletionProvider());
        COMPLETION_PROVIDERS.add(new CsRuleCompletionProvider());
        COMPLETION_PROVIDERS.add(new EntityAndMetadataCompletionProvider());
        COMPLETION_PROVIDERS.add(new InstanceOfCompletionProvider());
        COMPLETION_PROVIDERS.add(new MappingEntityRuleCompletionProvider());
        COMPLETION_PROVIDERS.add(new ParentCompletionProvider());
        COMPLETION_PROVIDERS.add(new PathCompletionProvider());
        COMPLETION_PROVIDERS.add(new SourceCompletionProvider());
        COMPLETION_PROVIDERS.add(new VsRuleCompletionProvider());
        COMPLETION_PROVIDERS.add(new SdRuleCompletionProvider());
    }

    @Override
    public Either<List<CompletionItem>, CompletionList> apply(CompletionParams completionParams) {
        List<List<CompletionItem>> completionItems = new ArrayList<>();
        if (completionParams.getTextDocument() == null) {
            return null;
        }
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(completionParams.getTextDocument());
        for (ICompletionProvider cp : COMPLETION_PROVIDERS) {
            if (cp.test(textDocument, completionParams)) {
                completionItems.add(cp.get());
                LOGGER.info("completion provider {} activated.", cp.toString());
            }
        }
        //if no other completion provider is in charge use default provider
        if (completionItems.isEmpty()) {
            completionItems.add(DEFAULT_PROVIDER.get());
            //add names of defined profiles or extensions, which are also often used
            completionItems.add(FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
            completionItems.add(FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }
        return Either.forLeft(completionItems.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));
    }
}
