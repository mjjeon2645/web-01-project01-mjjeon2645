package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
  @Test
  void creation() {
    Book book = new Book("images/books/1.png", "객체지향의 사실과 오해", "조영호",
        "http://www.yes24.com/Product/Goods/18249021",
        "과학/IT");
  }
}
