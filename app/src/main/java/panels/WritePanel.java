package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.List;

public class WritePanel extends JPanel {
  private List<Review> reviews;

  public WritePanel(List<Review> reviews) throws FileNotFoundException {
    this.reviews = reviews;
    this.setLayout(new BorderLayout());

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    this.add(panel, BorderLayout.PAGE_START);
    panel.setVisible(true);

    JLabel label = new JLabel("작성자명");
    panel.add(label);

    JTextField authorField = new JTextField(15);
    authorField.setText("작성자명");
    authorField.setBounds(100, 100, 100, 100);
    panel.add(authorField);

    JLabel label1 = new JLabel("비밀번호");
    panel.add(label1);

    JTextField passwordField = new JTextField(15);
    passwordField.setText("비밀번호");
    panel.add(passwordField);

    JLabel label2 = new JLabel("제목");
    panel.add(label2);

    JTextField titleField = new JTextField(15);
    titleField.setText("제목");
    panel.add(titleField);

    JTextArea reviewTextArea = new JTextArea(20, 20);
    reviewTextArea.setText("100자 이내로 리뷰를 적어주세요");
    reviewTextArea.setLineWrap(true);
    reviewTextArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (((JTextArea) e.getSource()).getText().length() > 100) {
          e.consume();
        }
      }
    });
    this.add(reviewTextArea, BorderLayout.CENTER);

    JButton writeButton = new JButton("작성완료");
    writeButton.addActionListener(event -> {
      String author = authorField.getText();
      String password = passwordField.getText();
      String title = titleField.getText();
      String text = reviewTextArea.getText();

      if (isBlank(author, password, title, text)) {
        displayWarningMessage();
      }

      if (!isBlank(author, password, title, text)) {
        Review review = new Review(author, password, title, text);
        reviews.add(review);

        authorField.setText("");
        passwordField.setText("");
        titleField.setText("");
        reviewTextArea.setText("");

        refreshReviewsPanel(reviews);
      }
    });
    this.add(writeButton, BorderLayout.SOUTH);

    this.setVisible(true);
  }

  public boolean isBlank(String author, String password, String title, String text) {
    return author.isBlank() || password.isBlank()
        || title.isBlank() || text.isBlank();
  }

  public void displayWarningMessage() {
    JFrame warningFrame = new JFrame("Warning!");
    warningFrame.setLayout(new GridLayout(2, 1));
    warningFrame.setSize(200, 100);
    warningFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    warningFrame.setVisible(true);

    JLabel messageLabel = new JLabel("모든 항목을 빠짐없이 입력하세요!");
    warningFrame.add(messageLabel);

    JButton button = new JButton("확인");
    button.addActionListener(event2 -> {
      warningFrame.setVisible(false);
    });
    warningFrame.add(button);
  }

  public void refreshReviewsPanel(List<Review> reviews) {
    this.removeAll();

    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);

    reviewsPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews);
        this.add(reviewPanel);
      }
    }
    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }
}
