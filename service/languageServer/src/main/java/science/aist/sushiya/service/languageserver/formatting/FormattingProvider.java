package science.aist.sushiya.service.languageserver.formatting;

import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.TextEdit;
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
        for (int pos = 0; pos < lines.length; pos++) {
            String line = lines[pos].toUpperCase(Locale.ROOT);

            if(firstWordIsEntity(line) || line.replaceFirst("\\s*","").startsWith("//")){
                if(line.matches("\\s(\\s|\\S)*")){
                    lines[pos] = lines[pos].replaceFirst("\\s*","");
                    TextEdit textEdit = new TextEdit();
                    textEdit.setNewText(lines[pos].replaceFirst("\\s*",""));
                    result.add(textEdit);
                }
            }else if(firstWordIsMetadata(line) || line.replaceFirst("\\s*","").startsWith("*")){
                if(! line.matches("\\t(\\s|\\S)*")){
                    TextEdit textEdit = new TextEdit();
                    textEdit.setNewText(line.replaceFirst("\\s*","\t"));
                    result.add(textEdit);
                }else{
                    LOGGER.info("Starts with Tab.");
                }
            }
        }

        return result;
    }

    private boolean firstWordIsEntity(String line){
        line = line.replaceFirst("\\s*","");

        return line.startsWith(Entity.ALIAS.name())
                || line.startsWith(Entity.PROFILE.name())
                || line.startsWith(Entity.EXTENSION.name())
                || line.startsWith(Entity.INVARIANT.name())
                || line.startsWith(Entity.INSTANCE.name())
                || line.startsWith(Entity.VALUESET.name())
                || line.startsWith(Entity.CODESYSTEM.name())
                || line.startsWith(Entity.RULESET.name())
                || line.startsWith(Entity.MAPPING.name());
    }

    private boolean firstWordIsMetadata(String line){
        line = line.replaceFirst("\\s*","");

        return line.startsWith(Metadata.DESCRIPTION.name())
                || line.startsWith(Metadata.EXPRESSION.name())
                || line.startsWith(Metadata.ID.name())
                || line.startsWith(Metadata.INSTANCEOF.name())
                || line.startsWith(Metadata.PARENT.name())
                || line.startsWith(Metadata.SEVERITY.name())
                || line.startsWith(Metadata.SOURCE.name())
                || line.startsWith(Metadata.TARGET.name())
                || line.startsWith(Metadata.TITLE.name())
                || line.startsWith(Metadata.USAGE.name())
                || line.startsWith(Metadata.XPATH.name())
                || line.startsWith(Metadata.MIXINS.name())
                ;
    }
}