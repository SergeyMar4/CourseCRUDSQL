package com.sergeymar4.crudsql.views;

import com.sergeymar4.crudsql.repositories.StudentRepository;
import com.sergeymar4.crudsql.repositories.TeacherRepository;

public class Main {
    public static void main(String[] args) {
        MainManager mainManager = new MainManager();
        mainManager.run();
    }
}