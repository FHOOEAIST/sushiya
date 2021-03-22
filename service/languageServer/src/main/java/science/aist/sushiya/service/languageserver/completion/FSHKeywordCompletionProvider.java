package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO insert documentation for this class</p>
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
    public List<CompletionItem> get() {
        return completionItems;
    }
}
