package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>This class handles all open fsh files of the editor and provides additional information.</p>
 *
 * @author SophieBauernfeind
 */
public class FSHFileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FSHFileHandler.class);
    private static final FSHFileHandler instance = new FSHFileHandler();
    private Map<String,TextDocumentItem> openedDocuments = new HashMap<>();
    private List<String> createdProfiles = new ArrayList<>();
    private List<String> createdExtensions = new ArrayList<>();

    enum Entity{
        PROFILE,
        EXTENSION
    }

    //private constructor to make it as a singleton
    private FSHFileHandler(){}

    public  static FSHFileHandler getInstance(){
        return instance;
    }

    public void update(DidChangeTextDocumentParams params){
        List<TextDocumentContentChangeEvent> contentChanges = params.getContentChanges();
        TextDocumentItem textDocument = openedDocuments.get(params.getTextDocument().getUri());
        if (!contentChanges.isEmpty()) {
            removeEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
            removeEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
            textDocument.setText(contentChanges.get(0).getText());
            addEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
            addEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
        }
    }

    public void addFile(DidOpenTextDocumentParams params){
        TextDocumentItem textDocument = params.getTextDocument();
        addEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
        addEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
        openedDocuments.put(textDocument.getUri(),textDocument);
    }

    public void removeFile(DidCloseTextDocumentParams params){
        String uri = params.getTextDocument().getUri();
        TextDocumentItem textDocument = openedDocuments.get(uri);
        removeEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
        removeEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
        openedDocuments.remove(uri);
    }

    public TextDocumentItem getFile(String uri){
        return openedDocuments.get(uri);
    }

    private List<String> getEntities(Entity entity,TextDocumentItem textDocument){
        List<String> result = new ArrayList<>();
        String entityName = entity.name().substring(0,1) +
                            entity.name().substring(1,entity.name().length()).toLowerCase();
        String[]lines = textDocument.getText().split("\\n");
        for (String line:lines) {
            if(line.matches("\\s*" + entityName + "\\s*:\\s*\\w+\\s*")){
                String createdEntityName = line.trim().split("\\s")[line.trim().split("\\s").length-1];
                result.add(createdEntityName);
            }
        }
        return result;
    }

    private void addEntities(Entity entity, List<String> entityNames){
        switch(entity){
            case EXTENSION:
                createdExtensions.addAll(entityNames);
                break;
            case PROFILE:
                createdProfiles.addAll(entityNames);
                break;
        }
    }

    private void removeEntities(Entity entity, List<String> entityNames){
        switch(entity){
            case EXTENSION:
                createdExtensions.removeAll(entityNames);
                break;
            case PROFILE:
                createdProfiles.removeAll(entityNames);
                break;
        }
    }

    public List<String> getCreatedProfiles() {
        return createdProfiles;
    }

    public List<String> getCreatedExtensions() {
        return createdExtensions;
    }
}
