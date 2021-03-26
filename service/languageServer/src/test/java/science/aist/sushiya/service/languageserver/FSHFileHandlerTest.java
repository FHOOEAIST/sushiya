package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link FSHFileHandler}</p>
 *
 * @author Sophie Bauernfeind
 */

public class FSHFileHandlerTest{
    private static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Test
    public void testAddFile(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertNotNull(FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
        //Assert.assertEquals(textDocumentItem, FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
    }

    @Test
    public void testRemoveFile(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);

        //when
        DidCloseTextDocumentParams closeParams = new DidCloseTextDocumentParams();
        closeParams.setTextDocument(new TextDocumentIdentifier(uri));
        FSHFileHandler.getInstance().removeFile(closeParams);

        //then
        Assert.assertNull(FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
    }

    @Test
    public void testUpdate() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String startText = "This is a test.";
        textDocumentItem.setText(startText);
        textDocumentItem.setUri(uri);

        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);

        //when
        DidChangeTextDocumentParams changeParams = new DidChangeTextDocumentParams();
        changeParams.getContentChanges().add(new TextDocumentContentChangeEvent("Something has changed."));
        changeParams.setTextDocument(new VersionedTextDocumentIdentifier(uri,1));
        FSHFileHandler.getInstance().update(changeParams);

        //then
        Assert.assertNotEquals(startText, FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)).getText());
    }

    @Test
    public void testGetFile() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertNotNull(FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
    }

    @Test
    public void testGetCreatedEntitiesAliasEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS).size(),0);
    }

    @Test
    public void testGetCreatedEntitiesProfileEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).size(),0);
    }

    @Test
    public void testGetCreatedEntitiesExtensionEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION).size(),0);
    }

    @Test
    public void testGetCreatedEntitiesCodeSystemEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.CODESYSTEM).size(),0);
    }

    @Test
    public void testGetCreatedEntitiesValueSetEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.VALUESET).size(),0);
    }

    @Test
    public void testGetCreatedEntitiesAliasNoDuplicates() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: is = correct\n"
                + "  Alias:  is = correct\n"
                + "  Alias  : is = correct\n"
                + "  Alias  :  is  =  correct\n"
                + " testing Alias: not = correct\n"
                + " Alias: not correct\n"
                + "Alias not = correct"
                + "simple Alias test";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS).size(), 1);
    }

    @Test
    public void testGetCreatedEntitiesProfileNoDuplicates() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: isCorrect\n"
                + "  Profile: isCorrect\n"
                + "  Profile  : isCorrect\n"
                + "  Profile  :  isCorrect\n"
                + "Profile: is not correct\n"
                + "test Profile: notCorrect\n"
                + "Profile notCorrect\n"
                + "simple Profile test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).size(), 1);
    }

    @Test
    public void testGetCreatedEntitiesExtensionNoDuplicates() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: isCorrect\n"
                + "  Extension: isCorrect\n"
                + "  Extension  : isCorrect\n"
                + "  Extension  :  isCorrect\n"
                + "Extension: is not correct\n"
                + "test Extension: notCorrect\n"
                + "Extension notCorrect\n"
                + "simple Extension test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION).size(), 1);
    }
    
    @Test
    public void testGetCreatedEntitiesCodeSystemNoDuplicates() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "CodeSystem: isCorrect\n"
                + "  CodeSystem: isCorrect\n"
                + "  CodeSystem  : isCorrect\n"
                + "  CodeSystem  :  isCorrect\n"
                + "CodeSystem: is not correct\n"
                + "test CodeSystem: notCorrect\n"
                + "CodeSystem notCorrect\n"
                + "simple CodeSystem test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.CODESYSTEM).size(), 1);
    }

    @Test
    public void testGetCreatedEntitiesValueSetNoDuplicates() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: isCorrect\n"
                + "  ValueSet: isCorrect\n"
                + "  ValueSet  : isCorrect\n"
                + "  ValueSet  :  isCorrect\n"
                + "ValueSet: is not correct\n"
                + "test ValueSet: notCorrect\n"
                + "ValueSet notCorrect\n"
                + "simple ValueSet test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.VALUESET).size(), 1);
    }

    @Test
    public void testGetCreatedEntitiesAlias() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: is = correct1\n"
                + "  Alias:  is = correct2\n"
                + "  Alias  : is = correct3\n"
                + "  Alias  :  is  =  correct4\n"
                + " testing Alias: not = correct\n"
                + " Alias: not correct\n"
                + "Alias not = correct"
                + "simple Alias test";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS).size(), 4);
    }

    @Test
    public void testGetCreatedEntitiesProfile() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: isCorrect1\n"
                + "  Profile: isCorrect2\n"
                + "  Profile  : isCorrect3\n"
                + "  Profile  :  isCorrect4\n"
                + "Profile: is not correct\n"
                + "test Profile: notCorrect\n"
                + "Profile notCorrect\n"
                + "simple Profile test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).size(), 4);
    }

    @Test
    public void testGetCreatedEntitiesExtension() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: isCorrect1\n"
                + "  Extension: isCorrect2\n"
                + "  Extension  : isCorrect3\n"
                + "  Extension  :  isCorrect4\n"
                + "Extension: is not correct\n"
                + "test Extension: notCorrect\n"
                + "Extension notCorrect\n"
                + "simple Extension test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION).size(), 4);
    }

    @Test
    public void testGetCreatedEntitiesCodeSystem() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "CodeSystem: isCorrect1\n"
                + "  CodeSystem: isCorrect2\n"
                + "  CodeSystem  : isCorrect3\n"
                + "  CodeSystem  :  isCorrect4\n"
                + "CodeSystem: is not correct\n"
                + "test CodeSystem: notCorrect\n"
                + "CodeSystem notCorrect\n"
                + "simple CodeSystem test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.CODESYSTEM).size(), 4);
    }

    @Test
    public void testGetCreatedEntitiesValueSet() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: isCorrect1\n"
                + "  ValueSet: isCorrect2\n"
                + "  ValueSet  : isCorrect3\n"
                + "  ValueSet  :  isCorrect4\n"
                + "ValueSet: is not correct\n"
                + "test ValueSet: notCorrect\n"
                + "ValueSet notCorrect\n"
                + "simple ValueSet test\n";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( FSHFileHandler.getInstance().getCreatedEntities(Entity.VALUESET).size(), 4);
    }

    @Test
    public void testAddFileNoUriSet(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertNull(FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
    }
}