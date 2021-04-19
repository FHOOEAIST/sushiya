/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.diagnostic;

import org.antlr.v4.runtime.*;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.services.LanguageClient;
import science.aist.sushiya.service.languageserver.FSHLanguageServer;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHLexer;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHParser;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * <p>This class handles the syntax checking and manage the diagnostic from the error listener.</p>
 *
 * @author SophieBauernfeind
 */


public class DiagnosticProvider {
    private final FSHLanguageServer server;

    public DiagnosticProvider(FSHLanguageServer server) {
        this.server = server;
    }

    public void compileAndSendDiagnostic(LanguageClient client, @NotNull TextDocumentItem textDocument) {
        FSHErrorListener errorListener = new FSHErrorListener();

        CompletableFuture.runAsync(() -> {
            String text = textDocument.getText();
            CharStream input = CharStreams.fromString(text);
            FSHLexer lexer = new FSHLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FSHParser parser = new FSHParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            parser.doc();

            if (client == null || textDocument.getUri() == null) {
                return;
            }

            client.publishDiagnostics(new PublishDiagnosticsParams(textDocument.getUri(), errorListener.getDiagnostics()));
        });
    }

    public void clear(String uri) {
        server.getClient().publishDiagnostics(new PublishDiagnosticsParams(uri, Collections.emptyList()));
    }
}
