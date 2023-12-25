package com.sergeymar4.crudsql.views;

import com.sergeymar4.crudsql.repositories.StudentRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        System.out.println(studentRepository.getAll());
    }
}