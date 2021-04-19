package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>One sample of a completion provider for the language server.</p>
 * <p>The providers will be handled and managed by the CompletionProcessor.</p>
 *
 * @author SophieBauernfeind
 */
public class FSHKeywordCompletionProvider implements ICompletionProvider {
    private static final List<CompletionItem> COMPLETION_ITEMS = new ArrayList<>();

    public FSHKeywordCompletionProvider() {
        COMPLETION_ITEMS.add(new CompletionItem("alias"));
        COMPLETION_ITEMS.add(new CompletionItem("profile"));
        COMPLETION_ITEMS.add(new CompletionItem("instance"));
        COMPLETION_ITEMS.add(new CompletionItem("invariant"));
        COMPLETION_ITEMS.add(new CompletionItem("ruleset"));
        COMPLETION_ITEMS.add(new CompletionItem("mapping"));
        COMPLETION_ITEMS.add(new CompletionItem("id"));
        COMPLETION_ITEMS.add(new CompletionItem("title"));
        COMPLETION_ITEMS.add(new CompletionItem("description"));
        COMPLETION_ITEMS.add(new CompletionItem("expression"));
        COMPLETION_ITEMS.add(new CompletionItem("xPath"));
        COMPLETION_ITEMS.add(new CompletionItem("severity"));
        COMPLETION_ITEMS.add(new CompletionItem("usage"));
        COMPLETION_ITEMS.add(new CompletionItem("source"));
        COMPLETION_ITEMS.add(new CompletionItem("target"));
        COMPLETION_ITEMS.add(new CompletionItem("from"));
        COMPLETION_ITEMS.add(new CompletionItem("example"));
        COMPLETION_ITEMS.add(new CompletionItem("preferred"));
        COMPLETION_ITEMS.add(new CompletionItem("extensible"));
        COMPLETION_ITEMS.add(new CompletionItem("required"));
        COMPLETION_ITEMS.add(new CompletionItem("contains"));
        COMPLETION_ITEMS.add(new CompletionItem("named"));
        COMPLETION_ITEMS.add(new CompletionItem("and"));
        COMPLETION_ITEMS.add(new CompletionItem("only"));
        COMPLETION_ITEMS.add(new CompletionItem("or"));
        COMPLETION_ITEMS.add(new CompletionItem("obeys"));
        COMPLETION_ITEMS.add(new CompletionItem("true"));
        COMPLETION_ITEMS.add(new CompletionItem("false"));
        COMPLETION_ITEMS.add(new CompletionItem("include"));
        COMPLETION_ITEMS.add(new CompletionItem("exclude"));
        COMPLETION_ITEMS.add(new CompletionItem("codes"));
        COMPLETION_ITEMS.add(new CompletionItem("where"));
        COMPLETION_ITEMS.add(new CompletionItem("valueset"));
        COMPLETION_ITEMS.add(new CompletionItem("system"));
        COMPLETION_ITEMS.add(new CompletionItem("units"));
        COMPLETION_ITEMS.add(new CompletionItem("exactly"));
        COMPLETION_ITEMS.add(new CompletionItem("insert"));
        COMPLETION_ITEMS.add(new CompletionItem("reference"));
        COMPLETION_ITEMS.add(new CompletionItem("extension"));
        COMPLETION_ITEMS.add(new CompletionItem("code"));
        COMPLETION_ITEMS.add(new CompletionItem("value"));
    }

    @Override
    public List<CompletionItem> get() {
        return COMPLETION_ITEMS;
    }

    //default completion provider
    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return true;
    }

    @Override
    public String toString() {
        return "FSHKeywordCompletionProvider";
    }
}
