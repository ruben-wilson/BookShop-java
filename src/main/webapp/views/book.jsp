<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    BookPage

    <div style="justify-content: center;">
      <div class="card"
        style="width: 24.33%; margin-left: auto; margin-right: auto; margin-top: 0.5rem; margin-bottom: 0.5rem;max-height: 12rem; ">
        <div class="card-body" style="overflow: auto;">
          <h5 class="card-title text-center">
            ${book.getTitle()}
          </h5>
          <p class="card-text">Author: ${book.getAuthor()}
          </p>
          <h6 class="card-subtitle mb-2 text-muted">${book.getDescription()}
          </h6>
          <h6 class="card-subtitle mb-2 text-muted">£ <%=b.getPrice()%>
          </h6>
          <form method="post" action="Basket">
            <input type="hidden" name="bookTitle" value="<%=b.getTitle()%>">
            <button class="btn btn-primary" type="submit">Add to basket</button>
          </form>
        </div>
      </div>
    </div>
    
    


  </body>

  </html>