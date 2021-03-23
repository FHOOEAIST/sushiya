package science.aist.sushiya.service.languageserver.hover;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/**
 * <p>For a better structure of the server, the hover requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */

public class HoverProcessor implements BiFunction<Position, TextDocumentItem,CompletableFuture<Hover>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HoverProcessor.class);

    @Override
    public CompletableFuture<Hover> apply(Position position, TextDocumentItem textDocumentItem) {
        LOGGER.warn("returns no useful hover");
        MarkupContent markupContent = new MarkupContent();
        markupContent.setValue("FSH Shorthand");
        markupContent.setKind("plaintext");
        Hover hover = new Hover(markupContent);
        return CompletableFuture.completedFuture(hover);
    }
}
