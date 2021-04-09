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
import science.aist.sushiya.service.languageserver.definition.DefinitionProvider;
import science.aist.sushiya.service.languageserver.diagnostic.DiagnosticProvider;
import science.aist.sushiya.service.languageserver.hover.HoverProcessor;
import science.aist.sushiya.service.languageserver.implementation.ImplementationProvider;
import science.aist.sushiya.service.languageserver.references.ReferencesProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {
    private final FSHLanguageServer fshLanguageServer;
    private final DiagnosticProvider diagnosticProvider;
    private static final Function<HoverParams,Hover>
            hoverProcessor = new HoverProcessor();
    private static final Function<CompletionParams,Either<List<CompletionItem>, CompletionList>>
            completionProcessor = new CompletionProcessor();
    private static final Function<DefinitionParams, Either<List<? extends Location>, List<? extends LocationLink>>>
            definitionProvider = new DefinitionProvider();
    private static final Function<ImplementationParams, Either<List<? extends Location>, List<? extends LocationLink>>>
            implementationProvider = new ImplementationProvider();
    private static final Function<ReferenceParams, List<? extends Location>>
            referencesProvider = new ReferencesProvider();

    public FSHTextDocumentService(FSHLanguageServer server) {
        this.fshLanguageServer = server;
        this.diagnosticProvider = new DiagnosticProvider(server);
    }

    public void didOpen(DidOpenTextDocumentParams params) {
        FSHFileHandler.getInstance().addFile(params);
        diagnosticProvider.compileAndSendDiagnostic(
                fshLanguageServer.getClient(),
                FSHFileHandler.getInstance().getFile(
                        new TextDocumentIdentifier(params.getTextDocument().getUri())
                ));
    }

    public void didChange(DidChangeTextDocumentParams params) {
        FSHFileHandler.getInstance().update(params);
        diagnosticProvider.compileAndSendDiagnostic(
                fshLanguageServer.getClient(),
                FSHFileHandler.getInstance().getFile(
                        new TextDocumentIdentifier(params.getTextDocument().getUri())
                ));
    }

    public void didClose(DidCloseTextDocumentParams params) {
        FSHFileHandler.getInstance().removeFile(params);
        diagnosticProvider.clear(params.getTextDocument().getUri());
    }

    public void didSave(DidSaveTextDocumentParams params) {
    }

    @Override
    public CompletableFuture<Hover> hover(HoverParams params){
        return CompletableFuture.completedFuture(hoverProcessor.apply(params));
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {
        return CompletableFuture.completedFuture(completionProcessor.apply(params));
    }

    @Override
    public CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved) {
        return CompletableFuture.completedFuture(unresolved);
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(DefinitionParams params) {
        return CompletableFuture.completedFuture(definitionProvider.apply(params));
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> implementation(ImplementationParams params) {
        return CompletableFuture.completedFuture(implementationProvider.apply(params));
    }

    @Override
    public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
        return CompletableFuture.completedFuture(referencesProvider.apply(params));
    }
}
