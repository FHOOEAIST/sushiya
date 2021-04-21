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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link InstanceOfCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class InstanceOfCompletionProviderTest {
    private static final InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
    private static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

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

        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

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
        String text = "InstanceOf: ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation2(){
        //given
        String text = "  InstanceOf: ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation3(){
        //given
        String text = "  InstanceOf  : ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testNoActivationWrongPosition() {
        //given
        String text = "InstanceOf: ";
        Position position = new Position(0,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationOutOfBound() {
        //given
        String text = "InstanceOf: ";
        Position position = new Position(1,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationEmptyText() {
        //given
        String text = "";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationIncorrectText() {
        //given
        String text = "test InstanceOf: ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetPosition() {
        //given
        String text = "InstanceOf: ";
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,null,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetContext() {
        //given
        String text = "InstanceOf: ";
        Position position = new Position(0,text.length());

        test(text,position,null,false);
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        String text = "InstanceOf: ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetTriggerCharacter() {
        //given
        String text = "InstanceOf: ";
        Position position = new Position(0,text.length());
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);

        test(text,position,completionContext,false);
    }

    @Test
    public void testActivationNoSetUri(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "InstanceOf: ";
        textDocumentItem.setText(text);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);


        //then
        //the uri does not affect the completion
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItems(){
        //given
        String text = "InstanceOf: "
                + "\n"
                + "Profile: Test";
        Position position = new Position(0,11);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),
                FHIRResources.getInstance().getAllBase().size()+
                        FHIRResources.getInstance().getAllClinical().size() +
                        1);
    }

    @Test
    public void testAmountCompletionItems2(){
        //given
        String text = "InstanceOf: \n"
                + "\n"
                + "Profile: Test\n"
                + "\n"
                + "Profile: Test2";
        Position position = new Position(0,11);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),
                FHIRResources.getInstance().getAllBase().size()+
                        FHIRResources.getInstance().getAllClinical().size() +
                        2);
    }
}
