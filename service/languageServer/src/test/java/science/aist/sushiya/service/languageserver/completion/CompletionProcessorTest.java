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
 * <p>Test class for {@link CompletionProcessor}</p>
 *
 * @author Sophie Bauernfeind
 */
public class CompletionProcessorTest {
    private static final CompletionProcessor processor = new CompletionProcessor();
    private static final String uri = "testing";

    @Test
    public void testApply(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApply2(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(6,14);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyEmptyTextDocument(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoSetText(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyPositionOutOfBound(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(5,10);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoSetPosition(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoSetContext(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoSetContextTriggerKind(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoSetContextTriggerCharacter(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        params.setTextDocument(new TextDocumentIdentifier(textDocumentItem.getUri()));

        //then
        Assert.assertNotNull(processor.apply(params));
    }

    @Test
    public void testApplyNoFileSet(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter(" ");
        params.setContext(completionContext);

        //then
        Assert.assertNull(processor.apply(params));
    }
}
