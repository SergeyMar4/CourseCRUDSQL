package com.sergeymar4.crudsql.repositories;

import com.sergeymar4.crudsql.models.Course;
import com.sergeymar4.crudsql.models.Student;
import com.sergeymar4.crudsql.providers.DatabaseManager;

import javax.xml.crypto.Data;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseRepository {

    public ArrayList<Course> getAll() {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from courses";
        ArrayList<Course> courses = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setTitle(resultSet.getString("title"));
                courses.add(course);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }

        return courses;
    }

    public Course getById(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from courses where id = ?";
        Course course = new Course();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            course.setId(resultSet.getInt("id"));
            course.setTitle(resultSet.getString("title"));
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }

        return course;
    }

    public void create(String title) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into courses (title) values(?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public void update(int id, String title) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "update course set title = ? where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public void delete(int id) {
        Connection connection = DatabaseManager.getConnection();
        String sql = "delete course from courses where id = ?";

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
