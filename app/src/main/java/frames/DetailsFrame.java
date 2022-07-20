package frames;

import frames.WarningMessageFrame;
import models.Review;
import panels.ReviewPanel;
import panels.ReviewsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DetailsFrame extends JFrame {
  private final JPanel detailsPanel;
  private List<Review> reviews;
  private Review review;
  private JTextField authorField;
  private JTextField titleField;
  private JTextArea contentArea;
  private JTextField passwordField;

  public DetailsFrame(List<Review> reviews, Review review) {
    this.reviews = reviews;
    this.review = review;

    this.setTitle("상세보기");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);

    detailsPanel = new JPanel();
    detailsPanel.setLayout(null);

    initAuthorField();

    initPasswordField();

    initTitleField();

    initTextArea();

    initDeleteButton();

    initModifyButton();

    this.add(detailsPanel);
  }

  public void initAuthorField() {
    JLabel authorLabel = new JLabel("작성자");
    authorLabel.setBounds(50, 20, 50, 50);
    detailsPanel.add(authorLabel);

    authorField = new JTextField(20);
    authorField.setText(review.author());
    authorField.setEditable(false);
    authorField.setBounds(110, 30, 150, 30);
    detailsPanel.add(authorField);
  }

  public void initPasswordField() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);
    detailsPanel.add(password);

    passwordField = new JTextField(4);
    passwordField.setBounds(110, 70, 250, 30);
    detailsPanel.add(passwordField);
  }

  public void initTitleField() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);
    detailsPanel.add(title);

    titleField = new JTextField(review.title());
    titleField.setBounds(110, 110, 350, 30);
    detailsPanel.add(titleField);
  }

  public void initTextArea() {
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
      if (review.password().equals(passwordField.getText())) {
        review.deleted();
        this.setVisible(false);

        refreshReviewsPanel(reviews);
      }

      if (!review.password().equals(passwordField.getText())) {
        String message = "비밀번호를 확인하세요!";
        WarningMessageFrame warningMessageFrame = new WarningMessageFrame(message);
      }
    });

    detailsPanel.add(deleteButton);
  }

  public void initModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(385, 420, 70, 35);
    modifyButton.addActionListener(event -> {
      if (review.password().equals(passwordField.getText())) {
        review.modifyAuthor(authorField.getText());
        review.modifyTitle(titleField.getText());
        review.modifyText(contentArea.getText());

        this.setVisible(false);

        refreshReviewsPanel(reviews);
      }
      if (!review.password().equals(passwordField.getText())) {
        String message = "비밀번호를 확인하세요!";
        WarningMessageFrame warningMessageFrame = new WarningMessageFrame(message);
      }
    });

    detailsPanel.add(modifyButton);
  }

  public void refreshReviewsPanel(List<Review> reviews) {
    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

    reviewsPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        reviewsPanel.add(reviewPanel);
      }
    }
// TODO: 문제 해결해야 함
//    contentPanel.add(reviewsPanel);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }
}
