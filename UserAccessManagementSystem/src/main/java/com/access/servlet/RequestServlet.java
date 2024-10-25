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

@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if ("Employee".equals(role)) {
            int userId = (Integer) session.getAttribute("user_id"); // Ensure user_id is set in session during login
            int softwareId = Integer.parseInt(request.getParameter("software_id"));
            String accessType = request.getParameter("access_type");
            String reason = request.getParameter("reason");

            try (Connection connection = DatabaseUtils.getConnection()) {
                String sql = "INSERT INTO requests (user_id, software_id, access_type, reason) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, userId);
                statement.setInt(2, softwareId);
                statement.setString(3, accessType);
                statement.setString(4, reason);
                statement.executeUpdate();
                response.sendRedirect("requestAccess.jsp?status=success");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
