package org.proyect.model;

import static java.lang.String.format;

public class Assistance {
    private Integer assistanceInAcademicCounseling;
    private Integer psychologyAssistance;
    private Integer medicalServiceAssistance;
    private Integer assistanceInSocialService;

    public Assistance(Integer assistanceInAcademicCounseling, Integer psychologyAssistance, Integer medicalServiceAssistance, Integer assistanceInSocialService) {
        this.assistanceInAcademicCounseling = assistanceInAcademicCounseling;
        this.psychologyAssistance = psychologyAssistance;
        this.medicalServiceAssistance = medicalServiceAssistance;
        this.assistanceInSocialService = assistanceInSocialService;
    }

    public Integer getAssistanceInAcademicCounseling() {
        return assistanceInAcademicCounseling;
    }

    public void setAssistanceInAcademicCounseling(Integer assistanceInAcademicCounseling) {
        this.assistanceInAcademicCounseling = assistanceInAcademicCounseling;
    }

    public Integer getPsychologyAssistance() {
        return psychologyAssistance;
    }

    public void setPsychologyAssistance(Integer psychologyAssistance) {
        this.psychologyAssistance = psychologyAssistance;
    }

    public Integer getMedicalServiceAssistance() {
        return medicalServiceAssistance;
    }

    public void setMedicalServiceAssistance(Integer medicalServiceAssistance) {
        this.medicalServiceAssistance = medicalServiceAssistance;
    }

    public Integer getAssistanceInSocialService() {
        return assistanceInSocialService;
    }

    public void setAssistanceInSocialService(Integer assistanceInSocialService) {
        this.assistanceInSocialService = assistanceInSocialService;
    }
    //Validate Assistance In Academic Counseling
    public void validateAssistanceInAcademicCounseling() {
        if(assistanceInAcademicCounseling.toString().isBlank()) {
            throw new RuntimeException("Assistance In Academic Counseling cannot be null");
        }
    }
    //Validate Psychology Assistance
    public void validatePsychologyAssistance() {
        if(psychologyAssistance.toString().isBlank()) {
            throw new RuntimeException("Psychology Assistance cannot be null");
        }
    }
    //Validate Medical Service Assistance
    public void validateMedicalServiceAssistance() {
        if(medicalServiceAssistance.toString().isBlank()) {
            throw new RuntimeException("Medical Service Assistance cannot be null");
        }
    }
    //Validate Assistance In Social Service
    public void validateAssistanceInSocialService() {
        if(assistanceInSocialService.toString().isBlank()) {
            throw new RuntimeException("Assistance In Social Service cannot be null");
        }
    }
    @Override
    public String toString() {
        return format("Assistance In Academic Counseling: %d, Psychology Assistance: %d," +
                " Medical Service Assistance: %d, Assistance In Social Service cannot be null: %d",
                assistanceInAcademicCounseling, psychologyAssistance, medicalServiceAssistance, assistanceInSocialService);
    }
}
