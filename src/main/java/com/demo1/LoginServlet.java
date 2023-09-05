package com.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("link.jsp").include(req, res);

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(password.equals("admin123")) {
            out.print("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\\\" integrity=\\\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
            out.print("<div class='alert alert-success' role='alert'>");
            out.print("<p>Welcome, " + name + "</p>");
            out.print("</div>");
            req.getRequestDispatcher("students.jsp").include(req, res);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
        } else {
            out.print("Sorry, username or password error!");
            req.getRequestDispatcher("login.jsp").include(req, res);
        }
        out.close();
    }
}
