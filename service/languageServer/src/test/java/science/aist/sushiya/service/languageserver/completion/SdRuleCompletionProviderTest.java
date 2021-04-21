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
 * <p>Test class for {@link SdRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class SdRuleCompletionProviderTest {
    private static final SdRuleCompletionProvider provider = new SdRuleCompletionProvider();
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
    public void testActivationProfileNewRule() {
        //given
        String text = "Profile: Test \n"
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
    public void testActivationProfileStartedRule() {
        //given
        String text = "Profile: Test\n"
                + " Title: \n"
                + " Description: \n"
                + "  * path ";
        Position position = new Position(3,9);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationProfileInRule() {
        //given
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path and more";
        Position position = new Position(3,19);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationExtensionNewRule() {
        //given
        String text = "Extension: Test \n"
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
    public void testActivationExtensionStartedRule() {
        //given
        String text = "Extension: Test\n"
                + " Title: \n"
                + " Description: \n"
                + "  * path ";
        Position position = new Position(3,9);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationExtensionInRule() {
        //given
        String text = "Extension: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path and more";
        Position position = new Position(3,19);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationRuleSetNewRule() {
        //given
        String text = "RuleSet: Test \n"
                + "  * ";
        Position position = new Position(1,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationRuleSetStartedRule() {
        //given
        String text = "RuleSet: Test\n"
                + "  * path ";
        Position position = new Position(1,9);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationRuleSetInRule() {
        //given
        String text = "RuleSet: Test\n"
                + "  * path and more ";
        Position position = new Position(1,19);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
    }

    @Test
    public void testNoActivationOutOfBound() {
        //given
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(5,20);
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
    public void testNoActivationIncorrectText() {
        //given
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "test  * ";
        Position position = new Position(3,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetPosition() {
        //given
        String text = "Profile: \n"
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
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,4);

        test(text,position,null,false);
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetTriggerCharacter() {
        //given
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);

        test(text,position,completionContext,false);
    }

    @Test
    public void testActivationNoSetUri() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        //when

        //then
        //the uri does not affect the completion
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItemsNewRule() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        Position position = new Position(3,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }

    @Test
    public void testAmountCompletionInsertRule() {
        //given
        String text = "RuleSet: AnotherTest\n"
                + "\n"
                + "Profile: Test \n"
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
    public void testAmountCompletionPathDefined() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path ";
        Position position = new Position(3,11);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),7);
    }

    @Test
    public void testAmountCompletionValueSetRule() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path from ";
        Position position = new Position(3,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);
        //then
        Assert.assertEquals(provider.get().size(),4);
    }

    @Test
    public void testAmountCompletionValueSetRuleDefinedValueSet() {
        //given
        String text = "ValueSet: AnotherTest \n"
                + "\n"
                + "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path from ";
        Position position = new Position(5,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),5);
    }

    @Test
    public void testAmountCompletionFixedValueRule() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * value = value ";
        Position position = new Position(3,18);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionOtherRule() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path 1..* ";
        Position position = new Position(3,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),8);
    }

    @Test
    public void testAmountCompletionObeysRuleOnlyKeyword() {
        //given
        String text = "Invariant: AnotherTest\n"
                + "\n"
                + "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * obeys ";
        Position position = new Position(5,10);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionObeysRuleWithDefinedPath() {
        //given
        String text = "Invariant: AnotherTest\n"
                + "\n"
                + "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path obeys ";
        Position position = new Position(5,15);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionObeysRuleEmpty() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * obeys ";
        Position position = new Position(3,10);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),0);
    }

    @Test
    public void testAmountCompletionNewRuleWithContainsRule() {
        //given
        String text = "Profile: Test \n"
                + " Title: \n"
                + " Description: \n"
                + " * test contains tryout 0..*\n"
                + " * ";
        Position position = new Position(4,3);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),3);
    }
}
