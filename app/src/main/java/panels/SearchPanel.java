package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchPanel extends JPanel {
  private List<Review> reviews;

  public SearchPanel(List<Review> reviews) {
    this.reviews = reviews;
    this.setLayout(new BorderLayout());
    this.setOpaque(false);

    initForm(reviews);
  }

  public void initForm(List<Review> reviews) {
    JPanel formPanel = new JPanel();
    formPanel.setOpaque(false);
    this.add(formPanel, BorderLayout.PAGE_START);

    String[] words = {Review.AUTHOR, Review.TITLE, Review.TEXT};
    JComboBox comboBox = new JComboBox(words);
    formPanel.add(comboBox);

    JTextField searchField = new JTextField(15);
    formPanel.add(searchField);

    JButton searchButton = new JButton("확인");
    searchButton.addActionListener(event -> {
      String text = searchField.getText();
      if (text.isBlank()) {
        JFrame warningFrame = new JFrame("Warning");
        warningFrame.setLayout(new GridLayout(2, 1));
        warningFrame.setSize(200, 100);
        warningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        warningFrame.setVisible(true);

        JLabel messageLabel = new JLabel("모든 항목을 빠짐없이 입력하세요!");
        warningFrame.add(messageLabel);

        JButton button = new JButton("확인");
        button.addActionListener(event2 -> {
          warningFrame.setVisible(false);
        });
        warningFrame.add(button);
      }

      if (!text.isBlank()) {
        if (comboBox.getSelectedItem().equals(Review.AUTHOR)) {
          searchReviewsWithAuthorKeyword(reviews, text);
        }

        if (comboBox.getSelectedItem().equals(Review.TITLE)) {
          searchReviewsWithTitleKeyword(reviews, text);
        }

        if (comboBox.getSelectedItem().equals(Review.TEXT)) {
          searchReviewsWithTextKeyword(reviews, text);
        }
      }
    });

    formPanel.add(searchButton);
  }

  public void searchReviewsWithAuthorKeyword(List<Review> reviews, String text) {
    this.removeAll();

    initForm(reviews);

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

    reviewsPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY) &&
          review.author().contains(text)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        reviewsPanel.add(reviewPanel);
      }
    }

    this.add(reviewsPanel, BorderLayout.CENTER);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }

  public void searchReviewsWithTitleKeyword(List<Review> reviews, String text) {
    this.removeAll();

    initForm(reviews);

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

    reviewsPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY) &&
          review.title().contains(text)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        reviewsPanel.add(reviewPanel);
      }
    }

    this.add(reviewsPanel, BorderLayout.CENTER);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }

  public void searchReviewsWithTextKeyword(List<Review> reviews, String text) {
    this.removeAll();

    initForm(reviews);

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

    reviewsPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY) &&
          review.text().contains(text)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        reviewsPanel.add(reviewPanel);
      }
    }

    this.add(reviewsPanel, BorderLayout.CENTER);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }
}
