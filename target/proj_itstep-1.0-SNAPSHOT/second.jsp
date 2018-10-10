<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "GET">
	<input type="checkbox" name="lang" value="JAVA">
	<input type="checkbox" name="lang" value="C++">
	<input type="checkbox" name="lang" value="RUBY">
	<input type="checkbox" name="lang" value="BASIC">
	<input type="submit" value="CHOOSE">
	
	<%
	String [] langs = request.getParameterValues("lang");
	if (langs != null) {
	%>
	
	 <h2>you have to learn: </h2>
	<% 
		for (int i = 0; i < langs.length; i++) {
			
	%>
		<li><%=langs[i]%></li>
	
	<% }
	}
	%>
	
	
	
	<a href ="<%=request.getRequestURI()%>">back</a>
</form>
</body>
</html>