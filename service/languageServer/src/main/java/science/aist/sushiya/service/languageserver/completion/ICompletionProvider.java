package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;

import java.util.List;
import java.util.function.Supplier;

public interface ICompletionProvider extends Supplier<List<CompletionItem>> {

}
