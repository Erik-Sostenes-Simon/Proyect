package org.proyect.model;

import static java.lang.String.format;

public class Course {
    private Integer key;
    private String nameTeacher;
    private String nameCourse;
    private Integer evaluationUnit;
    private Float qualification;

    public Course(Integer key, String nameTeacher, String nameCourse, Integer evaluationUnit, Float qualification) {
        this.key = key;
        this.nameTeacher = nameTeacher;
        this.nameCourse = nameCourse;
        this.evaluationUnit = evaluationUnit;
        this.qualification = qualification;
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

    public Float getQualification() {
        return qualification;
    }

    public void setQualification(Float qualification) {
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
    //Validate key
    public void validateKey() {
        if(key.toString().isBlank())
            throw  new RuntimeException("Key cannot be null ");
    }
    //validate name curse
    public void nameCurse() {
        if(nameCourse.isBlank())
            throw  new RuntimeException("Name curse cannot be null ");
    }
    //validate qualification
    public void validateQualification() {
        if(qualification.toString().isBlank())
            throw  new RuntimeException("Qualification cannot be null ");
    }
    //validate qualification
    public void validateNameTeacher() {
        if(nameTeacher.isBlank())
            throw  new RuntimeException("Name Teacher cannot be null ");
    }
    @Override
    public String toString() {
      return format("Key: %d, Name Course: %s, Qualification: %f, Name Teacher: %s", key, nameCourse, qualification, nameTeacher);
    }
}
