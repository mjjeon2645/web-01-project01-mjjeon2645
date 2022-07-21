package panels;

import frames.WarningMessageFrame;
import models.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.List;

public class WritePanel extends JPanel {
  private final JLabel characterCountLabel;
  private List<Review> reviews;

  public WritePanel(List<Review> reviews) throws FileNotFoundException {
    this.reviews = reviews;
    this.setOpaque(false);
    this.setLayout(new BorderLayout());

    JPanel panel = new JPanel();
    panel.setOpaque(false);
    panel.setLayout(new GridLayout(3, 1, 5, 5));
    this.add(panel, BorderLayout.PAGE_START);
    panel.setVisible(true);

    JTextField authorField = new JTextField(15);
    authorField.setText("닉네임을 적어주세요.");
    panel.add(authorField);

    JTextField passwordField = new JTextField(15);
    passwordField.setText("비밀번호를 적어주세요.");
    panel.add(passwordField);

    JTextField titleField = new JTextField(15);
    titleField.setText("제목을 적어주세요.");
    panel.add(titleField);


    JPanel textAreaPanel = new JPanel();
    textAreaPanel.setLayout(new BorderLayout());
    textAreaPanel.setOpaque(false);
    this.add(textAreaPanel, BorderLayout.CENTER);

    JTextArea reviewTextArea = new JTextArea(20, 25);
    reviewTextArea.setText("오늘 읽은 책은 어땠나요?" + "\n" + "100자 이내로 기록해서 공유해보세요.");
    reviewTextArea.setLineWrap(true);
    reviewTextArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (((JTextArea) e.getSource()).getText().length() > 99) {
          e.consume();
        }

        characterCountLabel.setText("현재 글자수: " + reviewTextArea.getText().length());
        if (characterCountLabel.getText().equals("현재 글자수: 100")) {
          characterCountLabel.setForeground(Color.RED);
        }

        if (!characterCountLabel.getText().equals("현재 글자수: 100")) {
          characterCountLabel.setForeground(Color.BLACK);
        }
      }
    });
    textAreaPanel.add(reviewTextArea, BorderLayout.PAGE_START);

    characterCountLabel = new JLabel("현재 글자수: " + reviewTextArea.getText().length());
    characterCountLabel.setFont(new Font("Verdada", Font.ITALIC, 14));

    characterCountLabel.setHorizontalAlignment(JLabel.RIGHT);
    textAreaPanel.add(characterCountLabel, BorderLayout.CENTER);

    JButton writeButton = new JButton("기록하기");
    writeButton.setMargin(new Insets(10, 10, 10, 10));
    writeButton.addActionListener(event -> {
      String author = authorField.getText();
      String password = passwordField.getText();
      String title = titleField.getText();
      String text = reviewTextArea.getText();

//      if (isBlank(author, password, title, text)) {
//        String message = "모든 항목을 빠짐없이 입력하세요!";
//        WarningMessageFrame warningMessageFrame = new WarningMessageFrame(message);
//      }

      if (author.isBlank()) {
        authorField.setBackground(Color.PINK);
        authorField.setText("작성자를 입력하세요.");
      }

      if (!author.isBlank()) {
        authorField.setBackground(Color.WHITE);
      }

      if (password.isBlank()) {
        passwordField.setBackground(Color.PINK);
        passwordField.setText("비밀번호를 입력하세요.");
      }

      if (!password.isBlank()) {
        passwordField.setBackground(Color.WHITE);
      }

      if (title.isBlank()) {
        titleField.setBackground(Color.PINK);
        titleField.setText("글 제목을 입력하세요.");
      }

      if (!title.isBlank()) {
        titleField.setBackground(Color.WHITE);
      }

      if (text.isBlank()) {
        reviewTextArea.setBackground(Color.PINK);
        reviewTextArea.setText("리뷰를 100자 이내로 입력하세요.");
      }

      if (!text.isBlank()) {
        reviewTextArea.setBackground(Color.WHITE);
      }

      if (isFilled(author, password, title, text)) {
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

  public boolean isFilled(String author, String password, String title, String text) {
    return !author.isBlank() && !password.isBlank()
        && !title.isBlank() && !text.isBlank();
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
        reviewsPanel.add(reviewPanel);
      }
    }

    this.add(reviewsPanel);

    reviewsPanel.setVisible(false);
    reviewsPanel.setVisible(true);
  }
}
