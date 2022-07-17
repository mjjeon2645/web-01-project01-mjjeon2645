package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReviewPanel extends JPanel {
  private Review review;
  private List<Review> reviews;

  public ReviewPanel(Review review, List<Review> reviews) {
    this.review = review;
    this.reviews = reviews;

    JPanel imagePanel = new JPanel();

    ImageIcon icon = new ImageIcon("/resources/book.png");

    Image image = icon.getImage();

    Image updateImg = updateImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH);

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
