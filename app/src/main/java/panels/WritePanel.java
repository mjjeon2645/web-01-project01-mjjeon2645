package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;

public class WritePanel extends JPanel {
  public WritePanel() {
    this.setLayout(new GridLayout(0, 1));

    JLabel titleLabel = new JLabel("리뷰 쓰기");
    this.add(titleLabel);

    JTextField authorField = new JTextField(15);
    authorField.setText("작성자명을 적어주세요");
    this.add(authorField);

    JTextField titleField = new JTextField(15);
    titleField.setText("제목을 적어주세요");
    this.add(titleField);

    JTextArea reviewTextArea = new JTextArea();
    reviewTextArea.setText("100자 이내의 리뷰를 적어주세요");
    this.add(reviewTextArea);

    JButton writeButton = new JButton("작성완료");
    writeButton.addActionListener(event -> {
      String author = authorField.getText();
      String title = titleField.getText();
      String text = reviewTextArea.getText();

      Review review = new Review(author, title, text);
    });
    this.add(writeButton);
  }
}
