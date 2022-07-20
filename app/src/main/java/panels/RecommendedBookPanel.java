package panels;

import models.Book;
import utils.BooksLoader;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class RecommendedBookPanel extends JPanel {
  public RecommendedBookPanel() throws FileNotFoundException {
    this.setLayout(new GridLayout(0, 1));

    BooksLoader booksLoader = new BooksLoader();
    List<Book> books = booksLoader.load();

    for (Book book : books) {
      JLabel label = new JLabel(book.title());
      this.add(label);
    }
  }
}
