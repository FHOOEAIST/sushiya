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


/**
 * this is the actual server implementation
 *
 * @author lhein
 *
 * @author SophieBauernfeind - replaced "Camel" with "FSH"
 */

package science.aist.sushiya.languageserver;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHTextDocumentService;
import science.aist.sushiya.service.languageserver.FSHWorkspaceService;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class FSHLanguageServer extends AbstractLanguageServer implements LanguageServer, LanguageClientAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(FSHLanguageServer.class);

    private LanguageClient client;

    public FSHLanguageServer() {
        super.setTextDocumentService(new FSHTextDocumentService());
        super.setWorkspaceService(new FSHWorkspaceService(getTextDocumentService()));
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
        if(CompletableFuture.completedFuture(result).isDone()) {
            LOGGER.info("THE VALUE IS DONE");
        }else {
            LOGGER.info("THE VALUE IS NOT DONE");
        }
        return CompletableFuture.completedFuture(result);
    }

    private ServerCapabilities createServerCapabilities() {
        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Full);
        capabilities.setHoverProvider(Boolean.TRUE);
        capabilities.setCompletionProvider(new CompletionOptions());
        capabilities.setCodeActionProvider(new CodeActionOptions(Arrays.asList(CodeActionKind.QuickFix)));
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
