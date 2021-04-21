/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver;

/**
 * <p>This class contains additional information about entities and metadata of fhir shorthand.</p>
 * <p>09.04.21, version 1.1.0</p>
 *
 * @author SophieBauernfeind
 */
public class AdditionalInformation {
    public static final String aliasInformation =
            "Aliases allow the user to replace a lengthy url or oid with a short string. " +
            "Aliases are for readability only, and do not change the meaning of rules. Typical uses of aliases are " +
            "to represent code systems and canonical URLs.";
    public static final String profileInformation =
            "To define a profile, the keywords Profile and Parent are required, and Id, Title, " +
            "and Description are OPTIONAL. Rules defining the profile follow immediately after the keyword section.";
    public static final String extensionInformation =
            "Defining extensions is similar to defining a profile, except that the parent of an " +
            "extension is not required. Extensions can also inherit from other extensions, but if the Parent keyword " +
            "is omitted, the parent is assumed to be FHIR’s Extension element.";
    public static final String invariantInformation =
            "Invariants are defined using the keywords Invariant, Description, Expression, " +
            "Severity, and XPath. The keywords correspond directly to elements in ElementDefinition.constraint. " +
            "An invariant definition cannot have rules, and are incorporated into a profile via obeys rules.";
    public static final String instanceInformation =
            "Instances are defined using the keywords Instance, InstanceOf, Title, Usage and Description. " +
            "The InstanceOf is required, and plays a role analogous to the Parent of a profile. " +
            "The value of InstanceOf can be the name, id, or url for any profile, resource, or complex data type " +
            "defined internally or externally.";
    public static final String valueSetInformation =
            "A value set is a group of coded values representing acceptable values for a FHIR " +
            "element whose data type is code, Coding, CodeableConcept, Quantity, string, or url.\n" +
            "\n" +
            "Value sets are defined using the declarative keyword ValueSet, with OPTIONAL keywords Id, Title and Description.\n" +
            "\n" +
            "Codes MUST be taken from one or more terminology systems (also called code systems or vocabularies). " +
            "Codes cannot be defined inside a value set. If necessary, you can define your own code system.";
    public static final String codeSystemInformation =
            "It is sometimes necessary to define new codes inside an IG that are not drawn from " +
            "an external code system (aka local codes). Local codes MUST be defined in the context of a code system.";
    public static final String ruleSetInformation =
            "Rule sets provide the ability to define a group rules as an independent entity. " +
            "Through insert rules, they can be incorporated into a compatible target. FSH behaves as if the rules in " +
            "a rule set are copied into the target. As such, the inserted rules have to make sense where they are inserted. " +
            "Once defined, a single rule set can be used in multiple places.";
    public static final String mappingInformation = "Mappings are an optional part of an SD, intended to help implementers understand the " +
            "SD in relation to other standards. While it is possible to define mappings using escape (caret) syntax, " +
            "FSH provides a more concise approach. These mappings are informative and are not to be confused with " +
            "the computable mappings provided by FHIR Mapping Language and the StructureMap resource.";
    public static final String descriptionInformation = "Provides a human-readable description.";
    public static final String expressionInformation = "The FHIR path expression in an invariant.";
    public static final String idInformation = "An identifier for an item.";
    public static final String instanceOfInformation = "The profile or resource an instance instantiates.";
    public static final String parentInformation = "Specifies the base class for a profile or extension.";
    public static final String severityInformation = "The XPath in an invariant.";
    public static final String sourceInformation = "The profile the mapping applies to.";
    public static final String targetInformation = "The standard being mapped to.";
    public static final String titleInformation = "Short human-readable name.";
    public static final String usageInformation = "Specifies how an instance is intended to be used in the IG.";
    public static final String xpathInformation = "";
    public static final String mixinsInformation = "";
}
