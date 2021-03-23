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
        completionItems.add(new CompletionItem("alias"));
        completionItems.add(new CompletionItem("profile"));
        completionItems.add(new CompletionItem("instance"));
        completionItems.add(new CompletionItem("ivairant"));
        completionItems.add(new CompletionItem("ruleSet"));
        completionItems.add(new CompletionItem("mapping"));
        completionItems.add(new CompletionItem("id"));
        completionItems.add(new CompletionItem("title"));
        completionItems.add(new CompletionItem("description"));
        completionItems.add(new CompletionItem("expression"));
        completionItems.add(new CompletionItem("xPath"));
        completionItems.add(new CompletionItem("severity"));
        completionItems.add(new CompletionItem("usage"));
        completionItems.add(new CompletionItem("source"));
        completionItems.add(new CompletionItem("target"));
        completionItems.add(new CompletionItem("from"));
        completionItems.add(new CompletionItem("example"));
        completionItems.add(new CompletionItem("preffered"));
        completionItems.add(new CompletionItem("extensible"));
        completionItems.add(new CompletionItem("required"));
        completionItems.add(new CompletionItem("contains"));
        completionItems.add(new CompletionItem("named"));
        completionItems.add(new CompletionItem("and"));
        completionItems.add(new CompletionItem("only"));
        completionItems.add(new CompletionItem("or"));
        completionItems.add(new CompletionItem("obeys"));
        completionItems.add(new CompletionItem("true"));
        completionItems.add(new CompletionItem("false"));
        completionItems.add(new CompletionItem("include"));
        completionItems.add(new CompletionItem("exclude"));
        completionItems.add(new CompletionItem("codes"));
        completionItems.add(new CompletionItem("where"));
        completionItems.add(new CompletionItem("valueSet"));
        completionItems.add(new CompletionItem("system"));
        completionItems.add(new CompletionItem("units"));
        completionItems.add(new CompletionItem("exactly"));
        completionItems.add(new CompletionItem("insert"));
        completionItems.add(new CompletionItem("Reference"));
        completionItems.add(new CompletionItem("extension"));
        completionItems.add(new CompletionItem("code"));
        completionItems.add(new CompletionItem("value"));
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
