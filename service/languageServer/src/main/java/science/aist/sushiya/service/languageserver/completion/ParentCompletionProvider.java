package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>This is the provider for the metadata-type 'profile'.</p>
 *
 * @author SophieBauernfeind
 */
public class ParentCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParentCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        FHIRResources resources = new FHIRResources();

        //adding all Resources which are for sure used
        completionItems.addAll(resources.getAllBase());
        completionItems.addAll(resources.getAllClinical());
        completionItems.addAll(FSHFileHandler.getInstance().getCreatedProfiles().stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));
        completionItems.addAll(FSHFileHandler.getInstance().getCreatedExtensions().stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));

        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        LOGGER.info("Parent Completion: {}" , checkKeywordParent(textDocumentItem, completionParams) && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked);
        return checkKeywordParent(textDocumentItem, completionParams) && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
    }

    private boolean checkKeywordParent(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("Parent:") && line.lastIndexOf("Parent:") < completionParams.getPosition().getCharacter();

        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
    }


}
