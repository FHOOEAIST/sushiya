package science.aist.sushiya.service.languageserver;

/**
 * <p>This class contains additional information about entities and metadata of fhir shorthand.</p>
 * <p>09.04.21, version 1.1.0</p>
 *
 * @author SophieBauernfeind
 */
public class AdditionalInformation {
    public static final String ALIAS_INFORMATION =
            "Aliases allow the user to replace a lengthy url or oid with a short string. " +
            "Aliases are for readability only, and do not change the meaning of rules. Typical uses of aliases are " +
            "to represent code systems and canonical URLs.";
    public static final String PROFILE_INFORMATION =
            "To define a profile, the keywords Profile and Parent are required, and Id, Title, " +
            "and Description are OPTIONAL. Rules defining the profile follow immediately after the keyword section.";
    public static final String EXTENSION_INFORMATION =
            "Defining extensions is similar to defining a profile, except that the parent of an " +
            "extension is not required. Extensions can also inherit from other extensions, but if the Parent keyword " +
            "is omitted, the parent is assumed to be FHIR’s Extension element.";
    public static final String INVARIANT_INFORMATION =
            "Invariants are defined using the keywords Invariant, Description, Expression, " +
            "Severity, and XPath. The keywords correspond directly to elements in ElementDefinition.constraint. " +
            "An invariant definition cannot have rules, and are incorporated into a profile via obeys rules.";
    public static final String INSTANCE_INFORMATION =
            "Instances are defined using the keywords Instance, InstanceOf, Title, Usage and Description. " +
            "The InstanceOf is required, and plays a role analogous to the Parent of a profile. " +
            "The value of InstanceOf can be the name, id, or url for any profile, resource, or complex data type " +
            "defined internally or externally.";
    public static final String VALUE_SET_INFORMATION =
            "A value set is a group of coded values representing acceptable values for a FHIR " +
            "element whose data type is code, Coding, CodeableConcept, Quantity, string, or url.\n" +
            "\n" +
            "Value sets are defined using the declarative keyword ValueSet, with OPTIONAL keywords Id, Title and Description.\n" +
            "\n" +
            "Codes MUST be taken from one or more terminology systems (also called code systems or vocabularies). " +
            "Codes cannot be defined inside a value set. If necessary, you can define your own code system.";
    public static final String CODE_SYSTEM_INFORMATION =
            "It is sometimes necessary to define new codes inside an IG that are not drawn from " +
            "an external code system (aka local codes). Local codes MUST be defined in the context of a code system.";
    public static final String RULE_SET_INFORMATION =
            "Rule sets provide the ability to define a group rules as an independent entity. " +
            "Through insert rules, they can be incorporated into a compatible target. FSH behaves as if the rules in " +
            "a rule set are copied into the target. As such, the inserted rules have to make sense where they are inserted. " +
            "Once defined, a single rule set can be used in multiple places.";
    public static final String MAPPING_INFORMATION = "Mappings are an optional part of an SD, intended to help implementers understand the " +
            "SD in relation to other standards. While it is possible to define mappings using escape (caret) syntax, " +
            "FSH provides a more concise approach. These mappings are informative and are not to be confused with " +
            "the computable mappings provided by FHIR Mapping Language and the StructureMap resource.";
    public static final String DESCRIPTION_INFORMATION = "Provides a human-readable description.";
    public static final String EXPRESSION_INFORMATION = "The FHIR path expression in an invariant.";
    public static final String ID_INFORMATION = "An identifier for an item.";
    public static final String INSTANCE_OF_INFORMATION = "The profile or resource an instance instantiates.";
    public static final String PARENT_INFORMATION = "Specifies the base class for a profile or extension.";
    public static final String SEVERITY_INFORMATION = "The XPath in an invariant.";
    public static final String SOURCE_INFORMATION = "The profile the mapping applies to.";
    public static final String TARGET_INFORMATION = "The standard being mapped to.";
    public static final String TITLE_INFORMATION = "Short human-readable name.";
    public static final String USAGE_INFORMATION = "Specifies how an instance is intended to be used in the IG.";
    public static final String XPATH_INFORMATION = "";
    public static final String MIXINS_INFORMATION = "";
}
