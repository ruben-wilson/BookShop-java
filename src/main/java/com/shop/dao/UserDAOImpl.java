package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.models.User;
import com.shop.utils.DatabaseConnection;

public class UserDAOImpl implements DataAccessObject<User> {

  private List<User> userList = new ArrayList<>();

  private Connection con;

  private PreparedStatement pst;

  private ResultSet rs;


  public User userLogin(String userEmail, String userPassword){
    this.userList.clear();
    this.con = DatabaseConnection.getMyDBConnection();

    User e = null;

    try {

      this.pst = this.con.prepareStatement("SELECT * from user WHERE Email = ? AND Password = ?");

      this.pst.setString(1, userEmail);
      this.pst.setString(2, userPassword);

      this.rs = this.pst.executeQuery();

      if (this.rs.next()) { // Login Success
        e = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println(ex);
    }

    return e;
  }

  @Override
  public int addObject(User user) {

    int i = 0;

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("INSERT into User(Name,"
      + "Username, Email, Password) VALUES(?,?,?,?)");

      this.pst.setString(1, user.getName());
      this.pst.setString(2, user.getSurname());
      this.pst.setString(3, user.getEmail());
      this.pst.setString(4, user.getPassword());

      i = this.pst.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return i;

  }

  @Override
  public List<User> returnAll() {
    this.userList.clear();

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("SELECT * FROM user");

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        User e = new User(this.rs.getInt(1),
            this.rs.getString(2),
            this.rs.getString(3),
            this.rs.getString(4), this.rs.getString(5));

        this.userList.add(e);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return this.userList;
  }

  @Override
  public int deleteById(int userId) {
    return 0;
  }

  @Override
  public List<User> findByParam(String userName) {
    this.con = DatabaseConnection.getMyDBConnection();
    this.userList.clear(); 

    try {

      this.pst = this.con.prepareStatement("SELECT * FROM user WHERE Name = ?");
      this.pst.setString(1, userName);

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        User user = new User(this.rs.getInt(1),
            this.rs.getString(2),
            this.rs.getString(3),
            this.rs.getString(4), this.rs.getString(5));

        this.userList.add(user);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return this.userList;
  }

  @Override
  public int updateParamById(int userId, String paramToUpdate, String newValue) {
    this.con = DatabaseConnection.getMyDBConnection();
    this.userList.clear();

    int i = 0;
    try {

      
      this.pst = this.con.prepareStatement("UPDATE user SET " + paramToUpdate  + " = " + "'" + newValue + "'" + "WHERE User_ID = ?");
      this.pst.setInt(1, userId);

      i = this.pst.executeUpdate();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }




    return i;

  }

}
