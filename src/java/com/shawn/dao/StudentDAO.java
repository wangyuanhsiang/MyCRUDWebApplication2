/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.dao;

import com.shawn.model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Shawn
 */
@Stateless
public class StudentDAO {

    @Resource(mappedName = "jdbc/StudentDB")
    private DataSource ds;

    public void addStudent(Student student) {
        String sql = "INSERT INTO SHAWN.STUDENT VALUES(" + student.getStudentID() + ",'" + student.getFirstname() + "','" + student.getLastname() + "', " + student.getYearLevel() + " )";
        executeModifyQuery(sql);
    }

    public void editStudent(Student student) {
        String sql = "UPDATE SHAWN.STUDENT SET FIRSTNAME = '" + student.getFirstname() + "', LASTNAME = '" + student.getLastname() + "', YEARLEVEL = " + student.getYearLevel() + " WHERE STUDENTID = " + student.getStudentID() + "";
        executeModifyQuery(sql);
    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM SHAWN.STUDENT WHERE STUDENTID =" + studentId + "";
        executeModifyQuery(sql);
    }

    public Student getstudent(int studentId) {
        Student student = new Student();
//        String studentIdStre = Integer.toString(studentId);
//        String sql = "SELECT * FROM STUDENT WHERE STUDENTID = " + studentId + "";
//        ResultSet rs = executeFetchQuery(sql);
        try {
            Connection conn = ds.getConnection();
//            String studentIdStre = Integer.toString(studentId);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENT WHERE STUDENTID = "+ studentId+"");
            while (rs.next()) {
                student.setStudentID(rs.getInt("STUDENTID"));
                student.setFirstname(rs.getString("FIRSTNAME"));
                student.setLastname(rs.getString("LASTNAME"));
                student.setYearLevel(rs.getInt("YEARLEVEL"));
            }
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return student;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> list = new ArrayList();
//        Student student = new Student();
//         String sql = "SELECT * FROM STUDENT";
//         ResultSet rs = executeFetchQuery(sql);

        try {
            Connection conn = ds.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENT");
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("STUDENTID"));
                student.setFirstname(rs.getString("FIRSTNAME"));
                student.setLastname(rs.getString("LASTNAME"));
                student.setYearLevel(rs.getInt("YEARLEVEL"));
                list.add(student);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return list;
    }

    public void executeModifyQuery(String sql) {
        try {
            Connection conn = ds.getConnection();
            conn.createStatement().execute(sql);
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet executeFetchQuery(String sql) {
        ResultSet rs = null;

        try {
            Connection conn = ds.getConnection();
            conn.createStatement().executeQuery(sql);
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rs;
    }

}
