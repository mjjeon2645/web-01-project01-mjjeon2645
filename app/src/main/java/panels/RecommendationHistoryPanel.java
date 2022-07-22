package panels;

import models.RecommendationHistory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class RecommendationHistoryPanel extends JPanel {
  private JPanel historyPanel;
  private List<RecommendationHistory> recommendationHistories;

  public RecommendationHistoryPanel(List<RecommendationHistory> recommendationHistories) {
    this.recommendationHistories = recommendationHistories;

    this.setOpaque(false);
    this.setLayout(new BorderLayout());

    initTitleSection();

    initHistorySection();

    for (RecommendationHistory recommendationHistory : recommendationHistories) {

      initFavoriteBookHistory(recommendationHistory);

      initChallengeBookHistory(recommendationHistory);
    }
  }

  public void initTitleSection() {
    JPanel titlePanel = new JPanel();
    titlePanel.setOpaque(false);
    titlePanel.setLayout(new GridLayout(0, 1, 0, 20));
    this.add(titlePanel, BorderLayout.PAGE_START);

    JLabel layoutLabel1 = new JLabel("  ");
    titlePanel.add(layoutLabel1);

    JLabel titleLabel = new JLabel("책 제목을 클릭하면 상세&구매 페이지로 이동합니다 :)");
    titleLabel.setFont(new Font("Verdada", Font.BOLD, 15));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(titleLabel);

    JLabel layoutLabel2 = new JLabel("  ");
    titlePanel.add(layoutLabel2);
  }

  public void initHistorySection() {
    historyPanel = new JPanel();
    historyPanel.setLayout(new GridLayout(0, 2, 30, 20));
    historyPanel.setOpaque(false);
    this.add(historyPanel, BorderLayout.CENTER);
  }

  public void initFavoriteBookHistory(RecommendationHistory recommendationHistory) {
    JPanel favoritePanel = new JPanel();
    favoritePanel.setBorder(new LineBorder(new Color(0, 90, 107)));
    favoritePanel.setBackground(new Color(255, 255, 255, 71));
    favoritePanel.setLayout(new GridLayout(0, 1, 10, 10));
    historyPanel.add(favoritePanel);

    JLabel favoriteTitleLabel = new JLabel("잘 어울리는 책");
    favoriteTitleLabel.setFont(new Font("Verdada", Font.BOLD, 13));
    favoritePanel.add(favoriteTitleLabel);

    JLabel favoriteBookTitleLabel = new JLabel("제목: " + recommendationHistory.favoriteBookTitle());
    favoriteBookTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
            URI uri = new URI(recommendationHistory.favoriteBookUrl());
            desktop.browse(uri);
          } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    favoritePanel.add(favoriteBookTitleLabel);

    JLabel favoriteBookAuthorLabel = new JLabel("저자: " + recommendationHistory.favoriteBookAuthor());
    favoritePanel.add(favoriteBookAuthorLabel);
  }

  public void initChallengeBookHistory(RecommendationHistory recommendationHistory) {
    JPanel challengePanel = new JPanel();
    challengePanel.setBorder(new LineBorder(new Color(253, 21, 124)));
    challengePanel.setBackground(new Color(255, 255, 255, 71));
    challengePanel.setLayout(new GridLayout(0, 1, 10, 10));
    historyPanel.add(challengePanel);

    JLabel challengeTitleLabel = new JLabel("도전을 위한 책");
    challengeTitleLabel.setFont(new Font("Verdada", Font.BOLD, 13));
    challengePanel.add(challengeTitleLabel);

    JLabel challengeBookTitleLabel = new JLabel("제목: " + recommendationHistory.challengeBookTitle());
    challengeBookTitleLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
            URI uri = new URI(recommendationHistory.challengeBookUrl());
            desktop.browse(uri);
          } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    challengePanel.add(challengeBookTitleLabel);

    JLabel challengeBookAuthorLabel = new JLabel("저자:" + recommendationHistory.challengeBookAuthor());
    challengePanel.add(challengeBookAuthorLabel);
  }
}
