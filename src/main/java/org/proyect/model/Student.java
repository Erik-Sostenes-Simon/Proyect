package org.proyect.model;

public class Student {
    private String tuition;
    private String nameStudent;
    private String reasonForDisapproval;
    private Double totalAverage;
    private Boolean canalization;
    private String group;
    private Integer grade;
    private String idManager;
    private Course courses;
    private Assistance assistance;

    public Student(String tuition, String nameStudent, String reasonForDisapproval, Double totalAverage, Boolean canalization, String group, Integer grade, String idManager) {
        this.tuition = tuition;
        this.nameStudent = nameStudent;
        this.reasonForDisapproval = reasonForDisapproval;
        this.totalAverage = totalAverage;
        this.canalization = canalization;
        this.group = group;
        this.grade = grade;
        this.idManager = idManager;
    }
    public Student(String tuition, String nameStudent, String reasonForDisapproval, Double totalAverage, Boolean canalization, String group, Integer grade) {
        this.tuition = tuition;
        this.nameStudent = nameStudent;
        this.reasonForDisapproval = reasonForDisapproval;
        this.totalAverage = totalAverage;
        this.canalization = canalization;
        this.group = group;
        this.grade = grade;
    }
    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getReasonForDisapproval() {
        return reasonForDisapproval;
    }

    public void setReasonForDisapproval(String reasonForDisapproval) {
        this.reasonForDisapproval = reasonForDisapproval;
    }

    public Double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(Double totalAverage) {
        this.totalAverage = totalAverage;
    }

    public Boolean getCanalization() {
        return canalization;
    }

    public void setCanalization(Boolean canalization) {
        this.canalization = canalization;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public Assistance getAssistance() {
        return assistance;
    }

    public void setAssistance(Assistance assistance) {
        this.assistance = assistance;
    }
    @Override
    public String toString() {
        return tuition + ","+
                nameStudent + "," +
                reasonForDisapproval + "," +
                totalAverage +","+
                canalization +","+
                group + "," +
                grade + ","+
                idManager;
    }
}
