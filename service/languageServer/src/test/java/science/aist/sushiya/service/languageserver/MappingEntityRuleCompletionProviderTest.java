package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.MappingEntityRuleCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link MappingEntityRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class MappingEntityRuleCompletionProviderTest {
    private static final MappingEntityRuleCompletionProvider provider = new MappingEntityRuleCompletionProvider();
    private static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Test
    public void testActivationNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationInRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,9);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationWrongEntity() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,11);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationOutOfBound() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,20);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationEmptyText() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,0);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationIncorrectText() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "test  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetPosition() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetContext() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationNoSetUri() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        //the uri does not affect the completion
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItemsNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: Test \n"
                + " Title: \n"
                + " Id: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);
        provider.test(textDocumentItem,params);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }

    @Test
    public void testAmountCompletionItemsPathDefined() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Mapping: Test \n"
                + " Title: \n"
                + " Id: \n"
                + "  * path ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,9);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);
        provider.test(textDocumentItem,params);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionInsertRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "RuleSet: AnotherTest\n"
                + "\n"
                + "Mapping: Test \n"
                + " Title: \n"
                + " Id: \n"
                + "  * insert ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,11);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);
        provider.test(textDocumentItem,params);

        //then
        Assert.assertEquals(provider.get().size(),1);
    }

    @Test
    public void testAmountCompletionInsertRuleMoreEnities() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "RuleSet: AnotherTest\n"
                + "\n"
                + "RuleSet: AnotherTest2\n"
                + "\n"
                + "Mapping: Test \n"
                + " Title: \n"
                + " Id: \n"
                + "  * insert ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(7,11);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocumentItem);
        FSHFileHandler.getInstance().addFile(openParams);
        provider.test(textDocumentItem,params);

        //then
        Assert.assertEquals(provider.get().size(),2);
    }
}
