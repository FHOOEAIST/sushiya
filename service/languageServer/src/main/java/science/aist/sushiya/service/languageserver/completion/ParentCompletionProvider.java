package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the provider for the metadata-type 'profile'.</p>
 * <p>It provides all official defined resources based on: https://www.hl7.org/fhir/resourcelist.html (23.03.21)</p>
 *
 * @author SophieBauernfeind
 */
public class ParentCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParentCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public ParentCompletionProvider() {
        FHIRResources resources = new FHIRResources();

        //adding all Resources which are for sure used
        completionItems.addAll(resources.getAllBase());
        completionItems.addAll(resources.getAllClinical());
        
        //TODO: get extensions and profiles of all open files
    }

    @Override
    public List<CompletionItem> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
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
