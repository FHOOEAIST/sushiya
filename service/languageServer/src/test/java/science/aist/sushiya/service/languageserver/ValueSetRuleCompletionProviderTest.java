package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.ValueSetRuleCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link ValueSetRuleCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class ValueSetRuleCompletionProviderTest {
    private static final ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testActivation1() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "ValueSet: \n"
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

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivation2() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "  ValueSet: \n"
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
        Position position = new Position(3,11);
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
        Position position = new Position(3,11);
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
        Position position = new Position(5,3);
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
        Position position = new Position(5,11);
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
        Position position = new Position(5,31);
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
        Position position = new Position(5,11);
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
        Position position = new Position(5,31);
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
        Position position = new Position(5,3);
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
        Position position = new Position(5,3);
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
        Position position = new Position(5,3);
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
}
