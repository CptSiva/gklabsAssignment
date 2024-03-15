package com.loginPageAssignment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/views")
public class RetrieveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<DetailsBean> al = new RetrieveDAO().retrieve();
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>User Details</title>");
        pw.println("</head>");
        pw.println("<body>");

        if (al.size() == 0) {
            pw.println("<p>Details not available...</p>");
        } else {
            pw.println("<table border='1'>");
            pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Date of Birth</th></tr>");
            for (DetailsBean pb : al) {
                pw.println("<tr>");
                pw.println("<td>" + pb.getId() + "</td>");
                pw.println("<td>" + pb.getName() + "</td>");
                pw.println("<td>" + pb.getEmail() + "</td>");
                pw.println("<td>" + pb.getAge() + "</td>");
                pw.println("<td>" + pb.getDate() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        }

        pw.println("<a href='Regestration.html'>Go Back</a>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
