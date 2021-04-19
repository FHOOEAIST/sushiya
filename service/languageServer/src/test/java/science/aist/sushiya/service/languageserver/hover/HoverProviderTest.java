package science.aist.sushiya.service.languageserver.hover;

import org.eclipse.lsp4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.AdditionalInformation;
import science.aist.sushiya.service.languageserver.Entity;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.Metadata;

/**
 * <p>Created by Sophie Bauernfeind on 09.04.2021</p>
 * <p>Test class for {@link HoverProvider}</p>
 *
 * @author Sophie Bauernfeind
 */
public class HoverProviderTest {
    static final HoverProvider provider = new HoverProvider();
    static final String uri = "testing";

    @BeforeMethod
    public void setUp() {
        FSHFileHandler.getInstance().clean();
    }

    @Parameters({"text", "testType"})
    public void ActivationTest(String text, String testType){
        //given
        TextDocumentItem textDocument = new TextDocumentItem();
        textDocument.setText(text);
        textDocument.setUri(uri);

        //register this document to the file handler
        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams();
        openParams.setTextDocument(textDocument);
        FSHFileHandler.getInstance().addFile(openParams);

        HoverParams hoverParams = new HoverParams();
        Position position = new Position(0,2);
        hoverParams.setPosition(position);
        hoverParams.setTextDocument(new TextDocumentIdentifier(uri));

        String solution = "";

        //when
        Hover hover = provider.apply(hoverParams);

        //then
        try{
            Entity searchedInformationEntity = Entity.valueOf(testType);
            switch (searchedInformationEntity){
                case ALIAS:
                    solution = AdditionalInformation.ALIAS_INFORMATION;
                    break;
                case PROFILE:
                    solution = AdditionalInformation.PROFILE_INFORMATION;
                    break;
                case EXTENSION:
                    solution = AdditionalInformation.EXTENSION_INFORMATION;
                    break;
                case INVARIANT:
                    solution = AdditionalInformation.INVARIANT_INFORMATION;
                    break;
                case INSTANCE:
                    solution = AdditionalInformation.INSTANCE_INFORMATION;
                    break;
                case VALUESET:
                    solution = AdditionalInformation.VALUE_SET_INFORMATION;
                    break;
                case CODESYSTEM:
                    solution = AdditionalInformation.CODE_SYSTEM_INFORMATION;
                    break;
                case RULESET:
                    solution = AdditionalInformation.RULE_SET_INFORMATION;
                    break;
                case MAPPING:
                    solution = AdditionalInformation.MAPPING_INFORMATION;
                    break;
            }
        }catch (Exception ignored){ }

        try{
            Metadata searchedInformationEntity = Metadata.valueOf(testType);
            switch (searchedInformationEntity){
                case DESCRIPTION:
                    solution = AdditionalInformation.DESCRIPTION_INFORMATION;
                    break;
                case EXPRESSION:
                    solution = AdditionalInformation.EXTENSION_INFORMATION;
                    break;
                case ID:
                    solution = AdditionalInformation.ID_INFORMATION;
                    break;
                case INSTANCEOF:
                    solution = AdditionalInformation.INSTANCE_OF_INFORMATION;
                    break;
                case PARENT:
                    solution = AdditionalInformation.PARENT_INFORMATION;
                    break;
                case SEVERITY:
                    solution = AdditionalInformation.SEVERITY_INFORMATION;
                    break;
                case SOURCE:
                    solution = AdditionalInformation.SOURCE_INFORMATION;
                    break;
                case TARGET:
                    solution = AdditionalInformation.TARGET_INFORMATION;
                    break;
                case TITLE:
                    solution = AdditionalInformation.TITLE_INFORMATION;
                    break;
                case USAGE:
                    solution = AdditionalInformation.USAGE_INFORMATION;
                    break;
                case XPATH:
                    solution = AdditionalInformation.XPATH_INFORMATION;
                    break;
                case MIXINS:
                    solution = AdditionalInformation.MIXINS_INFORMATION;
                    break;
            }
        }catch (Exception ignored){  }

        Assert.assertEquals(hover.getContents().getRight().getValue(), solution);
    }

    @Test
    public void testActivationAlias(){
        ActivationTest("Alias: LNC = http://loinc.org",
                Entity.ALIAS.name());
    }

    @Test
    public void testActivationProfile(){
        ActivationTest("Profile: ",
                Entity.PROFILE.name());
    }

    @Test
    public void testActivationExtension(){
        ActivationTest("Extension",
                Entity.EXTENSION.name());
    }

    @Test
    public void testActivationInvariant(){
        ActivationTest("Invariant  :",
                Entity.INVARIANT.name());
    }

    @Test
    public void testActivationInstance(){
        ActivationTest("   Instance",
                Entity.INSTANCE.name());
    }

    @Test
    public void testActivationValueSet(){
        ActivationTest("  ValueSet",
                Entity.VALUESET.name());
    }

    @Test
    public void testActivationCodeSystem(){
        ActivationTest(" CodeSystem",
                Entity.CODESYSTEM.name());
    }

    @Test
    public void testActivationRuleSet(){
        ActivationTest("RuleSet",
                Entity.RULESET.name());
    }

    @Test
    public void testActivationMapping(){
        ActivationTest("Mapping",
                Entity.MAPPING.name());
    }

    @Test
    public void testActivationDescription(){
        ActivationTest("Description",
                Metadata.DESCRIPTION.name());
    }

    @Test
    public void testActivationExpression(){
        ActivationTest("Expression",
                Metadata.EXPRESSION.name());
    }

    @Test
    public void testActivationId(){
        ActivationTest("  Id",
                Metadata.ID.name());
    }

    @Test
    public void testActivationInstanceOf(){
        ActivationTest("InstanceOf",
                Metadata.INSTANCEOF.name());
    }

    @Test
    public void testActivationParent(){
        ActivationTest("Parent",
                Metadata.PARENT.name());
    }

    @Test
    public void testActivationSeverity(){
        ActivationTest("Severity",
                Metadata.SEVERITY.name());
    }

    @Test
    public void testActivationSource(){
        ActivationTest("Source",
                Metadata.SOURCE.name());
    }

    @Test
    public void testActivationTarget(){
        ActivationTest("Target",
                Metadata.TARGET.name());
    }

    @Test
    public void testActivationTitle(){
        ActivationTest("Title",
                Metadata.TITLE.name());
    }

    @Test
    public void testActivationUsage(){
        ActivationTest("Usage",
                Metadata.USAGE.name());
    }
}