package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the provider for the metadata-type 'profile'.</p>
 * <p>It provides all official defined resources based on: https://www.hl7.org/fhir/resourcelist.html (23.03.21)</p>
 *
 * @author SophieBauernfeind
 */
public class ParentCompletionProvider implements ICompletionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParentCompletionProvider.class);
    private static final List<CompletionItem> completionItems = new ArrayList<>();

    public ParentCompletionProvider() {
        addResources();
        //TODO: get extensions and profiles of all open files
    }

    @Override
    public List<CompletionItem> apply(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return completionItems;
    }

    @Override
    public boolean test(TextDocumentItem textDocumentItem, CompletionParams completionParams) {
        return checkKeywordParent(textDocumentItem, completionParams) && completionParams.getContext().getTriggerKind() != CompletionTriggerKind.Invoked;
    }

    private boolean checkKeywordParent(TextDocumentItem textDocumentItem, CompletionParams completionParams){
        try{
            String line = textDocumentItem.getText().split("\n")[completionParams.getPosition().getLine()];
            return line.replaceAll("\\s","").matches("Parent:") && line.lastIndexOf("Parent:") < completionParams.getPosition().getCharacter();

        }catch (Error error){
            LOGGER.error(error.getMessage());
            return false;
        }
    }

    /**
     * completion for already defined resources based on: https://www.hl7.org/fhir/resourcelist.html
     * the completionItems are bundled according to their category and subcategory
     */
    private void addResources(){
        //foundation
        completionItems.add(new CompletionItem("CapabilityStatement"));
        completionItems.add(new CompletionItem("StructureDefinition"));
        completionItems.add(new CompletionItem("ImplementationGuide"));
        completionItems.add(new CompletionItem("SearchParameter"));
        completionItems.add(new CompletionItem("MessageDefinition"));
        completionItems.add(new CompletionItem("OperationDefinition"));
        completionItems.add(new CompletionItem("CompartmentDefinition"));
        completionItems.add(new CompletionItem("StructureMap"));
        completionItems.add(new CompletionItem("GraphDefinition"));
        completionItems.add(new CompletionItem("ExampleScenario"));

        completionItems.add(new CompletionItem("CodeSystem"));
        completionItems.add(new CompletionItem("ValueSet"));
        completionItems.add(new CompletionItem("ConceptMap"));
        completionItems.add(new CompletionItem("NamingSystem"));
        completionItems.add(new CompletionItem("TerminologyCapabilities"));

        completionItems.add(new CompletionItem("Provenance"));
        completionItems.add(new CompletionItem("AuditEvent"));
        completionItems.add(new CompletionItem("Consent"));

        completionItems.add(new CompletionItem("Composition"));
        completionItems.add(new CompletionItem("DocumentManifest"));
        completionItems.add(new CompletionItem("DocumentReference"));
        completionItems.add(new CompletionItem("CatalogEntry"));

        completionItems.add(new CompletionItem("Basic"));
        completionItems.add(new CompletionItem("Binary"));
        completionItems.add(new CompletionItem("Bundle"));
        completionItems.add(new CompletionItem("Linkage"));
        completionItems.add(new CompletionItem("MessageHeader"));
        completionItems.add(new CompletionItem("OperationOutcome"));
        completionItems.add(new CompletionItem("Parameters"));
        completionItems.add(new CompletionItem("Subscription"));


        //base
        completionItems.add(new CompletionItem("Patient"));
        completionItems.add(new CompletionItem("Practitioner"));
        completionItems.add(new CompletionItem("PractitionerRole"));
        completionItems.add(new CompletionItem("RelatedPerson"));
        completionItems.add(new CompletionItem("Person"));
        completionItems.add(new CompletionItem("Group"));

        completionItems.add(new CompletionItem("Organization"));
        completionItems.add(new CompletionItem("OrganizationAffiliation"));
        completionItems.add(new CompletionItem("HealthcareService"));
        completionItems.add(new CompletionItem("Endpoint"));
        completionItems.add(new CompletionItem("Location"));

        completionItems.add(new CompletionItem("Substance"));
        completionItems.add(new CompletionItem("BiologicallyDerivedProduct"));
        completionItems.add(new CompletionItem("Device"));
        completionItems.add(new CompletionItem("DeviceMetric"));

        completionItems.add(new CompletionItem("Task"));
        completionItems.add(new CompletionItem("Appointment"));
        completionItems.add(new CompletionItem("AppointmentResponse"));
        completionItems.add(new CompletionItem("Schedule"));
        completionItems.add(new CompletionItem("Slot"));
        completionItems.add(new CompletionItem("VerificationResult"));

        completionItems.add(new CompletionItem("Encounter"));
        completionItems.add(new CompletionItem("EpisodeOfCare"));
        completionItems.add(new CompletionItem("Flag"));
        completionItems.add(new CompletionItem("List"));
        completionItems.add(new CompletionItem("Library"));


        //clinical
        completionItems.add(new CompletionItem("AllergyIntolerance"));
        completionItems.add(new CompletionItem("AdverseEvent"));
        completionItems.add(new CompletionItem("Condition"));
        completionItems.add(new CompletionItem("Procedure"));
        completionItems.add(new CompletionItem("FamilyMemberHistory"));
        completionItems.add(new CompletionItem("ClinicalImpression"));
        completionItems.add(new CompletionItem("DetectedIssue"));

        completionItems.add(new CompletionItem("Observation"));
        completionItems.add(new CompletionItem("Media"));
        completionItems.add(new CompletionItem("DiagnosticReport"));
        completionItems.add(new CompletionItem("Specimen"));
        completionItems.add(new CompletionItem("BodyStructure"));
        completionItems.add(new CompletionItem("ImagingStudy"));
        completionItems.add(new CompletionItem("QuestionnaireResponse"));
        completionItems.add(new CompletionItem("MolecularSequence"));

        completionItems.add(new CompletionItem("MedicationRequest"));
        completionItems.add(new CompletionItem("MedicationAdministration"));
        completionItems.add(new CompletionItem("MedicationDispense"));
        completionItems.add(new CompletionItem("MedicationStatement"));
        completionItems.add(new CompletionItem("Medication"));
        completionItems.add(new CompletionItem("MedicationKnowledge"));
        completionItems.add(new CompletionItem("Immunization"));
        completionItems.add(new CompletionItem("ImmunizationEvaluation"));

        completionItems.add(new CompletionItem("CarePlan"));
        completionItems.add(new CompletionItem("CareTeam"));
        completionItems.add(new CompletionItem("Goal"));
        completionItems.add(new CompletionItem("ServiceRequest"));
        completionItems.add(new CompletionItem("NutritionOrder"));
        completionItems.add(new CompletionItem("VisionPrescription"));
        completionItems.add(new CompletionItem("RiskAssessment"));
        completionItems.add(new CompletionItem("RequestGroup"));

        completionItems.add(new CompletionItem("Communication"));
        completionItems.add(new CompletionItem("CommunicationRequest"));
        completionItems.add(new CompletionItem("DeviceRequest"));
        completionItems.add(new CompletionItem("DeviceUseStatement"));
        completionItems.add(new CompletionItem("GuidanceResponse"));
        completionItems.add(new CompletionItem("SupplyRequest"));
        completionItems.add(new CompletionItem("SupplyDelivery"));


        //financial
        completionItems.add(new CompletionItem("Coverage"));
        completionItems.add(new CompletionItem("CoverageEligibilityRequest"));
        completionItems.add(new CompletionItem("CoverageEligibilityResponse"));
        completionItems.add(new CompletionItem("EnrollmentRequest"));
        completionItems.add(new CompletionItem("EnrollmentResponse"));

        completionItems.add(new CompletionItem("Claim"));
        completionItems.add(new CompletionItem("ClaimResponse"));
        completionItems.add(new CompletionItem("Invoice"));

        completionItems.add(new CompletionItem("PaymentNotice"));
        completionItems.add(new CompletionItem("PaymentReconciliation"));

        completionItems.add(new CompletionItem("Account"));
        completionItems.add(new CompletionItem("ChargeItem"));
        completionItems.add(new CompletionItem("ChargeItemDefinition"));
        completionItems.add(new CompletionItem("Contract"));
        completionItems.add(new CompletionItem("ExplanationOfBenefit"));
        completionItems.add(new CompletionItem("InsurancePlan"));


        //spezialized
        completionItems.add(new CompletionItem("ResearchStudy"));
        completionItems.add(new CompletionItem("ResearchSubject"));

        completionItems.add(new CompletionItem("ActivityDefinition"));
        completionItems.add(new CompletionItem("DeviceDefinition"));
        completionItems.add(new CompletionItem("EventDefinition"));
        completionItems.add(new CompletionItem("ObservationDefinition"));
        completionItems.add(new CompletionItem("PlanDefinition"));
        completionItems.add(new CompletionItem("Questionnaire"));
        completionItems.add(new CompletionItem("SpecimenDefinition"));

        completionItems.add(new CompletionItem("ResearchDefinition"));
        completionItems.add(new CompletionItem("ResearchElementDefinition"));
        completionItems.add(new CompletionItem("Evidence"));
        completionItems.add(new CompletionItem("EvidenceVariable"));
        completionItems.add(new CompletionItem("EffectEvidenceSynthesis"));
        completionItems.add(new CompletionItem("RiskEvidenceSynthesis"));

        completionItems.add(new CompletionItem("Measure"));
        completionItems.add(new CompletionItem("MeasureReport"));
        completionItems.add(new CompletionItem("TestScript"));
        completionItems.add(new CompletionItem("TestReport"));

        completionItems.add(new CompletionItem("MedicinalProduct"));
        completionItems.add(new CompletionItem("MedicinalProductAuthorization"));
        completionItems.add(new CompletionItem("MedicinalProductContraindication"));
        completionItems.add(new CompletionItem("MedicinalProductIndication"));
        completionItems.add(new CompletionItem("MedicinalProductIngredient"));
        completionItems.add(new CompletionItem("MedicinalProductInteraction"));
        completionItems.add(new CompletionItem("MedicinalProductManufactured"));
        completionItems.add(new CompletionItem("MedicinalProductPackaged"));
        completionItems.add(new CompletionItem("MedicinalProductPharmaceutical"));
        completionItems.add(new CompletionItem("MedicinalProductUndesirableEffect"));
        completionItems.add(new CompletionItem("SubstanceNucleicAcid"));
        completionItems.add(new CompletionItem("SubstancePolymer"));
        completionItems.add(new CompletionItem("SubstanceProtein"));
        completionItems.add(new CompletionItem("SubstanceReferenceInformation"));
        completionItems.add(new CompletionItem("SubstanceSpecification"));
        completionItems.add(new CompletionItem("SubstanceSourceMaterial"));
    }
}
