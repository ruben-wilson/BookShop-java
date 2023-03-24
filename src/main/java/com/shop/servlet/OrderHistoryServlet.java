package com.shop.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.SaleDAOImpI;
import com.shop.models.Sale;

@WebServlet(urlPatterns = "/OrderHistory")

public class OrderHistoryServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(false);

    SaleDAOImpI saleDAO = new SaleDAOImpI();
    List<Sale> allOrders = saleDAO.findByUserID((int) session.getAttribute("userID"));

    session.setAttribute("allOrders", allOrders);
    session.setAttribute("totalOrders", allOrders.size());

    resp.sendRedirect("Account");
  }

}