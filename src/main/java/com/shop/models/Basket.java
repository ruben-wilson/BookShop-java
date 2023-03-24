package com.shop.models;

import java.util.ArrayList;
import java.util.List;

public class Basket {
  private List<Book> books;

  

  public Basket() {
    this.books = new ArrayList<>();
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void deleteBook(String bookTitle) {
    Book bToDelete = this.books.stream()
                              .filter(b -> b.getTitle().equals(bookTitle))
                              .findFirst()
                              .orElse(null);
    this.books.remove(bToDelete);
  } 

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public int howManyItems(){
    return this.books.size();
  }

  public double totalPrice(){

    double totalPrice = this.books.stream()
                                  .map(b -> b.getPrice())
                                  .mapToDouble(Double::doubleValue)
                                  .sum();
    return totalPrice;
  }

  public void resetBasket() {
    this.books.clear();
  }
}
