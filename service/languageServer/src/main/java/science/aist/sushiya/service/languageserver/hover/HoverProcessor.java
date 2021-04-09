package science.aist.sushiya.service.languageserver.hover;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * <p>For a better structure of the server, the hover requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */

public class HoverProcessor implements Function<HoverParams,Hover> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HoverProcessor.class);

    @Override
    public Hover apply(HoverParams params) {
        LOGGER.warn("returns no useful hover");
        MarkupContent markupContent = new MarkupContent();
        markupContent.setValue("FSH Shorthand");
        markupContent.setKind("plaintext");
        Hover hover = new Hover(markupContent);
        return hover;
    }
}
