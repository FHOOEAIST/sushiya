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
 * <p>This is the provider for the metadata-type 'source'.</p>
 *
 * @author SophieBauernfeind
 */
public class SourceCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParentCompletionProvider.class);
    private List<CompletionItem> completionItems = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();

        completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE)
                .stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));

        return completionItems.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkKeywordParent(textDocumentItem,completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
        }
        return false;
    }

    private boolean checkKeywordParent(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("Source:")
                    && line.lastIndexOf("Source:") < completionParams.getPosition().getCharacter();

        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
    }

}
