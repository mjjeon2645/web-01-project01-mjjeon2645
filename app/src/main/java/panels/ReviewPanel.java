package panels;

import models.Review;
import popups.DetailsPopUp;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
    this.setBorder(new LineBorder(Color.GRAY, 1, true));

    this.setLayout(new GridLayout(1, 2));

    JPanel panel = new JPanel();
    this.add(panel);

    ImagePanel imagePanel = new ImagePanel("book2.png");
    panel.add(imagePanel);

    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new GridLayout(3, 1, 0, 5));
    this.add(containerPanel);

    JLabel reviewTitleLabel = new JLabel(review.title());
    reviewTitleLabel.setFont(new Font("Verdada", Font.BOLD, 14));
    reviewTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsPopUp detailsPopUp = new DetailsPopUp(reviews, review);
        review.plusCount();
      }
    });
    containerPanel.add(reviewTitleLabel);

    JLabel authorLabel = new JLabel(review.author());
    containerPanel.add(authorLabel);

    JLabel countLabel = new JLabel("조회수: " + review.count());
    containerPanel.add(countLabel);
  }
}
