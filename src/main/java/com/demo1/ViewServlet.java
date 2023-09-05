package com.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("<a href='LogoutServlet' class='btn btn-outline-danger float-right mt-3 mr-3'>Logout</a>");
        out.println("<div class='container text-center'>");
        out.println("<h1>Students List</h1>");
        out.println("<a href='students.jsp' class='btn btn-outline-success'>Add New Student</a>");
        List<Student> list = StudentDao.getAllStudents();

        out.print("<table  class='mt-3 table mw-100'");
        out.print("<thead class='thead-dark'><tr><th>Id</th><th>Full Name</th><th>Course</th><th>Score</th><th>Edit</th><th>Delete</th></tr></thead>");
        for(Student s:list) {
            out.print("<tr><td>" + s.getId() + "</td><td>" + s.getFullName() + "</td><td>" + s.getCourse() + "</td> <td>" + s.getScore() + "</td><td><a class='btn btn-warning' href='EditServlet?id=" + s.getId() + "'>Edit</a></td> <td><a class='btn btn-danger' href='DeleteServlet?id=" + s.getId() + "'>Delete</a></td></tr>");
        }
        out.print("</table>");
        out.print("</div>");
        out.close();
    }
}
