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
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;

import java.io.IOException;

/**
 * @author lhein
 *
 * <p>This is the base structure for the server.</p>
 *
 * @author SophieBauernfeind - replaced "Camel" with "FSH"
 */
public abstract class AbstractLanguageServer {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    private final class FSHServerRunnable implements Runnable {
        public void run() {
            LOGGER.info("Starting FSH Language Server...");
            while (!shutdown && parentProcessStillRunning() && !Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    LOGGER.info("Server is running...");
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                    Thread.currentThread().interrupt();
                }
            }
            if (!Thread.currentThread().isInterrupted()) {
                LOGGER.info("FSH Language Server - Client vanished...");
            }
        }
    }

    private static final Logger LOGGER = Logger.getInstance(AbstractLanguageServer.class);

    private Thread runner;
    private volatile boolean shutdown;
    private long parentProcessId;
    private WorkspaceService workspaceService;
    private TextDocumentService textDocumentService;

    /**
     * starts the language server process
     *
     * @return	the exit code of the process
     */
    public int startServer() {
        runner = new Thread(new FSHServerRunnable(), "FSH Language Client Watcher");
        runner.start();
        return 0;
    }

    /**
     * Checks whether the parent process is still running.
     * If not, then we assume it has crashed, and we have to terminate the FSH Language Server.
     *
     * @return true if the parent process is still running
     */
    protected boolean parentProcessStillRunning() {
        // Wait until parent process id is available

        if (parentProcessId == 0) {
            LOGGER.info("Waiting for a client connection...");
        } else {
            LOGGER.info("Checking for client process pid: {}", parentProcessId);
        }

        if (parentProcessId == 0) return true;

        String command;
        if (OS.indexOf("win") != -1) { // && "x86".equals(ARCH)
            command = "cmd /c \"tasklist /FI \"PID eq " + parentProcessId + "\" | findstr " + parentProcessId + "\"";
        } else {
            command = "ps -p " + parentProcessId;
        }
        try {
            Process process = Runtime.getRuntime().exec(command);
            int processResult = process.waitFor();
            return processResult == 0;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return true;
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
            return true;
        }
    }

    /**
     * stops the server
     */
    public void stopServer() {
        LOGGER.info("Stopping language server");
        if (runner != null) {
            runner.interrupt();
        } else {
            LOGGER.info("Request to stop the server has been received but it wasn't started.");
        }
    }

    /**
     * shuts the server down
     */
    public void shutdownServer() {
        LOGGER.info("Shutting down language server");
        shutdown = true;
    }

    /**
     * returns the parent process id
     *
     * @return	the parent process id
     */
    protected synchronized long getParentProcessId() {
        return parentProcessId;
    }

    /**
     * sets the parent process id
     *
     * @param processId	the process id
     */
    protected synchronized void setParentProcessId(long processId) {
        LOGGER.info("Setting client pid to {}", processId);
        parentProcessId = processId;
    }

    /**
     * @return the textDocumentService
     */
    public TextDocumentService getTextDocumentService() {
        return this.textDocumentService;
    }

    /**
     * @param textDocumentService the textDocumentService to set
     */
    protected void setTextDocumentService(TextDocumentService textDocumentService) {
        this.textDocumentService = textDocumentService;
    }

    /**
     * @return the workspaceService
     */
    protected WorkspaceService getWorkspaceService() {
        return this.workspaceService;
    }

    /**
     * @param workspaceService the workspaceService to set
     */
    protected void setWorkspaceService(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }
}