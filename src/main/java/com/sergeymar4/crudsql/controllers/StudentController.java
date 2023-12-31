package com.sergeymar4.crudsql.controllers;

import com.sergeymar4.crudsql.models.Student;
import com.sergeymar4.crudsql.repositories.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
    private StudentRepository studentRepository;

    public StudentController() {
        this.studentRepository = new StudentRepository();
    }

    public ArrayList<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public void create(String firstName, String lastName, int age) {
        studentRepository.create(firstName, lastName, age);
    }

    public void update(int id, String firstName, String lastName, int age) {
        studentRepository.update(id, firstName, lastName, age);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }
}
