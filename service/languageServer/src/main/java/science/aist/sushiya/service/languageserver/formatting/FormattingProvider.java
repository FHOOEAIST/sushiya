package science.aist.sushiya.service.languageserver.formatting;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.parser.FSHLexer;
import science.aist.sushiya.service.languageserver.parser.FSHParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the formatting requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */
public class FormattingProvider implements Function<DocumentFormattingParams, List<? extends TextEdit>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FormattingProvider.class);

    @Override
    public List<? extends TextEdit> apply(DocumentFormattingParams documentFormattingParams) {
        List<TextEdit> result = new ArrayList<>();
        TextDocumentItem textDocument = FSHFileHandler.getInstance().getFile(documentFormattingParams.getTextDocument());
        Map<Integer, String> comments = new HashMap<>();

        //save comments before refactoring, because the parser steps over comments and
        //the formatting listener can't build a new string with the comments
        Thread saveComments = new Thread(()-> {
            String[] lines = textDocument.getText().split("\n");
            boolean inComment = false;
            int startCommentPosition = 0;
            for(int pos = 0; pos < lines.length; pos++){
                String line = lines[pos];
                //is a simple one line comment
                if(line.contains("//")){
                    int startIndex = line.indexOf("//");
                    String subString = line.substring(startIndex);
                    comments.put(pos, subString);
                }
                //if line contains begin and no end for block comment
                if(line.contains("/*") && !line.contains("*/")){
                    int startIndex = line.indexOf("/*");
                    String subString = line.substring(startIndex);
                    startCommentPosition = pos;
                    inComment = true;
                    comments.put(startCommentPosition,subString);
                }
                //if line contains no begin and end for block comment
                if(!line.contains("/*") && line.contains("*/")){
                    int endIndex = line.indexOf("*/");
                    String subString = line.substring(0, endIndex + 2);
                    comments.replace(startCommentPosition,
                            comments.get(startCommentPosition) + subString);
                    inComment = false;
                    startCommentPosition = 0;
                }
                //if line contains a start and end for block comment
                if(line.contains("/*") && line.contains("*/")){
                    int startIndex = line.indexOf("/*");
                    int endIndex = line.indexOf("*/");

                    //this else if is to prevent wrong commenting, if in the line "*/*"
                    if(endIndex < startIndex){
                        String subString = line.substring(0, endIndex + 2);
                        comments.replace(startCommentPosition,
                                comments.get(startCommentPosition) + subString);
                    }else{
                        startCommentPosition = pos;
                        String subString = line.substring(startIndex, endIndex + 2);
                        comments.put(startCommentPosition, subString);
                    }
                    inComment = false;
                    startCommentPosition = 0;
                }
                //if a block comment has started, but there is no begin or end
                if(inComment && !line.contains("/*") && !line.contains("*/")){
                    comments.replace(startCommentPosition,
                            comments.get(startCommentPosition) + line);
                    LOGGER.info("no BEGIN and END: {}", line);
                }
            }
        });
        saveComments.start();



        FSHFormattingListener formattingListener = new FSHFormattingListener();

        Thread parsing= new Thread(() -> {String text = textDocument.getText();
            CharStream input = CharStreams.fromString(text);
            FSHLexer lexer = new FSHLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            FSHParser parser = new FSHParser(tokens);
            //diagnostic provider is responsible for error checking
            parser.removeErrorListeners();
            parser.addParseListener(formattingListener);
            parser.doc();});
        parsing.start();


        //before inserting the comments, both threads have to finish
        try {
            saveComments.join();
            parsing.join();

            LOGGER.info("ALL comments: {}", comments);

            String formattedText = formattingListener.getFormattedText();
            String[]lines = formattedText.split("\n");
            //TODO: insert comments, which where removed before

            TextEdit textEdit = new TextEdit();
            textEdit.setNewText(formattedText);
            textEdit.setRange(new Range(new Position(0,0),
                    new Position(lines.length-1,lines[lines.length-1].length()-1)));
            result.add(textEdit);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }

        return result;
    }

}