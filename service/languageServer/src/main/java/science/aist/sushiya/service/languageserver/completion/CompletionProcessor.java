package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>For a better structure of the server, the completion requests will be handled here.</p>
 * <p>The CompletionProcessor has a collection of different CompletionProvider.</p>
 * <p>Each CompletionProvider, provides a different list of CompletionItems for a special case.</p>
 *
 * @author SophieBauernfeind
 */
public class CompletionProcessor implements Function<CompletionParams,Either<List<CompletionItem>, CompletionList>> {
    private static final List<ICompletionProvider> completionProviders = new ArrayList<>();
    private static final ICompletionProvider defaultProvider = new FSHKeywordCompletionProvider();
    private static final Logger LOGGER = LoggerFactory.getLogger(CompletionProcessor.class);

    public CompletionProcessor(){
        completionProviders.add(new AliasCompletionProvider());
        completionProviders.add(new CsRuleCompletionProvider());
        completionProviders.add(new EntityAndMetadataCompletionProvider());
        completionProviders.add(new InstanceOfCompletionProvider());
        completionProviders.add(new MappingEntityRuleCompletionProvider());
        completionProviders.add(new ParentCompletionProvider());
        completionProviders.add(new PathCompletionProvider());
        completionProviders.add(new SourceCompletionProvider());
        completionProviders.add(new VsRuleCompletionProvider());
        completionProviders.add(new SdRuleCompletionProvider());
    }

    @Override
    public Either<List<CompletionItem>, CompletionList> apply(CompletionParams completionParams) {
        List<List<CompletionItem>> completionItems = new ArrayList<>();
        if(completionParams.getTextDocument() == null){
            return null;
        }
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(completionParams.getTextDocument());
        for (ICompletionProvider cp: completionProviders) {
            if(cp.test(textDocument,completionParams)){
                completionItems.add(cp.get());
                LOGGER.info("completion provider {} activated.", cp.toString());
            }
        }
        //if no other completion provider is in charge use default provider
        if(completionItems.isEmpty()){
            completionItems.add(defaultProvider.get());
            completionItems.add(FSHFileHandler.getInstance().getCreatedEntities(Entity.PROFILE)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
            completionItems.add(FSHFileHandler.getInstance().getCreatedEntities(Entity.EXTENSION)
                    .stream().map(CompletionItem::new).collect(Collectors.toList()));
        }
        return Either.forLeft(completionItems.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));
    }
}
