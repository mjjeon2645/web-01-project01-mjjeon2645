package applications;

import models.Review;
import panels.ImagePanel;
import panels.ReviewsPanel;
import panels.SearchPanel;
import panels.WritePanel;
import utils.ReviewsLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BookReview {
  private List<Review> reviews;

  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private ImagePanel imagePanel;

  public static void main(String[] args) throws FileNotFoundException {
    BookReview application = new BookReview();
    application.run();
  }

  public BookReview() throws FileNotFoundException {
    ReviewsLoader reviewsLoader = new ReviewsLoader();
    reviews = reviewsLoader.load();
  }

  public void run() {
    initFrameAndImage();

    initMenus();

    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrameAndImage() {
    frame = new JFrame("Book Review 100");
    frame.setSize(780, 554);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        ReviewsLoader reviewsLoader = new ReviewsLoader();
        try {
        reviewsLoader.save(reviews);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    imagePanel = new ImagePanel("test.png");
    imagePanel.setLayout(new BorderLayout());
    frame.add(imagePanel);
    frame.setVisible(true);
  }

  public void initMenus() {
    menuPanel = new JPanel();
    imagePanel.add(menuPanel, BorderLayout.PAGE_START);
    menuPanel.setOpaque(false);

    menuPanel.add(displayReviewsMenu());
    menuPanel.add(writeReviewMenu());
    menuPanel.add(searchMenu());
  }

  public JButton displayReviewsMenu() {
    JButton button = new JButton("100글자 북 리뷰");
    button.addActionListener(event -> {
      ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

      showContentPanel(reviewsPanel);
    });

    return button;
  }

  public JButton writeReviewMenu() {
    JButton button = new JButton("리뷰 쓰기");
    button.addActionListener(event -> {
      WritePanel writePanel = null;
      try {
        writePanel = new WritePanel(reviews);
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
      showContentPanel(writePanel);
    });

    return button;
  }

  public JButton searchMenu() {
    JButton button = new JButton("리뷰 검색하기");
    button.addActionListener(event -> {
      SearchPanel searchPanel = new SearchPanel(reviews);

      showContentPanel(searchPanel);
    });

    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setOpaque(false);
    imagePanel.add(contentPanel, BorderLayout.CENTER);

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);
    reviewsPanel.setOpaque(false);
    contentPanel.add(reviewsPanel);

    frame.setVisible(true);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    contentPanel.setVisible(false);
    contentPanel.setVisible(true);

    frame.setVisible(true);
  }
}
