package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.references.ReferencesProvider;

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
}
