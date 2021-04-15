package science.aist.sushiya.service.languageserver.formatting;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.List;

/**
 * <p>Created by Sophie Bauernfeind on 13.04.2021</p>
 * <p>Test class for {@link FormattingProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FormattingProviderTest {
    static final FormattingProvider provider = new FormattingProvider();
    static final String uri = "testing";
    private List<? extends TextEdit> result;

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Parameters({"text"})
    public void changeTest(String text){
        //given
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DocumentFormattingParams formattingParams = new DocumentFormattingParams();
        formattingParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(formattingParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 1);
        Assert.assertNotEquals(result.get(0).getNewText(),text);
    }

    @Parameters({"text"})
    public void noChangeTest(String text){
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DocumentFormattingParams formattingParams = new DocumentFormattingParams();
        formattingParams.setTextDocument(new TextDocumentIdentifier(uri));

        //when
        result = provider.apply(formattingParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0).getNewText(),text);
    }

    @Test
    public void testExtension(){
        //given
        String text = "Extension: Test ";
        noChangeTest(text);
    }

    @Test
    public void testExtensionStartWithSpace(){
        //given
        String text = "    Extension: Test";
        changeTest(text);
    }

    @Test
    public void testExtensionEndsWithSpace(){
        //given
        String text = "Extension: Test ";
        noChangeTest(text);
    }

    @Test
    public void testProfileStartWithSpace(){
        //given
        String text = " Profile: Test";
        changeTest(text);
    }

    @Test
    public void testProfileEndsWithSpace(){
        //given
        String text = "Profile: Test ";
        noChangeTest(text);
    }

    @Test
    public void testParentStartWithSpace(){
        //given
        String text = " Parent: Test";
        changeTest(text);
    }

    @Test
    public void testParentEndsWithSpace(){
        //given
        String text = "Parent: Test   ";
        changeTest(text);
    }

    @Test
    public void testSourceStartWithSpace(){
        //given
        String text = " Source: Test";
        changeTest(text);
    }

    @Test
    public void testSourceEndsWithSpace(){
        //given
        String text = "Source: Test   ";
        changeTest(text);
    }

    @Test
    public void testRule(){
        //given
        String text = "* Test";
        changeTest(text);
    }

    @Test
    public void testRuleStartWithSpace(){
        //given
        String text = " * Test";
        changeTest(text);
    }

    @Test
    public void testRuleEndsWithSpace(){
        //given
        String text = "* Test   ";
        changeTest(text);
    }

    @Test
    public void testInstanceEntity(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "InstanceOf: TestPatient \n"
                + "Usage: #inline \n"
                + "* name.given[0] = \"Eve\"\n "
                + "* name.family = \"Anyperson\" ";
        changeTest(text);
    }
    //TODO:write correct test

    @Test
    public void testCommentInEntity(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "InstanceOf: TestPatient \n"
                + "Usage: #inline \n"
                + "//just a test\n"
                + "* name.given[0] = \"Eve\"\n "
                + "* name.family = \"Anyperson\" ";
    }

    @Test
    public void testBlockCommentInEntity(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "InstanceOf: TestPatient \n"
                + "Usage: #inline \n"
                + "/*just \na\n test\n*/"
                + "* name.given[0] = \"Eve\"\n "
                + "* name.family = \"Anyperson\" ";
    }

    @Test
    public void testBlockCommentInEntityOneLine(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "InstanceOf: TestPatient \n"
                + "Usage: #inline \n"
                + "/*just a test*/"
                + "* name.given[0] = \"Eve\"\n "
                + "* name.family = \"Anyperson\" ";
    }
}
