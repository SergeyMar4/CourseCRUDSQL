package com.sergeymar4.crudsql.views;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainManager {
    private String menuMessage;
    private Scanner scanner;
    private StudentView studentView;
    private TeacherView teacherView;
    private CourseView courseView;

    public MainManager() {
        this.menuMessage = "Выбирете класс для работы:\n" +
                            "1.Student\n" +
                            "2.Course\n" +
                            "3.Teacher\n" +
                            "4.Завершить программу";
        this.scanner = new Scanner(System.in);
        this.studentView = new StudentView(scanner);
        this.teacherView = new TeacherView(scanner);
        this.courseView = new CourseView(scanner);
    }

    public void run() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                studentView.show();
            } else if (s.equals("2")) {
                courseView.show();
            } else if (s.equals("3")) {
                teacherView.show();
            } else {
                break;
            }
        }
    }
}
