package panels;

import models.Review;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

    System.out.println("ReviewsPanel!!!!!!!!!!!!!!");

    // Save -> exit program
  }

  public void refreshPanel() {
    this.setVisible(false);
    this.setVisible(true);
  }


  //TODO: 리뷰 패널을 리프레시하는 것을 여기서 해줄순 없을까?
}
