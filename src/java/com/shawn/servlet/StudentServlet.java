/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.servlet;

import com.shawn.dao.StudentDAO;
import com.shawn.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shawn
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentDAO studentDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("Action");
        String studentIdStr = request.getParameter("ID");
        int studentId = 0;
        if (studentIdStr != " " && studentIdStr != null) {
            studentId = Integer.parseInt(studentIdStr);
        }
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String yearLeveltr = request.getParameter("yearLevel");
        int yearLevel = 0;
        if (yearLeveltr != " " && yearLeveltr != null) {
            yearLevel = Integer.parseInt(yearLeveltr);
        }

        Student student = new Student(studentId, firstname, lastname, yearLevel);

        switch (action) {
            case "Add":
                studentDAO.addStudent(student);
                request.setAttribute("student", student);             
                break;
            case "Delete":
                studentDAO.deleteStudent(studentId);
                break;
            case "Edit":
                studentDAO.editStudent(student);
//                Student editStudent = studentDAO.getstudent(studentId);
//                request.setAttribute("student", editStudent);
                request.setAttribute("student", student); 
                break;
            case "Search":
                Student searchedStudent = studentDAO.getstudent(studentId);
                request.setAttribute("student", searchedStudent);
                break;
            default:
                break;
        }

        
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
