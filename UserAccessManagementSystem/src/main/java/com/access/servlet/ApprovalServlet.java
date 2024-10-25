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

@WebServlet("/approveRequest")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if ("Manager".equals(role)) {
            int requestId = Integer.parseInt(request.getParameter("request_id"));
            String status = request.getParameter("status");

            try (Connection connection = DatabaseUtils.getConnection()) {
                String sql = "UPDATE requests SET status = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, status);
                statement.setInt(2, requestId);
                statement.executeUpdate();
                response.sendRedirect("pendingRequests.jsp?status=updated");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
