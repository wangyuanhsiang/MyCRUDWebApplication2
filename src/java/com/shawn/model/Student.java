/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.model;

/**
 *
 * @author Shawn
 */
public class Student {
    
    private int studentID;
    private String firstname;
    private String lastname;
    private int yearLevel;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Student(int studentID, String firstname, String lastname, int yearLevel) {
        this.studentID = studentID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearLevel = yearLevel;
    }

    public Student() {
    }
    
    
    
}
