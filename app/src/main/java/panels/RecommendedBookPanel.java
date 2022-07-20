package panels;

import models.Book;
import utils.BooksLoader;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class RecommendedBookPanel extends JPanel {
  public RecommendedBookPanel() throws FileNotFoundException {
    this.setLayout(new GridLayout(1, 2, 100, 10));
    this.setOpaque(false);

    BooksLoader booksLoader = new BooksLoader();
    List<Book> books = booksLoader.load();

    favoriteBookPanel(books);

    challengeBookPanel(books);

    // TODO. 추후 loader로 구현할 것
//    BooksLoader booksLoader = new BooksLoader();
//    List<Book> books = booksLoader.load();
//
//    for (Book book : books) {
//      JLabel label = new JLabel(book.title());
//      this.add(label);
//    }
  }

  public void favoriteBookPanel(List<Book> books) {
    JPanel favoriteBookPanel = new JPanel();
    favoriteBookPanel.setLayout(new BorderLayout());
    favoriteBookPanel.setOpaque(false);
    this.add(favoriteBookPanel);

    JPanel imageAddPanel = new JPanel();
    imageAddPanel.setLayout(new BorderLayout());
    imageAddPanel.setOpaque(false);
    favoriteBookPanel.add(imageAddPanel, BorderLayout.PAGE_START);

    JLabel favoriteSubtitleLabel = new JLabel("당신과 잘 어울리는 책");
    favoriteSubtitleLabel.setFont(new Font("Verdada", Font.BOLD, 14));
    imageAddPanel.add(favoriteSubtitleLabel, BorderLayout.PAGE_START);

    JLabel layoutLabel = new JLabel("  ");
    imageAddPanel.add(layoutLabel, BorderLayout.CENTER);

    Book testBook = books.get(0);
    String imageRoot = testBook.imageRoot();
    ImagePanel imagePanel = new ImagePanel(imageRoot);
    imageAddPanel.add(imagePanel, BorderLayout.PAGE_END);

    JPanel infoPanel = new JPanel();
    infoPanel.setOpaque(false);
    infoPanel.setLayout(new GridLayout(0, 1, 5, 5));
    favoriteBookPanel.add(infoPanel, BorderLayout.CENTER);

    infoPanel.add(new JLabel("  "));

    infoPanel.add(new JLabel("제목: " + testBook.bookTitle()));

    infoPanel.add(new JLabel("저자: " + testBook.bookAuthor()));
  }

  public void challengeBookPanel(List<Book> books) {
    JPanel challengeBookPanel = new JPanel();
    challengeBookPanel.setOpaque(false);
    challengeBookPanel.setLayout(new BorderLayout());
    this.add(challengeBookPanel);

    JPanel imageAddPanel = new JPanel();
    imageAddPanel.setOpaque(false);
    imageAddPanel.setLayout(new BorderLayout());
    challengeBookPanel.add(imageAddPanel, BorderLayout.PAGE_START);

    JLabel challengeSubtitleLabel = new JLabel("이런 책도 도전해보세요!");
    challengeSubtitleLabel.setFont(new Font("Verdada", Font.BOLD, 14));
    imageAddPanel.add(challengeSubtitleLabel, BorderLayout.PAGE_START);

    JLabel layoutLabel = new JLabel("  ");
    imageAddPanel.add(layoutLabel, BorderLayout.CENTER);

    Book testBook = books.get(1);
    String imageRoot = testBook.imageRoot();
    ImagePanel imagePanel = new ImagePanel(imageRoot);
    imageAddPanel.add(imagePanel, BorderLayout.PAGE_END);

    JPanel infoPanel = new JPanel();
    infoPanel.setOpaque(false);
    infoPanel.setLayout(new GridLayout(0, 1, 5, 5));
    challengeBookPanel.add(infoPanel, BorderLayout.CENTER);

    infoPanel.add(new JLabel("  "));

    infoPanel.add(new JLabel("제목: " + testBook.bookTitle()));

    infoPanel.add(new JLabel("저자: " + testBook.bookAuthor()));
  }
}
