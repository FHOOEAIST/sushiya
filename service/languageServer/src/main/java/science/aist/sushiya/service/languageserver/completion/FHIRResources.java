package science.aist.sushiya.service.languageserver.completion;

import org.eclipse.lsp4j.CompletionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Singleton to get completion Items for already defined resources based on: https://www.hl7.org/fhir/resourcelist.html (22 Oct 2020)</p>
 *
 * @author SophieBauernfeind
 *
 */
public class FHIRResources {
    private static final FHIRResources instance = new FHIRResources();

    private final List<CompletionItem> foundationConformanceCompletionItems = new ArrayList<>();
    private final List<CompletionItem> foundationTerminologyCompletionItems = new ArrayList<>();
    private final List<CompletionItem> foundationSecurityCompletionItems = new ArrayList<>();
    private final List<CompletionItem> foundationDocumentsCompletionItems = new ArrayList<>();
    private final List<CompletionItem> foundationOtherCompletionItems = new ArrayList<>();
    private final List<CompletionItem> baseIndividualsCompletionItems = new ArrayList<>();
    private final List<CompletionItem> baseEntities1CompletionItems = new ArrayList<>();
    private final List<CompletionItem> baseEntities2CompletionItems = new ArrayList<>();
    private final List<CompletionItem> baseWorkflowCompletionItems = new ArrayList<>();
    private final List<CompletionItem> baseManagementCompletionItems = new ArrayList<>();
    private final List<CompletionItem> clinicalSummaryCompletionItems = new ArrayList<>();
    private final List<CompletionItem> clinicalDiagnosticsCompletionItems = new ArrayList<>();
    private final List<CompletionItem> clinicalMedicationsCompletionItems = new ArrayList<>();
    private final List<CompletionItem> clinicalCareProvisionCompletionItems = new ArrayList<>();
    private final List<CompletionItem> clinicalRequestResponseCompletionItems = new ArrayList<>();
    private final List<CompletionItem> financialSupportCompletionItems = new ArrayList<>();
    private final List<CompletionItem> financialBillingCompletionItems = new ArrayList<>();
    private final List<CompletionItem> financialPaymentCompletionItems = new ArrayList<>();
    private final List<CompletionItem> financialGeneralCompletionItems = new ArrayList<>();
    private final List<CompletionItem> specializedPublicHealthResearchCompletionItems = new ArrayList<>();
    private final List<CompletionItem> specializedDefinitionalArtifactsCompletionItems = new ArrayList<>();
    private final List<CompletionItem> specializedEvidenceBasedMedicineCompletionItems = new ArrayList<>();
    private final List<CompletionItem> specializedQualityReportingTestingCompletionItems = new ArrayList<>();
    private final List<CompletionItem> specializedMedicationDefinitionCompletionItems = new ArrayList<>();

    public static FHIRResources getInstance() {
        return instance;
    }

    //private constructor to make it as a singleton
    private FHIRResources() {
        //foundation
        foundationConformanceCompletionItems.add(new CompletionItem("CapabilityStatement"));
        foundationConformanceCompletionItems.add(new CompletionItem("StructureDefinition"));
        foundationConformanceCompletionItems.add(new CompletionItem("ImplementationGuide"));
        foundationConformanceCompletionItems.add(new CompletionItem("SearchParameter"));
        foundationConformanceCompletionItems.add(new CompletionItem("MessageDefinition"));
        foundationConformanceCompletionItems.add(new CompletionItem("OperationDefinition"));
        foundationConformanceCompletionItems.add(new CompletionItem("CompartmentDefinition"));
        foundationConformanceCompletionItems.add(new CompletionItem("StructureMap"));
        foundationConformanceCompletionItems.add(new CompletionItem("GraphDefinition"));
        foundationConformanceCompletionItems.add(new CompletionItem("ExampleScenario"));

        foundationTerminologyCompletionItems.add(new CompletionItem("CodeSystem"));
        foundationTerminologyCompletionItems.add(new CompletionItem("ValueSet"));
        foundationTerminologyCompletionItems.add(new CompletionItem("ConceptMap"));
        foundationTerminologyCompletionItems.add(new CompletionItem("NamingSystem"));
        foundationTerminologyCompletionItems.add(new CompletionItem("TerminologyCapabilities"));

        foundationSecurityCompletionItems.add(new CompletionItem("Provenance"));
        foundationSecurityCompletionItems.add(new CompletionItem("AuditEvent"));
        foundationSecurityCompletionItems.add(new CompletionItem("Consent"));

        foundationDocumentsCompletionItems.add(new CompletionItem("Composition"));
        foundationDocumentsCompletionItems.add(new CompletionItem("DocumentManifest"));
        foundationDocumentsCompletionItems.add(new CompletionItem("DocumentReference"));
        foundationDocumentsCompletionItems.add(new CompletionItem("CatalogEntry"));

        foundationOtherCompletionItems.add(new CompletionItem("Basic"));
        foundationOtherCompletionItems.add(new CompletionItem("Binary"));
        foundationOtherCompletionItems.add(new CompletionItem("Bundle"));
        foundationOtherCompletionItems.add(new CompletionItem("Linkage"));
        foundationOtherCompletionItems.add(new CompletionItem("MessageHeader"));
        foundationOtherCompletionItems.add(new CompletionItem("OperationOutcome"));
        foundationOtherCompletionItems.add(new CompletionItem("Parameters"));
        foundationOtherCompletionItems.add(new CompletionItem("Subscription"));


        //base
        baseIndividualsCompletionItems.add(new CompletionItem("Patient"));
        baseIndividualsCompletionItems.add(new CompletionItem("Practitioner"));
        baseIndividualsCompletionItems.add(new CompletionItem("PractitionerRole"));
        baseIndividualsCompletionItems.add(new CompletionItem("RelatedPerson"));
        baseIndividualsCompletionItems.add(new CompletionItem("Person"));
        baseIndividualsCompletionItems.add(new CompletionItem("Group"));

        baseEntities1CompletionItems.add(new CompletionItem("Organization"));
        baseEntities1CompletionItems.add(new CompletionItem("OrganizationAffiliation"));
        baseEntities1CompletionItems.add(new CompletionItem("HealthcareService"));
        baseEntities1CompletionItems.add(new CompletionItem("Endpoint"));
        baseEntities1CompletionItems.add(new CompletionItem("Location"));

        baseEntities2CompletionItems.add(new CompletionItem("Substance"));
        baseEntities2CompletionItems.add(new CompletionItem("BiologicallyDerivedProduct"));
        baseEntities2CompletionItems.add(new CompletionItem("Device"));
        baseEntities2CompletionItems.add(new CompletionItem("DeviceMetric"));

        baseWorkflowCompletionItems.add(new CompletionItem("Task"));
        baseWorkflowCompletionItems.add(new CompletionItem("Appointment"));
        baseWorkflowCompletionItems.add(new CompletionItem("AppointmentResponse"));
        baseWorkflowCompletionItems.add(new CompletionItem("Schedule"));
        baseWorkflowCompletionItems.add(new CompletionItem("Slot"));
        baseWorkflowCompletionItems.add(new CompletionItem("VerificationResult"));

        baseManagementCompletionItems.add(new CompletionItem("Encounter"));
        baseManagementCompletionItems.add(new CompletionItem("EpisodeOfCare"));
        baseManagementCompletionItems.add(new CompletionItem("Flag"));
        baseManagementCompletionItems.add(new CompletionItem("List"));
        baseManagementCompletionItems.add(new CompletionItem("Library"));


        //clinical
        clinicalSummaryCompletionItems.add(new CompletionItem("AllergyIntolerance"));
        clinicalSummaryCompletionItems.add(new CompletionItem("AdverseEvent"));
        clinicalSummaryCompletionItems.add(new CompletionItem("Condition"));
        clinicalSummaryCompletionItems.add(new CompletionItem("Procedure"));
        clinicalSummaryCompletionItems.add(new CompletionItem("FamilyMemberHistory"));
        clinicalSummaryCompletionItems.add(new CompletionItem("ClinicalImpression"));
        clinicalSummaryCompletionItems.add(new CompletionItem("DetectedIssue"));

        clinicalDiagnosticsCompletionItems.add(new CompletionItem("Observation"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("Media"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("DiagnosticReport"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("Specimen"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("BodyStructure"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("ImagingStudy"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("QuestionnaireResponse"));
        clinicalDiagnosticsCompletionItems.add(new CompletionItem("MolecularSequence"));

        clinicalMedicationsCompletionItems.add(new CompletionItem("MedicationRequest"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("MedicationAdministration"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("MedicationDispense"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("MedicationStatement"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("Medication"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("MedicationKnowledge"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("Immunization"));
        clinicalMedicationsCompletionItems.add(new CompletionItem("ImmunizationEvaluation"));

        clinicalCareProvisionCompletionItems.add(new CompletionItem("CarePlan"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("CareTeam"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("Goal"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("ServiceRequest"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("NutritionOrder"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("VisionPrescription"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("RiskAssessment"));
        clinicalCareProvisionCompletionItems.add(new CompletionItem("RequestGroup"));

        clinicalRequestResponseCompletionItems.add(new CompletionItem("Communication"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("CommunicationRequest"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("DeviceRequest"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("DeviceUseStatement"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("GuidanceResponse"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("SupplyRequest"));
        clinicalRequestResponseCompletionItems.add(new CompletionItem("SupplyDelivery"));


        //financial
        financialSupportCompletionItems.add(new CompletionItem("Coverage"));
        financialSupportCompletionItems.add(new CompletionItem("CoverageEligibilityRequest"));
        financialSupportCompletionItems.add(new CompletionItem("CoverageEligibilityResponse"));
        financialSupportCompletionItems.add(new CompletionItem("EnrollmentRequest"));
        financialSupportCompletionItems.add(new CompletionItem("EnrollmentResponse"));

        financialBillingCompletionItems.add(new CompletionItem("Claim"));
        financialBillingCompletionItems.add(new CompletionItem("ClaimResponse"));
        financialBillingCompletionItems.add(new CompletionItem("Invoice"));

        financialPaymentCompletionItems.add(new CompletionItem("PaymentNotice"));
        financialPaymentCompletionItems.add(new CompletionItem("PaymentReconciliation"));

        financialGeneralCompletionItems.add(new CompletionItem("Account"));
        financialGeneralCompletionItems.add(new CompletionItem("ChargeItem"));
        financialGeneralCompletionItems.add(new CompletionItem("ChargeItemDefinition"));
        financialGeneralCompletionItems.add(new CompletionItem("Contract"));
        financialGeneralCompletionItems.add(new CompletionItem("ExplanationOfBenefit"));
        financialGeneralCompletionItems.add(new CompletionItem("InsurancePlan"));


        //spezialized
        specializedPublicHealthResearchCompletionItems.add(new CompletionItem("ResearchStudy"));
        specializedPublicHealthResearchCompletionItems.add(new CompletionItem("ResearchSubject"));

        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("ActivityDefinition"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("DeviceDefinition"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("EventDefinition"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("ObservationDefinition"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("PlanDefinition"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("Questionnaire"));
        specializedDefinitionalArtifactsCompletionItems.add(new CompletionItem("SpecimenDefinition"));

        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("ResearchDefinition"));
        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("ResearchElementDefinition"));
        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("Evidence"));
        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("EvidenceVariable"));
        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("EffectEvidenceSynthesis"));
        specializedEvidenceBasedMedicineCompletionItems.add(new CompletionItem("RiskEvidenceSynthesis"));

        specializedQualityReportingTestingCompletionItems.add(new CompletionItem("Measure"));
        specializedQualityReportingTestingCompletionItems.add(new CompletionItem("MeasureReport"));
        specializedQualityReportingTestingCompletionItems.add(new CompletionItem("TestScript"));
        specializedQualityReportingTestingCompletionItems.add(new CompletionItem("TestReport"));

        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProduct"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductAuthorization"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductContraindication"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductIndication"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductIngredient"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductInteraction"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductManufactured"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductPackaged"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductPharmaceutical"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("MedicinalProductUndesirableEffect"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstanceNucleicAcid"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstancePolymer"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstanceProtein"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstanceReferenceInformation"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstanceSpecification"));
        specializedMedicationDefinitionCompletionItems.add(new CompletionItem("SubstanceSourceMaterial"));
    }

    public List<CompletionItem> getFoundationConformanceCompletionItems() {
        return foundationConformanceCompletionItems;
    }

    public List<CompletionItem> getFoundationTerminologyCompletionItems() {
        return foundationTerminologyCompletionItems;
    }

    public List<CompletionItem> getFoundationSecurityCompletionItems() {
        return foundationSecurityCompletionItems;
    }

    public List<CompletionItem> getFoundationDocumentsCompletionItems() {
        return foundationDocumentsCompletionItems;
    }

    public List<CompletionItem> getFoundationOtherCompletionItems() {
        return foundationOtherCompletionItems;
    }

    public List<CompletionItem> getBaseIndividualsCompletionItems() {
        return baseIndividualsCompletionItems;
    }

    public List<CompletionItem> getBaseEntities1CompletionItems() {
        return baseEntities1CompletionItems;
    }

    public List<CompletionItem> getBaseEntities2CompletionItems() {
        return baseEntities2CompletionItems;
    }

    public List<CompletionItem> getBaseWorkflowCompletionItems() {
        return baseWorkflowCompletionItems;
    }

    public List<CompletionItem> getBaseManagementCompletionItems() {
        return baseManagementCompletionItems;
    }

    public List<CompletionItem> getClinicalSummaryCompletionItems() {
        return clinicalSummaryCompletionItems;
    }

    public List<CompletionItem> getClinicalDiagnosticsCompletionItems() {
        return clinicalDiagnosticsCompletionItems;
    }

    public List<CompletionItem> getClinicalMedicationsCompletionItems() {
        return clinicalMedicationsCompletionItems;
    }

    public List<CompletionItem> getClinicalCareProvisionCompletionItems() {
        return clinicalCareProvisionCompletionItems;
    }

    public List<CompletionItem> getClinicalRequestResponseCompletionItems() {
        return clinicalRequestResponseCompletionItems;
    }

    public List<CompletionItem> getFinancialSupportCompletionItems() {
        return financialSupportCompletionItems;
    }

    public List<CompletionItem> getFinancialBillingCompletionItems() {
        return financialBillingCompletionItems;
    }

    public List<CompletionItem> getFinancialPaymentCompletionItems() {
        return financialPaymentCompletionItems;
    }

    public List<CompletionItem> getFinancialGeneralCompletionItems() {
        return financialGeneralCompletionItems;
    }

    public List<CompletionItem> getSpecializedPublicHealthResearchCompletionItems() {
        return specializedPublicHealthResearchCompletionItems;
    }

    public List<CompletionItem> getSpecializedDefinitionalArtifactsCompletionItems() {
        return specializedDefinitionalArtifactsCompletionItems;
    }

    public List<CompletionItem> getSpecializedEvidenceBasedMedicineCompletionItems() {
        return specializedEvidenceBasedMedicineCompletionItems;
    }

    public List<CompletionItem> getSpecializedQualityReportingTestingCompletionItems() {
        return specializedQualityReportingTestingCompletionItems;
    }

    public List<CompletionItem> getSpecializedMedicationDefinitionCompletionItems() {
        return specializedMedicationDefinitionCompletionItems;
    }

    public List<CompletionItem> getAllFoundation(){
        List<CompletionItem> result = new ArrayList<>();
        result.addAll(foundationConformanceCompletionItems);
        result.addAll(foundationDocumentsCompletionItems);
        result.addAll(foundationOtherCompletionItems);
        result.addAll(foundationSecurityCompletionItems);
        result.addAll(foundationTerminologyCompletionItems);
        return result;
    }

    public List<CompletionItem> getAllBase(){
        List<CompletionItem> result = new ArrayList<>();
        result.addAll(baseIndividualsCompletionItems);
        result.addAll(baseEntities1CompletionItems);
        result.addAll(baseEntities2CompletionItems);
        result.addAll(baseManagementCompletionItems);
        result.addAll(baseWorkflowCompletionItems);
        return result;
    }

    public List<CompletionItem> getAllClinical(){
        List<CompletionItem> result = new ArrayList<>();
        result.addAll(clinicalCareProvisionCompletionItems);
        result.addAll(clinicalDiagnosticsCompletionItems);
        result.addAll(clinicalMedicationsCompletionItems);
        result.addAll(clinicalRequestResponseCompletionItems);
        result.addAll(clinicalSummaryCompletionItems);
        return result;
    }

    public List<CompletionItem> getAllFinancial(){
        List<CompletionItem> result = new ArrayList<>();
        result.addAll(financialBillingCompletionItems);
        result.addAll(financialGeneralCompletionItems);
        result.addAll(financialPaymentCompletionItems);
        result.addAll(financialSupportCompletionItems);
        return result;
    }

    public List<CompletionItem> getAllSpecialized(){
        List<CompletionItem> result = new ArrayList<>();
        result.addAll(specializedDefinitionalArtifactsCompletionItems);
        result.addAll(specializedEvidenceBasedMedicineCompletionItems);
        result.addAll(specializedMedicationDefinitionCompletionItems);
        result.addAll(specializedPublicHealthResearchCompletionItems);
        result.addAll(specializedQualityReportingTestingCompletionItems);
        return result;
    }
}
