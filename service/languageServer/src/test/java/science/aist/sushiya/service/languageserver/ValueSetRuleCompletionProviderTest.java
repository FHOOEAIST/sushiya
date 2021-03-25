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

    @Test
    public void testActivation1() {
        //given
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "  ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "  ValueSet  : \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
    public void testActivationNewRule() {
        //given
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
    public void testActivationInRuleOneWord() {
        //given
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
    public void testActivationInRuleMoreWords() {
        //given
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * include codes from valueset ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " Profile: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " testing ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

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
        ValueSetRuleCompletionProvider provider = new ValueSetRuleCompletionProvider();
        String text = "Test \n"
                + "\n"
                + " ValueSet: \n"
                + " Title: \n"
                + " Description: \n"
                + "  * ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,3);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }
}
