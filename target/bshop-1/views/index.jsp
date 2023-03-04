<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <li><a href=${sessionScope.href}>${sessionScope.isLogged}</a></li>
        <li><a href="Basket">view basket</a></li>
        <li><a href=${sessionScope.logOutHref}>${sessionScope.logOut}</a></li>
        <li>
          <form action="SearchBook" method="post">
            <input type="text" name="bookTitle" ></input>
            <input type="submit"></input>
          </form>
        </li>
      </ul>
    </nav>


      <ul>
           <%
              List<Book> allObjects = (List<Book>) request.getAttribute("allBooks");
                  for(Book b : allObjects){
            %>
            <li>
              <p>title: <%=b.getTitle()%></p>
            </li>
            <li>
              <p>Author: <%=b.getAuthor()%></p>
            </li>
            <li>
              <p>price:£<%=b.getPrice()%></p>
              <form method="post" action="Basket">
                <input type="hidden" name="bookTitle" value ="<%=b.getTitle()%>" >
                <button type="submit">Add to basket</button>
              </form>
            </li>
           
            <% } %>

      </ul>
      
      

  </body>
</html>