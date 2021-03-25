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
    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Test
    public void testAddFile(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals(textDocumentItem, FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri)));
    }

    @Test
    public void testRemoveFile(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        String uri = "testing";
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
        String uri = "testing";
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
        String uri = "testing";
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
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 0,FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS).size());
    }

    @Test
    public void testGetCreatedEntitiesProfileEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 0,FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).size());
    }

    @Test
    public void testGetCreatedEntitiesExtensionEmpty() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText("This is a test.");
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 0,FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION).size());
    }

    @Test
    public void testGetCreatedEntitiesAlias() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: test = testing \n" + "more text";
        textDocumentItem.setText(text);
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 1 ,FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS).size());
    }

    @Test
    public void testGetCreatedEntitiesProfile() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: test \n" + "more text";
        textDocumentItem.setText(text);
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 1,FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).size());
    }

    @Test
    public void testGetCreatedEntitiesExtension() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: test \n" + "more text";
        textDocumentItem.setText(text);
        String uri = "testing";
        textDocumentItem.setUri(uri);

        //when
        DidOpenTextDocumentParams params = new DidOpenTextDocumentParams();
        params.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(params);

        //then
        Assert.assertEquals( 1,FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION).size());
    }
}