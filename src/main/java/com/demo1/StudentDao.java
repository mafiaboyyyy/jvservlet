package com.demo1;

import jakarta.servlet.RequestDispatcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_management", "root", "29kingdragon");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static int save(Student s) {
        int status = 0;
        try {
            Connection connection = StudentDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students(id, full_name, course, score) VALUES (?,?,?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getScore());
            status = ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static int update(Student s) {
        int status = 0;
        try {
            Connection connection = StudentDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE students set full_name=?,course=?,score=? where id=?");
            ps.setString(1, s.getFullName());
            ps.setString(2, s.getCourse());
            ps.setDouble(3, s.getScore());
            ps.setInt(4, s.getId());
            status = ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = StudentDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static Student getStudentById(int id) {
        Student s = new Student();
        try {
            Connection connection = StudentDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id=?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                s.setId(resultSet.getInt(1));
                s.setFullName(resultSet.getString(2));
                s.setCourse(resultSet.getString(3));
                s.setScore(resultSet.getDouble(4));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = StudentDao.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt(1));
                s.setFullName(resultSet.getString(2));
                s.setCourse(resultSet.getString(3));
                s.setScore(resultSet.getDouble(4));
                list.add(s);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
