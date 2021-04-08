package science.aist.sushiya.service.languageserver.implementation;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>The implementation provider handles the incoming implementation requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class ImplementationProvider implements Function<ImplementationParams,
        Either<List<? extends Location>, List<? extends LocationLink>>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImplementationProvider.class);
    private static final String regexUsingMetadata= "(Expression|InstanceOf|Parent|Source)";

    @Override
    public Either<List<? extends Location>, List<? extends LocationLink>> apply(ImplementationParams implementationParams) {
        List<Location> result = new ArrayList<>();
        String searchedImplementations = getName(
                FSHFileHandler.getInstance().getFile(new TextDocumentIdentifier(implementationParams.getTextDocument().getUri())),
                implementationParams.getPosition());

        if(searchedImplementations == null){
            return Either.forLeft(result);
        }

        for (Map.Entry<String,TextDocumentItem> document : FSHFileHandler.getInstance().getOpenedDocuments().entrySet()) {
            if(document.getValue().getText().contains(searchedImplementations)){
                String text = document.getValue().getText();
                int linePos = 0;
                int characterPos = 0;

                String[] lines = text.split("\n");
                for (int pos = 0; pos < lines.length; pos++) {
                    if(lines[pos].matches("\\s*"+ regexUsingMetadata +"\\s*:\\s+" + searchedImplementations + "\\s*")){
                        linePos = pos;
                        characterPos = lines[pos].indexOf(searchedImplementations);

                        Position start = new Position(linePos, characterPos);
                        Position end = new Position(linePos, characterPos + searchedImplementations.length());
                        result.add(new Location(document.getKey(),
                                new Range(start,end)));
                    }
                }

            }
        }
        return Either.forLeft(result);
    }

    private String getName(TextDocumentItem textDocument, Position position){
        try{
            String line = textDocument.getText().split("\n")[position.getLine()];
            boolean startFound = false;
            boolean endFound = false;
            int startPos = position.getCharacter();
            int endPos = position.getCharacter() + 1;
            while ( !startFound && startPos > 0){
                if(line.charAt(startPos) == ' ' ||
                        String.valueOf(line.charAt(startPos)).matches("\\p{Punct}")){
                    startFound = true;
                }else{
                    startPos --;
                }
            }
            while (!endFound && endPos < line.length()){
                if(line.charAt(endPos) == ' ' ||
                        String.valueOf(line.charAt(endPos)).matches("\\p{Punct}")){
                    endFound = true;
                }else{
                    endPos ++;
                }
            }
            if( startFound && (endFound || endPos == line.length())){
                String result = line.substring(startPos+1, endPos);
                return result.matches("(\\s*|\\p{Punct})")? null : result;
            }
            return null;
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return null;
        }
    }
}
