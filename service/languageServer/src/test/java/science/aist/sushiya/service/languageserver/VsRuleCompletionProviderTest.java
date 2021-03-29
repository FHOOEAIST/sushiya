package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.VsRuleCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link VsRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class VsRuleCompletionProviderTest {
    private static final VsRuleCompletionProvider provider = new VsRuleCompletionProvider();
    private static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Test
    public void testActivation1() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: Test \n"
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
    public void testActivation2() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "  ValueSet: Test\n"
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
    public void testActivation3() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "  ValueSet  : \n"
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
    public void testActivation4() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "  ValueSet  : \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,12);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivation5() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "  ValueSet  : \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,12);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationInRuleInclude() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,12);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationInRuleIncludeMoreWords() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from valueset ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,32);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationInRuleExclude() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,12);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationInRuleExcludeMoreWords() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude codes from system ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,32);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoValueSet() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,4);
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
        String text = "Test \n"
                + "\n"
                + " testing ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
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
    public void testNoActivationNoSetPosition() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
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
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,4);
        params.setPosition(position);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,4);
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
        String text = "ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,3);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItemsNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,3);
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
    public void testAmountCompletionItemsNewRuleDefinedAlias() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: AnotherTest = testing\n"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,4);
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
        Assert.assertEquals(provider.get().size(),3);
    }

    @Test
    public void testAmountCompletionItemsStartedRuleInclude() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,12);
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
    public void testAmountCompletionItemsStartedRuleExclude() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * exclude ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,12);
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
    public void testAmountCompletionItemsValueSet() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: Test2"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from valueset ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,32);
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
    public void testAmountCompletionItemsCodeSystem() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "CodeSystem: Test2\n"
                + "\n"
                + "ValueSet: Test \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from system ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,34);
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
}
