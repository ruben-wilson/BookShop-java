package com.shop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.UserDAOImpl;
import com.shop.models.User;
import com.shop.utils.BSSFactory;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher view = req.getRequestDispatcher("./views/login.jsp");
    view.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String pword = (String) req.getParameter("password");
    String email = (String) req.getParameter("email");

    UserDAOImpl userDAO = (UserDAOImpl) BSSFactory.getUserDAO();
    User user = userDAO.userLogin(email, pword);
    
    if(user != null){
      HttpSession session = req.getSession(true);
      session.setAttribute("userID", user.getUserID());
      session.setAttribute("name", user.getName());
      session.setAttribute("surname", user.getSurname());
      session.setAttribute("email", user.getEmail());
      resp.sendRedirect("HomePageServlet");
    }else{
      resp.sendRedirect("Login");
    }

  }
}
