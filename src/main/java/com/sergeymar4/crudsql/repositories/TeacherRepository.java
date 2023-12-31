package com.sergeymar4.crudsql.repositories;

import com.sergeymar4.crudsql.models.Course;
import com.sergeymar4.crudsql.models.Teacher;
import com.sergeymar4.crudsql.providers.DatabaseManager;

import javax.xml.crypto.Data;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepository {

    public ArrayList<Teacher> getAll() {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from teachers";
        String sql2 = "select * from courses where teacher_id = ?";
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                ArrayList<Course> courses = new ArrayList<>();
                teacher.setAge(resultSet.getInt("age"));
                teacher.setFirstName(resultSet.getString("firstName"));
                teacher.setLastName(resultSet.getString("lastName"));
                teacher.setId(resultSet.getInt("id"));
                teacher.setSpecialization(resultSet.getString("specialization"));
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, resultSet.getInt("id"));
                ResultSet resultSet2 = ps2.executeQuery();

                while (resultSet2.next()) {
                    Course course = new Course();
                    course.setId(resultSet2.getInt("id"));
                    course.setTitle(resultSet2.getString("title"));
                    courses.add(course);
                }
                teacher.setCourses(courses);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }

        return teachers;
    }

    public Teacher getById(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from teachers where id = ?";
        String sql2 = "select * from courses where teacher_id = ?";
        Teacher teacher = new Teacher();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            teacher.setAge(resultSet.getInt("age"));
            teacher.setFirstName(resultSet.getString("firstName"));
            teacher.setLastName(resultSet.getString("lastName"));
            teacher.setSpecialization(resultSet.getString("specialization"));
            teacher.setId(resultSet.getInt("id"));
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
          DatabaseManager.closeConnection();
        }

        return teacher;
    }

    public void delete(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "delete from teachers where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.getConnection();
        }
    }

    public void update(int id, String firstName, String lastName, int age, String specialization) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "update from teachers set firstName = ?, lastName = ?, age = ?, specialization where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, age);
            ps.setString(4, specialization);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public void create(String firstName, String lastName, int age, String specialization) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into teachers (firstName, lastName, age, specialization) values (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, age);
            ps.setString(4,specialization);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }
}
