package science.aist.sushiya.service.languageserver.rename;

import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;

import java.util.function.Function;

/**
 * <p>For a better structure of the server, the rename requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class RenameProvider implements Function<RenameParams, WorkspaceEdit> {
    @Override
    public WorkspaceEdit apply(RenameParams renameParams) {
        return null;
    }
}
