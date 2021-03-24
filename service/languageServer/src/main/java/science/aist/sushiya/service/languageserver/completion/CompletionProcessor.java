package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

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
    private static final List<ICompletionProvider> completionProviders = new ArrayList<>();

    public CompletionProcessor(){
        completionProviders.add(new FSHKeywordCompletionProvider());
        completionProviders.add(new AliasCompletionProvider());
        completionProviders.add(new ParentCompletionProvider());
        completionProviders.add(new InstanceOfCompletionProvider());
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        List<List<CompletionItem>> completionItems = new ArrayList<>();
        for (ICompletionProvider cp: completionProviders) {
            if(cp.test(textDocumentItem,completionParams)){
                completionItems.add(cp.get());
            }
        }
        return CompletableFuture
                .completedFuture(Either
                        .forLeft(completionItems.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList())));
    }
}
