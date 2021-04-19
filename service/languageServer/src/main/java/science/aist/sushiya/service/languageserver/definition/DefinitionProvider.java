package science.aist.sushiya.service.languageserver.definition;

import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.ProviderHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <p>The definition provider handles the incoming definition requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class DefinitionProvider implements Function<DefinitionParams,
        Either<List<? extends Location>, List<? extends LocationLink>>> {
    private static final String REGEX_ENTITIES = "(Alias|Profile|Extension|Invariant|Instance|ValueSet|CodeSystem|RuleSet|Mapping)";
    private static final ProviderHelper HELPER = new ProviderHelper();

    @Override
    public Either<List<? extends Location>, List<? extends LocationLink>> apply(DefinitionParams definitionParams) {

        String searchedDefinition = HELPER.getName(
                FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(definitionParams.getTextDocument().getUri())),
                definitionParams.getPosition());

        if (searchedDefinition == null) {
            return Either.forLeft(new ArrayList<>());
        }

        return Either.forLeft(HELPER.getLocations(searchedDefinition,
                "\\s*" + REGEX_ENTITIES + "\\s*:\\s+" + searchedDefinition + "\\s*"));
    }

}
