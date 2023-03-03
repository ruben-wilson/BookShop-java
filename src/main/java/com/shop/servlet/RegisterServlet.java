package com.shop.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    HttpSession session = req.getSession(false);
    System.out.println(req.getAttribute("fname"));
    session.setAttribute("name", req.getAttribute("fname"));




    RequestDispatcher view = req.getRequestDispatcher("./views/success.jsp");
    view.forward(req, resp);
  }
}
