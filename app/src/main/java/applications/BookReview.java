package applications;

import models.RecommendationHistory;
import models.Review;
import panels.*;
import utils.RecommendationHistoryLoader;
import utils.ReviewsLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BookReview {
  private List<Review> reviews;
  private List<RecommendationHistory> recommendationHistories;

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

    RecommendationHistoryLoader recommendationHistoryLoader
        = new RecommendationHistoryLoader();
    recommendationHistories = recommendationHistoryLoader.load();
  }

  public void run() {
    initFrameAndImage();

    initContentPanel();

    initMenus();

    frame.setVisible(true);
  }

  public void initFrameAndImage() {
    frame = new JFrame("Book Review 100");
    frame.setSize(1000, 700);
    frame.setLocation(100, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        ReviewsLoader reviewsLoader = new ReviewsLoader();
        RecommendationHistoryLoader recommendationHistoryLoader
            = new RecommendationHistoryLoader();
        try {
        reviewsLoader.save(reviews);
        recommendationHistoryLoader.save(recommendationHistories);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });

    imagePanel = new ImagePanel("images/background2.png");
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
    menuPanel.add(searchReviewsMenu());
    menuPanel.add(recommendBooksMenu());
    menuPanel.add(recommendBooksHistoryMenu());
    frame.setVisible(true);

//   TODO: 프레임 자동갱신 기능(팝업을 띄웠을 때)
//    frame.addWindowListener(new WindowAdapter() {
//      @Override
//      public void windowActivated(WindowEvent e) {
//        super.windowActivated(e);
//
////        // what panel ? ... int selectedMenu = 0;
//        ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);
//        showContentPanel(reviewsPanel);
//      }
//    });
  }

  public JButton displayReviewsMenu() {
    JButton button = new JButton("100글자 북 리뷰");
    button.setBackground(Color.WHITE);
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      ReviewsPanel reviewsPanel = new ReviewsPanel(reviews, contentPanel);
      showContentPanel(reviewsPanel);
    });

    return button;
  }

  public JButton writeReviewMenu() {
    JButton button = new JButton("리뷰 쓰기");
    button.setBackground(Color.WHITE);
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      WritePanel writePanel = null;
      try {
        writePanel = new WritePanel(reviews, contentPanel);
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
      showContentPanel(writePanel);
    });

    return button;
  }

  public JButton searchReviewsMenu() {
    JButton button = new JButton("리뷰 검색하기");
    button.setBackground(Color.WHITE);
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      SearchPanel searchPanel = new SearchPanel(reviews, contentPanel);
      showContentPanel(searchPanel);
    });

    return button;
  }

  public JButton recommendBooksMenu() {
    JButton button = new JButton("오늘의 추천 책");
    button.setBackground(Color.WHITE);
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      SelectCategoryPanel selectCategoryPanel = new SelectCategoryPanel(recommendationHistories);
      showContentPanel(selectCategoryPanel);
    });

    return button;
  }

  public JButton recommendBooksHistoryMenu() {
    JButton button = new JButton("책 추천 히스토리");
    button.setBackground(Color.WHITE);
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {

      RecommendationHistoryPanel historyPanel = new RecommendationHistoryPanel(recommendationHistories);
      showContentPanel(historyPanel);
    });

    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setOpaque(false);
    imagePanel.add(contentPanel, BorderLayout.CENTER);

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews, contentPanel);
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
