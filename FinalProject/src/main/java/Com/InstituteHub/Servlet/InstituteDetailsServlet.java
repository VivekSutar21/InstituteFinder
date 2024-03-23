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

//@WebServlet("/InstituteDetailsServlet")
public class InstituteDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String instituteName = request.getParameter("InstituteName");
        String ownerName = request.getParameter("InstituteOwnerName");
        String email = request.getParameter("EmailAddress");
        String phoneNumber = request.getParameter("PhoneNumber");
        String establishedDate = request.getParameter("EstablishedDate");
        String address = request.getParameter("Address");
        int numberOfSeats = Integer.parseInt(request.getParameter("numberofSeats"));

        String course1Name = request.getParameter("1courseName");
        double course1Price = Double.parseDouble(request.getParameter("1coursePrice"));
        String course2Name = request.getParameter("2courseName");
        double course2Price = Double.parseDouble(request.getParameter("2coursePrice"));
        String course3Name = request.getParameter("3courseName");
        double course3Price = Double.parseDouble(request.getParameter("3coursePrice"));
        String course4Name = request.getParameter("4courseName");
        double course4Price = Double.parseDouble(request.getParameter("4coursePrice"));
        String course5Name = request.getParameter("5courseName");
        double course5Price = Double.parseDouble(request.getParameter("5coursePrice"));
        String course6Name = request.getParameter("6courseName");
        double course6Price = Double.parseDouble(request.getParameter("6coursePrice"));

    	
        String url = "jdbc:postgresql://localhost:5432/InstituteHub";
        String user = "postgres";
        String password = "viveksutar21";

        try {
            
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

           
 String sql = "INSERT INTO institute_information (institutename, instituteownername, emailaddress, phonenumber, establisheddate, address, numberofseats, course1name, course1price, course2name, course2price, course3name, course3price, " +
                    "course4name, course4price, course5name, course5price, course6name, course6price) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

          
            
            statement.setString(1, instituteName);
            statement.setString(2, ownerName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setString(5, establishedDate);
            statement.setString(6, address);
            statement.setInt(7, numberOfSeats);
            statement.setString(8, course1Name);
            statement.setDouble(9, course1Price);
            statement.setString(10, course2Name);
            statement.setDouble(11, course2Price);
            statement.setString(12, course3Name);
            statement.setDouble(13, course3Price);
            statement.setString(14, course4Name);
            statement.setDouble(15, course4Price);
            statement.setString(16, course5Name);
            statement.setDouble(17, course5Price);
            statement.setString(18, course6Name);
            statement.setDouble(19, course6Price);


          
            statement.executeUpdate();

            statement.close();
            conn.close();
            System.out.print("Details of Institute got successfully Added....");
          
            response.sendRedirect("InstituteInterface.html");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
           System.out.println("ERROR : Details doesn't got added...");
            response.sendRedirect("InstituteDetailForm.html");
        }
    }
}
