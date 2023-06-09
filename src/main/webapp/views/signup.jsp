<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

  </head>

  <body>
    <section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
              <div class="card-body p-5 text-center">
                <form action="Register" method="POST">
                  <div class="mb-md-5 mt-md-4 pb-5">
    
                    <h2 class="fw-bold mb-2 text-uppercase">Sign Up!</h2>
                    <p class="text-white-50 mb-5">Please enter your details!</p>
    
                    <div class="form-outline form-white mb-4">
                      <input type="text" name="name" id="typeEmailX" class="form-control form-control-lg" />
                      <label class="form-label" for="typeEmailX">Name</label>
                    </div>

                    <div class="form-outline form-white mb-4">
                      <input type="surname" name="surname" id="typeEmailX" class="form-control form-control-lg" />
                      <label class="form-label" for="typeEmailX">Surname</label>
                    </div>

                    <div class="form-outline form-white mb-4">
                      <input type="email" name="email" id="typeEmailX" class="form-control form-control-lg" />
                      <label class="form-label" for="typeEmailX">Email</label>
                    </div>
                    
    
                    <div class="form-outline form-white mb-4">
                      <input type="password" name="password" id="typePasswordX" class="form-control form-control-lg" />
                      <label class="form-label" for="typePasswordX">Password</label>
                    </div>
    
    
                    <button class="btn btn-outline-light btn-lg px-5" type="submit">SignUp</button>
    
                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
                      <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                      <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                      <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                    </div>
    
                  </div>
    
                  <div>
                    <p class="mb-0">Already have an Account? <a href="Login" class="text-white-50 fw-bold">login</a>
                    </p>
                  </div>
    
              </div>
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