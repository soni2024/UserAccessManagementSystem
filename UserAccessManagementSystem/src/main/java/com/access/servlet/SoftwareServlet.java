package com.access.servlet;

import com.access.model.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/createSoftware")
public class SoftwareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if ("Admin".equals(role)) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String accessLevels = request.getParameter("access_levels");

            try (Connection connection = DatabaseUtils.getConnection()) {
                String sql = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, description);
                statement.setString(3, accessLevels);
                statement.executeUpdate();
                response.sendRedirect("createSoftware.jsp?status=success");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
