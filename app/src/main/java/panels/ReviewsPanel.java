package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReviewsPanel extends JPanel {
  private final List<Review> reviews;

  public ReviewsPanel(List<Review> reviews) {
    this.reviews = reviews;

    this.setLayout(new GridLayout(0, 2));

    JLabel column1 = new JLabel("작성자");
    this.add(column1);

    JLabel column2 = new JLabel("글 제목");
    this.add(column2);

    for (Review review : reviews) {
      if (review.state().equals("DISPLAY")) {
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

  public void refresh() {
    this.removeAll();
    this.revalidate();
  }

//TODO. 확인 필요 영역
//  public void updatePanel() {
//    this.removeAll();  // revalidate이랑 동시에 가능?
//
//    this.revalidate();
//  }
}
