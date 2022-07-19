package panels;

import buttons.BookCategoryButton;

import javax.swing.*;
import java.awt.*;

public class SelectCategoryPanel extends JPanel {
  public SelectCategoryPanel() {
    this.setLayout(new BorderLayout());
    this.setOpaque(false);

    JPanel titlePanel = new JPanel();
    titlePanel.setOpaque(false);
    titlePanel.setLayout(new GridLayout(0, 1, 10, 5));
    this.add(titlePanel, BorderLayout.PAGE_START);

    titlePanel.add(new JLabel());

    JLabel titleLabel = new JLabel("관심분야를 선택해주세요.");
    titleLabel.setFont(new Font("Verdada", Font.BOLD, 16));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(titleLabel);

    JLabel subtitleLabel1 = new JLabel("관심분야 3개를 선택하시면");
    subtitleLabel1.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel1);

    JLabel subtitleLabel2 = new JLabel("분야에 맞는 책을 추천드려요.");
    subtitleLabel2.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel2);

    JPanel choicePanel = new JPanel();
    choicePanel.setLayout(new GridLayout(6, 4, 10, 20));
    choicePanel.setOpaque(false);
    this.add(choicePanel, BorderLayout.CENTER);

    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JButton("\uD83E\uDD17 소설"));
    choicePanel.add(new JButton("에세이"));
    choicePanel.add(new JButton("시"));
    choicePanel.add(new JButton("인문학"));
    choicePanel.add(new JButton("자기계발"));
    choicePanel.add(new JButton("경제/경영"));
    choicePanel.add(new JButton("마케팅"));
    choicePanel.add(new JButton("재태크"));
    choicePanel.add(new JButton("철학"));
    choicePanel.add(new JButton("예술/문화"));
    choicePanel.add(new JButton("사회/정치"));
    choicePanel.add(new JButton("디자인"));
    choicePanel.add(new JButton("과학"));
    choicePanel.add(new JButton("여행"));
    JButton button = new JButton("종교");
    button.setBackground(new Color(255, 0, 0));
    button.addActionListener(event -> {
      button.setBackground(Color.BLUE);
    });
    choicePanel.add(button);



    choicePanel.add(new BookCategoryButton("라이프스타일"));

    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());

    JButton button1 = new JButton("추천 책 만나러가기!");
    this.add(button1, BorderLayout.PAGE_END);

  }
}
