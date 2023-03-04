package com.shop.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shop.dao.BookDAOImpl;
import com.shop.dao.DataAccessObject;
import com.shop.models.Book;

@WebServlet(urlPatterns = "/SearchBook")
public class SearchBooksServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String bookTitle = req.getParameter("bookTitle");
    RequestDispatcher view = req.getRequestDispatcher("./views/book.jsp");

    DataAccessObject<Book> bookDAO = new BookDAOImpl();
    List<Book> resultSet = bookDAO.findByParam(bookTitle);
    System.out.println(resultSet.get(0));

    req.setAttribute("book", resultSet.get(0));
    view.forward(req, resp);
  }
}