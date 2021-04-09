package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link EntityAndMetadataCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class EntityAndMetadataCompletionProviderTest {
    private static final EntityAndMetadataCompletionProvider provider = new EntityAndMetadataCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testActivation1(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Al";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivation2(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(2,5);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testActivationEmptyText(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationOutOfBound(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(2,20);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetPosition(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.Invoked);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetContext(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(2,text.length());
        params.setPosition(position);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

    @Test
    public void testNoActivationNoSetTriggerKind(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profi";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(2,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        params.setContext(completionContext);
        //when

        //then
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }
}
