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
 * <p>This is the completion provider for the entity 'alias'.</p>
 * <p>It contains common used aliases.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class AliasCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliasCompletionProvider.class);
    private static final List<CompletionItem> COMPLETION_ITEMS = new ArrayList<>();

    @Override
    public List<CompletionItem> get() {
        COMPLETION_ITEMS.clear();

        COMPLETION_ITEMS.add(new CompletionItem("LNC = http://loinc.org"));
        COMPLETION_ITEMS.add(new CompletionItem("SCT = http://snomed.info/sct"));
        COMPLETION_ITEMS.addAll(FSHFileHandler.getInstance().getCreatedEntities(Entity.ALIAS)
                .stream().map(CompletionItem::new).collect(Collectors.toList()));

        return COMPLETION_ITEMS.stream().distinct().collect(Collectors.toList());
    }

    @Override
    //test if this provider is responsible. Only if this function returns true the List of Completion make sense for the completion.
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if (textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkKeywordAlias(textDocumentItem, completionParams)
                    //check if the trigger character is space, then this provider is responsible
                    && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked
                    && completionParams.getContext().getTriggerCharacter() != null
                    && completionParams.getContext().getTriggerCharacter().equals(" ");
        }
        return false;
    }

    //check if the current line contains the keyword "Alias". If it does this completion provider is responsible.
    private boolean checkKeywordAlias(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try {
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s", "").matches("Alias:")
                    && line.lastIndexOf("Alias:") < completionParams.getPosition().getCharacter();

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            return false;
        }
    }
}
