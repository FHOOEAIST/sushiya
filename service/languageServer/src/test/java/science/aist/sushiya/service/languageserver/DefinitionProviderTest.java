package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.definition.DefinitionProvider;

import java.util.List;

/**
 * <p>Created by Sophie Bauernfeind on 08.04.2021</p>
 * <p>Test class for {@link DefinitionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class DefinitionProviderTest {
    static final DefinitionProvider provider = new DefinitionProvider();
    private Either<List<? extends Location>, List<? extends LocationLink>> result;
    private static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Test
    public void testNoSource(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,9);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }

    @Test
    public void testOneSource(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient\n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(6,9);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testNoSourceWrongPosition(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent:  \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,8);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }

    @Test
    public void testNoSourcePositionAtEndOfWord(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient\n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,14);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }

    @Test
    public void testNoSourcePositionAtStartOfWord(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient\n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,7);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }

    @Test
    public void testOneSourcePositionAtEndOfWord(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient\n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test\n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(6,11);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testOneSourcePositionAtStartOfWord(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient\n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest \n"
                + "Parent: Test\n"
                + "Id: test \n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(6,7);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testNoSourceInLineOpenRoundBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* subject = Reference(Patient or try or swhat | nndndn)\n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,12);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }

    @Test
    public void testNoSourceOtherOpenSquareBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* path[test]\n"
                + "* value 0..0 \n";

        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(profile1 + profile2);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,4);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertEquals(result.getLeft().size(),0);
    }
}
