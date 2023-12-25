package com.sergeymar4.crudsql.models;

public class Teacher {
    private int id;
    private int age;
    private String firstName;
    private String LastName;
    private String specialization;

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

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
