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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FSHTextDocumentService.class);

    public FSHTextDocumentService() {
    }

    public void didOpen(DidOpenTextDocumentParams didOpenTextDocumentParams) {
        LOGGER.info("did close: ", didOpenTextDocumentParams.getTextDocument());
    }

    public void didChange(DidChangeTextDocumentParams didChangeTextDocumentParams) {
        LOGGER.info("did close: ", didChangeTextDocumentParams.getTextDocument());
    }

    public void didClose(DidCloseTextDocumentParams didCloseTextDocumentParams) {
        LOGGER.info("did close: ", didCloseTextDocumentParams.getTextDocument());
    }

    public void didSave(DidSaveTextDocumentParams didSaveTextDocumentParams) {
        LOGGER.info("did save: " , didSaveTextDocumentParams.getTextDocument());
    }
}
