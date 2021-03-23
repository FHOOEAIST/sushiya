/**
 * <p>In this class most of the incoming requests of the clients are handled.</p>
 * <p>For each set capability of the server, the specific function has to be implemented, to process the requests.</p>
 *
 * @author SophieBauernfeind
 */

package science.aist.sushiya.service.languageserver;


import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.completion.CompletionProcessor;
import science.aist.sushiya.service.languageserver.hover.HoverProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FSHTextDocumentService.class);
    private Map<String,TextDocumentItem> openedDocuments = new HashMap<>();
    private static final BiFunction<Position, TextDocumentItem,CompletableFuture<Hover>> hoverProcessor = new HoverProcessor();
    private static final BiFunction<Position, TextDocumentItem,CompletableFuture<Either<List<CompletionItem>, CompletionList>>> completionProcessor = new CompletionProcessor();

    public void didOpen(DidOpenTextDocumentParams params) {
        TextDocumentItem textDocument = params.getTextDocument();
        LOGGER.info("did open: ", textDocument);
        openedDocuments.put(textDocument.getUri(),textDocument);
    }

    public void didChange(DidChangeTextDocumentParams params) {
        LOGGER.info("did change: {}", params.getTextDocument());
        List<TextDocumentContentChangeEvent> contentChanges = params.getContentChanges();
    }

    public void didClose(DidCloseTextDocumentParams params) {
        LOGGER.info("did close: {}");
        String uri = params.getTextDocument().getUri();
        openedDocuments.remove(uri);
    }

    public void didSave(DidSaveTextDocumentParams params) {
        LOGGER.info("did save: {}", params.getTextDocument());
    }

    @Override
    public CompletableFuture<Hover> hover(HoverParams hoverParams){
        LOGGER.info("hover: {}", hoverParams.getTextDocument());
        String uri = hoverParams.getTextDocument().getUri();
        TextDocumentItem textDocument = openedDocuments.get(uri);
        return hoverProcessor.apply(hoverParams.getPosition(), textDocument);
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams completionParams) {
        LOGGER.info("completion: {}");
        String uri = completionParams.getTextDocument().getUri();
        TextDocumentItem textDocument = openedDocuments.get(uri);
        return completionProcessor.apply(completionParams.getPosition(), textDocument);
    }

}
