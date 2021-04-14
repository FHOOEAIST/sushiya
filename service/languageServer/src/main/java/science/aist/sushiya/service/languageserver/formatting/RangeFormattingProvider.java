package science.aist.sushiya.service.languageserver.formatting;

import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.TextEdit;

import java.util.List;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the range formatting requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class RangeFormattingProvider implements Function<DocumentRangeFormattingParams, List<? extends TextEdit>> {

    @Override
    public List<? extends TextEdit> apply(DocumentRangeFormattingParams documentRangeFormattingParams) {
        return null;
    }
}
