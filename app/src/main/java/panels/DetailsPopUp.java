package panels;

import models.Review;
import utils.ReviewsLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class DetailsPopUp extends JPanel {
  private final JFrame detailsFrame;
  private final JPanel detailsPanel;
  private List<Review> reviews;
  private Review review;
  private JTextField authorField;
  private JTextField titleField;
  private JTextArea contentArea;

  public DetailsPopUp(List<Review> reviews, Review review) {
    this.reviews = reviews;
    this.review = review;

    detailsFrame = new JFrame("상세보기");
    detailsFrame.setSize(500, 500);
    detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    detailsFrame.setVisible(true);

    detailsPanel = new JPanel();
    detailsPanel.setLayout(null);

    initAuthorField();

    initTitleField();

    initContentArea();

    initDeleteButton();

    initModifyButton();

    detailsFrame.add(detailsPanel);
  }

  public void initAuthorField() {
    JLabel authorLabel = new JLabel("작성자");
    authorLabel.setBounds(50, 20, 50, 50);
    detailsPanel.add(authorLabel);

    authorField = new JTextField(20);
    authorField.setText(review.author());
    authorField.setBounds(110, 30, 150, 30);
    detailsPanel.add(authorField);
  }

  public void initTitleField() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);
    detailsPanel.add(title);

    titleField = new JTextField(review.title());
    titleField.setBounds(110, 110, 350, 30);
    detailsPanel.add(titleField);
  }

  public void initContentArea() {
    contentArea = new JTextArea();
    contentArea.setText(review.text());
    contentArea.setLineWrap(true);
    contentArea.setBounds(50, 160, 405, 250);
    detailsPanel.add(contentArea);
  }

  public void initDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(300, 420, 70, 35);
    deleteButton.addActionListener(event -> {
      review.deleted();

      ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

      ReviewsLoader reviewsLoader = new ReviewsLoader();
      try {
        reviewsLoader.save(reviews);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      detailsFrame.setVisible(false);
    });

    detailsPanel.add(deleteButton);
  }

  public void initModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(385, 420, 70, 35);
    modifyButton.addActionListener(event -> {
      review.modifyAuthor(authorField.getText());
      review.modifyTitle(titleField.getText());
      review.modifyText(contentArea.getText());

      detailsFrame.setVisible(false);
    });

    detailsPanel.add(modifyButton);
  }
}
