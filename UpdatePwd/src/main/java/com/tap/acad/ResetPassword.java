package com.tap.acad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ResetPassword extends HttpServlet {
    private String email, password, cpassword;
    private final String RESET = "update employee set password=? where email=?";
    private final String FETCH = "select * from employee where email=?";
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet result;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee", "root", "mohanraj@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            password = req.getParameter("password");
            cpassword = req.getParameter("cpassword");

            if (password.equals(cpassword)) {
                email = req.getParameter("email");

                // Update the password
                pstmt = con.prepareStatement(RESET);
                pstmt.setString(1, password);
                pstmt.setString(2, email);
                int x = pstmt.executeUpdate();

                if (x == 0) {
                    res.sendRedirect("failure.html");
                } else {
                    // Fetch employee details after password reset
                    pstmt = con.prepareStatement(FETCH);
                    pstmt.setString(1, email);
                    result = pstmt.executeQuery();

                    while (result.next()) {
                        String name = result.getString("empname");
                        String desig = result.getString("desig");
                        int salary = result.getInt("salary");

                        // Create cookies for employee details
                        Cookie c1 = new Cookie("name", name);
                        Cookie c2 = new Cookie("desig", desig);
                        Cookie c3 = new Cookie("salary", Integer.toString(salary)); // Convert salary to String

                        // Set Max-Age before adding cookies
                        c1.setMaxAge(60);
                        c2.setMaxAge(90);
                        c3.setMaxAge(120);

                        // Add cookies to response
                        res.addCookie(c1);
                        res.addCookie(c2);
                        res.addCookie(c3);
                    }
                    res.sendRedirect("success.html");
                }
            } else {
                res.sendRedirect("pwdMismatch.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
