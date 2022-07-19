package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DetailsPopUp extends JPanel {
  private final JFrame detailsFrame;
  private final JPanel detailsPanel;
  private List<Review> reviews;
  private Review review;
  private JTextField authorField;
  private JTextField titleField;
  private JTextArea contentArea;
  private JTextField passwordField;

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

    initPasswordField();

    initTitleField();

    initTextArea();

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
        detailsFrame.setVisible(false);

        refreshReviewsPanel(reviews);
      }

      displayWarningMessage();
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

        detailsFrame.setVisible(false);

        refreshReviewsPanel(reviews);
      }

      displayWarningMessage();
    });

    detailsPanel.add(modifyButton);
  }

  public void displayWarningMessage() {
    if (!review.password().equals(passwordField.getText())) {
      JFrame warningFrame = new JFrame("Warning");
      warningFrame.setLayout(new GridLayout(2, 1));
      warningFrame.setSize(200, 100);
      warningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      warningFrame.setVisible(true);

      JLabel messageLabel = new JLabel("비밀번호를 확인하세요");
      warningFrame.add(messageLabel);

      JButton button = new JButton("확인");
      button.addActionListener(event2 -> {
        warningFrame.setVisible(false);
      });
      warningFrame.add(button);
    }
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

//    contentPanel.add(reviewsPanel);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }
}
