package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the completion provider for the entities and metadata.</p>
 *
 * @author SophieBauernfeind
 */
public class EntityAndMetadataCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityAndMetadataCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public EntityAndMetadataCompletionProvider() {
        CompletionItem alias = new CompletionItem("Alias");
        TextEdit textEditAlias = new TextEdit();
        textEditAlias.setNewText("Alias:");
        alias.setTextEdit(textEditAlias);
        alias.setKind(CompletionItemKind.Keyword);
        alias.setDocumentation("Aliases allow the user to replace a lengthy url or oid with a short string. " +
                "Aliases are for readability only, and do not change the meaning of rules. Typical uses of aliases are " +
                "to represent code systems and canonical URLs.");
        completionItems.add(alias);

        CompletionItem profile = new CompletionItem("Profile");
        TextEdit textEditProfile = new TextEdit();
        textEditProfile.setNewText("Profile:");
        profile.setTextEdit(textEditProfile);
        profile.setKind(CompletionItemKind.Keyword);
        profile.setDocumentation("To define a profile, the keywords Profile and Parent are required, and Id, Title, " +
                "and Description are OPTIONAL. Rules defining the profile follow immediately after the keyword section.");
        completionItems.add(profile);

        CompletionItem extension = new CompletionItem("Extension");
        TextEdit textEditExtension = new TextEdit();
        textEditExtension.setNewText("Extension:");
        extension.setTextEdit(textEditExtension);
        extension.setKind(CompletionItemKind.Keyword);
        extension.setDocumentation("Defining extensions is similar to defining a profile, except that the parent of an " +
                "extension is not required. Extensions can also inherit from other extensions, but if the Parent keyword " +
                "is omitted, the parent is assumed to be FHIR’s Extension element.");
        completionItems.add(extension);

        CompletionItem instance = new CompletionItem("Instance");
        TextEdit textEditInstance = new TextEdit();
        textEditInstance.setNewText("Instance:");
        instance.setTextEdit(textEditInstance);
        instance.setKind(CompletionItemKind.Keyword);
        instance.setDocumentation("Instances are defined using the keywords Instance, InstanceOf, Title, Usage and Description. " +
                "The InstanceOf is required, and plays a role analogous to the Parent of a profile. " +
                "The value of InstanceOf can be the name, id, or url for any profile, resource, or complex data type " +
                "defined internally or externally.");
        completionItems.add(instance);

        CompletionItem instanceOf = new CompletionItem("InstanceOf");
        TextEdit textEditInstanceOf = new TextEdit();
        textEditInstanceOf.setNewText("InstanceOf:");
        instanceOf.setTextEdit(textEditInstanceOf);
        instanceOf.setKind(CompletionItemKind.Keyword);
        instanceOf.setDocumentation("The profile or resource an instance instantiates.");
        completionItems.add(instanceOf);

        CompletionItem invariant = new CompletionItem("Invariant");
        TextEdit textEditInvariant = new TextEdit();
        textEditInvariant.setNewText("Invariant:");
        invariant.setTextEdit(textEditInvariant);
        invariant.setKind(CompletionItemKind.Keyword);
        invariant.setDocumentation("Invariants are defined using the keywords Invariant, Description, Expression, " +
                "Severity, and XPath. The keywords correspond directly to elements in ElementDefinition.constraint. " +
                "An invariant definition cannot have rules, and are incorporated into a profile via obeys rules.");
        completionItems.add(invariant);

        CompletionItem valueSet = new CompletionItem("ValueSet");
        TextEdit textEditValueSet = new TextEdit();
        textEditValueSet.setNewText("ValueSet:");
        valueSet.setTextEdit(textEditValueSet);
        valueSet.setKind(CompletionItemKind.Keyword);
        valueSet.setDocumentation("A value set is a group of coded values representing acceptable values for a FHIR " +
                "element whose data type is code, Coding, CodeableConcept, Quantity, string, or url.\n" +
                "\n" +
                "Value sets are defined using the declarative keyword ValueSet, with OPTIONAL keywords Id, Title and Description.\n" +
                "\n" +
                "Codes MUST be taken from one or more terminology systems (also called code systems or vocabularies). " +
                "Codes cannot be defined inside a value set. If necessary, you can define your own code system.");
        completionItems.add(valueSet);

        CompletionItem codeSystem = new CompletionItem("CodeSystem");
        TextEdit textEditCodeSysten = new TextEdit();
        textEditCodeSysten.setNewText("CodeSystem:");
        codeSystem.setTextEdit(textEditCodeSysten);
        codeSystem.setKind(CompletionItemKind.Keyword);
        codeSystem.setDocumentation("It is sometimes necessary to define new codes inside an IG that are not drawn from " +
                "an external code system (aka local codes). Local codes MUST be defined in the context of a code system.");
        completionItems.add(codeSystem);

        CompletionItem ruleSet = new CompletionItem("RuleSet");
        TextEdit textEditRuleSet = new TextEdit();
        textEditRuleSet.setNewText("RuleSet: ");
        ruleSet.setTextEdit(textEditRuleSet);
        ruleSet.setKind(CompletionItemKind.Keyword);
        ruleSet.setDocumentation("Rule sets provide the ability to define a group rules as an independent entity. " +
                "Through insert rules, they can be incorporated into a compatible target. FSH behaves as if the rules in " +
                "a rule set are copied into the target. As such, the inserted rules have to make sense where they are inserted. " +
                "Once defined, a single rule set can be used in multiple places.");
        completionItems.add(ruleSet);

        CompletionItem mapping = new CompletionItem("Mapping");
        TextEdit textEditMapping = new TextEdit();
        textEditMapping.setNewText("Mapping:");
        mapping.setTextEdit(textEditMapping);
        mapping.setKind(CompletionItemKind.Keyword);
        mapping.setDocumentation("Mappings are an optional part of an SD, intended to help implementers understand the " +
                "SD in relation to other standards. While it is possible to define mappings using escape (caret) syntax, " +
                "FSH provides a more concise approach. These mappings are informative and are not to be confused with " +
                "the computable mappings provided by FHIR Mapping Language and the StructureMap resource.");
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
        parent.setDocumentation("Specifies the base class for a profile or extension.");
        completionItems.add(parent);

        CompletionItem id = new CompletionItem("Id");
        TextEdit textEditId = new TextEdit();
        textEditId.setNewText("Id:");
        id.setTextEdit(textEditId);
        id.setKind(CompletionItemKind.Keyword);
        id.setDocumentation("An identifier for an item.");
        completionItems.add(id);

        CompletionItem title = new CompletionItem("Title");
        TextEdit textEditTitle = new TextEdit();
        textEditTitle.setNewText("Title:");
        title.setTextEdit(textEditTitle);
        title.setKind(CompletionItemKind.Keyword);
        title.setDocumentation("Short human-readable name.");
        completionItems.add(title);

        CompletionItem description = new CompletionItem("Description");
        TextEdit textEditDescription = new TextEdit();
        textEditDescription.setNewText("Description:");
        description.setTextEdit(textEditDescription);
        description.setKind(CompletionItemKind.Keyword);
        description.setDocumentation("Provides a human-readable description.");
        completionItems.add(description);

        CompletionItem expression = new CompletionItem("Expression");
        TextEdit textEditExpression = new TextEdit();
        textEditExpression.setNewText("Expression:");
        expression.setTextEdit(textEditExpression);
        expression.setKind(CompletionItemKind.Keyword);
        expression.setDocumentation("The FHIR path expression in an invariant.");
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
        severity.setDocumentation("The XPath in an invariant.");
        completionItems.add(severity);

        CompletionItem usage = new CompletionItem("Usage");
        TextEdit textEditUsage = new TextEdit();
        textEditUsage.setNewText("Usage:");
        usage.setTextEdit(textEditUsage);
        usage.setKind(CompletionItemKind.Keyword);
        usage.setDocumentation("Specifies how an instance is intended to be used in the IG.");
        completionItems.add(usage);

        CompletionItem source = new CompletionItem("Source");
        TextEdit textEditSource = new TextEdit();
        textEditSource.setNewText("Source:");
        source.setTextEdit(textEditSource);
        source.setKind(CompletionItemKind.Keyword);
        source.setDocumentation("The profile the mapping applies to.");
        completionItems.add(source);

        CompletionItem target = new CompletionItem("Target");
        TextEdit textEditTarget = new TextEdit();
        textEditTarget.setNewText("Target:");
        target.setTextEdit(textEditTarget);
        target.setKind(CompletionItemKind.Keyword);
        target.setDocumentation("The standard being mapped to.");
        completionItems.add(target);
    }

    @Override
    public List<CompletionItem> get() {
        return completionItems;
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
            for (CompletionItem item: completionItems) {
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
