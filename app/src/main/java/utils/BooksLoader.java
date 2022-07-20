package utils;

import models.Book;
import models.Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksLoader {
  public List<Book> load() throws FileNotFoundException {
    List<Book> books = new ArrayList<>();

    File file = new File("booksdata.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Book book = parseBook(line);
      books.add(book);
    }

    return books;
  }

  public Book parseBook(String text) {
    String[] words = text.split("///");

    return new Book(words[0], words[1], words[2], words[3], words[4]);
  }
}
