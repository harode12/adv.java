<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
        // Declare and initialize the variable 'message' here
        String message = "Calculation will be done on the next page!";
    %>
 <jsp:forward page="displaydata.jsp">
      <jsp:param value="<%=message%>" name="msg"/>
   </jsp:forward>
   
</body>
</html>