package org.proyect.model;

import java.util.List;

public class Student {
    private String tuition;
    private String nameStudent;
    private String reasonForDisapproval;
    private Double totalAverage;
    private Boolean canalization;
    private String group;
    private Integer grade;
    private String idManager;
    private List<Course> courses;
    private List<Assistance> assistance;

    public Student(String group, String tuition, String nameStudent, Double totalAverage) {
        this.group = group;
        this.tuition = tuition;
        this.nameStudent = nameStudent;
        this.totalAverage = totalAverage;
    }
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Assistance> getAssistance() {
        return assistance;
    }

    public void setAssistance(List<Assistance> assistance) {
        this.assistance = assistance;
    }
    @Override
    public String toString() {
        return "Student{" +
                "tuition='" + tuition + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                ", reasonForDisapproval='" + reasonForDisapproval + '\'' +
                ", totalAverage=" + totalAverage +
                ", canalization=" + canalization +
                ", group='" + group + '\'' +
                ", grade=" + grade +
                ", idManager='\n" + idManager + '\'' +
                '}';
    }
}
