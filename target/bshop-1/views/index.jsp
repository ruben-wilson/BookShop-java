<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
</head>
<body>
    <% 
      String form = "<form action="RegisterServlet" method="POST"> <label for="name">Name:</label> Employee FirstName = <input type="text" name="fname" /> <br> <input type="submit" value="REGISTER" />";

      if(session.getAttribute("name") != null){
        out.print("<p>Logged in</p>");
      }else{
        out.print(form);

      }

    %>
  <form action="RegisterServlet" method="POST">
      <label for="name">Name:</label>
      Employee FirstName = <input type="text" name="fname" /> <br>
      <input type="submit" value="REGISTER" />
   </form>

</body>
</html>