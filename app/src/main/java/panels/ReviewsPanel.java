package panels;

import models.Review;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReviewsPanel extends JPanel {
  private List<Review> reviews;

  public ReviewsPanel(List<Review> reviews) {
    this.reviews = reviews;

    this.setLayout(new GridLayout(0, 1, 10, 10));
    this.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        this.add(reviewPanel);
      }
    }
  }
  //TODO: 리뷰 패널을 리프레시하는 것을 여기서 해줄순 없을까?
}
