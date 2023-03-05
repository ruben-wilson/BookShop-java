<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.models.Book" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="Home">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href=${sessionScope.href}>${sessionScope.isLogged}</a>
            </li>
            <li class="nav-item">
              <a href="Basket">view basket</a>
            </li>
            <li class="nav-item">
              <a href=${sessionScope.logOutHref}>${sessionScope.logOut}</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>

    <div>
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
    </div>


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
      
      

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
  </body>
</html>