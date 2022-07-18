package applications;

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

    initDisplayMenu();

    initWriteMenu();

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
        reviewsLoader.save(reviews);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initDisplayMenu() {
    menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(displayReviews());
  }

  public JButton displayReviews() {
    JButton button = new JButton("100글자 북 리뷰");
    button.addActionListener(event -> {
      ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

      showContentPanel(reviewsPanel);
    });

    return button;
  }

  public void initWriteMenu() {
    JPanel writeMenuPanel = new JPanel();
    writeMenuPanel.setLayout(new BorderLayout());
    frame.add(writeMenuPanel, BorderLayout.SOUTH);

    JPanel buttonLayoutPanel = new JPanel();
    writeMenuPanel.add(buttonLayoutPanel);
    writeMenuPanel.add(writeReview(), BorderLayout.EAST);
  }

  public JButton writeReview() {
    JButton button = new JButton("리뷰 쓰기");
    // TODO. 이미지로 버튼 만들어보기
//    button.setSize(30, 30);
//    button.setBorderPainted(false);
//    button.setFocusPainted(false);
//    button.setContentAreaFilled(false);
    button.addActionListener(event -> {
      WritePanel writePanel = null;
      try {
        writePanel = new WritePanel(reviews);
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
      showContentPanel(writePanel);
    });
//    button.setVisible(true);
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel, BorderLayout.CENTER);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    contentPanel.setVisible(false);
    contentPanel.setVisible(true);

    frame.setVisible(true);
  }
}
