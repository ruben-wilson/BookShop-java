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
    <style>
      nav {
        position: sticky;
        top: 0;
        background-color: white;
      }
    
      nav li {
        display: inline-block;
        margin-right: 5px;
      }
    </style>
</head>
  <body>
    <nav>
      <ul>
        <li><a href=${sessionScope.href}>${sessionScope.logged}</a></li>
        <li>
          <form action="SearchBook" method="post">
            <input type="text" name="bookTitle" ></input>
            <input type="submit" action="" value="Search"></input>
          </form>
        </li>
      </ul>
    </nav>

      <% 
      List<Book> allObjects = (List<Book>) request.getAttribute("allBooks");
      for(Book b : allObjects){
      %>
    
      <p>title: <%=b.getTitle()%> price:£<%=b.getPrice()%></p>
    
      <% } %>

  </body>
</html>