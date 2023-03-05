package com.shop.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.BookDAOImpl;
import com.shop.dao.DataAccessObject;
import com.shop.dao.SaleDAOImpI;
import com.shop.models.Basket;
import com.shop.models.Book;
import com.shop.models.Sale;

@WebServlet(urlPatterns = "/OrderHistory")

public class OrderHistoryServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);

    SaleDAOImpI saleDAO = new SaleDAOImpI();
    List<Sale> allOrders = saleDAO.findByUserID((int) session.getAttribute("userID"));

    System.out.println(allOrders + " OrderHistory :35");
    session.setAttribute("allOrders", allOrders);

    
    resp.sendRedirect("Account");
  }

}