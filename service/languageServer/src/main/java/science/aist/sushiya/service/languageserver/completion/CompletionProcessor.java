package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * <p>For a better structure of the server, the completion requests will be handled here.</p>
 * <p>The CompletionProcessor has a collection of different CompletionProvider.</p>
 * <p>Each CompletionProvider, provides a different list of CompletionItems for a special case.</p>
 *
 * @author SophieBauernfeind
 */
public class CompletionProcessor implements BiFunction<TextDocumentItem, CompletionParams,CompletableFuture<Either<List<CompletionItem>, CompletionList>>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompletionProcessor.class);
    private static final List<ICompletionProvider> completionProviders = new ArrayList<>();

    public CompletionProcessor(){
        completionProviders.add(new FSHKeywordCompletionProvider());
        completionProviders.add(new AliasCompletionProvider());
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        List<List<CompletionItem>> completionProvidersItems = new ArrayList<>();
        for (ICompletionProvider cp: completionProviders) {
            if(cp.test(textDocumentItem,completionParams)){
                completionProvidersItems.add(cp.apply(textDocumentItem, completionParams));
            }
        }
        return CompletableFuture
                .completedFuture(Either
                        .forLeft(completionProvidersItems.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList())));
    }
}
