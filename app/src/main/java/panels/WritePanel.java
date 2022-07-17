package panels;

import applications.BookReview;
import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.List;

public class WritePanel extends JPanel {
  private List<Review> reviews;
  private ReviewsPanel reviewsPanel;

  public WritePanel(List<Review> reviews) throws FileNotFoundException {
    this.reviews = reviews;
    this.setLayout(new GridLayout(0, 1));

    JLabel titleLabel = new JLabel("리뷰 쓰기");
    this.add(titleLabel);

    JTextField authorField = new JTextField(15);
    authorField.setText("작성자명");
    this.add(authorField);

    JTextField passwordField = new JTextField(15);
    passwordField.setText("비밀번호");
    this.add(passwordField);

    JTextField titleField = new JTextField(15);
    titleField.setText("제목");
    this.add(titleField);

    JTextArea reviewTextArea = new JTextArea(1, 30);
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
    this.add(reviewTextArea);

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
      }
    });
    this.add(writeButton);

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
}
