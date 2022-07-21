package frames;

import frames.WarningMessageFrame;
import models.Review;
import panels.ReviewPanel;
import panels.ReviewsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class DetailsFrame extends JFrame {
  private final JPanel detailsPanel;
  private List<Review> reviews;
  private Review review;
  private JTextField authorField;
  private JTextField titleField;
  private JTextArea contentArea;
  private JTextField passwordField;
  private JLabel characterCountLabel;
  private JPanel contentPanel;

  public DetailsFrame(List<Review> reviews, Review review, JPanel contentPanel) {
    this.reviews = reviews;
    this.review = review;
    this.contentPanel = contentPanel;

    this.setTitle("상세보기");
    this.setSize(500, 500);
    this.setLocation(750, 100);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);

    detailsPanel = new JPanel();
    detailsPanel.setLayout(null);

    initViewCountField();

    initAuthorField();

    initPasswordField();

    initTitleField();

    initTextArea();

    initDeleteButton();

    initModifyButton();

    this.add(detailsPanel);
  }

  public void initViewCountField() {
    JLabel viewCountLabel = new JLabel("조회수");
    viewCountLabel.setBounds(50, 15, 50, 50);
    detailsPanel.add(viewCountLabel);

    JLabel countLabel = new JLabel(String.valueOf(review.count()));
    countLabel.setBounds(110, 25, 150, 30);
    detailsPanel.add(countLabel);
  }

  public void initAuthorField() {
    JLabel authorLabel = new JLabel("작성자");
    authorLabel.setBounds(50, 55, 50, 50);
    detailsPanel.add(authorLabel);

    authorField = new JTextField(20);
    authorField.setText(review.author());
    authorField.setEditable(false);
    authorField.setBounds(110, 65, 150, 30);
    detailsPanel.add(authorField);
  }

  public void initPasswordField() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 105, 100, 30);
    detailsPanel.add(password);

    passwordField = new JTextField(4);
    passwordField.setBounds(110, 105, 150, 30);
    detailsPanel.add(passwordField);
  }

  public void initTitleField() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 150, 30, 30);
    detailsPanel.add(title);

    titleField = new JTextField(review.title());
    titleField.setBounds(110, 150, 350, 30);
    detailsPanel.add(titleField);
  }

  public void initTextArea() {
    contentArea = new JTextArea();
    contentArea.setText(review.text());
    contentArea.setBounds(50, 200, 405, 180);
    contentArea.setLineWrap(true);
    contentArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (((JTextArea) e.getSource()).getText().length() > 99) {
          e.consume();
        }

        characterCountLabel.setText("현재 글자수: " + contentArea.getText().length());
        if (characterCountLabel.getText().equals("현재 글자수: 100")) {
          characterCountLabel.setForeground(Color.RED);
        }

        if (!characterCountLabel.getText().equals("현재 글자수: 100")) {
          characterCountLabel.setForeground(Color.BLACK);
      }
    }});

    detailsPanel.add(contentArea);

    characterCountLabel = new JLabel("현재 글자수: " + contentArea.getText().length());
    characterCountLabel.setFont(new Font("Verdada", Font.ITALIC, 14));
    characterCountLabel.setBounds(360, 350, 100, 100);
    detailsPanel.add(characterCountLabel);
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
        passwordField.setBackground(Color.PINK);
        passwordField.setText("비밀번호를 확인하세요!");
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
        passwordField.setBackground(Color.PINK);
        passwordField.setText("비밀번호를 확인하세요!");
      }
    });

    detailsPanel.add(modifyButton);
  }

  public void refreshReviewsPanel(List<Review> reviews) {
    ReviewsPanel reviewsPanel = new ReviewsPanel(reviews, contentPanel);

    contentPanel.removeAll();
    reviewsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    reviewsPanel.setOpaque(false);

    for (Review review : reviews) {
      if (review.state().equals(Review.DISPLAY)) {
        ReviewPanel reviewPanel = new ReviewPanel(review, reviews, contentPanel);
      }
    }
    contentPanel.removeAll();
    contentPanel.add(reviewsPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
