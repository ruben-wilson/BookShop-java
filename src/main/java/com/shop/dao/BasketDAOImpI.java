package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.models.Book;
import com.shop.utils.DatabaseConnection;

public class BasketDAOImpI implements DataAccessObject<Book> {

  private List<Book> bookList = new ArrayList<>();

  private Connection con;

  private PreparedStatement pst;

  private ResultSet rs;

  @Override
  public int addObject(Book book) {

    int i = 0;

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con
          .prepareStatement("INSERT into Book(Title, Description, Genre, Author, Price) VALUES(?,?,?,?,?)");

      this.pst.setString(1, book.getTitle());
      this.pst.setString(2, book.getDescription());
      this.pst.setString(3, book.getGenre());
      this.pst.setString(4, book.getAuthor());
      this.pst.setDouble(5, book.getPrice());

      i = this.pst.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e);
    }

    return i;
  }

  @Override
  public List<Book> returnAll() {

    this.con = DatabaseConnection.getMyDBConnection();

    try {

      this.pst = this.con.prepareStatement("SELECT * FROM Book");

      this.rs = this.pst.executeQuery();

      while (this.rs.next()) {

        Book b = new Book(this.rs.getInt(1),
            this.rs.getString(2),
            this.rs.getString(3),
            this.rs.getString(4), this.rs.getString(5), this.rs.getDouble(6));

        this.bookList.add(b);
      }

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e);
    }

    return this.bookList;
  }

  @Override
  public int deleteById(int BookId) {
    return 0;
  }

  @Override
  public List<Book> findByParam(String bookTitle) {
    
    return this.bookList;
  }

  @Override
  public int updateParamById(int BookId, String paramToUpdate, String newValue) {

    return 0;

  }

}
