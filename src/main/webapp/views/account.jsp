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
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    <body>
      <section class="h-100 gradient-custom-2">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
              <div class="card">
                <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                  <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp"
                      alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                      style="width: 150px; z-index: 1">
                    <button type="button" onclick="createForm()" class="btn btn-outline-dark" data-mdb-ripple-color="dark" style="z-index: 1;">
                      Edit profile
                    </button>
                  </div>
                  <div class="ms-3" style="margin-top: 130px;">
                    <h5>${sessionScope.name} ${sessionScope.surname}</h5>
                    <p>Email: ${sessionScope.email}</p>
                  </div>
                </div>
                <div class="p-4 text-black" style="background-color: #f8f9fa;">
                  <div class="d-flex justify-content-end text-center py-1">
                    <div>
                      <p class="mb-1 h5">253</p>
                      <p class="small text-muted mb-0">Photos</p>
                    </div>
                    <div class="px-3">
                      <p class="mb-1 h5">1026</p>
                      <p class="small text-muted mb-0">Followers</p>
                    </div>
                    <div>
                      <p class="mb-1 h5">478</p>
                      <p class="small text-muted mb-0">Following</p>
                    </div>
                  </div>
                </div>
                  <div class="d-flex justify-content-between align-items-center mb-4" style="padding-left: 2rem; padding-right: 2rem;">
                    <p class="lead fw-normal mb-0">Recent Orders</p>
                      <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">Toggle bottom offcanvas</button>
                  </div>

                  <!-- pop up order History menu -->
                  <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
                    <div class="offcanvas-header">
                      <h5 class="offcanvas-title" id="offcanvasBottomLabel">Offcanvas bottom</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body small" style="overflow-x: scroll; display: flex;">
                      <% if(session.getAttribute("allOrders") !=null){%>
                        <% List<Sale> allOrders = (List<Sale>) session.getAttribute("allOrders");
                            for(Sale s : allOrders){
                            %>
                            <!-- create card for sale item -->
                            <div class="card"
                              style="min-width: 24.33%; margin-left: auto; margin-right: auto; margin-bottom: 1.5rem;max-height: 12rem; ">
                              <div class="card-body" style="overflow: auto;">
                                <h5 class="card-title text-center">
                                  Item: <%=s.getBookTitle()%> 
                                </h5>
                                <h6 class="card-subtitle mb-2 text-muted">
                                  Purchase Date:<%=s.getDate()%>
                                </h6>
                                <h6 class="card-subtitle mb-2 text-muted">£ <%=s.getPrice()%>
                                </h6>
                              </div>
                            </div>
                            <% } %>
                        <% } %>
                    </div>
                  </div>



              </div>
            </div>
          </div>
        </div>
      </section>

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



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
      integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
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