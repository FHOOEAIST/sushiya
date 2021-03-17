/**
 * <p>TODO insert documentation for this class</p>
 *
 * @author SophieBauernfeind
 */

package science.aist.sushiya.service.languageserver;


import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.languageserver.FSHLanguageServer;

public class FSHTextDocumentService implements TextDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FSHTextDocumentService.class);
    private FSHLanguageServer FSHLanguageServer;

    public FSHTextDocumentService(FSHLanguageServer fshLanguageServer) {
        this.FSHLanguageServer = fshLanguageServer;
    }

    public void didOpen(DidOpenTextDocumentParams didOpenTextDocumentParams) {
        LOGGER.info("did open: ",didOpenTextDocumentParams.getTextDocument());
    }

    public void didChange(DidChangeTextDocumentParams didChangeTextDocumentParams) {
        LOGGER.info("did change: ",didChangeTextDocumentParams.getTextDocument());
    }

    public void didClose(DidCloseTextDocumentParams didCloseTextDocumentParams) {
        LOGGER.info("did close: ", didCloseTextDocumentParams.getTextDocument());
    }

    public void didSave(DidSaveTextDocumentParams didSaveTextDocumentParams) {
        LOGGER.info("did save: " , didSaveTextDocumentParams.getTextDocument());
    }
}
