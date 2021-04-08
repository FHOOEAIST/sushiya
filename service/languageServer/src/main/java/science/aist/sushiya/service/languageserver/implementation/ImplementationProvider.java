package science.aist.sushiya.service.languageserver.implementation;

import org.eclipse.lsp4j.ImplementationParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.LocationProviderHelper;

import java.util.List;
import java.util.function.Function;

/**
 * <p>The implementation provider handles the incoming implementation requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class ImplementationProvider implements Function<ImplementationParams,
        Either<List<? extends Location>, List<? extends LocationLink>>> {
    private static final String regexUsingMetadata= "(Expression|InstanceOf|Parent|Source)";
    private static final LocationProviderHelper locationHelper = new LocationProviderHelper();

    @Override
    public Either<List<? extends Location>, List<? extends LocationLink>> apply(ImplementationParams implementationParams) {
        String searchedImplementations = locationHelper.getName(
                FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(implementationParams.getTextDocument().getUri())),
                implementationParams.getPosition());

        if(searchedImplementations == null){
            return Either.forLeft(null);
        }

        return Either.forLeft(locationHelper.getLocations(searchedImplementations,
                "\\s*"+ regexUsingMetadata +"\\s*:\\s+" + searchedImplementations + "\\s*"));
    }

}
