package science.aist.sushiya.service.languageserver.implementation;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.List;

/**
 * <p>Created by Sophie Bauernfeind on 08.04.2021</p>
 * <p>Test class for {@link ImplementationProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class ImplementationProviderTest {
    static final ImplementationProvider provider = new ImplementationProvider();
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
    public void testNoImplementation(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(5,10);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testOneImplementation(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(0,10);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testOneImplementationOtherFiles(){
        //given
        String firstText = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n";
        prepareForTest(firstText);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(0,10);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        String secondText = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* value 0..0 \n";
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(secondText);
        textDocument.setUri("secondFile");

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testNoImplementationWrongPosition(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(4,0);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertNull(result.getLeft());
        Assert.assertNull(result.getRight());
    }

    @Test
    public void testOneImplementationPositionAtEndOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(0,12);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testOneImplementationPositionAtStartOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(0,9);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(),1);
    }

    @Test
    public void testNoImplementationPositionAtStartOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(5,9);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testNoImplementationPositionAtEndOfWord(){
        //given
        prepareForTest(text);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(5,19);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testNoImplementationInLineOpenRoundBracket(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* subject = Reference(Try)\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(8,13);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testNoImplementationInLineRoundBrackets(){
        //given
        String profile1 = "Profile: Test\n"
                + "Parent: Patient \n"
                + "Id: test \n"
                + "* value 0..0 \n"
                + "\n";
        String profile2 = "Profile: AnotherTest\n"
                + "Parent: Test \n"
                + "Id: test \n"
                + "* subject = Reference(Try)\n"
                + "* value 0..0 \n";
        prepareForTest(profile1+profile2);

        //generate parameter to call the provider
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(8,21);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testNoImplementationInLineOpenSquareBracket(){
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
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(8,4);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }

    @Test
    public void testNoImplementationInLineSquareBrackets(){
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
        ImplementationParams implParams = new ImplementationParams();
        Position position = new Position(8,7);
        implParams.setPosition(position);
        implParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(implParams);

        // then
        Assert.assertEquals(result.getLeft().size(), 0);
    }
}
