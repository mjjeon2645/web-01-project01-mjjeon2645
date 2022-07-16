import models.Review;
import panels.ReviewsPanel;
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

  public static void main(String[] args) throws FileNotFoundException {
    BookReview application = new BookReview();
    application.run();
  }

  public BookReview() throws FileNotFoundException {
    ReviewsLoader reviewsLoader = new ReviewsLoader();
    reviews = reviewsLoader.load();
  }

  public void run() {
    initFrame();

    initMenus();

    initContentPanel();
  }

  public void initFrame() {
    frame = new JFrame("Book Review 100");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        ReviewsLoader reviewsLoader = new ReviewsLoader();

        try {
        reviewsLoader.saveReviews(reviews);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initMenus() {
    menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(displayReviews());
    menuPanel.add(writeReview());
  }

  public JButton displayReviews() {
    JButton button = new JButton("리뷰 보기");
    button.addActionListener(event -> {
      ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);
      showContentPanel(reviewsPanel);
    });
    return button;
  }

  public JButton writeReview() {
    JButton button = new JButton("리뷰 쓰기");
    button.addActionListener(event -> {
      WritePanel writePanel = new WritePanel(reviews);
      showContentPanel(writePanel);
    });
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    contentPanel.setVisible(false);
    contentPanel.setVisible(true);

    frame.setVisible(true);
  }
}
