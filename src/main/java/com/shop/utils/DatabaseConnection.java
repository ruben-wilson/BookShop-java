package com.shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static Connection con;


  private DatabaseConnection() {

  }

  public static Connection getMyDBConnection() {


    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      if (con == null)
        con = DriverManager.getConnection("jdbc:mysql://localhost/shopping_db", "root", "");

    }
    catch (ClassNotFoundException e) {
      System.out.println(e);
    }
		catch (SQLException e) {
      System.out.println(e);
    }

    return con;

  }
}
