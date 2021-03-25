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
    private boolean newRule = false;

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        if (newRule){
            completionItems.add(new CompletionItem("include"));
            completionItems.add(new CompletionItem("exclude"));
        }
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return ValueSetRules(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
        }
        return false;
    }

    private boolean ValueSetRules(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if( (newRule(line) || inRule(line))
                    && textDocumentItem.getText().contains("ValueSet")){
                String[]lines = textDocumentItem.getText().split("\\n");
                //check from current line above to the next empty line or the start of the text
                for(int i = completionParams.getPosition().getLine(); i >= 0 ; i --){
                    if(lines[i].matches("\\s*")|| i == 0){
                        //check the first line or the line after the empty line for the keyword
                        int index = i == 0 ? 0 : i +1;
                        return lines[index].trim().matches("\\s*ValueSet\\s*:(\\s*|\\s+\\S+)");
                    }
                }
            }
        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean newRule(String line){
        newRule = line.matches("\\s*\\*\\s+");
        return line.matches("\\s*\\*\\s+");
    }

    private boolean inRule(String line){
        return line.matches("\\s*\\*\\s+\\S+(\\s|\\S)*");
    }
}
