package science.aist.sushiya.service.languageserver.references;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.ProviderHelper;

import java.util.List;
import java.util.function.Function;

/**
 * <p>The references provider handles the incoming reference requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class ReferencesProvider implements Function<ReferenceParams,
        List<? extends Location>> {
    private static final ProviderHelper locationHelper = new ProviderHelper();

    @Override
    public List<? extends Location> apply(ReferenceParams referenceParams) {
        String searchedReference = locationHelper.getName(
                FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(referenceParams.getTextDocument().getUri())),
                referenceParams.getPosition());

        if(searchedReference == null){
            return null;
        }

        return locationHelper.getLocations(searchedReference,
                "(\\S*|\\s*)*(\\p{Punct}|\\s)+" + searchedReference + "(\\p{Punct}|\\s|)+(\\S*|\\s*)*");
    }

}
