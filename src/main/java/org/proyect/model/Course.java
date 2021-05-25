package org.proyect.model;

import static java.lang.String.format;

public class Course {
    private Integer key;
    private String nameTeacher;
    private String nameCourse;
    private Integer evaluationUnit;
    private Double qualification;

    public Course(){}
    public Course(String nameCourse, Double qualification,  Integer evaluationUnit) {
        this.nameCourse = nameCourse;
        this.qualification = qualification;
        this.evaluationUnit = evaluationUnit;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }
    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public Integer getEvaluationUnit() {
        return evaluationUnit;
    }

    public void setEvaluationUnit(Integer evaluationUnit) {
        this.evaluationUnit = evaluationUnit;
    }
    @Override
    public String toString() {
      return format("Key: %d, Name Course: %s, Qualification: %f, Name Teacher: %s", key, nameCourse, qualification, nameTeacher);
    }
}
