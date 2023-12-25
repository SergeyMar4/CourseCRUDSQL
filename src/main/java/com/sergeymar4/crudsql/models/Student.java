package com.sergeymar4.crudsql.models;

public class Student {
    private int id;
    private int age;
    private String firstName;
    private String LastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
