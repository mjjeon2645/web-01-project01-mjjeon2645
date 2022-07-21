package panels;

import models.Book;
import models.RecommendationHistory;
import utils.BooksLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecommendedBookPanel extends JPanel {
  private List<RecommendationHistory> recommendationHistories;
  private Book favoriteBook;
  private Book challengeBook;

  public RecommendedBookPanel(String selectedCategory, List<RecommendationHistory> recommendationHistories) throws IOException {
    this.recommendationHistories = recommendationHistories;

    this.setLayout(new GridLayout(1, 2, 100, 10));
    this.setOpaque(false);

    BooksLoader booksLoader = new BooksLoader();

    List<Book> books = booksLoader.load();

    favoriteBookPanel(books, selectedCategory);

    challengeBookPanel(books, selectedCategory);

    RecommendationHistory recommendationHistory = new RecommendationHistory(favoriteBook, challengeBook);

    recommendationHistories.add(recommendationHistory);
  }

  public void favoriteBookPanel(List<Book> books, String selectedCategory) {
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

    favoriteBook = recommendFavoriteBook(books, selectedCategory);
    String imageRoot = favoriteBook.imageRoot();
    ImagePanel imagePanel = new ImagePanel(imageRoot);
    imageAddPanel.add(imagePanel, BorderLayout.PAGE_END);

    JPanel informationPanel = new JPanel();
    informationPanel.setOpaque(false);
    informationPanel.setLayout(new GridLayout(0, 1, 5, 5));
    favoriteBookPanel.add(informationPanel, BorderLayout.CENTER);

    informationPanel.add(new JLabel("  "));

    JLabel bookTitleLabel = new JLabel("제목: " + favoriteBook.bookTitle());
    informationPanel.add(bookTitleLabel);

    JLabel bookAuthorLabel = new JLabel("저자: " + favoriteBook.bookAuthor());
    informationPanel.add(bookAuthorLabel);

    JLabel hyperlinkLabel = new JLabel(">>책 사러가기 click!<<");
    hyperlinkLabel.setForeground(new Color(255, 0, 113));
    hyperlinkLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
            URI uri = new URI(favoriteBook.url());
            desktop.browse(uri);
          } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    informationPanel.add(hyperlinkLabel);
  }

  public void challengeBookPanel(List<Book> books, String selectedCategory) {
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

    challengeBook = recommendChallengeBook(books, selectedCategory);
    String imageRoot = challengeBook.imageRoot();
    ImagePanel imagePanel = new ImagePanel(imageRoot);
    imageAddPanel.add(imagePanel, BorderLayout.PAGE_END);

    JPanel informationPanel = new JPanel();
    informationPanel.setOpaque(false);
    informationPanel.setLayout(new GridLayout(0, 1, 5, 5));
    challengeBookPanel.add(informationPanel, BorderLayout.CENTER);

    informationPanel.add(new JLabel("  "));

    JLabel bookTitleLabel = new JLabel("제목: " + challengeBook.bookTitle());
    informationPanel.add(bookTitleLabel);

    JLabel bookAuthorLabel = new JLabel("저자: " + challengeBook.bookAuthor());
    informationPanel.add(bookAuthorLabel);

    JLabel hyperlinkLabel = new JLabel(">>책 사러가기 click!<<");
    hyperlinkLabel.setForeground(new Color(255, 0, 113));
    hyperlinkLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
            URI uri = new URI(challengeBook.url());
            desktop.browse(uri);
          } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    informationPanel.add(hyperlinkLabel);
  }

  public Book recommendFavoriteBook(List<Book> books, String selectedCategory) {
    List<Book> favoriteBooks = new ArrayList<>();

    for (int i = 0; i < books.size(); i += 1) {
      if (books.get(i).category().equals(selectedCategory)) {
        favoriteBooks.add(books.get(i));
      }
    }

    Random random = new Random();

    int randomIndexNumber = random.nextInt(3);

    return favoriteBooks.get(randomIndexNumber);
  }

  public Book recommendChallengeBook(List<Book> books, String selectedCategory) {
    List<Book> challengeBooks = new ArrayList<>();

    for (int i = 0; i < books.size(); i += 1) {
      if (!books.get(i).category().equals(selectedCategory)) {
        challengeBooks.add(books.get(i));
      }
    }

    Random random = new Random();

    int randomIndexNumber = random.nextInt(books.size() - 3);

    return challengeBooks.get(randomIndexNumber);
  }
}
