package com.shop.utils;

import com.shop.dao.BookDAOImpl;
import com.shop.dao.DataAccessObject;
import com.shop.dao.SaleDAOImpI;
import com.shop.dao.UserDAOImpl;
import com.shop.models.Basket;
import com.shop.models.Book;
import com.shop.models.Sale;
import com.shop.models.User;

public class EISFactory {

  public static DataAccessObject<User> getUserDAO(){
    return new UserDAOImpl();
  }

  public static DataAccessObject<Book> getBookDAO(){
    return new BookDAOImpl();
  }

  public static DataAccessObject<Sale> getSaleDAO(){
    return new SaleDAOImpI();
  }

  public static User getUserObj(int userID, String name, String surname, String password, String email){
    return new User(userID, name, surname, password, email);
  }

  public static Book getBookObj(int book_ID, String title, String description, String genre, String author, Double price){
    return new Book(book_ID, title, description,genre, author, price);
  }

  public static Basket getBasketObj(){
    return new Basket();
  }

  public static Sale getSaleObj(String userName, String bookTitle, String genre, String author, String date, double price) {
    return new Sale();
  }
  
  public static Sale getSaleObj(int user_ID, int book_ID, String date, double amount) {
    return new Sale();
  }

  
  

 
}
