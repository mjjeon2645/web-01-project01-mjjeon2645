package panels;

import models.Review;
import frames.DetailsFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReviewPanel extends JPanel {
  private Review review;
  private List<Review> reviews;
  private JPanel contentPanel;

  public ReviewPanel(Review review, List<Review> reviews, JPanel contentPanel) {
    this.review = review;
    this.reviews = reviews;
    this.contentPanel = contentPanel;

    this.setOpaque(false);
    this.setBorder(new LineBorder(Color.GRAY, 1, true));

    this.setLayout(new FlowLayout(FlowLayout.LEFT));

    JPanel panel = new JPanel();
    panel.setOpaque(false);
    this.add(panel);

    ImagePanel imagePanel = new ImagePanel("images/bookicon.png");
    imagePanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsFrame detailsPopUp = new DetailsFrame(reviews, review, contentPanel);
        review.plusCount();
      }
    });
    panel.add(imagePanel);

    JPanel containerPanel = new JPanel();
    containerPanel.setOpaque(false);
    containerPanel.setLayout(new GridLayout(3, 1, 0, 5));
    containerPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsFrame detailsPopUp = new DetailsFrame(reviews, review, contentPanel);
        review.plusCount();
      }
    });
    this.add(containerPanel);

    JLabel reviewTitleLabel = new JLabel(review.title());
    reviewTitleLabel.setFont(new Font("Verdada", Font.BOLD, 14));
    reviewTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsFrame detailsPopUp = new DetailsFrame(reviews, review, contentPanel);
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
