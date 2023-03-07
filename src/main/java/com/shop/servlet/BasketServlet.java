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
import com.shop.models.Basket;
import com.shop.models.Book;


@WebServlet(urlPatterns = "/Basket")
public class BasketServlet extends HttpServlet{
  
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher view = req.getRequestDispatcher("./views/basket.jsp");
    HttpSession session = req.getSession();

    if(session.getAttribute("name") == null){
      
      resp.sendRedirect("Login");
    }else{

      if(session.getAttribute("basket") != null){
        Basket basket = (Basket) session.getAttribute("basket");
        req.setAttribute("totalItems", basket.howManyItems());
        req.setAttribute("totalPrice", basket.totalPrice());
      }
      
      view.forward(req, resp);
    }
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    if(session.getAttribute("name") == null){
      resp.sendRedirect("Basket");
    }else{

      String bookTitle = req.getParameter("bookTitle");

      DataAccessObject<Book> bookDAO = new BookDAOImpl();
      List<Book> allBooks = bookDAO.findByParam(bookTitle);
      Book addedBook = allBooks.get(0);

      if (session.getAttribute("basket") == null) {

        Basket basket = new Basket();
        basket.addBook(addedBook);
        session.setAttribute("basket", basket);
      } else {
        Basket basket = (Basket) session.getAttribute("basket");
        basket.addBook(addedBook);
        session.setAttribute("basket", basket);
      }

      resp.sendRedirect("Home");
    }
  }

  public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    Basket basket = (Basket) session.getAttribute("basket");
    basket.deleteBook(req.getParameter("bookTitle"));

    System.out.println("her at deleteBook");
    session.setAttribute("basket", basket);

    resp.sendRedirect("Basket");
  }
  
}
