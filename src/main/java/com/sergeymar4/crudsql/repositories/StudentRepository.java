package com.sergeymar4.crudsql.repositories;

import com.sergeymar4.crudsql.models.Student;
import com.sergeymar4.crudsql.providers.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRepository {

    public ArrayList<Student> getAll() {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from students";
        ArrayList<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setAge(resultSet.getInt("age"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }
}
