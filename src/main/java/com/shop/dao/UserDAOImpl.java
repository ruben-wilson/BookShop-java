package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.models.User;
import com.shop.utils.DatabaseConnection;

public class UserDAOImpl implements UserDAO {

  private List<User> userList = new ArrayList<>();

  private Connection con;

  private PreparedStatement pst;

  private ResultSet rs;

  public int addUser(User User) {

    int i = 0;

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("INSERT into User(User_id, User_first_name, "
          + "User_last_name,User_email, User_password) VALUES(?,?,?,?,?)");

      this.pst.setInt(1, User.getUserID());
      this.pst.setString(2, User.getName());
      this.pst.setString(3, User.getSurname());
      this.pst.setString(4, User.getPassword());
      this.pst.setString(5, User.getEmail());

      i = this.pst.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e);
    }

    return i;

  }

  public List<User> findAllUsers() {

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("SELECT * FROM user");

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        User e = new User(this.rs.getInt(1),
            this.rs.getString(2),
            this.rs.getString(3),
            this.rs.getString(4), this.rs.getString(5));

        userList.add(e);

      }

    } catch (SQLException e) {
      System.out.println(e);
    }

    return this.userList;
  }

  @Override
  public User userLogin(String userEmail, String userPassword) {

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
      System.out.println(ex);
    }

    return e;
  }

  @Override
  public int deleteUserById(int userId) {
    return 0;
  }

  @Override
  public List<User> findAllUsersByFirstName(String firstName) {

    return null;

  }

  @Override
  public int updateUserEmailById(int UserId, String newEmail) {

    return 0;

  }

}
