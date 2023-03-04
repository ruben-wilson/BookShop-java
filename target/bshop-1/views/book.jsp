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
      <div>
        <ul>
          <li>
            <p>book title: ${book.getTitle()}</p>
          </li>
          <li>
            <p>book author: ${book.getAuthor()}</p>
          </li>
          <li>
            <p>description: ${book.getDescription()}</p>
          </li>
          <li>
            <p>price: ${book.getPrice()}</p>
          </li>
          <li>
            <button type="submit" action="basket">Add to basket </button>
          </li>
        </ul>

      </div>
    </div>
    
    


  </body>

  </html>