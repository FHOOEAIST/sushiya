package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>One sample of a completion provider for the language server.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class FSHKeywordCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(FSHKeywordCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public FSHKeywordCompletionProvider() {
        completionItems.add(new CompletionItem("FSH"));
    }

    @Override
    public List<CompletionItem> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return true;
    }
}
