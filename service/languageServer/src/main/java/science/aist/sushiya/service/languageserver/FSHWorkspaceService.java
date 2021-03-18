package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>TODO insert documentation for this class</p>
 *
 * @author SophieBauernfeind
 */

public class FSHWorkspaceService implements WorkspaceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FSHWorkspaceService.class);

    public FSHWorkspaceService(FSHTextDocumentService textDocumentService) {
    }

    public void didChangeConfiguration(DidChangeConfigurationParams didChangeConfigurationParams) {
        LOGGER.info("SERVER: changeConfig");
    }

    public void didChangeWatchedFiles(DidChangeWatchedFilesParams didChangeWatchedFilesParams) {
        LOGGER.info("SERVER: changeWatchedFile");
    }
}
