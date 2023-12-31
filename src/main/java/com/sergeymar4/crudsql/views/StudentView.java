package com.sergeymar4.crudsql.views;

import com.sergeymar4.crudsql.controllers.StudentController;

import java.util.Scanner;

public class StudentView {
    private String menuMessage;
    private StudentController studentController;
    private Scanner scanner;

    public StudentView(Scanner scanner) {
        this.menuMessage = "Выбирете действие над Student:\n" +
                            "1.Вывести весь список\n" +
                            "2.Вывести по id\n" +
                            "3.Создать\n" +
                            "4.Обновить\n" +
                            "5.Удалить\n" +
                            "6.Выйти в главное меню";
        this.studentController = new StudentController();
        this.scanner = scanner;
    }

    void show() {
        while (true) {
            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println(studentController.getAll());
            } else if (s.equals("2")) {
                System.out.println("Введите id = ");
                int id = scanner.nextInt();
                System.out.println(studentController.getById(id));
            } else if (s.equals("3")) {
                System.out.println("Введите имя студента = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию студента = ");
                String lastName = scanner.next();
                System.out.println("Введиет возраст студента = ");
                int age = scanner.nextInt();
                studentController.create(firstName, lastName, age);
            } else if (s.equals("4")) {
                System.out.println("Введите id студента = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя студента = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию студента = ");
                String lastName = scanner.next();
                System.out.println("Введите возраст студента = ");
                int age = scanner.nextInt();
                studentController.update(id, firstName, lastName, age);
            } else if (s.equals("5")) {
                System.out.println("Введите id студента = ");
                int id = scanner.nextInt();
                studentController.delete(id);
            } else {
                break;
            }
        }
    }
}
