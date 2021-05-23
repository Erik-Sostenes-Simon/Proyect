package org.proyect.model;

import java.util.List;

public class Student {
    private String nameManager;
    private String enrollment;
    private Group group;
    private String nameStudent;
    private Boolean canalization;
    private List<Course> courses;
    private Double totalAverage;
    private String reasonForDisapproval;
    private Assistance assistance;

    public Student(String nameManager, String enrollment, Group group, String name, Boolean canalization, List<Course> courses, Double totalAverage, String reasonForDisapproval, Assistance assistance) {
        this.nameManager = nameManager;
        this.enrollment = enrollment;
        this.group = group;
        this.nameStudent = name;
        this.canalization = canalization;
        this.courses = courses;
        this.totalAverage = totalAverage;
        this.reasonForDisapproval = reasonForDisapproval;
        this.assistance = assistance;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }


    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Boolean getCanalization() {
        return canalization;
    }

    public void setCanalization(Boolean canalization) {
        this.canalization = canalization;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(Double totalAverage) {
        this.totalAverage = totalAverage;
    }

    public String getReasonForDisapproval() {
        return reasonForDisapproval;
    }

    public void setReasonForDisapproval(String reasonForDisapproval) {
        this.reasonForDisapproval = reasonForDisapproval;
    }

    public Assistance getAssistance() {
        return assistance;
    }

    public void setAssistance(Assistance assistance) {
        this.assistance = assistance;
    }
}
