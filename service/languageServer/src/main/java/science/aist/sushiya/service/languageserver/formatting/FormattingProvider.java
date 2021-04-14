package science.aist.sushiya.service.languageserver.formatting;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.Metadata;
import science.aist.sushiya.service.languageserver.completion.AliasCompletionProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the formatting requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class FormattingProvider implements Function<DocumentFormattingParams, List<? extends TextEdit>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliasCompletionProvider.class);

    @Override
    public List<? extends TextEdit> apply(DocumentFormattingParams documentFormattingParams) {
        List<TextEdit> result = new ArrayList<>();
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(documentFormattingParams.getTextDocument());

        String[] lines = textDocument.getText().split("\\n");
        StringBuilder newText = new StringBuilder();
        for (String s : lines) {
            String line = s;

            if (firstWordIsMetadata(line) || line.replaceFirst("\\s*", "").startsWith("*")) {
                if (!line.matches("\\s{4}(\\s|\\S)*")) {
                    line = s.replaceFirst("\\s*", "    ");
                }
            } else if (firstWordIsEntity(line) || line.replaceFirst("\\s*", "").startsWith("//")) {
                if (line.matches("\\s(\\s|\\S)*")) {
                    line = s.replaceFirst("\\s*", "");
                }
            }
            newText.append(line);
        }
        TextEdit textEdit = new TextEdit();
        textEdit.setNewText(newText.toString());
        textEdit.setRange(new Range(new Position(0,0),
                new Position(lines.length-1,lines[lines.length-1].length()-1)));
        result.add(textEdit);

        return result;
    }

    private boolean firstWordIsEntity(String line){
        return line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.ALIAS.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.PROFILE.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.EXTENSION.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.INVARIANT.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.INSTANCE.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.VALUESET.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.CODESYSTEM.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.RULESET.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Entity.MAPPING.name())
                ;
    }

    private boolean firstWordIsMetadata(String line){
        return line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.DESCRIPTION.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.EXPRESSION.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.ID.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.INSTANCEOF.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.PARENT.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.SEVERITY.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.SOURCE.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.TARGET.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.TITLE.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.USAGE.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.XPATH.name())
                || line.toUpperCase(Locale.ROOT).replaceFirst("\\s*","").startsWith(Metadata.MIXINS.name())
                ;
    }
}