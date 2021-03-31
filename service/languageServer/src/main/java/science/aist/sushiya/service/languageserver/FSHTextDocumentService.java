/**
 * <p>In this class most of the incoming requests of the clients are handled.</p>
 * <p>For each set capability of the server, the specific function has to be implemented, to process the requests.</p>
 *
 * @author SophieBauernfeind
 */

package science.aist.sushiya.service.languageserver;


import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import science.aist.sushiya.service.languageserver.completion.CompletionProcessor;
import science.aist.sushiya.service.languageserver.hover.HoverProcessor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {
    private static final BiFunction<Position, TextDocumentItem,CompletableFuture<Hover>>
            hoverProcessor = new HoverProcessor();
    private static final BiFunction<TextDocumentItem, CompletionParams,CompletableFuture<Either<List<CompletionItem>, CompletionList>>>
            completionProcessor = new CompletionProcessor();

    public void didOpen(DidOpenTextDocumentParams params) {
        FSHFileHandler.getInstance().addFile(params);
    }

    public void didChange(DidChangeTextDocumentParams params) {
        FSHFileHandler.getInstance().update(params);
    }

    public void didClose(DidCloseTextDocumentParams params) {
        FSHFileHandler.getInstance().removeFile(params);
    }

    public void didSave(DidSaveTextDocumentParams params) {
    }

    @Override
    public CompletableFuture<Hover> hover(HoverParams hoverParams){
        String uri = hoverParams.getTextDocument().getUri();
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri));
        return hoverProcessor.apply(hoverParams.getPosition(), textDocument);
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams completionParams) {
        String uri = completionParams.getTextDocument().getUri();
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(uri));
        return completionProcessor.apply(textDocument, completionParams);
    }

    @Override
    public CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved) {
        return CompletableFuture.completedFuture(unresolved);
    }
}
