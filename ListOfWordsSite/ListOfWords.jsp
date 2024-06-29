<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Список слов</title>
</head>
<body>

    <h1>Список:</h1>
<%
    String URL = "jdbc:mysql://localhost/listofWords";
    String USER = "root";
    String PASSWORD = "root";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>

<%
    try{ 
    connection = DriverManager.getConnection(URL, USER, PASSWORD);

    statement=connection.createStatement();

    String select = "SELECT * FROM words";

    resultSet = statement.executeQuery(select);

    while(resultSet.next()){
	<p> <%=resultSet.getString("word") %> </p>
    }

    } catch (Exception e) {
	e.printStackTrace();
    }
%>

</body>
</html>