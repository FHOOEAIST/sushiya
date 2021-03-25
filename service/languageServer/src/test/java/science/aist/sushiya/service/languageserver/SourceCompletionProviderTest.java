package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.SourceCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link SourceCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class SourceCompletionProviderTest {
    @Test
    public void testActivation1(){
        //given
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "  Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "  Source  : ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "test Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
        SourceCompletionProvider provider = new SourceCompletionProvider();
        String text = "Source: ";

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
