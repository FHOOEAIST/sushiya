package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.CompletionTriggerKind;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>This is the provider for the entity 'InstanceOf'.</p>
 *
 * @author SophieBauernfeind
 */
public class InstanceOfCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceOfCompletionProvider.class);
    private List<CompletionItem> completionItems = new ArrayList<>();


    @Override
    public List<CompletionItem> get() {
        completionItems.clear();

        //adding all Resources which are for sure used
        completionItems.addAll(FHIRResources.getInstance().getAllBase());
        completionItems.addAll(FHIRResources.getInstance().getAllClinical());
        completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE).stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));

        return completionItems.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return checkKeywordInstanceOf(textDocumentItem, completionParams) && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
    }

    private boolean checkKeywordInstanceOf(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("InstanceOf:") && line.lastIndexOf("InstanceOf:") < completionParams.getPosition().getCharacter();

        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
    }
}
