package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.models.Employee;
import com.shop.utils.DatabaseConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

  private List<Employee> employeeList = new ArrayList<>();

  private Connection con;

  private PreparedStatement pst;

  private ResultSet rs;

  public int addEmployee(Employee employee) {

    int i = 0;

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("INSERT into employee(employee_id, employee_first_name, "
          + "employee_last_name,employee_email, employee_password) VALUES(?,?,?,?,?)");

      this.pst.setInt(1, employee.getEmployeeId());
      this.pst.setString(2, employee.getEmployeeFirstName());
      this.pst.setString(3, employee.getEmployeeLastName());
      this.pst.setString(4, employee.getEmployeeEmail());
      this.pst.setString(5, employee.getEmployeePassword());

      i = this.pst.executeUpdate();// This is used to RUN INSERT, UPDATE and DELETE

    } catch (SQLException e) {
      System.out.println(e);
    }

    return i;

  }

  public List<Employee> findAllEmployees() {

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("SELECT * FROM PRODUCT");

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        Employee e = new Employee(this.rs.getInt(1),
            this.rs.getString(2),
            this.rs.getString(3),
            "email");

        employeeList.add(e);

      }

    } catch (SQLException e) {
      System.out.println(e);
    }

    return this.employeeList;
  }

  public List<Employee> findAllEmployeesByFirstName(String firstName) {

    return null;

  }

  public int updateEmployeeEmailById(int employeeId, String newEmail) {

    Employee employeeFound = null;

    int index = 0;

    for (Employee e : employeeList) {

      if (e.getEmployeeId() == employeeId) {
        employeeFound = e;
        break;
      }

      index++;
    }

    employeeFound.setEmployeeEmail(newEmail);

    employeeList.set(index, employeeFound);

    return 1;

  }

  public int deleteEmployeeById(int employeeId) {

    return 0;

  }

  @Override
  public Employee employeeLogin(String employeeEmail, String employeePassword) {

    this.con = DatabaseConnection.getMyDBConnection();

    Employee e = null;

    try {

      this.pst = this.con.prepareStatement("SELECT * from employee WHERE employee_email = ? AND employee_password = ?");

      this.pst.setString(1, employeeEmail);
      this.pst.setString(2, employeePassword);

      this.rs = this.pst.executeQuery();

      if (this.rs.next()) { // Login Success
        e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
      }

    } catch (SQLException ex) {
      System.out.println(ex);
    }

    return e;
  }

}
