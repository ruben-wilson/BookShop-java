<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.shop.models.Book" %>
<%@ page import="com.shop.models.Sale" %>
<%@ page import="java.util.ArrayList" %>
 <%@ page import="java.util.List" %>
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

      <div id="main" style="justify-content: center;">
        <div>
          <ul>
            <li>
              <p>Name: ${sessionScope.name}</p>
            </li>
            <li>
              <p>Surname: ${sessionScope.surname}</p>
            </li>
            <li>
              <p>Email: ${sessionScope.email}</p>
            </li>
            <li>
              <form action="OrderHistory" method="get">
                <button type="submit">see Order History</button>
              </form>
            </li>
            <li>
              <button onclick="createForm()">Edit account details</button>
            </li>
          </ul>
        </div>
        <% if(session.getAttribute("allOrders") != null){%>
          <div>
            All Orders
            <ul>
              <% List<Sale> allOrders = (List<Sale>) session.getAttribute("allOrders");
                  for(Sale s : allOrders){
                  %>
                  <li>
                    <p>item: <%=s.getBookTitle()%> purchase date: <%=s.getDate()%>
                    </p>
                  </li>
                  <li>
                    <p>Author: <%=s.getAuthor()%>
                    </p>
                  </li>
                  <li>
                    <p>price:£<%=s.getPrice()%>
                    </p>
                  </li>
            
                  <% } %>
            </ul>
          </div>
        <% }%>
      </div>




    </body>
    <script>

       const createForm = () => {
          let form = document.createElement("form");
          form.setAttribute("method", "post");
          form.setAttribute("action", "Account");

          let input1 = document.createElement("input");
          input1.setAttribute("type", "text");
          input1.setAttribute("name", "name");
          input1.setAttribute("placeholder", "Enter your new name");

          let input2 = document.createElement("input");
          input2.setAttribute("type", "text");
          input2.setAttribute("name", "surname");
          input2.setAttribute("placeholder", "Enter your new username");

          let input3 = document.createElement("input");
          input3.setAttribute("type", "text");
          input3.setAttribute("name", "email");
          input3.setAttribute("placeholder", "Enter your new email");

          let button = document.createElement("button");
          button.setAttribute("type", "submit");
          button.innerHTML = "Submit";

          form.appendChild(input1);
          form.appendChild(input2);
          form.appendChild(input3);
          form.appendChild(button);

          document.body.appendChild(form);
        }


    </script>

    </html>