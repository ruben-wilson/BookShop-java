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
      <title>Account</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    <body>
      <section class="h-100 gradient-custom-2">
        <!-- nav bar -->

        <nav class="navbar navbar-expand-lg bg-body-tertiary bg-primary" data-bs-theme="dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="Home">BookShop</a>
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
                  <a class="nav-link active" href=${sessionScope.href}>${sessionScope.isLogged}</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="Basket">view basket</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href=${sessionScope.logOutHref}>${sessionScope.logOut}</a>
                </li>
              </ul>
              <form class="d-flex" role="search" action="SearchBook" method="post">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="bookTitle">
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
            </div>
          </div>
        </nav>




        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
              <div class="card">
                <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">

                  
                  <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                   
                    <img src="https://img.freepik.com/premium-vector/avatar-profile-icon-vector-illustration_276184-165.jpg?w=2000"
                      alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                      style="width: 150px; z-index: 1">
                      <form action="Account" method="post">
                        <button type="submit" id="editProfileButton" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                          style="z-index: 1;">
                          Edit profile
                        </button>
                      </form>
                      
                     
                  </div>
                 
                  <div class="ms-3" style="margin-top: 130px;">
                    <h5>${sessionScope.name} ${sessionScope.surname}</h5>
                    <p>Email: ${sessionScope.email}</p>
                  </div>
                </div>
                <div class="p-4 text-black" style="background-color: #f8f9fa;">
                  <form action="Account" method="post">
                    <button type="submit" id="editProfileButton" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                      style="z-index: 1;">
                      Edit profile
                    </button>
                  </form>
                  <div class="d-flex justify-content-end text-center py-1">
                      <p class="mb-1 h5">${totalOrders} </p>
                      <p class="small text-muted mb-0">Total Purchases</p>
                    </div>
                  </div>
                </div>
                  <div class="d-flex mb-2 mt-2" style="justify-content: center; padding-left: 2rem; padding-right: 2rem;" >
                      <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">View Your Order History</button>
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

            <!-- Menu to update account details! -->
          <%if(session.getAttribute("edit") == "true"){%>
            <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Update Account details</h2>
            
              <form action="Account" method="post">
            
                <div class="form-outline mb-4">
                  <input name="name" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example1cg">First name</label>
                </div>
            
                <div class="form-outline mb-4">
                  <input name="surname" type="text" id="form3Example3cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example3cg">Surname</label>
                </div>
            
                <div class="form-outline mb-4">
                  <input name="email" type="email" id="form3Example4cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example4cg">Email</label>
                </div>
            
                <div class="form-outline mb-4">
                  <input name="password" type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example4cdg">Password</label>
                </div>
   
                <div class="d-flex justify-content-center">
                  <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Update Account</button>
                </div>
            
              </form>
            
            </div>
            </div>
          <%}%>

          </div>
        </div>
      </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
      integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    </body>
    <script>
    </script>
    </html>