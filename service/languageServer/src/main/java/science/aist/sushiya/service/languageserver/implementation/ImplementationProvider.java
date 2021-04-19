package science.aist.sushiya.service.languageserver.implementation;

import org.eclipse.lsp4j.ImplementationParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.ProviderHelper;

import java.util.List;
import java.util.function.Function;

/**
 * <p>The implementation provider handles the incoming implementation requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class ImplementationProvider implements Function<ImplementationParams,
        Either<List<? extends Location>, List<? extends LocationLink>>> {
    private static final String REGEX_USING_METADATA = "(Expression|InstanceOf|Parent|Source)";
    private static final ProviderHelper HELPER = new ProviderHelper();

    @Override
    public Either<List<? extends Location>, List<? extends LocationLink>> apply(ImplementationParams implementationParams) {
        String searchedImplementations = HELPER.getName(
                FSHFileHandler.getInstance().getFile(implementationParams.getTextDocument()),
                implementationParams.getPosition());

        if (searchedImplementations == null) {
            return Either.forLeft(null);
        }

        return Either.forLeft(HELPER.getLocations(searchedImplementations,
                "\\s*" + REGEX_USING_METADATA + "\\s*:\\s+" + searchedImplementations + "\\s*"));
    }

}
