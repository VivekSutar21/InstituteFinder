package Com.InstituteHub.Servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/InstituteRegistrationServlet")
public class InstituteRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instituteName = request.getParameter("InstituteName");
        String ownerName = request.getParameter("OnerName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        // JDBC URL, username, and password of PostgreSQL server
        String url = "jdbc:postgresql://localhost:5432/InstituteHub";
        String dbUsername = "postgres";
        String dbPassword = "viveksutar21";

        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            // SQL query to insert data into the institutes table
            String sql = "INSERT INTO institute_details (institute_name, owner_name, institute_email, institute_number,institute_address, institute_password) VALUES (?, ?, ?, ?,?, ?)";

            // Create a PreparedStatement to execute the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, instituteName);
                preparedStatement.setString(2, ownerName);
                preparedStatement.setString(4, phoneNumber);
                preparedStatement.setString(3, email);
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, password);

                // Execute the query
                preparedStatement.executeUpdate();
            }
            System.out.println("Institute Registeration done");
            // Close the connection
            connection.close();

            // Redirect to a success page
            response.sendRedirect("InstituteHome.html");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions, redirect to an error page, or show an error message
            System.out.println("Institute Registration not working");
            response.sendRedirect("instituteregistration.jsp");
        }
    }
}