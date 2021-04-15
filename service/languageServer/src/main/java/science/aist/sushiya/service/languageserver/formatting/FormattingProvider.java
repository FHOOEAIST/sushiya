package science.aist.sushiya.service.languageserver.formatting;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.parser.FSHBaseListener;
import science.aist.sushiya.service.languageserver.parser.FSHLexer;
import science.aist.sushiya.service.languageserver.parser.FSHParser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the formatting requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class FormattingProvider implements Function<DocumentFormattingParams, List<? extends TextEdit>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FormattingProvider.class);

    @Override
    public List<? extends TextEdit> apply(DocumentFormattingParams documentFormattingParams) {
        List<TextEdit> result = new ArrayList<>();
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(documentFormattingParams.getTextDocument());

        FSHBaseListener listener = new FSHBaseListener();
        FSHFormattingListener formattingListener = new FSHFormattingListener();
        String text = textDocument.getText();
        CharStream input = CharStreams.fromString(text);
        FSHLexer lexer = new FSHLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FSHParser parser = new FSHParser(tokens);
        parser.addParseListener(listener);
        parser.addParseListener(formattingListener);
        parser.doc();

        String[] lines = formattingListener.getFormattedText().split("\\n");

        TextEdit textEdit = new TextEdit();
        textEdit.setNewText(formattingListener.getFormattedText());
        textEdit.setRange(new Range(new Position(0,0),
                new Position(lines.length-1,lines[lines.length-1].length()-1)));
        result.add(textEdit);

        return result;
    }
}