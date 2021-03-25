package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.InstanceOfCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link InstanceOfCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class InstanceOfCompletionProviderTest {
    @Test
    public void testActivation1(){
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivation2(){
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "  InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivation3(){
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "  InstanceOf  : ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationWrongPosition() {
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

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
    public void testNoActivationOutOfBound() {
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(1,0);
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
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
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
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "test InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
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
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

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
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetTriggerKind() {
        //given
        InstanceOfCompletionProvider provider = new InstanceOfCompletionProvider();
        String text = "InstanceOf: ";

        TextDocumentItem textDocumentItem = new TextDocumentItem();
        textDocumentItem.setText(text);
        textDocumentItem.setUri("testing");

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }
}
