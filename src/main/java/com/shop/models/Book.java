package com.shop.models;

public class Book {
  private int book_ID;
  private String title;
  private String description;
  private String genre;
  private String author;
  private int price;
  

  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public Book(int book_ID, String title, String description, String genre, String author, int price) {
    this.book_ID = book_ID;
    this.title = title;
    this.description = description;
    this.genre = genre;
    this.author = author;
    this.price = price;
  }
  public int getBook_ID() {
    return book_ID;
  }
  public void setBook_ID(int book_ID) {
    this.book_ID = book_ID;
  }
  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
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
