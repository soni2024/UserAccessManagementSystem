<% 
    String role = (String) session.getAttribute("role");
    if (!"Manager".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Access Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <form action="approveRequest" method="post">
        <table>
            <thead>
                <tr>
                    <th>Employee Name</th>
                    <th>Software</th>
                    <th>Access Type</th>
                    <th>Reason</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Replace with actual database query logic
                    // ResultSet pendingRequests = ...;
                    // while (pendingRequests.next()) {
                    //     out.print("<tr>");
                    //     out.print("<td>" + pendingRequests.getString("employee_name") + "</td>");
                    //     out.print("<td>" + pendingRequests.getString("software_name") + "</td>");
                    //     out.print("<td>" + pendingRequests.getString("access_type") + "</td>");
                    //     out.print("<td>" + pendingRequests.getString("reason") + "</td>");
                    //     out.print("<td>");
                    //     out.print("<button name='status' value='Approved'>Approve</button>");
                    //     out.print("<button name='status' value='Rejected'>Reject</button>");
                    //     out.print("<input type='hidden' name='request_id' value='" + pendingRequests.getInt("id") + "'>");
                    //     out.print("</td>");
                    //     out.print("</tr>");
                    // }
                %>
            </tbody>
        </table>
    </form>
    <a href="logout">Logout</a>
</body>
</html>
