package com.shop.dao;

import java.util.List;
import com.shop.models.Employee;

public interface EmployeeDAO {
  public int addEmployee(Employee employee);
  
  public Employee employeeLogin(String employeeEmail, String employeePassword);

  public List<Employee> findAllEmployees();

  public List<Employee> findAllEmployeesByFirstName(String firstName);

  public int updateEmployeeEmailById(int employeeId, String newEmail);

  public int deleteEmployeeById(int employeeId);
}