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
      <title>Basket</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    <body>
      <section class="vh-100" style="height: 100vh;">
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


        <div class="container h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col pb-2">
              <%if(session.getAttribute("basket") ==null){%>
                <p><span class="h2">Shopping Cart </span><span class="h4">(0 item in your cart)</span></p>
                <div style="justify-content: center;"></div>
              <%}%>

                <%if(session.getAttribute("basket") !=null){%>
                  <p><span class="h2">Shopping Cart </span><span class="h4">(${totalItems} item in your cart)</span></p>
                  <div style="justify-content: center;"></div>
                 
                    <% Basket basket=(Basket) session.getAttribute("basket"); List<Book> allBooks = basket.getBooks();
                      for(Book b : allBooks){
                      %>

                      <div class="card mb-4">
                        <div class="card-body p-4">
                      
                          <div class="row align-items-center">
                            <div class="col-md-2">
                              <img
                                src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Black_book_icon.svg/1200px-Black_book_icon.svg.png"
                                class="img-fluid" alt="Generic placeholder image">
                            </div>
                            <div class="col-md-2 d-flex justify-content-center">
                              <div>
                                <p class="small text-muted mb-4 pb-2">Name</p>
                                <p class="lead fw-normal mb-0"><%=b.getTitle()%></p>
                              </div>
                            </div>
                            <div class="col-md-2 d-flex justify-content-center">
                              <div>
                                <p class="small text-muted mb-4 pb-2">Quantity</p>
                                <p class="lead fw-normal mb-0">1</p>
                              </div>
                            </div>
                            <div class="col-md-2 d-flex justify-content-center">
                              <div>
                                <p class="small text-muted mb-4 pb-2">Author</p>
                                <p class="lead fw-normal mb-0"><%=b.getAuthor()%></p>
                              </div>
                            </div>
                            <div class="col-md-2 d-flex justify-content-center">
                              <div>
                                <p class="small text-muted mb-4 pb-2">Price</p>
                                <p class="lead fw-normal mb-0">£ <%=b.getPrice()%></p>
                              </div>
                            </div>
                            <div class="col-md-2 d-flex justify-content-center">
                              <div>
                              <form method="post" action="BasketDelete">
                                <button type="submit" class="btn btn-primary btn-lg">Delete Item</button>
                              </form>
                              </div>
                            </div>

                          </div>
                      
                        </div>
                      </div>
              
              
                      <% } %>
              
              
                  <%}%>
      
      
              <div class="card mb-5">
                <div class="card-body p-4">
      
                  <div class="float-end">
                    <p class="mb-0 me-5 d-flex align-items-center">
                      <span class="small text-muted me-2">Order total:</span> <span class="lead fw-normal">£ ${totalPrice}</span>
                    </p>
                  </div>
      
                </div>
              </div>
      
              <div class="d-flex justify-content-end">
                <form method="get" action="Home">
                  <button type="submit" class="btn btn-light btn-lg me-2">Continue shopping</button>
                </form>
                <form method="post" action="Sale">
                  <button type="submit" class="btn btn-primary btn-lg">Buy Now!</button>
                </form>
              </div>
      
            </div>
          </div>
        </div>
      </section>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    </body>

    </html>