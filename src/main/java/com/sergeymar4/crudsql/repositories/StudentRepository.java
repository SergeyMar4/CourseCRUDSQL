package com.sergeymar4.crudsql.repositories;

import com.sergeymar4.crudsql.models.Student;
import com.sergeymar4.crudsql.providers.DatabaseManager;

import java.sql.*;
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
        } finally {
            DatabaseManager.closeConnection();
        }

        return students;
    }

    public Student getById(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from students where id = ?";
        Student student = new Student();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                student.setAge(resultSet.getInt("age"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setId(resultSet.getInt("id"));
            }
        } catch(SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }

        return student;
    }

    public void create(String firstName, String lastName, int age) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into students (firstName, lastName, age) values (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public void update(int id, String firstName, String lastName, int age) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "update students set firstName = ?, lastName = ?, age = ? where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public void delete(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "delete from students where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }
}
