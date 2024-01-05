package com.sergeymar4.crudsql.views;

import com.sergeymar4.crudsql.controllers.CourseController;

import java.util.Scanner;

public class CourseView {
    private String menuMessage;
    private Scanner scanner;
    private CourseController courseController;

    public CourseView(Scanner scanner) {
        this.menuMessage = "Выбирете действие над Course\n" +
                "1.Вывести весь список\n" +
                "2.Вывести по id\n" +
                "3.Создать\n" +
                "4.Обновить\n" +
                "5.Удалить\n" +
                "6.Выйти в главное меню";
        this.scanner = scanner;
        this.courseController = new CourseController();
    }

    void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(courseController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id дисциплины = ");
                int id = scanner.nextInt();
                System.out.println(courseController.getById(id));
            } else if (s.equals("3")) {
                System.out.println("Введите название дисциплины = ");
                String title = scanner.next();
                System.out.println("Введите id = ");
                int id = scanner.nextInt();
                courseController.create(title, id);
            } else if (s.equals("4")) {
                System.out.println("Введите id дисциплины = ");
                int id = scanner.nextInt();
                System.out.println("Введите название дисциплины = ");
                String title = scanner.next();
                courseController.update(id, title);
            } else if (s.equals("5")) {
                System.out.println("Введите id дисциплины = ");
                int id = scanner.nextInt();
                courseController.delete(id);
            } else {
                break;
            }
        }
    }
}