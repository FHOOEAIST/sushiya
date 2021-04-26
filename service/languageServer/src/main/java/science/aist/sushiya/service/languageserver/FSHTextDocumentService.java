/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/**
 * <p>In this class most of the incoming requests of the clients are handled.</p>
 * <p>For each set capability of the server, the specific function has to be implemented, to process the requests.</p>
 *
 * @author SophieBauernfeind
 */

package science.aist.sushiya.service.languageserver;


import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import science.aist.sushiya.service.languageserver.completion.CompletionProcessor;
import science.aist.sushiya.service.languageserver.definition.DefinitionProvider;
import science.aist.sushiya.service.languageserver.diagnostic.DiagnosticProvider;
import science.aist.sushiya.service.languageserver.hover.HoverProvider;
import science.aist.sushiya.service.languageserver.implementation.ImplementationProvider;
import science.aist.sushiya.service.languageserver.references.ReferencesProvider;
import science.aist.sushiya.service.languageserver.rename.RenameProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {
    private final FSHLanguageServer fshLanguageServer;
    private final DiagnosticProvider diagnosticProvider;
    private static final Function<HoverParams, Hover>
            HOVER_PROVIDER = new HoverProvider();
    private static final Function<CompletionParams, Either<List<CompletionItem>, CompletionList>>
            COMPLETION_PROCESSOR = new CompletionProcessor();
    private static final Function<DefinitionParams, Either<List<? extends Location>, List<? extends LocationLink>>>
            DEFINITION_PROVIDER = new DefinitionProvider();
    private static final Function<ImplementationParams, Either<List<? extends Location>, List<? extends LocationLink>>>
            IMPLEMENTATION_PROVIDER = new ImplementationProvider();
    private static final Function<ReferenceParams, List<? extends Location>>
            REFERENCES_PROVIDER = new ReferencesProvider();
    private static final Function<RenameParams, WorkspaceEdit>
            RENAME_PROVIDER = new RenameProvider();

    public FSHTextDocumentService(FSHLanguageServer server) {
        this.fshLanguageServer = server;
        this.diagnosticProvider = new DiagnosticProvider(server);
    }

    public void didOpen(DidOpenTextDocumentParams params) {
        FSHFileHandler.getInstance().addFile(params);
        diagnosticProvider.compileAndSendDiagnostic(
                fshLanguageServer.getClient(),
                FSHFileHandler.getInstance().getFile(
                        new TextDocumentIdentifier(params.getTextDocument().getUri())
                ));
    }

    public void didChange(DidChangeTextDocumentParams params) {
        FSHFileHandler.getInstance().update(params);
        diagnosticProvider.compileAndSendDiagnostic(
                fshLanguageServer.getClient(),
                FSHFileHandler.getInstance().getFile(
                        new TextDocumentIdentifier(params.getTextDocument().getUri())
                ));
    }

    public void didClose(DidCloseTextDocumentParams params) {
        FSHFileHandler.getInstance().removeFile(params);
        diagnosticProvider.clear(params.getTextDocument().getUri());
    }

    public void didSave(DidSaveTextDocumentParams params) {
    }

    @Override
    public CompletableFuture<Hover> hover(HoverParams params) {
        return CompletableFuture.completedFuture(HOVER_PROVIDER.apply(params));
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {
        return CompletableFuture.completedFuture(COMPLETION_PROCESSOR.apply(params));
    }

    @Override
    public CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved) {
        return CompletableFuture.completedFuture(unresolved);
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(DefinitionParams params) {
        return CompletableFuture.completedFuture(DEFINITION_PROVIDER.apply(params));
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> implementation(ImplementationParams params) {
        return CompletableFuture.completedFuture(IMPLEMENTATION_PROVIDER.apply(params));
    }

    @Override
    public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
        return CompletableFuture.completedFuture(REFERENCES_PROVIDER.apply(params));
    }

    @Override
    public CompletableFuture<WorkspaceEdit> rename(RenameParams params) {
        return CompletableFuture.completedFuture(RENAME_PROVIDER.apply(params));
    }
}
