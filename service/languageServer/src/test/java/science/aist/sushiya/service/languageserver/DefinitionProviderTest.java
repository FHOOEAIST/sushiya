package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
    private static final String text =
                    "Profile: Test\n"
                    + "Parent: Patient \n"
                    + "Id: test \n"
                    + "* value 0..0 \n"
                    + "\n"
                    + "Profile: AnotherTest\n"
                    + "Parent: Test \n"
                    + "Id: test \n"
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
    public void testNoSource(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,9);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testOneSource(){
        //given
        prepareForTest(text);

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
        prepareForTest(text);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(4,0);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testNoSourcePositionAtEndOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,14);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testNoSourcePositionAtStartOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(1,7);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testOneSourcePositionAtEndOfWord(){
        //given
        prepareForTest(text);

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
        prepareForTest(text);

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
                + "* subject = Reference(Patient)\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,13);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testNoSourceInLineRoundBrackets(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
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
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,21);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
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
                + "* path[test]\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,4);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testNoSourceInLineSquareBrackets(){
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
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        DefinitionParams defParams = new DefinitionParams();
        Position position = new Position(8,7);
        defParams.setPosition(position);
        defParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(defParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }
}
