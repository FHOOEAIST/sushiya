package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.sdRuleCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link sdRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class sdRuleCompletionProviderTest {
    private static final sdRuleCompletionProvider provider = new sdRuleCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testActivationProfileNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: Test \n"
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
    public void testActivationProfileStartedRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: Test\n"
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
    public void testActivationProfileInRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path and more";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,19);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationExtensionNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: Test \n"
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
    public void testActivationExtensionStartedRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: Test\n"
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
    public void testActivationExtensionInRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Extension: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * path and more";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,19);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationRuleSetNewRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "RuleSet: Test \n"
                + "  * ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(1,4);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationRuleSetStartedRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "RuleSet: Test\n"
                + "  * path ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(1,9);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationRuleSetInRule() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "RuleSet: Test\n"
                + "  * path and more ";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(1,19);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationOutOfBound() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
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
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
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
        String text = "Profile: \n"
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
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
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
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
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
        String text = "Profile: \n"
                + " Title: \n"
                + " Description: \n"
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
}
