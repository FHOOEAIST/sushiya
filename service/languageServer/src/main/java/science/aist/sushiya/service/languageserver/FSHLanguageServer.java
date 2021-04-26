/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/**
 * original Licenced by Apache Software Foundation (ASF)
 */

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package science.aist.sushiya.service.languageserver;

import at.fh.hagenberg.aist.seshat.Logger;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.WorkspaceService;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author lhein
 *
 * <p>This is the actual server implementation.</p>
 * <p>The server capabilites specify which features such as hover or autocompletion, will be supported by the server.</p>
 *
 * @author SophieBauernfeind - replaced "Camel" with "FSH"
 */

public class FSHLanguageServer extends AbstractLanguageServer implements LanguageServer, LanguageClientAware {
    private static final Logger LOGGER = Logger.getInstance(FSHLanguageServer.class);
    private LanguageClient client;

    public FSHLanguageServer() {
        super.setTextDocumentService(new FSHTextDocumentService(this));
        super.setWorkspaceService(new FSHWorkspaceService());
    }

    @Override
    public void connect(LanguageClient client) {
        this.client = client;
    }

    @Override
    public void exit() {
        super.stopServer();
        System.exit(0);
    }

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        Integer processId = params.getProcessId();
        if(processId != null) {
            setParentProcessId(processId.longValue());
        } else {
            LOGGER.info("Missing Parent process ID!!");
            setParentProcessId(0);
        }

        ServerCapabilities capabilities = createServerCapabilities();
        InitializeResult result = new InitializeResult(capabilities);
        return CompletableFuture.completedFuture(result);
    }

    /**
     * Which features will be supported by the server will be set here in the capabilities.
     * For each set capability the required function has the be implemented in the Workspace service or the TextDocument service,
     * to handle the incoming requests of the client.
     */
    private ServerCapabilities createServerCapabilities() {
        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Full);
        capabilities.setHoverProvider(Boolean.TRUE);
        capabilities.setDefinitionProvider(Boolean.TRUE);
        capabilities.setImplementationProvider(Boolean.TRUE);
        capabilities.setReferencesProvider(Boolean.TRUE);
        capabilities.setRenameProvider(Boolean.TRUE);
        capabilities.setDocumentFormattingProvider(Boolean.TRUE);
        capabilities.setCompletionProvider(new CompletionOptions(Boolean.TRUE, Arrays.asList(" ","[")));
        return capabilities;
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        super.shutdownServer();
        return CompletableFuture.completedFuture(new Object());
    }

    @Override
    public WorkspaceService getWorkspaceService() {
        return super.getWorkspaceService();
    }

    /**
     * Sends the given <code>show message notification</code> back to the client
     * as a notification
     *
     * @param type
     *            the type of message
     * @param msg
     *            The message to send back to the client
     */
    public void sendShowMessageNotification(final MessageType type, final String msg) {
        getClient().showMessage(new MessageParams(type, msg));
    }

    public LanguageClient getClient() {
        return client;
    }

    @Override
    public void initialized(InitializedParams params) {
        LOGGER.info("server and client are initialized.");
    }
}
