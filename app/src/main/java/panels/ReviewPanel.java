package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;

public class ReviewPanel extends JPanel {
  private Review review;
  private List<Review> reviews;

  public ReviewPanel(Review review, List<Review> reviews) {
    this.review = review;
    this.reviews = reviews;

    this.setLayout(new GridLayout(1, 2));

    JLabel imageLabel = new JLabel();

    String address = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Book-icon-bible.png";
    try{
      imageLabel.setIcon(new ImageIcon((new URL(address))));
    }catch(Exception ex) {}
//    setLayout(null);

    imageLabel.setBounds(30, 30, 30, 30);
    this.add(imageLabel);
    imageLabel.setVisible(true);
    this.setVisible(true);
//    ImageIcon icon = new ImageIcon("/resources/book.png");
//
//    Image image = icon.getImage();
//
//    Image updateImg = updateImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH);


    JPanel titleAndAuthor = new JPanel();

    JLabel reviewTitleLabel = new JLabel(review.title());
    reviewTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsPopUp detailsPopUp = new DetailsPopUp(reviews, review);
      }
    });
    this.add(titleAndAuthor);

    JLabel authorLabel = new JLabel(review.author());
    this.add(authorLabel);

  }
}
