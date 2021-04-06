package science.aist.sushiya.service.languageserver;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.diagnostic.FSHErrorListener;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHLexer;
import science.aist.sushiya.service.languageserver.diagnostic.parser.FSHParser;

/**
 * <p>Created by Sophie Bauernfeind on 06.04.2021</p>
 * <p>Test class for {@link FSHErrorListener}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FSHErrorListenerTest {

    @Parameters({"text", "errorListener"})
    public void parse(String text, FSHErrorListener errorListener){
        //given
        CharStream input = CharStreams.fromString(text);
        FSHLexer lexer = new FSHLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FSHParser parser = new FSHParser(tokens);
        //parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        //when
        parser.doc();
    }

    @Test
    public void testOneCorrectAlias(){
        //given
        String text = "Alias: LNC = http://loinc.org";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testTwoCorrectAlias(){
        //given
        String text = "Alias: LNC = http://loinc.org\n"
                + "Alias: SCT = http://snomed.info/sct";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectAlias(){
        //given
        String text = "Alias: LNC wrong = http://loinc.org";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(errorListener.getDiagnostics().size(),1);
    }

    @Test
    public void testCorrectProfile(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustrianAddress.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Profile:     AustrianAddress \n"
                + "Parent:          Address \n"
                + "Id:              AustrianRepresentationOfAddress \n"
                + "Title:           \"Austrian Representation of an Address\" \n"
                + "Description:     \"HL7 Austria FHIR Core Profile for Address Data in Austria.\" \n"
                + "* period 0..0 \n"
                + "* district 0..0 \n"
                + "* obeys at-addr-1\n"
                + "* obeys at-addr-2\n"
                + "* obeys at-addr-3";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectProfile(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustrianAddress.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Profile:     AustrianAddress \n"
                + "Parent:          Address \n"
                + "Source:          wrong\n"
                + "Id:              AustrianRepresentationOfAddress \n"
                + "Title:           \"Austrian Representation of an Address\" \n"
                + "Description:     \"HL7 Austria FHIR Core Profile for Address Data in Austria.\" \n"
                + "* period 0..0 \n"
                + "* district 0..0 \n"
                + "* obeys at-addr-1\n"
                + "* obeys at-addr-2\n"
                + "* obeys at-addr-3";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectExtension(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustriaReligion.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Extension:    PatientReligion \n"
                + "Id:           patientReligion \n"
                + "Title:        \"Patient Religion\" \n"
                + "Description:  \"The Religion (registered in Austria) of a Patient\" \n"
                + "* value[x] 0..0\n"
                + "* extension contains \n"
                + "    code 0..1 and\n"
                + "    period 0..1\n"
                + "* extension[code].value[x] only CodeableConcept\n"
                + "* extension[code] ^short = \"Religion code of the Patient\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectExtension(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustriaReligion.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Extension:    PatientReligion \n"
                + "Id:           patientReligion \n"
                + "Title:        \"Patient Religion\" \n"
                + "Description:  \"The Religion (registered in Austria) of a Patient\" \n"
                + "* value[x] 0..0\n"
                + "* extension contains \n"
                + "    code 0..1 and\n"
                + "    period 0..1\n"
                + "* extension[code].value[x] only CodeableConcept\n"
                + "* extension[code] ^short = \"Religion code of the Patient\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectInvariant(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-invariants (03 march 2021, Shorthand v. 1.1.0)
        String text = "Invariant:  us-core-8 \n"
                + "Description: \"Patient.name.given or Patient.name.family or both SHALL be present\" \n"
                + "Expression: \"family.exists() or given.exists()\" \n"
                + "Severity:   #error \n"
                + "XPath:      \"f:given or f:family\" \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectInvariant(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-invariants (03 march 2021, Shorthand v. 1.1.0)
        String text = "Invariant:  us-core-8 \n"
                + "Id:      WrongMetadata \n"
                + "Description: \"Patient.name.given or Patient.name.family or both SHALL be present\" \n"
                + "Expression: \"family.exists() or given.exists()\" \n"
                + "Severity:   #error \n"
                + "XPath:      \"f:given or f:family\" \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectInstance(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/VS-ELGA-ReligiousAffiliation.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Instance:   VS-ELGA-ReligiousAffiliation \n"
                + "InstanceOf: ValueSet \n"
                + "Usage:      #definition \n"
                + "* title = \"Set of Religious Affiliation to be used in ELGA\"\n"
                + "* name = \"elga-religious-affiliation\"\n"
                + "* description = \"Set of Religious Affiliation to be used in ELGA. It is preferred to use entries of the first level hierachy (1-L)\"\n"
                + "* version = \"2.6.0+20131019\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectInstance(){
        //given
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/VS-ELGA-ReligiousAffiliation.fsh (06 april 2021, Shorthand v. 1.1.0)
        String text = "Instance: \n"
                + "InstanceOf: ValueSet \n"
                + "Usage:      #definition \n"
                + "* title = \"Set of Religious Affiliation to be used in ELGA\"\n"
                + "* name = \"elga-religious-affiliation\"\n"
                + "* description = \"Set of Religious Affiliation to be used in ELGA. It is preferred to use entries of the first level hierachy (1-L)\"\n"
                + "* version = \"2.6.0+20131019\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectValueSet(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-value-sets (06 april 2021, Shorthand v. 1.1.0)
        String text = "ValueSet: 		BodyWeightPreconditionVS \n"
                + "Title: 		\"Body weight preconditions.\" \n"
                + "Description:  	\"Circumstances for body weight measurement.\" \n"
                + "* SCT#971000205103 \"Wearing street clothes with shoes\"\n"
                + "* SCT#961000205106 \"Wearing street clothes, no shoes\"\n"
                + "* SCT#951000205108 \"Wearing underwear or less\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectValueSet(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-value-sets (06 april 2021, Shorthand v. 1.1.0)
        String text = "ValueSet: \n"
                + "Title: 		\"Body weight preconditions.\" \n"
                + "Description:  	\"Circumstances for body weight measurement.\" \n"
                + "* SCT#971000205103 \"Wearing street clothes with shoes\"\n"
                + "* SCT#961000205106 \"Wearing street clothes, no shoes\"\n"
                + "* SCT#951000205108 \"Wearing underwear or less\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectCodeSystem(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-code-systems (06 april 2021, Shorthand v. 1.1.0)
        String text = "CodeSystem:  	YogaCS \n"
                + "Id: 			yoga-code-system \n"
                + "Title: 		\"Yoga Code System.\" \n"
                + "Description:  	\"A brief vocabulary of yoga-related terms.\" \n"
                + "  * #Sirsasana \"Headstand\"\n"
                + "      \"An inverted asana, also called mudra in classical hatha yoga, involves standing on one's head.\"\n"
                + "  * #Halasana \"Plough Pose\"\n"
                + "      \"Halasana or Plough pose is an inverted asana in hatha yoga and modern yoga as exercise. "
                + "Its variations include Karnapidasana with the knees by the ears, and Supta Konasana with the feet wide apart.\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectCodeSystem(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-code-systems (06 april 2021, Shorthand v. 1.1.0)
        String text = "CodeSystem: \n"
                + "Id: 			yoga-code-system \n"
                + "Title: 		\"Yoga Code System.\" \n"
                + "Description:  	\"A brief vocabulary of yoga-related terms.\" \n"
                + "  * #Sirsasana \"Headstand\"\n"
                + "      \"An inverted asana, also called mudra in classical hatha yoga, involves standing on one's head.\"\n"
                + "  * #Halasana \"Plough Pose\"\n"
                + "      \"Halasana or Plough pose is an inverted asana in hatha yoga and modern yoga as exercise. "
                + "Its variations include Karnapidasana with the knees by the ears, and Supta Konasana with the feet wide apart.\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectRuleSet(){
        //given
        //reference from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#simple-rule-sets (11 march 2021, Shorthand v. 1.1.0)
        String text = "RuleSet: RuleSet1 \n"
                + "* ^status = #draft \n"
                + "* ^experimental = true \n"
                + "* ^publisher = \"Elbonian Medical Society\" \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectRuleSet(){
        //given
        //reference from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#simple-rule-sets (11 march 2021, Shorthand v. 1.1.0)
        String text = "RuleSet: RuleSet1 \n"
                + "Source:      WrongMetadata\n"
                + "* ^status = #draft \n"
                + "* ^experimental = true \n"
                + "* ^publisher = \"Elbonian Medical Society\" \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectParamRuleSet(){
        //given
        //reference from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#parameterized-rule-sets (11 march 2021, Shorthand v. 1.1.0)
        String text = "RuleSet:     Question(linkId, text, type, repeats) \n"
                + "* item[+].linkId = \"{linkId}\"  \n"
                + "* item[=].text = \"{text}\"  \n"
                + "* item[=].type = #{type}  \n"
                + "* item[=].repeats = {repeats}  \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectParamRuleSet(){
        //given
        //reference from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#parameterized-rule-sets (11 march 2021, Shorthand v. 1.1.0)
        String text = "RuleSet:     Question(linkId, text, type, repeats) \n"
                + "Source:      WrongMetadata\n"
                + "* item[+].linkId = \"{linkId}\"  \n"
                + "* item[=].text = \"{text}\"  \n"
                + "* item[=].type = #{type}  \n"
                + "* item[=].repeats = {repeats}  \n";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectMapping(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-mappings (06 april 2021, Shorthand v. 1.1.0)
        String text = "Mapping:  USCorePatientToArgonaut \n"
                + "Source:   USCorePatient \n"
                + "Target:   \"http://unknown.org/Argonaut-DQ-DSTU2\" \n"
                + "Title:    \"Argonaut DSTU2\" \n"
                + "Id:       argonaut-dq-dstu2 \n"
                + "* -> \"Patient\"\n"
                + "* extension[USCoreRaceExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-race]\"\n"
                + "* extension[USCoreEthnicityExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity]\"\n"
                + "* extension[USCoreBirthSexExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-birthsex]\"\n"
                + "* identifier -> \"Patient.identifier\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectMapping(){
        //given
        //reference took from https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-mappings (06 april 2021, Shorthand v. 1.1.0)
        String text = "Mapping: \n"
                + "Source:   USCorePatient \n"
                + "Target:   \"http://unknown.org/Argonaut-DQ-DSTU2\" \n"
                + "Title:    \"Argonaut DSTU2\" \n"
                + "Id:       argonaut-dq-dstu2 \n"
                + "* -> \"Patient\"\n"
                + "* extension[USCoreRaceExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-race]\"\n"
                + "* extension[USCoreEthnicityExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity]\"\n"
                + "* extension[USCoreBirthSexExtension] -> \"Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-birthsex]\"\n"
                + "* identifier -> \"Patient.identifier\"";
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(1, errorListener.getDiagnostics().size());
    }

    @Test
    public void testCorrectEntities(){
        //given
        String alias = "Alias: LNC = http://loinc.org\n";
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustrianAddress.fsh (06 april 2021, Shorthand v. 1.1.0)
        String profile = "Profile:     AustrianAddress \n"
                + "Parent:          Address \n"
                + "Id:              AustrianRepresentationOfAddress \n"
                + "Title:           \"Austrian Representation of an Address\" \n"
                + "Description:     \"HL7 Austria FHIR Core Profile for Address Data in Austria.\" \n"
                + "* period 0..0 \n"
                + "* district 0..0 \n"
                + "* obeys at-addr-1\n"
                + "* obeys at-addr-2\n"
                + "* obeys at-addr-3 \n";
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustriaReligion.fsh (06 april 2021, Shorthand v. 1.1.0)
        String extension = "Extension:    PatientReligion \n"
                + "Id:           patientReligion \n"
                + "Title:        \"Patient Religion\" \n"
                + "Description:  \"The Religion (registered in Austria) of a Patient\" \n"
                + "* value[x] 0..0\n"
                + "* extension contains \n"
                + "    code 0..1 and\n"
                + "    period 0..1\n"
                + "* extension[code].value[x] only CodeableConcept\n"
                + "* extension[code] ^short = \"Religion code of the Patient\"\n";

        String text = alias + "\n" + profile + "\n" + extension;
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(0, errorListener.getDiagnostics().size());
    }

    @Test
    public void testIncorrectEntities(){
        //given
        String alias = "Alias: LNC wrong = http://loinc.org\n";
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustrianAddress.fsh (06 april 2021, Shorthand v. 1.1.0)
        String profile = "Profile:     AustrianAddress \n"
                + "Parent:          Address \n"
                + "Source:          wrong\n"
                + "Id:              AustrianRepresentationOfAddress \n"
                + "Title:           \"Austrian Representation of an Address\" \n"
                + "Description:     \"HL7 Austria FHIR Core Profile for Address Data in Austria.\" \n"
                + "* period 0..0 \n"
                + "* district 0..0 \n"
                + "* obeys at-addr-1\n"
                + "* obeys at-addr-2\n"
                + "* obeys at-addr-3 \n";
        //reference took from https://github.com/HL7Austria/HL7-AT-FHIR-Core-R4/blob/main/input/fsh/AustriaReligion.fsh (06 april 2021, Shorthand v. 1.1.0)
        String extension = "Extension:    PatientReligion \n"
                + "Id:           patientReligion \n"
                + "Source:          wrong\n"
                + "Title:        \"Patient Religion\" \n"
                + "Description:  \"The Religion (registered in Austria) of a Patient\" \n"
                + "* value[x] 0..0\n"
                + "* extension contains \n"
                + "    code 0..1 and\n"
                + "    period 0..1\n"
                + "* extension[code].value[x] only CodeableConcept\n"
                + "* extension[code] ^short = \"Religion code of the Patient\"\n";

        String text = alias + profile + extension;
        FSHErrorListener errorListener = new FSHErrorListener();

        //when
        parse(text,errorListener);

        //then
        Assert.assertEquals(3, errorListener.getDiagnostics().size());
    }
}
