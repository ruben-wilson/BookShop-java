package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.shop.dao.BookDAOImpl;
import com.shop.dao.DataAccessObject;
import com.shop.dao.UserDAOImpl;
import com.shop.models.Basket;
import com.shop.models.Book;
import com.shop.models.User;

@WebServlet(urlPatterns = "/Account")

public class AccountServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher view = req.getRequestDispatcher("./views/account.jsp");
    HttpSession session = req.getSession(false);

    UserDAOImpl userDAO = new UserDAOImpl();

    System.out.println(session.getAttribute("name") + " acount servelt :33");
    User user = userDAO.findByParam(((String) session.getAttribute("name"))).get(0);
    
    

    if (user != null) {
      session.setAttribute("userID", user.getUserID());
      session.setAttribute("name", user.getName());
      session.setAttribute("surname", user.getSurname());
      session.setAttribute("email", user.getEmail());
    }

    view.forward(req, resp);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DataAccessObject<User> userDAO = new UserDAOImpl();

    HttpSession session = req.getSession(false);

    if(req.getParameter("name") != null ){
      userDAO.updateParamById(((int) session.getAttribute("userID")), "Name", req.getParameter("name"));
    }
    if(req.getParameter("surname") != null) {
          userDAO.updateParamById(((int) session.getAttribute("userID")), "Username", req.getParameter("surname"));
    } 
    if (req.getParameter("email") != null) {
        userDAO.updateParamById(((int) session.getAttribute("userID")), "Email", req.getParameter("email"));
    }
 
    resp.sendRedirect("Account");
  }

}
