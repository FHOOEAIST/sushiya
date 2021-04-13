package science.aist.sushiya.service.languageserver.rename;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

/**
 * <p>Created by Sophie Bauernfeind on 12.04.2021</p>
 * <p>Test class for {@link RenameProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class RenameProviderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RenameProviderTest.class);
    static final RenameProvider provider = new RenameProvider();
    static final String uri = "testing";

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
    public void testActivation(){
        //given
        String text = "Profile: Test\n" +
                "    Parent: Patient\n" +
                "    Id: test-patient\n" +
                "    * example contains testing 1..*\n" +
                "    * example[testing] = test";
        prepareForTest(text);

        //generate parameter to call the provider
        RenameParams renameParams = new RenameParams();
        Position position = new Position(0,10);
        renameParams.setPosition(position);
        renameParams.setTextDocument(new TextDocumentIdentifier(uri));
        renameParams.setNewName("Testing");

        //when
        WorkspaceEdit result = provider.apply(renameParams);

        // then
        Assert.assertNotNull(result);
    }

    @Test
    public void testAmountChanges(){
        //given
        String text = "Profile: Test\n" +
                "    Parent: Patient\n" +
                "    Id: Test\n" +
                "    * example contains testing 1..*\n" +
                "    * example[testing] = test";
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        RenameParams renameParams = new RenameParams();
        Position position = new Position(0,10);
        renameParams.setPosition(position);
        renameParams.setTextDocument(new TextDocumentIdentifier(uri));
        renameParams.setNewName("Testing");

        //when
        WorkspaceEdit result = provider.apply(renameParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getChanges());
        //how many files have changes
        Assert.assertEquals(result.getChanges().size(),1);
        //how many changes
        Assert.assertEquals(result.getChanges().get(uri).size(), 2);
    }

    @Test
    public void testAmountChangesContainsWord(){
        //given
        String text = "Profile: Test\n" +
                "    Parent: PatientTest\n" +
                "    Id: Test\n" +
                "    * example contains testing 1..*\n" +
                "    * example[testing] = test";
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //generate parameter to call the provider
        RenameParams renameParams = new RenameParams();
        Position position = new Position(0,10);
        renameParams.setPosition(position);
        renameParams.setTextDocument(new TextDocumentIdentifier(uri));
        renameParams.setNewName("Testing");

        //when
        WorkspaceEdit result = provider.apply(renameParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getChanges());
        //how many files have changes
        Assert.assertEquals(result.getChanges().size(),1);
        //how many changes
        Assert.assertEquals(result.getChanges().get(uri).size(), 2);
    }

    @Test
    public void testAmountChangesEndOfFileOtherFile(){
        //given
        String text = "Alias: LNC = http://loinc.org\n" +
                "\n" +
                "Profile: Test\n" +
                "    Parent: Patient\n" +
                "    Id: test-patient\n" +
                "    * example contains testing 1..*\n" +
                "    * example[testing] = test\n" +
                "\n" +
                "CodeSystem: SystemTest\n" +
                "\n" +
                "Instance: Try\n" +
                "    InstanceOf: Test\n" +
                "\n" +
                "ValueSet: ValueTest\n" +
                "    * include codes from system SystemTest";
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        //add the second file
        String text2 = "Profile: Test\n" +
                "    Parent: Patient";
        TextDocumentItem textDocument2 = new TextDocumentItem();
        textDocument2.setText(text2);
        textDocument2.setUri("test2");

        DidOpenTextDocumentParams openParams2 = new DidOpenTextDocumentParams();
        openParams2.setTextDocument(textDocument2);
        FSHFileHandler.getInstance().addFile(openParams2);

        RenameParams renameParams = new RenameParams();
        Position position = new Position(2,10);
        renameParams.setPosition(position);
        renameParams.setTextDocument(new TextDocumentIdentifier(uri));
        renameParams.setNewName("Testing");

        //when
        WorkspaceEdit result = provider.apply(renameParams);

        // then
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getChanges());
        //how many files have changes
        Assert.assertEquals(result.getChanges().size(),2);
        //how many changes
        Assert.assertEquals(result.getChanges().get(uri).size(), 2);
        Assert.assertEquals(result.getChanges().get("test2").size(), 1);
    }

}
