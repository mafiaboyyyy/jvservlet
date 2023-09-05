package com.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String fullName = req.getParameter("full_name");
        String course = req.getParameter("course");
        double score = Double.parseDouble(req.getParameter("score"));
        Student s = new Student();
        s.setId(id);
        s.setFullName(fullName);
        s.setCourse(course);
        s.setScore(score);
        int status = StudentDao.save(s);
        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            req.getRequestDispatcher("students.jsp").include(req, res);
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}
