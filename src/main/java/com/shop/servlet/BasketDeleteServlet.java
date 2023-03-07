package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.models.Basket;

@WebServlet(urlPatterns = "/BasketDelete")

public class BasketDeleteServlet extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    Basket basket = (Basket) session.getAttribute("basket");
    basket.deleteBook(req.getParameter("bookTitle"));

    session.setAttribute("basket", basket);

    resp.sendRedirect("Basket");
  }

}
