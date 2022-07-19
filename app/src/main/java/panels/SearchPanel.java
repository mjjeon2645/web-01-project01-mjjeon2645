package panels;

import frames.WarningMessageFrame;
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
        String message = "검색어를 입력하세요!";
        WarningMessageFrame warningMessageFrame = new WarningMessageFrame(message);
      }

      // TODO. 여기 중복 해결해줄 수는 없을까?
      if (!text.isBlank()) {
        String selection = String.valueOf(comboBox.getSelectedItem());

        if (selection.equals(Review.AUTHOR)) {
          searchReviewsWithAuthorKeyword(reviews, text);
        }

        if (selection.equals(Review.TITLE)) {
          searchReviewsWithTitleKeyword(reviews, text);
        }

        if (selection.equals(Review.TEXT)) {
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
