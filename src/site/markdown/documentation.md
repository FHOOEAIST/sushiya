# FSH-language-server

The FSH-language-server is a languageserver implementation for
[HL7® FHIR® Shorthand](http://hl7.org/fhir/uv/shorthand/STU1/)
and implements the [language server protocol](https://microsoft.github.io/language-server-protocol/).
It can be used with any editor, if the editor implements a client for this language server. The base structure leaned on the [camel-language-server](https://github.com/camel-tooling/camel-language-server/tree/master).

## Clients
Right now there is no functioning client, but there is one in work [VS Code](https://github.com/FHOOEAIST/Itamae).

## Features

**Code completion**
* Entity names and metadata
  ![Completion for alias](.././images/aliasCompletion.png "Completion for alias")
  ![Completion for extension](.././images/extensionCompletion.png "Completion for extension")
  ![Completion for profile](.././images/profileCompletion.png "Completion for profile")
* Completion support for different rules
    * value set rule
      ![Completion for valueSet rule beginning](.././images/vsRuleCompletion1.png "Completion for valueSet rule beginning")
      ![Completion for valueSet rule including](.././images/vsRuleCompletion2.png "Completion for valueSet rule including")
      ![Completion for valueSet rule including system](.././images/vsRuleCompletion3.png "Completion for valueSet rule including system")
    * path definition support for entities with contains rule
      ![Completion with contains rule](.././images/sdRuleCompletionWithContainsRule.png "Completion with contains rule")
* Completion support for metadata
    * InstanceOf
    * Source
    * Parent
      ![Completion for parent default possibilities](.././images/parentCompletion.png "Completion for parent default possibilities")
      ![Completion for parent with other file](.././images/parentCompletionWithOtherFile.png "Completion for parent with other file")


**Syntax checking**
![Syntax checking with unexpected end of file](.././images/syntaxCheckingEOF.png "Syntax checking with unexpected end of file")
![Syntax checking with wrong metadata](.././images/syntaxCheckingWrongMetadata.png "Syntax checking with wrong metadata")
![Syntax checking with wrong expected token](.././images/syntaxCheckingWrongToken.png "Syntax checking with wrong expected token")


**Goto code** \
Goto Definition
![Goto Definition](.././images/goToDefinition.gif "Goto Definition") \
\
Goto Implementation
![Goto Implementation](.././images/goToImplementation.gif "Goto Implementation")\
\
Goto References
![Goto References](.././images/goToReferences.gif "Goto References")

**Hover information**
![Alias Hover](.././images/aliasHover.png "Alias Hover")
![CodeSystem Hover](.././images/codeSystemHover.png "CodeSystem Hover")
![ValueSet Hover](.././images/valueSetHover.png "ValueSet Hover")

**Rename**
![rename](.././images/rename.gif "rename")
If the renaming entity is the last word, renaming won't work.

**Formatting** \
All examples are from [FSH language reference](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html).
![formatting](.././images/formatting.gif "formatting")

## Contributing

**First make sure to read our [general contribution guidelines](https://fhooeaist.github.io/CONTRIBUTING.html).**

## Licence

Copyright (c) 2021 the original author or authors.
DO NOT ALTER OR REMOVE COPYRIGHT NOTICES.

This Source Code Form is subject to the terms of the Mozilla Public
License, v. 2.0. If a copy of the MPL was not distributed with this
file, You can obtain one at https://mozilla.org/MPL/2.0/.

## Research

If you are going to use this project as part of a research paper, we would ask you to reference this project by citing
it.
