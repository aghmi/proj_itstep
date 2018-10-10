<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
	<input type = "text" name = "offices" value = "search...">
	</form>
<%@page import="java.sql.*" %>
<%		
		String officeVal = request.getParameter("offices");
		if (officeVal != null) {
		String sql = "SELECT * FROM retailer.offices" +
		"WHERE city LIKE '%" + officeVal.trim() + "%'";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer", "root", "");
		Statement stmt = conn.createStatement();
			
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			%> <h2>OFFICE ID: <%=rs.getString("officeCode") %> </h2>
			
	<% 
		}
	}
		
	%>
		
</body>
</html>