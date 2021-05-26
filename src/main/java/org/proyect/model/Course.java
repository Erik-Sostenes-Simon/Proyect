package org.proyect.model;


public class Course {
    private String idCourse;
    private String nameCourse;
    private String nameManager;
    private Integer evaluationUnit;
    private String keyGroup;
    private String periodC;
    private Double qualification;
    private String idStudent;
    private String idManager;

    public Course(String idCourse, String nameCourse, String nameManager, Integer evaluationUnit, String keyGroup, String periodC, Double qualification, String idStudent, String idManager) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.nameManager = nameManager;
        this.evaluationUnit = evaluationUnit;
        this.keyGroup = keyGroup;
        this.periodC = periodC;
        this.qualification = qualification;
        this.idStudent = idStudent;
        this.idManager = idManager;
    }
    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public Integer getEvaluationUnit() {
        return evaluationUnit;
    }

    public void setEvaluationUnit(Integer evaluationUnit) {
        this.evaluationUnit = evaluationUnit;
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

    public String getPeriodC() {
        return periodC;
    }

    public void setPeriodC(String periodC) {
        this.periodC = periodC;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }
    @Override
    public String toString() {
        return "Course{" +
                "idCourse='" + idCourse + '\'' +
                ", nameCourse='" + nameCourse + '\'' +
                ", nameManager='" + nameManager + '\'' +
                ", evaluationUnit=" + evaluationUnit +
                ", keyGroup='" + keyGroup + '\'' +
                ", periodC='" + periodC + '\'' +
                ", qualification=" + qualification +
                ", idStudent='" + idStudent + '\'' +
                ", idManager='" + idManager + '\'' +
                '}';
    }
}
