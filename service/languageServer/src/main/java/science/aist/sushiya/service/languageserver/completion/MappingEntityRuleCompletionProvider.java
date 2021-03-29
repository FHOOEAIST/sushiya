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
 * <p>This is the provider for rules for mapping.</p>
 *
 * @author SophieBauernfeind
 */
public class MappingEntityRuleCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(MappingEntityRuleCompletionProvider.class);
    private List<CompletionItem> completionItems = new ArrayList<>();
    private boolean newRule = false;
    private boolean rulePathDefined = false;
    private boolean insertRule = false;

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        if(newRule){
            completionItems.add(new CompletionItem("->"));
            completionItems.add(new CompletionItem("insert"));
        }else if(insertRule){
            completionItems.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.RULESET)
                    .stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));
        }else if(rulePathDefined){
            completionItems.add(new CompletionItem("insert"));
        }
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkRuleConditions(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
        }
        return false;
    }

    private boolean checkRuleConditions(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if(isRule(line) &&
                    textDocumentItem.getText().contains("Mapping")){
                String[]lines = textDocumentItem.getText().split("\\n");

                //check from current line above to the next empty line or the start of the text
                for(int i = completionParams.getPosition().getLine(); i >= 0 ; i --){
                    if(lines[i].matches("\\s*")|| i == 0){

                        //check the first line or the line after the empty line for the keyword
                        int index = i == 0 ? 0 : i +1;
                        return lines[index].trim().matches("\\s*Mapping\\s*:(\\s*|\\s+\\S+)\\s*");
                    }
                }
            }
        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean isRule(String line){
        newRule = line.matches("\\s*\\*\\s+");
        rulePathDefined = line.matches("\\s*\\*\\s+\\S+\\s+");
        insertRule = line.matches("\\s*\\*\\s+insert\\s+");
        return line.matches("\\s*\\*\\s+(\\s|\\S)*");
    }
}
