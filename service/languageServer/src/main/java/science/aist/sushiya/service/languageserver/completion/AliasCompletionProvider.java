package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the completion provider for the entity 'alias'.</p>
 * <p>It contains common used aliases.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class AliasCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliasCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public AliasCompletionProvider() {
        completionItems.add(new CompletionItem("LNC = http://loinc.org"));
        completionItems.add(new CompletionItem("SCT = http://snomed.info/sct"));
    }

    @Override
    public List<CompletionItem> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return completionParams.getContext().getTriggerCharacter().equals(" ")
                && checkKeywordAlias(textDocumentItem,completionParams);
    }

    private boolean checkKeywordAlias(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("Alias:") && line.lastIndexOf("Alias:") < completionParams.getPosition().getCharacter();

        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
    }
}
