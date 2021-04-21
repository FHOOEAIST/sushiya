/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>One sample of a completion provider for the language server.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class FSHKeywordCompletionProvider implements ICompletionProvider {
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public FSHKeywordCompletionProvider() {
        completionItems.add(new CompletionItem("alias"));
        completionItems.add(new CompletionItem("profile"));
        completionItems.add(new CompletionItem("instance"));
        completionItems.add(new CompletionItem("invariant"));
        completionItems.add(new CompletionItem("ruleset"));
        completionItems.add(new CompletionItem("mapping"));
        completionItems.add(new CompletionItem("id"));
        completionItems.add(new CompletionItem("title"));
        completionItems.add(new CompletionItem("description"));
        completionItems.add(new CompletionItem("expression"));
        completionItems.add(new CompletionItem("xPath"));
        completionItems.add(new CompletionItem("severity"));
        completionItems.add(new CompletionItem("usage"));
        completionItems.add(new CompletionItem("source"));
        completionItems.add(new CompletionItem("target"));
        completionItems.add(new CompletionItem("from"));
        completionItems.add(new CompletionItem("example"));
        completionItems.add(new CompletionItem("preferred"));
        completionItems.add(new CompletionItem("extensible"));
        completionItems.add(new CompletionItem("required"));
        completionItems.add(new CompletionItem("contains"));
        completionItems.add(new CompletionItem("named"));
        completionItems.add(new CompletionItem("and"));
        completionItems.add(new CompletionItem("only"));
        completionItems.add(new CompletionItem("or"));
        completionItems.add(new CompletionItem("obeys"));
        completionItems.add(new CompletionItem("true"));
        completionItems.add(new CompletionItem("false"));
        completionItems.add(new CompletionItem("include"));
        completionItems.add(new CompletionItem("exclude"));
        completionItems.add(new CompletionItem("codes"));
        completionItems.add(new CompletionItem("where"));
        completionItems.add(new CompletionItem("valueset"));
        completionItems.add(new CompletionItem("system"));
        completionItems.add(new CompletionItem("units"));
        completionItems.add(new CompletionItem("exactly"));
        completionItems.add(new CompletionItem("insert"));
        completionItems.add(new CompletionItem("reference"));
        completionItems.add(new CompletionItem("extension"));
        completionItems.add(new CompletionItem("code"));
        completionItems.add(new CompletionItem("value"));
    }

    @Override
    public List<CompletionItem> get() {
        return completionItems;
    }

    //default completion provider
    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return true;
    }

    @Override
    public String toString() {
        return "FSHKeywordCompletionProvider";
    }
}
