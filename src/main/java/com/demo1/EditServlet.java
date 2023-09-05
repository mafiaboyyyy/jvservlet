package com.demo1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        int id = Integer.parseInt(req.getParameter("id"));
        Student s = StudentDao.getStudentById(id);
        out.print("<form action='EditServlet2' method='post' style='width:40%' class='p-2'");
        out.println("<h1 class='mb-2'>Update Student</h1>");
        out.print("<input type='hidden' name='id' value='"+s.getId()+"'/></td></tr>");
        out.print("<input class='form-control mb-2' type='text' name='full_name' value='"+s.getFullName()+"'/>");
        out.print("<input class='form-control mb-2' type='text' name='course' value='"+s.getCourse()+"'/>");
        out.print("<input class='form-control mb-2' type='number' name='score' value='"+s.getScore()+"'/>");
        out.print("<input class='btn btn-success' type='submit' value='Edit & Save'/>");
        out.print("</form>");
        out.close();
    }
}
