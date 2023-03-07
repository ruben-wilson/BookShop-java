package com.shop.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.DataAccessObject;
import com.shop.dao.UserDAOImpl;
import com.shop.models.User;


@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
    RequestDispatcher view = req.getRequestDispatcher("./views/signup.jsp");
    view.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    
      String name = (String) req.getParameter("name");
      String surname = (String) req.getParameter("surname");
      String pword = (String) req.getParameter("password");
      String email = (String) req.getParameter("email");

      User user = new User(0, name, surname, pword, email);

      DataAccessObject<User> userDAO = new UserDAOImpl();
      int i = userDAO.addObject(user);

      if(i == 0){
        throw new Error("user not created");
      }else{
        HttpSession session = req.getSession(true);

        User registeredUser = userDAO.findByParam(name).get(0);

        session.setAttribute("userID", registeredUser.getUserID());
        session.setAttribute("name", registeredUser.getName());
        session.setAttribute("surname", registeredUser.getPassword());
        session.setAttribute("email", registeredUser.getEmail());

        resp.sendRedirect("HomePageServlet");
      }
  }
}
