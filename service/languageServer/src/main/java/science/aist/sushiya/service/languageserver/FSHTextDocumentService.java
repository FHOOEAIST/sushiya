/**
 * <p>TODO insert documentation for this class</p>
 *
 * @author SophieBauernfeind
 */

package science.aist.sushiya.service.languageserver;


import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FSHTextDocumentService implements org.eclipse.lsp4j.services.TextDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FSHTextDocumentService.class);

    public FSHTextDocumentService() {
    }

    public void didOpen(DidOpenTextDocumentParams params) {
        TextDocumentItem textDocument = params.getTextDocument();
        LOGGER.info("did open: ", textDocument);
    }

    public void didChange(DidChangeTextDocumentParams params) {
        LOGGER.info("did change: {}", params.getTextDocument());
        List<TextDocumentContentChangeEvent> contentChanges = params.getContentChanges();
    }

    public void didClose(DidCloseTextDocumentParams params) {
        LOGGER.info("did close: {}", params.getTextDocument());
        String uri = params.getTextDocument().getUri();
    }

    public void didSave(DidSaveTextDocumentParams params) {
        LOGGER.info("did save: {}", params.getTextDocument());
    }
}
