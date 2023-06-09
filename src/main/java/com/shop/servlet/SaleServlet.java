package com.shop.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.DataAccessObject;
import com.shop.dao.SaleDAOImpI;
import com.shop.models.Basket;
import com.shop.models.Sale;
import com.shop.utils.BSSFactory;

@WebServlet(urlPatterns = "/Sale")

public class SaleServlet extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    Basket basket = (Basket) session.getAttribute("basket");
    if(basket != null){
      DataAccessObject<Sale> saleDAO = BSSFactory.getSaleDAO();

      LocalDate currentDate = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String dateString = currentDate.format(formatter);

      basket.getBooks()
            .stream()
            .forEach( b -> {
              saleDAO.addObject(new Sale( ((int) session.getAttribute("userID")), b.getBook_ID(), dateString, b.getPrice()));
            });
    }
    basket.resetBasket();
    session.setAttribute("basket", basket);

    resp.sendRedirect("Basket");
  }

}