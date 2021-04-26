/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver;

import at.fh.hagenberg.aist.seshat.Logger;
import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.services.WorkspaceService;

/**
 * <p>Other requests/messages will be processed here.</p>
 *
 * @author SophieBauernfeind
 */

public class FSHWorkspaceService implements WorkspaceService {
    private static final Logger LOGGER = Logger.getInstance(FSHWorkspaceService.class);

    public void didChangeConfiguration(DidChangeConfigurationParams didChangeConfigurationParams) {
        LOGGER.info("SERVER: changeConfig");
    }

    public void didChangeWatchedFiles(DidChangeWatchedFilesParams didChangeWatchedFilesParams) {
        LOGGER.info("SERVER: changeWatchedFile");
    }
}
