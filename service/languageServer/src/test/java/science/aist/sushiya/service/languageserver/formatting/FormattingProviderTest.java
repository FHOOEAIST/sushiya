package science.aist.sushiya.service.languageserver.formatting;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(FormattingProviderTest.class);
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

        String[] newTextLines = result.get(0).getNewText().split("\n");
        String[] originalTextLines = text.split("\n");

        Assert.assertEquals(newTextLines.length, originalTextLines.length);
        boolean containsOneNotEqual = false;
        for (int linePos = 0; linePos < newTextLines.length && !containsOneNotEqual; linePos++){
            containsOneNotEqual = ! originalTextLines[linePos].equals(newTextLines[linePos]);
        }
        Assert.assertTrue(containsOneNotEqual);
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

        String[] newTextLines = result.get(0).getNewText().split("\n");
        String[] originalTextLines = text.split("\n");
        LOGGER.info("original:{}",text);
        LOGGER.info("newtest2:{}",result.get(0).getNewText());

        Assert.assertEquals(newTextLines.length, originalTextLines.length);
        for (int linePos = 0; linePos < newTextLines.length; linePos++){
            Assert.assertEquals(originalTextLines[linePos] ,newTextLines[linePos]);
        }
    }

    @Test
    public void testExtension(){
        //given
        String text = "Extension: Test \n";
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

    @Test
    public void testCommentInEntity(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "\tInstanceOf: TestPatient \n"
                + "\tUsage: #inline \n"
                + "\t//just a test \n"
                + "\t* name.given[0] = \"Eve\" \n"
                + "\t* name.family = \"Anyperson\" ";
        noChangeTest(text);
    }

    @Test
    public void testTwoCommentInEntity(){
        //given
        String originalText = "Instance: EveAnyperson \n"
                + "\tInstanceOf: TestPatient \n"
                + "\tUsage: #inline \n"
                + "\t//just a test \n"
                + "\t* name.given[0] = \"Eve\" \n"
                + "\t//another test \n"
                + "\t* name.family = \"Anyperson\" \n";
        noChangeTest(originalText);
    }

    @Test
    public void testBlockCommentInEntity(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "\tInstanceOf: TestPatient \n"
                + "\tUsage: #inline \n"
                + "\t/*just\n"
                + "\ta \n"
                + "\ttest\n"
                + "\t*/\n"
                + "\t* name.given[0] = \"Eve\" \n"
                + "\t* name.family = \"Anyperson\" \n";
        noChangeTest(text);
    }

    @Test
    public void testBlockCommentInEntityOneLine(){
        //given
        String text = "Instance: EveAnyperson \n"
                + "\tInstanceOf: TestPatient \n"
                + "\tUsage: #inline \n"
                + "\t/*just a test*/\n"
                + "\t* name.given[0] = \"Eve\" \n"
                + "\t* name.family = \"Anyperson\" \n";
        noChangeTest(text);
    }

    @Test
    public void testInstance(){
        //given
        String originalText = "Instance: EveAnyperson \n" +
                "InstanceOf: TestPatient \n" +
                "Usage: #inline \n" +
                "// #inline means this instance should not be exported as a separate example \n" +
                "* name.given[0] = \"Eve\" \n" +
                "* name.family = \"Anyperson\" \n";
        changeTest(originalText);
    }

    @Test
    public void testValueSet(){
        //given
        String originalText = "ValueSet: BodyWeightPreconditionVS \n" +
                "Title: \"Body weight preconditions.\" \n" +
                "Description:  \"Circumstances for body weight measurement.\" \n" +
                "* SCT#971000205103 \"Wearing street clothes with shoes\" \n" +
                "* SCT#961000205106 \"Wearing street clothes, no shoes\" \n" +
                "* SCT#951000205108 \"Wearing underwear or less\" \n";
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(originalText);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        DocumentFormattingParams formattingParams = new DocumentFormattingParams();
        formattingParams.setTextDocument(new TextDocumentIdentifier(uri));

        String expectingText = "ValueSet: BodyWeightPreconditionVS \n" +
                "\tTitle: \"Body weight preconditions.\" \n" +
                "\tDescription:  \"Circumstances for body weight measurement.\" \n" +
                "\t* SCT#971000205103 \"Wearing street clothes with shoes\" \n" +
                "\t* SCT#961000205106 \"Wearing street clothes, no shoes\" \n" +
                "\t* SCT#951000205108 \"Wearing underwear or less\" \n";

        //when
        result = provider.apply(formattingParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 1);

        String[] newTextLines = result.get(0).getNewText().split("\n");
        String[] expectingTextLines = expectingText.split("\n");

        Assert.assertEquals(newTextLines.length,expectingTextLines.length);
        for (int linePos = 1; linePos < newTextLines.length && linePos < expectingTextLines.length; linePos++){
            LOGGER.info("expectedTextLine:{}",newTextLines[linePos]);
            LOGGER.info("     newTextLine:{}",newTextLines[linePos]);
            Assert.assertEquals(expectingTextLines[linePos] ,newTextLines[linePos]);
        }
    }
}
