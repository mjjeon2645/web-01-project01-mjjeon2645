package panels;

import applications.BookReview;
import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReviewsPanel extends JPanel {
  private final List<Review> reviews;
  private BookReview bookReview;

  public ReviewsPanel(List<Review> reviews) {
    this.reviews = reviews;

    this.setLayout(new GridLayout(0, 2));

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
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
  }
}
