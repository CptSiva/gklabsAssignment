package com.loginPageAssignment;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
@WebServlet("/rege")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receive parameters from the web page
    	 //int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email=request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String dateOfBirthString = request.getParameter("dob");

        // Parse the date string from the request
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateOfBirth = null; // Corrected type
        try {
            dateOfBirth = dateFormat.parse(dateOfBirthString);
        } catch (java.text.ParseException e) {
            e.printStackTrace(); // Handle parsing exception appropriately
        }

        // Create a DetailsBean object and set its attributes
        DetailsBean detailsBean = new DetailsBean();
      //sdetailsBean.setId(id);
        detailsBean.setName(name);
        detailsBean.setEmail(email);
        detailsBean.setAge(age);
        detailsBean.setDate(dateOfBirth); // Pass the parsed java.util.Date

        // Insert into database using RegistrationDAO
        RegistrationDAO registrationDAO = new RegistrationDAO();
        int rowsAffected = registrationDAO.insert(detailsBean);

        // Handle response accordingly
        if (rowsAffected > 0) {
            // Insertion successful
            response.getWriter().println("Insertion successful");
        } else {
            // Insertion failed
            response.getWriter().println("Insertion failed");
        }
    }
}
