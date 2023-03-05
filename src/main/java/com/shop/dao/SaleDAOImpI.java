package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.models.Sale;
import com.shop.utils.DatabaseConnection;

public class SaleDAOImpI implements DataAccessObject<Sale> {

  private List<Sale> saleList = new ArrayList<>();

  private Connection con;

  private PreparedStatement pst;

  private ResultSet rs;

  @Override
  public int addObject(Sale s) {

    int i = 0;

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con
          .prepareStatement("INSERT INTO sale(User_ID, Book_ID, Date, Amount)VALUES(?,?,?,?)");

      // convert java double to fit in mysql float(10,2)
      String mySqlFloat = String.format("%.2f", s.getAmount());

      System.out.println(Float.parseFloat(mySqlFloat));

      this.pst.setInt(1, s.getUser_ID());
      this.pst.setInt(2, s.getBook_ID());
      this.pst.setString(3, s.getDate());
      this.pst.setFloat(4, Float.parseFloat(mySqlFloat));
      


      i = this.pst.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return i;
  }

  public List<Sale> findByUserID(int userID) {
    this.con = DatabaseConnection.getMyDBConnection();
    this.saleList.clear();

    try {

      this.pst = this.con.prepareStatement("SELECT u.Name, b.Title, b.genre, b.Author, s.Date, s.Amount FROM "
          + "sale s "
          + "INNER JOIN book b ON s.Book_ID = b.Book_ID "
          + "INNER JOIN user u ON s.User_ID = u.User_ID "
          + "WHERE u.User_ID = ?");
      this.pst.setInt(1, userID);

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        Sale sale = new Sale(
            this.rs.getString(1),
            this.rs.getString(2),
            this.rs.getString(3), 
            this.rs.getString(4),
            this.rs.getString(5),
            this.rs.getDouble(6)
            );

        this.saleList.add(sale);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return this.saleList;
  }

  @Override
  public List<Sale> returnAll() {
    return this.saleList;
  }

  @Override
  public int deleteById(int SaleId) {
    return 0;
  }

  @Override
  public List<Sale> findByParam(String userID) {
    return null;
  }

  @Override
  public int updateParamById(int SaleId, String paramToUpdate, String newValue) {
    return 0;

  }

}