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
 * <p>Test class for {@link VsRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class VsRuleCompletionProviderTest {
    private static final VsRuleCompletionProvider provider = new VsRuleCompletionProvider();
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
    public void testActivation1() {
        //given
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation2() {
        //given
        String text = "  ValueSet: Test\n"
                + " Title: \n"
                + " Description: \n"
                + "  * insert ";
        Position position = new Position(3,11);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation3() {
        //given
        String text = "  ValueSet  : \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        Position position = new Position(3,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivation4() {
        //given
        String text = "  ValueSet  : \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        Position position = new Position(3,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationNewRule() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationInRuleInclude() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        Position position = new Position(5,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationInRuleIncludeMoreWords() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from valueset ";
        Position position = new Position(5,32);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationInRuleExclude() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        Position position = new Position(5,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationInRuleExcludeMoreWords() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude codes from system ";
        Position position = new Position(5,32);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testNoActivationNoValueSet() {
        //given
        String text = "Test \n"
                + "\n"
                + " Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationIncorrectText() {
        //given
        String text = "Test \n"
                + "\n"
                + " testing ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(0,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationEmptyText() {
        //given
        String text = "";
        Position position = new Position(0,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetPosition() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,null,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetContext() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);

        test(text,position,null,false);
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetTriggerCharacter() {
        //given
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);

        test(text,position,completionContext,false);
    }

    @Test
    public void testActivationNoSetUri() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(3,3);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItemsNewRule() {
        //given
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,3);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),3);
    }

    @Test
    public void testAmountCompletionInsertRule() {
        //given
        String text = "RuleSet: AnotherTest\n"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * insert ";
        Position position = new Position(5,11);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionItemsNewRuleDefinedAlias() {
        //given
        String text = "Alias: AnotherTest = testing\n"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),4);
    }

    @Test
    public void testAmountCompletionItemsStartedRuleInclude() {
        //given
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        Position position = new Position(3,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }

    @Test
    public void testAmountCompletionItemsStartedRuleExclude() {
        //given
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        Position position = new Position(3,12);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }

    @Test
    public void testAmountCompletionItemsValueSet() {
        //given
        String text = "ValueSet: Test2"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from valueset ";
        Position position = new Position(5,32);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }

    @Test
    public void testAmountCompletionItemsCodeSystem() {
        //given
        String text = "CodeSystem: Test2\n"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from system ";
        Position position = new Position(5,34);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }
}
