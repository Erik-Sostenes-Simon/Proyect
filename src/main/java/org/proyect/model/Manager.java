package org.proyect.model;

import static java.lang.String.format;

public class Manager {
    private Integer id;
    private String name;
    private String password;
    private String group;
    private Integer grade;
    //Constructor
    public Manager(String name, Integer id, String password, String group, Integer grade) {
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

    @Override
    public String toString() {
        return format("Id: %d, Name: %s, Group: %s, Grade: %d", id, name, group, grade);
    }
}
