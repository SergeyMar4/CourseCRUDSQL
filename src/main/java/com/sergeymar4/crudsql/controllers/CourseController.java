package com.sergeymar4.crudsql.controllers;

import com.sergeymar4.crudsql.models.Course;
import com.sergeymar4.crudsql.repositories.CourseRepository;

import java.util.ArrayList;

public class CourseController {
    private CourseRepository courseRepository;

    public CourseController() {
        this.courseRepository = new CourseRepository();
    }

    public ArrayList<Course> getAll() {
        return courseRepository.getAll();
    }

    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    public void create(String title, int id) {
        courseRepository.create(title, id);
    }

    public void update(int id, String title) {
        courseRepository.update(id, title);
    }

    public void delete(int id) {
        courseRepository.delete(id);
    }
}
