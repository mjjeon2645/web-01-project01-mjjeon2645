package utils;

import models.Book;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static models.Book.SCIENCE_IT;
import static org.junit.jupiter.api.Assertions.*;

class BooksLoaderTest {
  @Test
  void parseBook() {
    BooksLoader booksLoader = new BooksLoader();
    Book book = new Book("1", "1", "1", "1", "과학/IT");

    assertEquals(book, booksLoader.parseBook("1///1///1///1///과학/IT"));
  }

  @Test
  void load() throws FileNotFoundException {
    BooksLoader booksLoader = new BooksLoader();
    Book book = new Book("1", "1", "1", "1", "과학/IT");

    assertEquals(book, booksLoader.parseBook("1///1///1///1///과학/IT"));

    List<Book> books = booksLoader.load();

    Book book1 = books.get(0);
    Book book2 = books.get(1);

    assertEquals(book1, new Book("images/books/1.png", "객체지향의 사실과 오해", "조영호",
        "http://www.yes24.com/Product/Goods/18249021", "과학/IT"));

    assertEquals(book2, new Book("images/books/2.png", "토지 1", "박경리",
        "http://www.yes24.com/Product/Goods/7412374", "소설"));
  }
}
