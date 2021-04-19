package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
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
public class PathCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(PathCompletionProvider.class);
    private final List<CompletionItem> completionItems = new ArrayList<>();
    private List<String> ruleLines = new ArrayList<>();
    private final Map<String, List<String>> components = new HashMap<>();
    private String triggerWord = "";

    @Override
    public List<CompletionItem> get() {
        completionItems.clear();
        fillCompletionItems();
        return completionItems;
    }

    @Override
    //test if this provider is responsible. Only if this function returns true the List of Completion make sense for the completion.
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if (textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkRuleConditions(textDocumentItem, completionParams)
                    //check if the trigger character is a open square bracket, then this provider is responsible
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals("[");
        }
        return false;
    }

    //check if different conditions are fulfilled, then completion provider is responsible.
    private boolean checkRuleConditions(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try {
            String line = textDocumentItem.getText().split("\\n")[completionParams.getPosition().getLine()];
            if (isRule(line) && textDocumentItem.getText().contains("contains")) {
                String[] lines = textDocumentItem.getText().split("\\n");

                int startPos = getEntityStart(lines, completionParams.getPosition());
                if (startPos == -1) {
                    LOGGER.error("Get entity start failed.");
                    return false;
                }
                return containsContainsRule(lines, startPos);
            }
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return false;
        }
        return false;
    }

    private boolean isRule(String line) {
        String[] words = line.split("\\s");
        //normally the last word in the line is the word, which caused the completion request
        triggerWord = words[words.length - 1];
        //the trigger word length has to be bigger or equal 2 - at length 1 it is just the open bracket
        //and the line has to be a rule
        if (triggerWord.length() >= 2
                && line.matches("\\s*\\*\\s+\\S+(\\s|\\S)*")) {
            triggerWord = triggerWord.substring(0, triggerWord.length() - 2);
            return true;
        }
        //if the size of the trigger word is smaller than 2 and the line has to be a rule, the trigger word is not valid
        else if (triggerWord.length() < 2
                && line.matches("\\s*\\*\\s+\\S+(\\s|\\S)*")) {
            LOGGER.info("No valid trigger word.");
            return false;
        } else {
            return false;
        }
    }

    private int getEntityStart(String[] lines, Position position) {
        //get to the next empty line to get the start position (linenumber) of the entity
        for (int pos = position.getLine(); pos >= 0; pos--) {
            if (lines[pos].matches("\\s*") || pos == 0) {
                return pos == 0 ? 0 : pos + 1;
            }
        }
        return -1;
    }

    //check if the current rule block has a contains rule
    private boolean containsContainsRule(String[] lines, int entityStartPos) {
        boolean contains = false;
        boolean ruleStarted = false;
        boolean ruleEnded = false;
        //safe all rule lines and check if a rule contains keyword "contains"
        //for this move over the whole lines, start by the entity start till the end is reached or the rule block ended
        for (int pos = entityStartPos; pos < lines.length - 1 && !ruleEnded; pos++) {
            if (lines[pos].matches("\\s*")) {
                //if the line is a empty line, the rule block has ended
                ruleEnded = true;
            } else {
                if (!ruleStarted && lines[pos].matches("\\s*\\*\\s+(\\s|\\S)*")) {
                    ruleStarted = true;
                }
                if (ruleStarted && !ruleEnded) {
                    //if the current position is in the rule block, safe the whole line and check if the keyword "contains" is in it
                    if (lines[pos].contains("contains")) {
                        contains = true;
                    }
                    ruleLines.add(lines[pos]);
                }
            }
        }
        fillComponentMap();
        return contains && components.containsKey(triggerWord);
    }

    //make out of all saved names, with the same extension name / trigger word, a completion item and add it to the list
    private void fillCompletionItems() {
        if (components.containsKey(triggerWord)) {
            completionItems.addAll(components.get(triggerWord)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }
    }

    //get all names of different contains rules and put it into a map, which will be used indirectly by the get function
    private void fillComponentMap() {
        boolean containsRuleStarted = false;
        String componentName = null;

        //prepare for correct workflow
        flattenRuleLines();
        components.clear();

        for (String ruleLine : ruleLines) {
            //get all names of the contains rule and put it into a map
            if (ruleLine.contains("contains")) {
                String[] words = ruleLine.split("\\s+");

                for (int wordPos = 0; wordPos < words.length - 1; wordPos++) {
                    // get the componentName
                    // the componentName is before the keyword, with this it's not possible that contains is at position 0
                    if (words[wordPos].matches("contains") && wordPos != 0) {
                        componentName = words[wordPos - 1];
                        containsRuleStarted = true;
                        components.put(componentName, new ArrayList<>());

                        //add first item of component
                        String item = words[wordPos + 1];
                        components.get(componentName).add(item);
                    }

                    //if the keyword "named" appeared the last inserted item name has to be replaced with the new name
                    if (containsRuleStarted && words[wordPos].matches("named")) {
                        String item = words[wordPos + 1];
                        components.get(componentName)
                                .set(components.get(componentName).size() - 1, item);
                    }

                    //after each keyword "and" a item will follow
                    if (containsRuleStarted && words[wordPos].matches("and")) {
                        String item = words[wordPos + 1];
                        components.get(componentName).add(item);
                    }
                }
            }
        }
    }

    //To avoid errors because of possible multiline rules, flatten the rules to one line per rule
    private void flattenRuleLines() {
        List<String> result = new ArrayList<>();

        for (String ruleLine : ruleLines) {
            if (ruleLine.matches("\\s*\\*\\s+(\\s|\\S)*")) {
                result.add(ruleLine);
            } else {
                result.set(
                        result.size() - 1,
                        result.get(result.size() - 1) + " " + ruleLine
                );
            }
        }
        ruleLines = result;
    }
}
