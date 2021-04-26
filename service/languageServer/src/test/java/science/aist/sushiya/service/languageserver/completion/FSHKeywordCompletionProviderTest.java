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
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link FSHKeywordCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FSHKeywordCompletionProviderTest {
    private static final FSHKeywordCompletionProvider provider = new FSHKeywordCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testActivation(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = " ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

}
