package panels;

import models.Review;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
    this.setBorder(new LineBorder(Color.GRAY, 1, true));

    this.setLayout(new GridLayout(1, 2));

    // TODO. 이미지화 하여 각 리스트를 보여주고 싶음
//    JLabel imageLabel = new JLabel();
//
//    String address = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Book-icon-bible.png";
//    try{
//      imageLabel.setIcon(new ImageIcon((new URL(address))));
//    }catch(Exception ex) {}
////    setLayout(null);
//
//    imageLabel.setBounds(30, 30, 30, 30);
//    this.add(imageLabel);
//    imageLabel.setVisible(true);
//    this.setVisible(true);
//    ImageIcon icon = new ImageIcon("/resources/book.png");
//
//    Image image = icon.getImage();
//
//    Image updateImg = updateImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH);

    JPanel imagePanel = new JPanel();
    imagePanel.setBackground(Color.orange);
    this.add(imagePanel);

    JLabel noticeLabel = new JLabel("이미지 삽입 예정");
    imagePanel.add(noticeLabel);

    JPanel titleAndAuthor = new JPanel();
    titleAndAuthor.setLayout(new GridLayout(2, 1, 0, 10));
    titleAndAuthor.setBackground(Color.white);
    this.add(titleAndAuthor);

    JLabel reviewTitleLabel = new JLabel(review.title());
    reviewTitleLabel.setFont(new Font("Verdada", Font.BOLD, 14));
    reviewTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        DetailsPopUp detailsPopUp = new DetailsPopUp(reviews, review);
      }
    });
    titleAndAuthor.add(reviewTitleLabel);

    JLabel authorLabel = new JLabel(review.author());
    titleAndAuthor.add(authorLabel);

  }
}
