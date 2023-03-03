<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.models.Book" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
</head>
<body>

  <% 
    List<Book> allObjects = (List<Book>) request.getAttribute("allBooks");



    for(Book b : allObjects){
    %>
  
    <p>title: <%=b.getTitle()%>price:£<%=b.getPrice()%></p>
  
    <% } %>


  <form action="RegisterServlet" method="POST">
      <label for="name">Name:</label>
      Employee FirstName = <input type="text" name="fname" /> <br>
      <input type="submit" value="REGISTER" />
   </form>
  <p>title: </p>
  </p>
</body>
</html>