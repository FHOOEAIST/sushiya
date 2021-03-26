package science.aist.sushiya.service.languageserver;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FSHFileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FSHFileHandler.class);
    private static final FSHFileHandler instance = new FSHFileHandler();
    private Map<String,TextDocumentItem> openedDocuments = new HashMap<>();
    private List<String> createdProfiles = new ArrayList<>();
    private List<String> createdExtensions = new ArrayList<>();
    private List<String> createdAlias = new ArrayList<>();
    private List<String> createdCodeSystems = new ArrayList<>();
    private List<String> createdValueSets = new ArrayList<>();
    private List<String> createdRuleSets = new ArrayList<>();

    //TODO:check why every second character of saved aliases are whitespace

    //private constructor to make it as a singleton
    private FSHFileHandler(){}

    public  static FSHFileHandler getInstance(){
        return instance;
    }

    public void update(DidChangeTextDocumentParams params){
        List<TextDocumentContentChangeEvent> contentChanges = params.getContentChanges();
        if(openedDocuments.containsKey(params.getTextDocument().getUri())){
            TextDocumentItem textDocument = openedDocuments.get(params.getTextDocument().getUri());
            if (!contentChanges.isEmpty()) {
                removeAllEntities(textDocument);
                textDocument.setText(contentChanges.get(0).getText());
                addAllEntities(textDocument);
            }
        }else{
            LOGGER.error("No file with uri: {}", params.getTextDocument().getUri());
        }
    }

    public void addFile(DidOpenTextDocumentParams params){
        TextDocumentItem textDocument = params.getTextDocument();
        addAllEntities(textDocument);
        if(textDocument.getUri() != null){
            openedDocuments.put(textDocument.getUri(),textDocument);
        }
    }

    public void removeFile(DidCloseTextDocumentParams params){
        String uri = params.getTextDocument().getUri();
        if(openedDocuments.containsKey(uri)){
            TextDocumentItem textDocument = openedDocuments.get(uri);
            removeAllEntities(textDocument);
            openedDocuments.remove(uri);
        }else{
            LOGGER.error("No file with uri: {}", params.getTextDocument().getUri());
        }
    }

    public TextDocumentItem getFile(TextDocumentIdentifier identifier){
        if(openedDocuments.containsKey(identifier.getUri())){
            return openedDocuments.get(identifier.getUri());
        }else{
            LOGGER.error("No file with uri: {}", identifier.getUri());
            return null;
        }
    }

    private List<String> getEntities(Entity entity,TextDocumentItem textDocument){
        List<String> result = new ArrayList<>();
        String entityName;
        if(entity.equals(Entity.CODESYSTEM)){
            entityName = "CodeSystem";
        }else if(entity.equals(Entity.VALUESET)){
            entityName = "ValueSet";
        }else if(entity.equals(Entity.RULESET)){
            entityName = "RuleSet";
        }
        else{
            entityName = entity.name().substring(0,1) +
                    entity.name().substring(1,entity.name().length()).toLowerCase();
        }
        String[]lines = textDocument.getText().split("\\n");
        for (String line:lines) {
            if(entity.equals(Entity.ALIAS)){
                if(line.matches("\\s*" + entityName + "\\s*:\\s*\\w+\\s*=\\s*\\S+\\s*")){
                    String createdEntityName = line.replaceFirst("\\s*" + entityName + "\\s*:","").trim();
                    result.add(createdEntityName);
                }
            }else {
                if(line.matches("\\s*" + entityName + "\\s*:\\s*\\w+\\s*")){
                    String createdEntityName = line.trim().split("\\s")[line.trim().split("\\s").length-1];
                    result.add(createdEntityName);
                }
            }
        }
        return result;
    }

    private void addEntities(Entity entity, List<String> entityNames){
        switch(entity){
            case RULESET:
                for (String entityName: entityNames) {
                    if(! createdRuleSets.contains(entityName)){
                        createdRuleSets.add(entityName);
                    }
                }
                break;
            case CODESYSTEM:
                for (String entityName: entityNames) {
                    if(! createdCodeSystems.contains(entityName)){
                        createdCodeSystems.add(entityName);
                    }
                }
                break;
            case VALUESET:
                for (String entityName: entityNames) {
                    if(! createdValueSets.contains(entityName)){
                        createdValueSets.add(entityName);
                    }
                }
                break;
            case ALIAS:
                for (String entityName: entityNames) {
                    if(! createdAlias.contains(entityName)){
                        createdAlias.add(entityName);
                    }
                }
                break;
            case EXTENSION:
                for (String entityName: entityNames) {
                    if(! createdExtensions.contains(entityName)){
                        createdExtensions.add(entityName);
                    }
                }
                break;
            case PROFILE:
                for (String entityName: entityNames) {
                    if(! createdProfiles.contains(entityName)){
                        createdProfiles.add(entityName);
                    }
                }
                break;
        }
    }

    private void removeEntities(Entity entity, List<String> entityNames){
        switch(entity){
            case RULESET:
                createdRuleSets.removeAll(entityNames);
                break;
            case CODESYSTEM:
                createdCodeSystems.removeAll(entityNames);
                break;
            case VALUESET:
                createdValueSets.removeAll(entityNames);
                break;
            case ALIAS:
                createdAlias.removeAll(entityNames);
                break;
            case EXTENSION:
                createdExtensions.removeAll(entityNames);
                break;
            case PROFILE:
                createdProfiles.removeAll(entityNames);
                break;
        }
    }

    public List<String> getCreatedEntities(Entity entity){
        switch(entity){
            case RULESET:
                return createdRuleSets;
            case CODESYSTEM:
                return createdCodeSystems;
            case VALUESET:
                return createdValueSets;
            case ALIAS:
                return createdAlias;
            case EXTENSION:
                return createdExtensions;
            case PROFILE:
                return createdProfiles;
        }
        return new ArrayList<>();
    }

    private void addAllEntities(TextDocumentItem textDocument){
        addEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
        addEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
        addEntities(Entity.ALIAS, getEntities(Entity.ALIAS,textDocument));
        addEntities(Entity.CODESYSTEM, getEntities(Entity.CODESYSTEM,textDocument));
        addEntities(Entity.VALUESET, getEntities(Entity.VALUESET,textDocument));
        addEntities(Entity.RULESET, getEntities(Entity.RULESET,textDocument));
    }

    private void removeAllEntities(TextDocumentItem textDocument){
        removeEntities(Entity.PROFILE, getEntities(Entity.PROFILE,textDocument));
        removeEntities(Entity.EXTENSION, getEntities(Entity.EXTENSION,textDocument));
        removeEntities(Entity.ALIAS, getEntities(Entity.ALIAS,textDocument));
        removeEntities(Entity.CODESYSTEM, getEntities(Entity.CODESYSTEM,textDocument));
        removeEntities(Entity.VALUESET, getEntities(Entity.VALUESET,textDocument));
        removeEntities(Entity.RULESET, getEntities(Entity.RULESET,textDocument));
    }

    protected void clean(){
        openedDocuments = new HashMap<>();
        createdProfiles = new ArrayList<>();
        createdExtensions = new ArrayList<>();
        createdAlias = new ArrayList<>();
        createdCodeSystems = new ArrayList<>();
        createdValueSets = new ArrayList<>();
        createdRuleSets = new ArrayList<>();
    }
}
