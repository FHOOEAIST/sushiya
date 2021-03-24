package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.TextDocumentItem;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public interface ICompletionProvider extends Supplier<List<CompletionItem>>, BiPredicate<TextDocumentItem, CompletionParams> {

}
