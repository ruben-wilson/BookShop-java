package com.shop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.DataAccessObject;
import com.shop.dao.UserDAOImpl;
import com.shop.models.User;

@WebServlet(urlPatterns = "/Account")

public class AccountServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher view = req.getRequestDispatcher("./views/account.jsp");
    HttpSession session = req.getSession(false);
    
    if(session.getAttribute("allOrders") == null){
      System.out.println("32 AccountServlet fetching all OrderHistory" );
      resp.sendRedirect("OrderHistory");
    }else{
      view.forward(req, resp);
    }

  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    DataAccessObject<User> userDAO = new UserDAOImpl();

    HttpSession session = req.getSession(false);

    if(session.getAttribute("edit") == "false" || session.getAttribute("edit") == null ){

     session.setAttribute("edit", "true");
     resp.sendRedirect("Account");
    }else{

      session.setAttribute("edit", "false");

      if (req.getParameter("name") != "") {
        userDAO.updateParamById(((int) session.getAttribute("userID")), "Name", req.getParameter("name"));
        session.setAttribute("name", req.getParameter("name"));
      }
      if (req.getParameter("surname") != "") {
        userDAO.updateParamById(((int) session.getAttribute("userID")), "Username", req.getParameter("surname"));
        session.setAttribute("surname", req.getParameter("surname"));
      }
      if (req.getParameter("email") != "") {
        userDAO.updateParamById(((int) session.getAttribute("userID")), "Email", req.getParameter("email"));
        session.setAttribute("email", req.getParameter("email"));
      }

      resp.sendRedirect("Account");

    }

    
  }

}
