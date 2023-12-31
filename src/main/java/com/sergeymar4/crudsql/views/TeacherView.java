package com.sergeymar4.crudsql.views;

import com.sergeymar4.crudsql.controllers.TeacherController;

import java.util.Scanner;

public class TeacherView {
    private String menuMessage;
    private Scanner scanner;
    private TeacherController teacherController;

    public TeacherView(Scanner scanner) {
        this.menuMessage = "Выбирете действие над teacher:\n" +
                            "1.Вывести весь список\n" +
                            "2.Вывести по id\n" +
                            "3.Обновить\n" +
                            "4.Удалить\n" +
                            "5.Создать\n" +
                            "6.Выйти в главное меню";
        this.scanner = scanner;
        this.teacherController = new TeacherController();
    }

    void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(teacherController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id = ");
                int id = scanner.nextInt();
                System.out.println(teacherController.getById(id));
            } else if (s.equals("3")) {
                System.out.println("Введите id преподавателя = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя преподавателя = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию преподавателя = ");
                String lastName = scanner.next();
                System.out.println("Введите возраст преподавателя = ");
                int age = scanner.nextInt();
                System.out.println("Введите специализацию преподавателя = ");
                String specialization = scanner.next();
                teacherController.update(id, firstName, lastName, age, specialization);
            } else if (s.equals("4")) {
                System.out.println("Введиет id студента = ");
                int id = scanner.nextInt();
                teacherController.delete(id);
            } else if (s.equals("5")) {
                System.out.println("Введите имя преподавателя = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию преподавателя = ");
                String lastName = scanner.next();
                System.out.println("Введите возраст преподавателя = ");
                int age = scanner.nextInt();
                System.out.println("Введите специализацию преподавателя = ");
                String specialization = scanner.next();
                teacherController.create(firstName, lastName, age, specialization);
            } else {
                break;
            }
        }
    }
}
