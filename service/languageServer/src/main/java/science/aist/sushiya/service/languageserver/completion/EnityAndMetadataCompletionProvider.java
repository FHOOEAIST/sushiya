package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO insert documentation for this class</p>
 *
 * @author SophieBauernfeind
 */
public class EnityAndMetadataCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnityAndMetadataCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public EnityAndMetadataCompletionProvider() {
        CompletionItem alias = new CompletionItem("Alias");
        TextEdit textEditAlias = new TextEdit();
        textEditAlias.setNewText("Alias:");
        alias.setTextEdit(textEditAlias);
        alias.setKind(CompletionItemKind.Keyword);
        alias.setDocumentation("Aliases allow the user to replace a lengthy url or oid with a short string. Aliases are for readability only, and do not change the meaning of rules. Typical uses of aliases are to represent code systems and canonical URLs.");
        completionItems.add(alias);

        CompletionItem profile = new CompletionItem("Profile");
        TextEdit textEditProfile = new TextEdit();
        textEditProfile.setNewText("Profile:");
        profile.setTextEdit(textEditProfile);
        profile.setKind(CompletionItemKind.Keyword);
        profile.setDocumentation("To define a profile, the keywords Profile and Parent are required, and Id, Title, and Description are OPTIONAL. Rules defining the profile follow immediately after the keyword section.");
        completionItems.add(profile);

        CompletionItem extension = new CompletionItem("Extension");
        TextEdit textEditExtension = new TextEdit();
        textEditExtension.setNewText("Extension:");
        extension.setTextEdit(textEditExtension);
        extension.setKind(CompletionItemKind.Keyword);
        extension.setDocumentation("Defining extensions is similar to defining a profile, except that the parent of an extension is not required. Extensions can also inherit from other extensions, but if the Parent keyword is omitted, the parent is assumed to be FHIR’s Extension element.");
        completionItems.add(extension);

        CompletionItem instance = new CompletionItem("Instance");
        TextEdit textEditInstance = new TextEdit();
        textEditInstance.setNewText("Instance:");
        instance.setTextEdit(textEditInstance);
        instance.setKind(CompletionItemKind.Keyword);
        completionItems.add(instance);

        CompletionItem instanceOf = new CompletionItem("InstanceOf");
        TextEdit textEditInstanceOf = new TextEdit();
        textEditInstanceOf.setNewText("InstanceOf:");
        instanceOf.setTextEdit(textEditInstanceOf);
        instanceOf.setKind(CompletionItemKind.Keyword);
        completionItems.add(instanceOf);

        CompletionItem invariant = new CompletionItem("Invariant");
        TextEdit textEditInvariant = new TextEdit();
        textEditInvariant.setNewText("Invariant:");
        invariant.setTextEdit(textEditInvariant);
        invariant.setKind(CompletionItemKind.Keyword);
        completionItems.add(invariant);

        CompletionItem valueSet = new CompletionItem("ValueSet");
        TextEdit textEditValueSet = new TextEdit();
        textEditValueSet.setNewText("ValueSet:");
        valueSet.setTextEdit(textEditValueSet);
        valueSet.setKind(CompletionItemKind.Keyword);
        completionItems.add(valueSet);

        CompletionItem codeSystem = new CompletionItem("CodeSystem");
        TextEdit textEditCodeSysten = new TextEdit();
        textEditCodeSysten.setNewText("CodeSystem:");
        codeSystem.setTextEdit(textEditCodeSysten);
        codeSystem.setKind(CompletionItemKind.Keyword);
        completionItems.add(codeSystem);

        CompletionItem ruleSet = new CompletionItem("RuleSet");
        TextEdit textEditRuleSet = new TextEdit();
        textEditRuleSet.setNewText("RuleSet: ");
        ruleSet.setTextEdit(textEditRuleSet);
        ruleSet.setKind(CompletionItemKind.Keyword);
        completionItems.add(ruleSet);

        CompletionItem mapping = new CompletionItem("Mapping");
        TextEdit textEditMapping = new TextEdit();
        textEditMapping.setNewText("Mapping:");
        mapping.setTextEdit(textEditMapping);
        mapping.setKind(CompletionItemKind.Keyword);
        completionItems.add(mapping);

        CompletionItem mixins = new CompletionItem("Mixins");
        TextEdit textEditMixins = new TextEdit();
        textEditMixins.setNewText("Mixins");
        mixins.setTextEdit(textEditMixins);
        mixins.setKind(CompletionItemKind.Keyword);
        completionItems.add(mixins);

        CompletionItem parent = new CompletionItem("Parent");
        TextEdit textEditParent = new TextEdit();
        textEditParent.setNewText("Parent:");
        parent.setTextEdit(textEditParent);
        parent.setKind(CompletionItemKind.Keyword);
        completionItems.add(parent);

        CompletionItem id = new CompletionItem("Id");
        TextEdit textEditId = new TextEdit();
        textEditId.setNewText("Id:");
        id.setTextEdit(textEditId);
        id.setKind(CompletionItemKind.Keyword);
        completionItems.add(id);

        CompletionItem title = new CompletionItem("Title");
        TextEdit textEditTitle = new TextEdit();
        textEditTitle.setNewText("Title:");
        title.setTextEdit(textEditTitle);
        title.setKind(CompletionItemKind.Keyword);
        completionItems.add(title);

        CompletionItem description = new CompletionItem("Description");
        TextEdit textEditDescription = new TextEdit();
        textEditDescription.setNewText("Description:");
        description.setTextEdit(textEditDescription);
        description.setKind(CompletionItemKind.Keyword);
        completionItems.add(description);

        CompletionItem expression = new CompletionItem("Expression");
        TextEdit textEditExpression = new TextEdit();
        textEditExpression.setNewText("Expression:");
        expression.setTextEdit(textEditExpression);
        expression.setKind(CompletionItemKind.Keyword);
        completionItems.add(expression);

        CompletionItem xpath = new CompletionItem("XPath");
        TextEdit textEditXPath = new TextEdit();
        textEditXPath.setNewText("XPath:");
        xpath.setTextEdit(textEditXPath);
        xpath.setKind(CompletionItemKind.Keyword);
        completionItems.add(xpath);

        CompletionItem severity = new CompletionItem("Severity");
        TextEdit textEditSeverity = new TextEdit();
        textEditSeverity.setNewText("Severity:");
        severity.setTextEdit(textEditSeverity);
        severity.setKind(CompletionItemKind.Keyword);
        completionItems.add(severity);

        CompletionItem usage = new CompletionItem("Usage");
        TextEdit textEditUsage = new TextEdit();
        textEditUsage.setNewText("Usage:");
        usage.setTextEdit(textEditUsage);
        usage.setKind(CompletionItemKind.Keyword);
        completionItems.add(usage);

        CompletionItem source = new CompletionItem("Source");
        TextEdit textEditSource = new TextEdit();
        textEditSource.setNewText("Source:");
        source.setTextEdit(textEditSource);
        source.setKind(CompletionItemKind.Keyword);
        completionItems.add(source);

        CompletionItem target = new CompletionItem("Target");
        TextEdit textEditTarget = new TextEdit();
        textEditTarget.setNewText("Target:");
        target.setTextEdit(textEditTarget);
        target.setKind(CompletionItemKind.Keyword);
        completionItems.add(target);
    }

    @Override
    public List<CompletionItem> get() {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.trim().split("\\s").length == 1 && completionParams.getContext().getTriggerKind() == CompletionTriggerKind.Invoked;

        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
    }
}
