package com.shop.models;

public class Sale {
  private int user_ID;
  private int book_ID;
  private String date;
  private double amount;

  private String userName;
  private String bookTitle;
  private double price;
  private String genre;
  private String author;

  public Sale(){
  }

  public Sale(String userName, String bookTitle, String genre, String author, String date, double price) {
    this.userName = userName;
    this.bookTitle = bookTitle;
    this.price = price;
    this.genre = genre;
    this.author = author;
    this.date = date;
  }

  public Sale(int user_ID, int book_ID, String date, double amount) {
    this.user_ID = user_ID;
    this.book_ID = book_ID;
    this.date = date;
    this.amount = amount;
  }

  public int getUser_ID() {
    return user_ID;
  }

  public void setUser_ID(int user_ID) {
    this.user_ID = user_ID;
  }

  public int getBook_ID() {
    return book_ID;
  }
  
  public void setBook_ID(int book_ID) {
    this.book_ID = book_ID;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
  
}
