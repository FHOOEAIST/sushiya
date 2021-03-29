package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>This is the completion provider for some fsh paths.</p>
 * <p>The provider checks if the entity has "contains rules" and based on these, completion items will be provided.</p>
 *
 * @author SophieBauernfeind
 */
public class PathCompletionProvider implements ICompletionProvider{
    private static final Logger LOGGER = LoggerFactory.getLogger(PathCompletionProvider.class);
    private List<CompletionItem> completionItems = new ArrayList<>();
    private List<String> ruleLines = new ArrayList<>();
    private Map<String,List<String>> components = new HashMap<>();
    private String triggerWord = "";

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        fillCompletionItems();
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkRuleConditions(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerCharacter() == "[";
        }
        return false;
    }

    private boolean checkRuleConditions(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if(isRule(line) && textDocumentItem.getText().contains("contains")){
                String[]lines = textDocumentItem.getText().split("\\n");

                int startPos = getEntityStart(lines, completionParams.getPosition());
                if(startPos == -1){
                    LOGGER.error("Get entity start failed.");
                    return false;
                }
                return containsContainsRule(lines,startPos);
            }
        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean isRule(String line){
        String[]words = line.split("\\s");
        triggerWord = words[words.length -1];
        triggerWord = triggerWord.substring(0,triggerWord.length()-1);
        if(triggerWord.length() <= 0){
            LOGGER.warn("No valid trigger word.");
            return false;
        }
        return line.matches("\\s*\\*\\s+(\\s|\\S)*");
    }

    private int getEntityStart(String[] lines, Position position){
        //get to the next empty line to get the start linenumber of the entity
        for(int pos = position.getLine(); pos >= 0 ; pos --){
            if(lines[pos].matches("\\s*")|| pos == 0){
                return pos == 0 ? 0 : pos + 1;
            }
        }
        return -1;
    }

    private boolean containsContainsRule(String[] lines, int entityStartPos){
        //safe all rule lines and check if a rule contains keyword "contains"
        boolean contains = false;
        boolean ruleStarted = false;
        boolean ruleEnded = false;
        for(int pos = entityStartPos; pos <= lines.length-1; pos ++){
            if(lines[pos].matches("\\s*")){
                ruleEnded = true;
            }else{
                if(!ruleStarted && lines[pos].matches("\\s*\\*\\s+(\\s|\\S)*")){
                    ruleStarted = true;
                }
                if(ruleStarted && !ruleEnded){
                    if(lines[pos].contains("contains")){
                        contains = true;
                    }
                    ruleLines.add(lines[pos]);
                }
            }
        }
        if(contains){
            return true;
        }
        return false;
    }

    private void fillCompletionItems(){
        LOGGER.info("rule lines size: {}", ruleLines.size());
        fillComponentMap();
        if(components.containsKey(triggerWord)){
            completionItems.addAll(components.get(triggerWord)
                      .stream().map(name -> new CompletionItem(name)).collect(Collectors.toList()));
        }
    }

    private void fillComponentMap(){
        boolean containsRuleStarted = false;
        String componentName = null;

        flattenRuleLines();

        for(String ruleLine: ruleLines){
            if(ruleLine.contains("contains")){
                String[] words = ruleLine.split("\\s");

                //only iterate till words.length-1 to avoid out of bound if rule is not completed yet
                for(int wordCount = 0; wordCount < words.length-1; wordCount++){
                    //get the componentName
                    if(words[wordCount].matches("contains")&& wordCount != 0){
                        componentName = words[wordCount-1];
                        containsRuleStarted = true;
                        components.put(componentName,new ArrayList<>());

                        //add first item of component
                        String item = words[wordCount+1];
                        components.get(componentName).add(item);
                    }

                    //if the keyword "named" appeared the last inserted item name has to be replaced with the new name
                    if(containsRuleStarted && words[wordCount].matches("named")){
                        String item = words[wordCount+1];
                        components.get(componentName)
                                .set(components.get(componentName).size(), item);
                    }

                    //after each keyword "and" a item will follow
                    if(containsRuleStarted && words[wordCount].matches("and")){
                        String item = words[wordCount+1];
                        components.get(componentName).add(item);
                    }
                }
            }
        }
    }

    private void flattenRuleLines(){
        List<String> result = new ArrayList<>();

        for(String ruleLine: ruleLines){
            if(ruleLine.matches("\\s*\\*\\s+(\\s|\\S)*")){
                result.add(ruleLine);
            }else{
                result.set(
                        result.size(),
                        result.get(result.size()) + " " + ruleLine
                );
            }
        }
    }
}
