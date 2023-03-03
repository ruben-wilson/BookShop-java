package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.EmployeeDAOImpl;
import com.shop.models.Employee;

@WebServlet(urlPatterns = "/mambo.do")
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();
    List<Employee> a = daoImpl.findAllEmployees();
    Employee e1 = new Employee(0, "fff", "fff", "fff");
    
    System.out.println("print form servlet");
    System.out.println(a);
    out.println("<html>");
    out.println("<head>");
    out.println("<title>");
    out.println("</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Hello ");
    out.println(e1);
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }
}
