package com.shop.models;

public class Employee {

  private int employeeId;

  private String employeeFirstName;

  private String employeeLastName;

  private String employeeEmail;

  private String employeePassword;

  public Employee(int employeeId, String employeeFirstName, String employeeLastName, String employeeEmail) {
    super();
    this.employeeId = employeeId;
    this.employeeFirstName = employeeFirstName;
    this.employeeLastName = employeeLastName;
    this.employeeEmail = employeeEmail;
  }

  public Employee(int employeeId, String employeeFirstName, String employeeLastName, String employeeEmail,
      String employeePassword) {
    super();
    this.employeeId = employeeId;
    this.employeeFirstName = employeeFirstName;
    this.employeeLastName = employeeLastName;
    this.employeePassword = employeePassword;
    this.employeeEmail = employeeEmail;

  }

  public String getEmployeeEmail() {
    return employeeEmail;
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeFirstName() {
    return employeeFirstName;
  }

  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }

  public String getEmployeeLastName() {
    return employeeLastName;
  }

  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }

  public String getEmployeePassword() {
    return employeePassword;
  }

  public void setEmployeePassword(String employeePassword) {
    this.employeePassword = employeePassword;
  }

  @Override
  public String toString() {
    return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
        + employeeLastName + ", employeeEmail=" + employeeEmail + "]";
  }

}