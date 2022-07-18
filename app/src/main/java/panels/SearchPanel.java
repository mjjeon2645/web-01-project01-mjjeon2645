package panels;

import models.Review;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.List;

public class SearchPanel extends JPanel {
  private List<Review> reviews;

  public SearchPanel(List<Review> reviews) {
    this.reviews = reviews;
    this.setLayout(new BorderLayout());
    this.setOpaque(false);

    JPanel formPanel = new JPanel();
    formPanel.setOpaque(false);
    this.add(formPanel, BorderLayout.PAGE_START);

    String[] words = {"작성자", "제목", "내용"};
    JComboBox comboBox = new JComboBox(words);
    formPanel.add(comboBox);

    JTextField searchField = new JTextField(15);
    formPanel.add(searchField);

    JButton searchButton = new JButton("확인");
    searchButton.addActionListener(event -> {
      String text = searchField.getText();
//  TODO: 구성 필요
//      if (comboBox.getSelectedItem().equals("작성자")) {
//        for (Review review : reviews) {
//          if (review.author().contains(text)) {
//            ReviewsPanel reviewsPanel = new ReviewsPanel(reviews);
//            this.add(reviewsPanel);
//          }
//        }
//      }
    });

    formPanel.add(searchButton);
  }
}
