package panels;

import frames.WarningMessageFrame;
import models.RecommendationHistory;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BorderLayout.CENTER;

public class SelectCategoryPanel extends JPanel {
  private final JPanel choicePanel;
  private List<RecommendationHistory> bookRecommendationHistories;

  public SelectCategoryPanel(List<RecommendationHistory> bookRecommendationHistories) {
    this.bookRecommendationHistories = bookRecommendationHistories;

    this.setLayout(new BorderLayout());
    this.setOpaque(false);

    JPanel titlePanel = new JPanel();
    titlePanel.setOpaque(false);
    titlePanel.setLayout(new GridLayout(0, 1, 20, 5));
    this.add(titlePanel, BorderLayout.PAGE_START);

    titlePanel.add(new JLabel());

    JLabel titleLabel = new JLabel("관심분야를 선택해주세요.");
    titleLabel.setFont(new Font("Verdada", Font.BOLD, 16));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(titleLabel);

    JLabel subtitleLabel1 = new JLabel("관심분야 1개를 선택하시면");
    subtitleLabel1.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel1);

    JLabel subtitleLabel2 = new JLabel("분야에 맞는 책을 추천드려요.");
    subtitleLabel2.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel2);

    choicePanel = new JPanel();
    choicePanel.setLayout(new GridLayout(6, 4, 30, 20));
    choicePanel.setOpaque(false);
    this.add(choicePanel, CENTER);

    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());

    String[] categories = new String[]
        {"소설 \uD83D\uDE00", "에세이 \uD83C\uDF31", "시 \uD83D\uDCDC",
            "인문학 \uD83D\uDC64", "자기계발 \uD83E\uDD34", "경제/경영 \uD83C\uDF93",
            "마케팅 \uD83D\uDD76", "재테크 \uD83D\uDCC8", "예술/문화 \uD83C\uDF39",
            "사회/정치 \uD83D\uDC40", "과학/IT \uD83D\uDEF0", "여행 \uD83D\uDEE9",
            "종교 \uD83D\uDE4F", "라이프 \uD83C\uDFD6", "결혼/육아 \uD83D\uDC8D",
            "건강 \uD83C\uDFD3"};

    List<CategoryPanel> categoryPanels = new ArrayList<>();

    for (String category : categories) {
      CategoryPanel categoryPanel = new CategoryPanel(category);
      choicePanel.add(categoryPanel);
      categoryPanels.add(categoryPanel);
    }

    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());

    JButton button = new JButton("추천 책 만나러가기 GO!");
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      String selectedCategory = "";

      for (int i = 0; i < categoryPanels.size(); i += 1) {
        if (categoryPanels.get(i).countSelectedCheckBox() == 0) {
          continue;
        }

        selectedCategory = categoryPanels.get(i).selectedCategory();
      }

      int accumulator = 0;

      for (CategoryPanel categoryPanel : categoryPanels) {
        accumulator += categoryPanel.countSelectedCheckBox();
      }

      if (accumulator != 1) {
        WarningMessageFrame warningMessageFrame
            = new WarningMessageFrame("관심있는 카테고리 1개를 선택해주세요!");
      }

      if (accumulator == 1) {
        this.removeAll();

        titlePanel.removeAll();

        JLabel layoutLabel1 = new JLabel();
        titlePanel.add(layoutLabel1);

        JLabel recommendTitleLabel = new JLabel("당신에게 추천하는 책입니다!");
        recommendTitleLabel.setFont(new Font("Verdada", Font.BOLD, 16));
        recommendTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(recommendTitleLabel);

        JLabel layoutLabel2 = new JLabel();
        titlePanel.add(layoutLabel2);

        this.add(titlePanel, BorderLayout.PAGE_START);

        try {
          RecommendedBookPanel recommendedBookPanel = new RecommendedBookPanel(selectedCategory, bookRecommendationHistories);
          this.add(recommendedBookPanel, CENTER);
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        this.setVisible(false);
        this.setVisible(true);
      }
    });

    this.add(button, BorderLayout.PAGE_END);
    this.setVisible(true);
  }
}
