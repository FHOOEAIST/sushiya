package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.FSHKeywordCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link FSHKeywordCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FSHKeywordCompletionProviderTest {
    private static final FSHKeywordCompletionProvider provider = new FSHKeywordCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testNoActivation(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = " ";
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
        Assert.assertFalse(provider.test(textDocumentItem,params));
    }

}
