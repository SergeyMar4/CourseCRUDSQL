package com.sergeymar4.crudsql.controllers;

import com.sergeymar4.crudsql.models.Teacher;
import com.sergeymar4.crudsql.repositories.TeacherRepository;

import java.util.ArrayList;

public class TeacherController {
    private TeacherRepository teacherRepository;

    public TeacherController() {
        this.teacherRepository = new TeacherRepository();
    }

    public ArrayList<Teacher> getAll() {
        return teacherRepository.getAll();
    }

    public Teacher getById(int id) {
        return teacherRepository.getById(id);
    }

    public void update(int id, String firstName, String lastName, int age, String specialization) {
        teacherRepository.update(id, firstName, lastName, age, specialization);
    }

    public void delete(int id) {
        teacherRepository.delete(id);
    }

    public void create(String firstName, String lastName, int age, String specialization) {
        teacherRepository.create(firstName, lastName, age, specialization);
    }
}
