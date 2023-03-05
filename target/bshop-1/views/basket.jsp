<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.shop.models.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.models.Basket" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Home</title>
    </head>

    <body>
      Basket

      <div style="justify-content: center;">
        <%if(session.getAttribute("basket") != null){%>
        <ul>
          <% 
              Basket basket = (Basket) session.getAttribute("basket");
              List<Book> allBooks = basket.getBooks();
              for(Book b : allBooks){
              %>
              <li>
                <p>title: <%=b.getTitle()%>
                </p>
              </li>
              <li>
                <p>Author: <%=b.getAuthor()%>
                </p>
              </li>
              <li>
                <p>price:£<%=b.getPrice()%>
                </p>
                <form method="post" action="BasketDelete">
                  <input type="hidden" name="bookTitle" value="<%=b.getTitle()%>">
                  <button type="submit">Delete from basket</button>
                </form>
              </li>

        
              <% } %>
        
        </ul>
        <%}%>
      </div>
    </body>

    </html>