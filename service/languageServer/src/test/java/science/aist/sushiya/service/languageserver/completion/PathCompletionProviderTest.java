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
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link PathCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class PathCompletionProviderTest {
    private static final PathCompletionProvider provider = new PathCompletionProvider();
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
    public void testActivation() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationMoreEntities() {
        //given
        String text = "Profile: AnotherTest\n"
                + "\n"
                + "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(8,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);
    }

    @Test
    public void testActivationMoreContainsRules() {
        //given
        String text = "Profile: AnotherTest\n"
                + "\n"
                + "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * test contains tryout 0.*\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(9,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);
    }

    @Test
    public void testNoActivationWrongPosition() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,0);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationOutOfBound() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(9,20);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationEmptyText() {
        //given
        String text = "";
        Position position = new Position(0,0);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationIncorrectText() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " test  * identifier[]";
        Position position = new Position(6,19);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetPosition() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,null,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetContext() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(0,text.length());

        test(text,position,null,false);
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoSetTriggerCharacter() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);

        test(text,position,completionContext,false);
    }

    @Test
    public void testActivationNoSetUri(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        textDocumentItem.setText(text);

        CompletionParams params = new CompletionParams();
        Position position = new Position(6,14);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");
        params.setContext(completionContext);
        //when

        //then
        //the uri does not affect the completion
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItems() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),3);
    }

    @Test
    public void testAmountCompletionItemsOneItemNamed() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber named sn 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),3);
    }

    @Test
    public void testAmountCompletionItemsAllItemsNamed() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber named sn 0..1 and \n"
                + "     bPK named bp 0..* and \n"
                + "     localPatientId named lp 0..1 \n"
                + " * identifier[]";
        Position position = new Position(6,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,true);

        //then
        Assert.assertEquals(provider.get().size(),3);
    }

    @Test
    public void testNoActivationNoContainsRule() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier[]";
        Position position = new Position(2,14);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationWrongComponentName() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * testing[]";
        Position position = new Position(6,8);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }

    @Test
    public void testNoActivationNoComponentName() {
        //given
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * []";
        Position position = new Position(6,4);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");

        test(text,position,completionContext,false);
    }
}
