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
    view.forward(req, resp);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DataAccessObject<User> userDAO = new UserDAOImpl();

    userDAO.updateParamById(0, getServletName(), getServletInfo());
 
    resp.sendRedirect("Account");
  }

}
