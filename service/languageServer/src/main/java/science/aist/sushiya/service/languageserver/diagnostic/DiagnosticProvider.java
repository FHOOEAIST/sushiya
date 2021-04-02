package science.aist.sushiya.service.languageserver.diagnostic;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.services.LanguageClient;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHLexer;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHParser;

/**
 * <p>This class handles the syntax checking and manage the diagnostic from the error listener.</p>
 *
 * @author SophieBauernfeind
 */


public class DiagnosticProvider {
    private static final FSHErrorListener errorListener = new FSHErrorListener();

    public void compileAndSendDiagnostic(LanguageClient client, TextDocumentItem textDocument){
        String text = textDocument.getText();
        CharStream input = CharStreams.fromString(text);
        FSHLexer lexer = new FSHLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FSHParser parser = new FSHParser(tokens);
        parser.addErrorListener(errorListener);
        parser.doc();

        client.publishDiagnostics(new PublishDiagnosticsParams(textDocument.getUri(),errorListener.getDiagnostics()));
    }
}
