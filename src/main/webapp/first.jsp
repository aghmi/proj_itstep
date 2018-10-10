<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<!-- JSP EXPRESSION -->
	<% 
	List<String> listOfURLs = new ArrayList<>(); 
	listOfURLs.add("https://www.google.by");
	listOfURLs.add("https://www.sushi.by");
	listOfURLs.add("https://www.onliner.by");
	listOfURLs.add("https://www.tut.by");
	listOfURLs.add("https://www.google.by");
	listOfURLs.add("https://www.sushi.by");
	listOfURLs.add("https://www.onliner.by");
	listOfURLs.add("https://www.tut.by");	
	listOfURLs.add("https://www.google.by");
	listOfURLs.add("https://www.sushi.by");
	listOfURLs.add("https://www.onliner.by");
	listOfURLs.add("https://www.tut.by");

	double x = Math.random();
	if (x > 0.8) {
		%>
		 
		<h1>RRANDOM VAL > 0.8</h1>
	<% } else { 
	
	%>
	<h1>RRANDOM VAL less then 0.8</h1>
	
	<%
			int counter = 1;
			for (String url : listOfURLs) {
				String color = counter % 2 == 0 ? "lightblue" : "gray";
				%>
			<a href = "<%= url%>" style="background-color: <%=color%>">
			<%= url%></a><br>
			
		
			<%
				counter++;
		}
	}

	%>

	<h2>Server time: <%=new Date()  %></h2>
	<a href="<%=request.getRequestURI()%>"> TRY AGAIN</a>
</body>
</html>