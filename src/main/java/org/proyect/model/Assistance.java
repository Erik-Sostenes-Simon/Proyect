package org.proyect.model;

import static java.lang.String.format;

public class Assistance {
    private String assistanceInAcademicCounseling;
    private String psychologyAssistance;
    private String medicalServiceAssistance;
    private String assistanceInSocialService;

    public Assistance(){}
    public Assistance(String assistanceInAcademicCounseling, String psychologyAssistance, String medicalServiceAssistance, String assistanceInSocialService) {
        this.assistanceInAcademicCounseling = assistanceInAcademicCounseling;
        this.psychologyAssistance = psychologyAssistance;
        this.medicalServiceAssistance = medicalServiceAssistance;
        this.assistanceInSocialService = assistanceInSocialService;
    }

    public String getAssistanceInAcademicCounseling() {
        return assistanceInAcademicCounseling;
    }

    public void setAssistanceInAcademicCounseling(String assistanceInAcademicCounseling) {
        this.assistanceInAcademicCounseling = assistanceInAcademicCounseling;
    }

    public String getPsychologyAssistance() {
        return psychologyAssistance;
    }

    public void setPsychologyAssistance(String psychologyAssistance) {
        this.psychologyAssistance = psychologyAssistance;
    }

    public String getMedicalServiceAssistance() {
        return medicalServiceAssistance;
    }

    public void setMedicalServiceAssistance(String medicalServiceAssistance) {
        this.medicalServiceAssistance = medicalServiceAssistance;
    }

    public String getAssistanceInSocialService() {
        return assistanceInSocialService;
    }

    public void setAssistanceInSocialService(String assistanceInSocialService) {
        this.assistanceInSocialService = assistanceInSocialService;
    }

    @Override
    public String toString() {
        return format("Assistance In Academic Counseling: %s, Psychology Assistance: %s," +
                " Medical Service Assistance: %s, Assistance In Social Service: %s",
                assistanceInAcademicCounseling, psychologyAssistance, medicalServiceAssistance, assistanceInSocialService);
    }
}
