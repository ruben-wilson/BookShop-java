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

@WebServlet(urlPatterns = "/Sale")

public class SaleServlet extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    Basket basket = (Basket) session.getAttribute("basket");
    if(basket != null){
      DataAccessObject<Sale> saleDAO = new SaleDAOImpI();
      
      System.out.println("here in sale ");
      
      LocalDate currentDate = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String dateString = currentDate.format(formatter);

      basket.getBooks()
            .stream()
            .forEach( b -> {
              saleDAO.addObject(new Sale( ((int) session.getAttribute("userID")), b.getBook_ID(), dateString, b.getPrice()));
            });

    }

    resp.sendRedirect("Basket");
  }

}