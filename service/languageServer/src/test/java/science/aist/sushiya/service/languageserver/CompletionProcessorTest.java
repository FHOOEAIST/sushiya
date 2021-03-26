package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.CompletionProcessor;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link CompletionProcessor}</p>
 *
 * @author Sophie Bauernfeind
 */
public class CompletionProcessorTest {
    private static final CompletionProcessor processor = new CompletionProcessor();

    @Test
    public void testApply(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        String uri = "testing";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

    @Test
    public void testApplyEmptyTextDocument(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "";
        String uri = "testing";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(0,text.length());
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

    @Test
    public void testApplyNoSetText(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        String uri = "testing";
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

    @Test
    public void testApplyPositionOutOfBound(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        String uri = "testing";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(5,10);
        params.setPosition(position);
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

    @Test
    public void testApplyNoSetPosition(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        String uri = "testing";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        CompletionContext completionContext = new CompletionContext();
        completionContext.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
        params.setContext(completionContext);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

    @Test
    public void testApplyNoSetContext(){
        //given
        TextDocumentItem textDocumentItem = new TextDocumentItem();
        String text = "Alias: LNC = http://loinc.org\n"
                + "\n"
                + "Profile: MyWeightProfile\n"
                + "Id: MyWeightProfile \n"
                + "Parent: ";
        String uri = "testing";
        textDocumentItem.setText(text);
        textDocumentItem.setUri(uri);

        CompletionParams params = new CompletionParams();
        Position position = new Position(4,8);
        params.setPosition(position);
        //when

        //then
        Assert.assertNotNull(processor.apply(textDocumentItem,params));
    }

}
