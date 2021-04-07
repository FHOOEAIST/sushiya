package science.aist.sushiya.service.languageserver.definition;

import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * <p>The definition provider handles the incoming definition requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class DefinitionProvider implements Function<DefinitionParams, CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>>> {

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> apply(DefinitionParams definitionParams) {
        return CompletableFuture
                .completedFuture(null);
    }
}
