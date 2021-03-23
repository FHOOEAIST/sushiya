package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public interface ICompletionProvider extends BiFunction<TextDocumentItem, CompletionParams, List<CompletionItem>>, BiPredicate<TextDocumentItem, CompletionParams> {

}
