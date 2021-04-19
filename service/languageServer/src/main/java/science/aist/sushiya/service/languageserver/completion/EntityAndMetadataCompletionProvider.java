package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.AdditionalInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the completion provider for the entities and metadata.</p>
 *
 * @author SophieBauernfeind
 */
public class EntityAndMetadataCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityAndMetadataCompletionProvider.class);
    private static final List<CompletionItem> COMPLETION_ITEMS = new ArrayList<>();

    public EntityAndMetadataCompletionProvider() {
        CompletionItem alias = new CompletionItem("Alias");
        TextEdit textEditAlias = new TextEdit();
        textEditAlias.setNewText("Alias:");
        alias.setTextEdit(textEditAlias);
        alias.setKind(CompletionItemKind.Keyword);
        alias.setDocumentation(AdditionalInformation.ALIAS_INFORMATION);
        COMPLETION_ITEMS.add(alias);

        CompletionItem profile = new CompletionItem("Profile");
        TextEdit textEditProfile = new TextEdit();
        textEditProfile.setNewText("Profile:");
        profile.setTextEdit(textEditProfile);
        profile.setKind(CompletionItemKind.Keyword);
        profile.setDocumentation(AdditionalInformation.PROFILE_INFORMATION);
        COMPLETION_ITEMS.add(profile);

        CompletionItem extension = new CompletionItem("Extension");
        TextEdit textEditExtension = new TextEdit();
        textEditExtension.setNewText("Extension:");
        extension.setTextEdit(textEditExtension);
        extension.setKind(CompletionItemKind.Keyword);
        extension.setDocumentation(AdditionalInformation.EXTENSION_INFORMATION);
        COMPLETION_ITEMS.add(extension);

        CompletionItem instance = new CompletionItem("Instance");
        TextEdit textEditInstance = new TextEdit();
        textEditInstance.setNewText("Instance:");
        instance.setTextEdit(textEditInstance);
        instance.setKind(CompletionItemKind.Keyword);
        instance.setDocumentation(AdditionalInformation.INSTANCE_INFORMATION);
        COMPLETION_ITEMS.add(instance);

        CompletionItem instanceOf = new CompletionItem("InstanceOf");
        TextEdit textEditInstanceOf = new TextEdit();
        textEditInstanceOf.setNewText("InstanceOf:");
        instanceOf.setTextEdit(textEditInstanceOf);
        instanceOf.setKind(CompletionItemKind.Keyword);
        instanceOf.setDocumentation(AdditionalInformation.INSTANCE_OF_INFORMATION);
        COMPLETION_ITEMS.add(instanceOf);

        CompletionItem invariant = new CompletionItem("Invariant");
        TextEdit textEditInvariant = new TextEdit();
        textEditInvariant.setNewText("Invariant:");
        invariant.setTextEdit(textEditInvariant);
        invariant.setKind(CompletionItemKind.Keyword);
        invariant.setDocumentation(AdditionalInformation.INVARIANT_INFORMATION);
        COMPLETION_ITEMS.add(invariant);

        CompletionItem valueSet = new CompletionItem("ValueSet");
        TextEdit textEditValueSet = new TextEdit();
        textEditValueSet.setNewText("ValueSet:");
        valueSet.setTextEdit(textEditValueSet);
        valueSet.setKind(CompletionItemKind.Keyword);
        valueSet.setDocumentation(AdditionalInformation.VALUE_SET_INFORMATION);
        COMPLETION_ITEMS.add(valueSet);

        CompletionItem codeSystem = new CompletionItem("CodeSystem");
        TextEdit textEditCodeSysten = new TextEdit();
        textEditCodeSysten.setNewText("CodeSystem:");
        codeSystem.setTextEdit(textEditCodeSysten);
        codeSystem.setKind(CompletionItemKind.Keyword);
        codeSystem.setDocumentation(AdditionalInformation.CODE_SYSTEM_INFORMATION);
        COMPLETION_ITEMS.add(codeSystem);

        CompletionItem ruleSet = new CompletionItem("RuleSet");
        TextEdit textEditRuleSet = new TextEdit();
        textEditRuleSet.setNewText("RuleSet: ");
        ruleSet.setTextEdit(textEditRuleSet);
        ruleSet.setKind(CompletionItemKind.Keyword);
        ruleSet.setDocumentation(AdditionalInformation.RULE_SET_INFORMATION);
        COMPLETION_ITEMS.add(ruleSet);

        CompletionItem mapping = new CompletionItem("Mapping");
        TextEdit textEditMapping = new TextEdit();
        textEditMapping.setNewText("Mapping:");
        mapping.setTextEdit(textEditMapping);
        mapping.setKind(CompletionItemKind.Keyword);
        mapping.setDocumentation(AdditionalInformation.MAPPING_INFORMATION);
        COMPLETION_ITEMS.add(mapping);

        CompletionItem mixins = new CompletionItem("Mixins");
        TextEdit textEditMixins = new TextEdit();
        textEditMixins.setNewText("Mixins");
        mixins.setTextEdit(textEditMixins);
        mixins.setKind(CompletionItemKind.Keyword);
        COMPLETION_ITEMS.add(mixins);

        CompletionItem parent = new CompletionItem("Parent");
        TextEdit textEditParent = new TextEdit();
        textEditParent.setNewText("Parent:");
        parent.setTextEdit(textEditParent);
        parent.setKind(CompletionItemKind.Keyword);
        parent.setDocumentation(AdditionalInformation.PARENT_INFORMATION);
        COMPLETION_ITEMS.add(parent);

        CompletionItem id = new CompletionItem("Id");
        TextEdit textEditId = new TextEdit();
        textEditId.setNewText("Id:");
        id.setTextEdit(textEditId);
        id.setKind(CompletionItemKind.Keyword);
        id.setDocumentation(AdditionalInformation.ID_INFORMATION);
        COMPLETION_ITEMS.add(id);

        CompletionItem title = new CompletionItem("Title");
        TextEdit textEditTitle = new TextEdit();
        textEditTitle.setNewText("Title:");
        title.setTextEdit(textEditTitle);
        title.setKind(CompletionItemKind.Keyword);
        title.setDocumentation(AdditionalInformation.TITLE_INFORMATION);
        COMPLETION_ITEMS.add(title);

        CompletionItem description = new CompletionItem("Description");
        TextEdit textEditDescription = new TextEdit();
        textEditDescription.setNewText("Description:");
        description.setTextEdit(textEditDescription);
        description.setKind(CompletionItemKind.Keyword);
        description.setDocumentation(AdditionalInformation.DESCRIPTION_INFORMATION);
        COMPLETION_ITEMS.add(description);

        CompletionItem expression = new CompletionItem("Expression");
        TextEdit textEditExpression = new TextEdit();
        textEditExpression.setNewText("Expression:");
        expression.setTextEdit(textEditExpression);
        expression.setKind(CompletionItemKind.Keyword);
        expression.setDocumentation(AdditionalInformation.EXPRESSION_INFORMATION);
        COMPLETION_ITEMS.add(expression);

        CompletionItem xpath = new CompletionItem("XPath");
        TextEdit textEditXPath = new TextEdit();
        textEditXPath.setNewText("XPath:");
        xpath.setTextEdit(textEditXPath);
        xpath.setKind(CompletionItemKind.Keyword);
        COMPLETION_ITEMS.add(xpath);

        CompletionItem severity = new CompletionItem("Severity");
        TextEdit textEditSeverity = new TextEdit();
        textEditSeverity.setNewText("Severity:");
        severity.setTextEdit(textEditSeverity);
        severity.setKind(CompletionItemKind.Keyword);
        severity.setDocumentation(AdditionalInformation.SEVERITY_INFORMATION);
        COMPLETION_ITEMS.add(severity);

        CompletionItem usage = new CompletionItem("Usage");
        TextEdit textEditUsage = new TextEdit();
        textEditUsage.setNewText("Usage:");
        usage.setTextEdit(textEditUsage);
        usage.setKind(CompletionItemKind.Keyword);
        usage.setDocumentation(AdditionalInformation.USAGE_INFORMATION);
        COMPLETION_ITEMS.add(usage);

        CompletionItem source = new CompletionItem("Source");
        TextEdit textEditSource = new TextEdit();
        textEditSource.setNewText("Source:");
        source.setTextEdit(textEditSource);
        source.setKind(CompletionItemKind.Keyword);
        source.setDocumentation(AdditionalInformation.SOURCE_INFORMATION);
        COMPLETION_ITEMS.add(source);

        CompletionItem target = new CompletionItem("Target");
        TextEdit textEditTarget = new TextEdit();
        textEditTarget.setNewText("Target:");
        target.setTextEdit(textEditTarget);
        target.setKind(CompletionItemKind.Keyword);
        target.setDocumentation(AdditionalInformation.TARGET_INFORMATION);
        COMPLETION_ITEMS.add(target);
    }

    @Override
    public List<CompletionItem> get() {
        return COMPLETION_ITEMS;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        if(textDocumentItem != null
                && completionParams != null
                && completionParams.getContext() != null
                && completionParams.getContext().getTriggerKind() != null) {
            return checkLine(textDocumentItem, completionParams)
                    && completionParams.getContext().getTriggerKind() == CompletionTriggerKind.Invoked;
        }
        return false;
    }

    private boolean checkLine(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            String firstWord = line.trim().split("\\s")[0];
            boolean substringOfKeyword = false;
            for (CompletionItem item: COMPLETION_ITEMS) {
                substringOfKeyword = substringOfKeyword || item.getLabel().contains(firstWord);
            }
            return (substringOfKeyword ||  line.matches("^\\s*\\n") )
                    && line.length() >= completionParams.getPosition().getCharacter();
        }catch (Exception exception){
            LOGGER.error(exception.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "EntityAndMetadataCompletionProvider";
    }
}
