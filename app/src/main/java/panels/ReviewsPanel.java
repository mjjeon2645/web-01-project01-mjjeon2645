package panels;

import models.Review;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReviewsPanel extends JPanel {
  private final JPanel contentPanel;
  private List<Review> reviews;

  public ReviewsPanel(List<Review> reviews, JPanel contentPanel) {
    this.reviews = reviews;
    this.contentPanel = contentPanel;

    this.setLayout(new GridLayout(0, 1, 10, 10));
    this.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews, contentPanel);
        this.add(reviewPanel);
      }
    }
  }
}
