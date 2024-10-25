<% 
    String role = (String) session.getAttribute("role");
    if (!"Admin".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<a href="logout">Logout</a>

<form action="createSoftware" method="post">
    <label for="name">Software Name:</label>
    <input type="text" id="name" name="name" required>
    <label for="description">Description:</label>
    <textarea id="description" name="description"></textarea>
    <label>Access Levels:</label>
    <input type="checkbox" name="access_levels" value="Read">Read
    <input type="checkbox" name="access_levels" value="Write">Write
    <input type="checkbox" name="access_levels" value="Admin">Admin
    <button type="submit">Create Software</button>
</form>
