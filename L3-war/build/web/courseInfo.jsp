<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
    </head>
    <body>
        <h1>inscription</h1>
        <form action="./StudentCourseServlet" method="POST">
            <table>
                <tr>
                    <td>Student ID</td>
                    <td><input type="text" name="studentId" value="${course.studentid}" /></td>
                </tr>
                <tr>
                    <td>Course ID</td>
                    <td><input type="text" name="courseId" value="${course.courseid}" /></td>
                </tr>
                                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Delete" />                         
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Course ID</th>
            <th>Student ID</th>          
                <c:forEach items="${allCourses}" var="cour">
                <tr>
                    <td>${cour.courseid}</td>                    
                    <td>${cour.name}</td>
                    <td>${cour.credits}</td>             
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
