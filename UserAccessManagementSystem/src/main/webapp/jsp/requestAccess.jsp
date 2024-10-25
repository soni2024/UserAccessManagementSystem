<% 
    String role = (String) session.getAttribute("role");
    if (!"Employee".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access to Software</h2>
    <form action="requestAccess" method="post">
        <label for="software_id">Select Software:</label>
        <select id="software_id" name="software_id">
            <% 
                // Example code for populating software options from a database
                // Replace with actual JDBC code if needed
                // ResultSet softwareList = ...;
                // while (softwareList.next()) {
                //     out.print("<option value='" + softwareList.getInt("id") + "'>" + softwareList.getString("name") + "</option>");
                // }
            %>
        </select>

        <label for="access_type">Access Type:</label>
        <select id="access_type" name="access_type">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select>

        <label for="reason">Reason for Request:</label>
        <textarea id="reason" name="reason" required></textarea>

        <button type="submit">Submit Request</button>
    </form>
    <a href="logout">Logout</a>
</body>
</html>
