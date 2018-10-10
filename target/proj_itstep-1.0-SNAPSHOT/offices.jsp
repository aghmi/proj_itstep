<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "GET">
		<label>
			<input type = "text" name = "offices" placeholder="search...">
		</label>
		<input type="submit" value="CHOOSE">
	</form>
<%@page import="java.sql.*" %>
<%		
		String officeVal = request.getParameter("offices");

		if (officeVal != null) {
		String sql = "SELECT * FROM RETAILER.OFFICES " +
		"WHERE CITY LIKE '" + officeVal.trim() + "%';";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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