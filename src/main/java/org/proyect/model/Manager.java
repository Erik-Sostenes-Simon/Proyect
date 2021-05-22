package org.proyect.model;

import static java.lang.String.format;

public class Manager {
    private Integer id;
    private String name;
    private String password;
    private Group group;
    private Integer grade;
    //Constructor
    public Manager(String name, Integer id, String password, Group group, Integer grade) {
        setId(id);
        setName(name);
        setPassword(password);
        setGroup(group);
        setGrade(grade);
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    // validate the id
    public void validateId() {
        if(String.valueOf(id) == null )
            throw new RuntimeException("Id is not a number");
    }
    // validate the name
    public void validateName() {
        if(name.isBlank())
            throw new RuntimeException("Name cannot be null");
    }
    // validate the name
    public void validatePassword() {
        if(password.isBlank())
            throw new RuntimeException("Password cannot be null");
    }
    // validate the name
    public void validateGroup() {
        if(group.name().isBlank())
            throw new RuntimeException("Group cannot be null");
    }
    // validate the id
    public void validateGrade() {
        if(String.valueOf(grade) == null )
            throw new RuntimeException("Grade is not a number");
    }
    @Override
    public String toString() {
        return format("Id: %d, Name: %s, Group: %s, Grade: %d", id, name, group.toString(), grade);
    }
}
