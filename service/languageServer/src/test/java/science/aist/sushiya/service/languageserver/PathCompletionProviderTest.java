package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.PathCompletionProvider;

/**
 * <p>Created by Sophie Bauernfeind on 25.03.2021</p>
 * <p>Test class for {@link PathCompletionProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class PathCompletionProviderTest {
    private static final PathCompletionProvider provider = new PathCompletionProvider();
    private static final String uri = "testing";

    @Test
    public void testActivation1() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[";


        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(3,14);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");
        params.setContext(completionContext);
        //when

        //then
        Assert.assertTrue(provider.test(textDocumentItem,params));
    }

    @Test
    public void testAmountCompletionItems() {
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Profile:     TestPatient\n"
                + " Parent:     Patient\n"
                + " * identifier contains \n"
                + "     socialSecurityNumber 0..1 and \n"
                + "     bPK 0..* and \n"
                + "     localPatientId 0..1 \n"
                + " * identifier[";


        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(6,14);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        completionContext.setTriggerCharacter("[");
        params.setContext(completionContext);
        //when

        //then
        Assert.assertEquals(provider.get().size(),3);
    }

}
