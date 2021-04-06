package science.aist.sushiya.service.languageserver.diagnostic;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHParser;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The FSHErrorListener Listens to the {@link FSHParser}, and creates a Diagnostic if the syntax checking failed.</p>
 *
 * @author SophieBauernfeind
 */
public class FSHErrorListener extends BaseErrorListener {
    private List<Diagnostic> diagnostics = new ArrayList<>();

    //Only the first syntaxError will generate a Diagnostic. If a entity hase more mistakes only the first one will be marked.
    //TODO: check if it is possible to mark all errors in one entity

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        Diagnostic diagnostic = new Diagnostic();
        diagnostic.setMessage(msg);
        diagnostic.setRange(new Range(
                new Position(line-1,charPositionInLine),
                new Position(line-1,charPositionInLine)
        ));
        diagnostics.add(diagnostic);
    }

    public List<Diagnostic> getDiagnostics() {
        return diagnostics;
    }
}
