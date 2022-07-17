package panels;

import models.Review;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReviewPanel extends JPanel {
  private Review review;
  private List<Review> reviews;

  public ReviewPanel(Review review, List<Review> reviews) {
    this.review = review;
    this.reviews = reviews;

    JLabel authorLabel = new JLabel(review.author());
    this.add(authorLabel);

    JLabel reviewTitleLabel = new JLabel(review.title());
    reviewTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsPopUp detailsPopUp = new DetailsPopUp(reviews, review);
      }
    });
    this.add(reviewTitleLabel);
  }
}
