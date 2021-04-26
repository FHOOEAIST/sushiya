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

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public interface ICompletionProvider extends Supplier<List<CompletionItem>>, BiPredicate<TextDocumentItem, CompletionParams> {

}
