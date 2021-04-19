/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.references;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.List;

/**
 * <p>Created by Sophie Bauernfeind on 08.04.2021</p>
 * <p>Test class for {@link ReferencesProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class ReferenceProviderTest {
    static final ReferencesProvider provider = new ReferencesProvider();
    private List<? extends Location> result;
    private static final String uri = "testing";
    private static final String textReference =
                    "Profile: Test \n"
                    + "Parent: Patient \n"
                    + "Id: Test \n"
                    + "* value 0..0 \n"
                    + "\n"
                    + "Profile: AnotherTest\n"
                    + "Parent: Test \n"
                    + "Id: Test \n"
                    + "* value 0..0 \n";
    private static final String textNoReference =
                    "Profile: Test\n"
                    + "Parent: Patient \n"
                    + "Id: Nr \n"
                    + "* value 0..0 \n"
                    + "\n"
                    + "Profile: Example\n"
                    + "Parent: Try \n"
                    + "Id: Nr \n"
                    + "* value 0..0 \n";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Parameters({"text"})
    public void prepareForTest(String text){
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);
    }

    @Test
    public void testNoOtherReference(){
        //given
        prepareForTest(textNoReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(5,10);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void testReferences(){
        //given
        prepareForTest(textReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,10);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),4);
    }

    @Test
    public void testReferencesOtherFiles(){
        //given
        //prepare first file, where the position is set to a
        //word where the other file have references
        prepareForTest(textNoReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,10);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //create the other file, where the references can get from
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(textReference);
        textDocument.setUri("secondFile");
        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),5);
    }

    @Test
    public void testNoReferenceWrongPosition(){
        //given
        prepareForTest(textReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(4,0);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertNull(result);
    }

    @Test
    public void testNoOtherReferencesPositionAtEndOfWord(){
        //given
        prepareForTest(textNoReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,12);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),1);
    }

    @Test
    public void testNoOtherReferencesPositionAtStartOfWord(){
        //given
        prepareForTest(textNoReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,9);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),1);
    }

    @Test
    public void testReferencesPositionAtEndOfWord(){
        //given
        prepareForTest(textReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,12);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),4);
    }

    @Test
    public void testReferencesPositionAtStartOfWord(){
        //given
        prepareForTest(textReference);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(0,9);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),4);
    }

    @Test
    public void testNoSourceInLineOpenRoundBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Testing \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* subject = Reference(Patient)\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(8,13);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),1);
    }

    @Test
    public void testNoSourceInLineRoundBrackets(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Testing \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* subject = Reference(Patient)\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(8,21);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(),1);
    }

    @Test
    public void testNoSourceInLineOpenSquareBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* path[try]\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(8,4);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void testNoSourceInLineSquareBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* path[try]\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ReferenceParams refParams = new ReferenceParams();
        Position position = new Position(8,7);
        refParams.setPosition(position);
        refParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(refParams);

        // then
        Assert.assertEquals(result.size(), 1);
    }
}
