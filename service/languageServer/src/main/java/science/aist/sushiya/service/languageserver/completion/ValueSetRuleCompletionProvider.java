package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.CompletionTriggerKind;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the provider for the some valueSet rules.</p>
 *
 * @author SophieBauernfeind
 */
public class ValueSetRuleCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValueSetRuleCompletionProvider.class);
    private List<CompletionItem> completionItems = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return ValueSetRules(textDocumentItem, completionParams) && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
    }

    private boolean ValueSetRules(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String[] entries = textDocumentItem.getText().split("^\\n");
            //TODO: check if a rule has started & if the entity is a valueSet
        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
        return false;
    }
}
