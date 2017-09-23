<%-- 
    Document   : studentinfo
    Created on : 19-Sep-2017, 11:14:22 PM
    Author     : Shawn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <table border="1">
            <td><a href="studentinfo.jsp">Student Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllStudents">All Students</a></td>
        </table>
        <br />
        
        <form action="${pageContext.request.contextPath}/StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student ID: </td>
                    <td><input type="text" name="ID" value="${student.studentID}" /></td>
                </tr>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level: </td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="Action" value="Add">
                        <input type="submit" name="Action" value="Delete">
                        <input type="submit" name="Action" value="Edit">
                        <input type="submit" name="Action" value="Search">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
