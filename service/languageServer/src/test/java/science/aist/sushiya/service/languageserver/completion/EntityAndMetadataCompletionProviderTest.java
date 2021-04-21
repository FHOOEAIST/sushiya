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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link EntityAndMetadataCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class EntityAndMetadataCompletionProviderTest {
    private static final EntityAndMetadataCompletionProvider provider = new EntityAndMetadataCompletionProvider();
    private static final String uri = "testing";

    @Parameters({"text", "position", "completionContext", "expectedActivation"})
    public void test(String text, Position position, CompletionContext completionContext, boolean expectedActivation){
        //when
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        CompletionParams params = new CompletionParams();
        if(position != null){
            params.setPosition(position);
        }if(completionContext != null){
            params.setContext(completionContext);
        }

        //then
        if(expectedActivation){
            Assert.assertTrue(provider.test(textDocument,params));
        }else{
            Assert.assertFalse(provider.test(textDocument,params));
        }
    }

    @Test
    public void testActivation1(){
        //given
        String text = "Al";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation2(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        Position position = new Position(2,5);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationEmptyText(){
        //given
        String text = "";
        Position position = new Position(0,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);

        test(text,position,completionContext,true);
    }

    @Test
    public void testNoActivationOutOfBound(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        Position position = new Position(2,20);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetPosition(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);

        test(text,null,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetContext(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        Position position = new Position(2,text.length());

        test(text,position,null,false);
    }

    @Test
    public void testNoActivationNoSetTriggerKind(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        Position position = new Position(2,text.length());
        CompletionContext completionContext = new CompletionContext();

        test(text,position,completionContext,false);
    }
}
