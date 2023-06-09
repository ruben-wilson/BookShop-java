package com.shop.servlet;
import java.io.IOException;

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
import com.shop.models.Book;
import com.shop.utils.BSSFactory;

@WebServlet(urlPatterns = "/")
public class HomePageServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    RequestDispatcher view = req.getRequestDispatcher("./views/index.jsp");

    DataAccessObject<Book> bookDAO = BSSFactory.getBookDAO();
    List<Book> allBooks = bookDAO.returnAll();
    req.setAttribute("allBooks", allBooks);

    if (session.getAttribute("name") == null) {
      session.setAttribute("href", "Login");
      session.setAttribute("isLogged", "Login");
      session.setAttribute("logOutHref", null);
      session.setAttribute("logOut", null);

      view.forward(req, resp);
    }else{

      session.setAttribute("href", "Account");
      session.setAttribute("isLogged", "Account Details");
      session.setAttribute("logOutHref", "Logout");
      session.setAttribute("logOut", "Logout");

    
      view.forward(req, resp);
    }
  
  }

}
