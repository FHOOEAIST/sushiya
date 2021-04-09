package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>This Helper class is for providers which are working with incoming requests with a list of location response.</p>
 *
 * @author SophieBauernfeind
 */
public class LocationProviderHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationProviderHelper.class);

    public String getName(@NotNull TextDocumentItem textDocument, @NotNull Position position){
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

    public List<Location> getLocations(@NotNull String searchedName, @NotNull String RegexLine){
        List<Location> result = new ArrayList<>();
        for (Map.Entry<String,TextDocumentItem> document : FSHFileHandler.getInstance().getOpenedDocuments().entrySet()) {
            if(document.getValue().getText().contains(searchedName)){
                String text = document.getValue().getText();
                int characterPos = 0;

                String[] lines = text.split("\n");
                for (int pos = 0; pos < lines.length; pos++) {
                    if(lines[pos].matches(RegexLine)){
                        characterPos = lines[pos].indexOf(searchedName);

                        Position start = new Position(pos, characterPos);
                        Position end = new Position(pos, characterPos + searchedName.length());
                        result.add(new Location(document.getKey(),
                                new Range(start,end)));
                    }
                }

            }
        }
        return result.size() > 0 ? result : new ArrayList<>();
    }
}
