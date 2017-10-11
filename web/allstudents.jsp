<%-- 
    Document   : allstudents
    Created on : 20-Sep-2017, 3:11:55 AM
    Author     : Shawn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
    </head>
    <body>
        <table border="1">
            <td><a href="studentinfo.jsp">Student Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllStudents">All Students</a></td>
        </table>
        <br />
        <h1>List of Students</h1>
        <br/>

        <table border="1" >
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${requestScope.List}" var="student" >
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetStudent?ID=${student.studentID}" >${student.studentID}</a></td>
                    <td>${student.firstname}</td>
                    <td>${student.lastname}</td>
                    <td>${student.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
