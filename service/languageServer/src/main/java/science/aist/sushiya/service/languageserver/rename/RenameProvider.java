/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.rename;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.ProviderHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the rename requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class RenameProvider implements Function<RenameParams, WorkspaceEdit> {
    private static final ProviderHelper HELPER = new ProviderHelper();

    @Override
    public WorkspaceEdit apply(RenameParams renameParams) {
        String renamingWord = HELPER.getName(FSHFileHandler.getInstance().getFile(renameParams.getTextDocument()),
                renameParams.getPosition());
        String newWord = renameParams.getNewName();

        WorkspaceEdit workspaceEdit = new WorkspaceEdit();
        Map<String,List<TextEdit>> changesMap = new HashMap<>();
        List<Location> locations = HELPER.getLocations(renamingWord,
                "((\\S|\\s)*\\s+|\\p{Punct})*" + renamingWord + "(\\s+(\\S|\\s)*|\\p{Punct})*");
        for (Location location : locations) {
            TextEdit textEdit = new TextEdit();
            textEdit.setNewText(newWord);
            textEdit.setRange(location.getRange());

            if(! changesMap.containsKey(location.getUri())){
                changesMap.put(location.getUri(), new ArrayList<>());
            }
            changesMap.get(location.getUri()).add(textEdit);
        }
        workspaceEdit.setChanges(changesMap);

        return workspaceEdit;
    }
}
