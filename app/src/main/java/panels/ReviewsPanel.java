package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReviewsPanel extends JPanel {
  private final List<Review> reviews;

  public ReviewsPanel(List<Review> reviews) {
    this.reviews = reviews;
    this.setLayout(new GridLayout(0, 1));

    JLabel titleLabel = new JLabel("리뷰 목록");
    this.add(titleLabel);

    for (Review review : reviews) {
      JPanel reviewPanel = new JPanel();
      this.add(reviewPanel);

      JLabel authorLabel = new JLabel(review.author());
      reviewPanel.add(authorLabel);

      JLabel reviewTitleLabel = new JLabel(review.title());
      reviewPanel.add(reviewTitleLabel);
    }
  }
//TODO. 확인 필요 영역
//  public void updatePanel() {
//    this.removeAll();  // revalidate이랑 동시에 가능?
//
//    this.revalidate();
//  }
}
