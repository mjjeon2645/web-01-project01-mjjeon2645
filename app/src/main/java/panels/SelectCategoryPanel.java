package panels;

import frames.WarningMessageFrame;

import javax.swing.*;
import java.awt.*;

public class SelectCategoryPanel extends JPanel {
  private final JPanel choicePanel;

  private JCheckBox novelCheckBox;
  private JCheckBox essayCheckBox;
  private JCheckBox poemCheckBox;
  private JCheckBox humanitiesCheckBox;
  private JCheckBox selfDevelopmentCheckBox;
  private JCheckBox economicsBusinessCheckBox;
  private JCheckBox marketingCheckBox;
  private JCheckBox moneyManagementCheckBox;
  private JCheckBox artsCultureCheckBox;
  private JCheckBox socialPoliticsCheckBox;
  private JCheckBox scienceCheckBox;
  private JCheckBox travelCheckBox;
  private JCheckBox religionCheckBox;
  private JCheckBox lifeStyleCheckBox;
  private JCheckBox weddingChildcareCheckBox;
  private JCheckBox healthCheckBox;

  public SelectCategoryPanel() {
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

    JLabel subtitleLabel1 = new JLabel("관심분야 3개를 선택하시면");
    subtitleLabel1.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel1);

    JLabel subtitleLabel2 = new JLabel("분야에 맞는 책을 추천드려요.");
    subtitleLabel2.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(subtitleLabel2);

    choicePanel = new JPanel();
    choicePanel.setLayout(new GridLayout(6, 4, 30, 20));
    choicePanel.setOpaque(false);
    this.add(choicePanel, BorderLayout.CENTER);

    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());

    // TODO. 제대로 구현할 수 있을 때 다시 사용하기
//    String[] categories = new String[]
//        {"소설\uD83D\uDE00", "에세이\uD83C\uDF31", "시\uD83D\uDCDC",
//            "인문학\uD83D\uDC64", "자기계발\uD83E\uDD34", "경제/경영\uD83C\uDF93",
//            "마케팅\uD83D\uDD76", "재테크\uD83D\uDCC8", "예술/문화\uD83C\uDF39",
//            "사회/정치\uD83D\uDC40", "과학\uD83D\uDEF0", "여행\uD83D\uDEE9",
//            "종교\uD83D\uDE4F", "라이프\uD83C\uDFD6", "결혼/육아\uD83D\uDC8D",
//            "건강\uD83C\uDFD3"};
//
//    for (int i = 0; i < categories.length; i += 1) {
//      choicePanel.add(new CategoryPanel(categories[i]));
//    }

    initNovelForm();
    initEssayForm();
    initPoemForm();
    initHumanitiesForm();
    initSelfDevelopmentForm();
    initEconomicsBusinessForm();
    initMarketingForm();
    initMoneyManagementForm();
    initArtsCultureForm();
    initSocialPoliticsForm();
    initScienceForm();
    initTravelForm();
    initReligionForm();
    initLifeStyleForm();
    initWeddingChildcareForm();
    initHealthForm();


    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());
    choicePanel.add(new JLabel());

    JButton button = new JButton("추천 책 만나러가기 GO!");
    button.setPreferredSize(new Dimension(130, 45));
    button.addActionListener(event -> {
      int accumulator = count(novelCheckBox) + count(essayCheckBox)
          + count(poemCheckBox) + count(humanitiesCheckBox)
          + count(selfDevelopmentCheckBox) + count(economicsBusinessCheckBox)
          + count(marketingCheckBox) + count(moneyManagementCheckBox)
          + count(artsCultureCheckBox) + count(socialPoliticsCheckBox)
          + count(scienceCheckBox) + count(travelCheckBox)
          + count(religionCheckBox) + count(lifeStyleCheckBox)
          + count(weddingChildcareCheckBox) + count(healthCheckBox);

      if (accumulator != 3) {
        WarningMessageFrame warningMessageFrame
            = new WarningMessageFrame("관심있는 카테고리 3개를 선택해주세요!");
      }
    });

    this.add(button, BorderLayout.PAGE_END);
    this.setVisible(true);
  }

  public void initNovelForm() {
    JPanel novelPanel = new JPanel();
    novelPanel.setLayout(new BorderLayout());
    novelPanel.setOpaque(false);
    choicePanel.add(novelPanel);

    novelCheckBox = new JCheckBox();
    novelPanel.add(novelCheckBox, BorderLayout.WEST);

    JLabel novelLabel = new JLabel("소설\uD83D\uDE00");
    novelLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    novelPanel.add(novelLabel);
  }

  public void initEssayForm() {
    JPanel essayPanel = new JPanel();
    essayPanel.setLayout(new BorderLayout());
    essayPanel.setOpaque(false);
    choicePanel.add(essayPanel);

    essayCheckBox = new JCheckBox();
    essayPanel.add(essayCheckBox, BorderLayout.WEST);

    JLabel essayLabel = new JLabel("에세이\uD83C\uDF31");
    essayLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    essayPanel.add(essayLabel);
  }

  public void initPoemForm() {
    JPanel poemPanel = new JPanel();
    poemPanel.setLayout(new BorderLayout());
    poemPanel.setOpaque(false);
    choicePanel.add(poemPanel);

    poemCheckBox = new JCheckBox();
    poemPanel.add(poemCheckBox, BorderLayout.WEST);

    JLabel poemLabel = new JLabel("시\uD83D\uDCDC");
    poemLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    poemPanel.add(poemLabel);
  }

  public void initHumanitiesForm() {
    JPanel humanitiesPanel = new JPanel();
    humanitiesPanel.setLayout(new BorderLayout());
    humanitiesPanel.setOpaque(false);
    choicePanel.add(humanitiesPanel);

    humanitiesCheckBox = new JCheckBox();
    humanitiesPanel.add(humanitiesCheckBox, BorderLayout.WEST);

    JLabel humanitiesLabel = new JLabel("인문학\uD83D\uDC64");
    humanitiesLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    humanitiesPanel.add(humanitiesLabel);
  }

  public void initSelfDevelopmentForm() {
    JPanel selfDevelopmentPanel = new JPanel();
    selfDevelopmentPanel.setLayout(new BorderLayout());
    selfDevelopmentPanel.setOpaque(false);
    choicePanel.add(selfDevelopmentPanel);

    selfDevelopmentCheckBox = new JCheckBox();
    selfDevelopmentPanel.add(selfDevelopmentCheckBox, BorderLayout.WEST);

    JLabel selfDevelopmentLabel = new JLabel("자기계발\uD83E\uDD34");
    selfDevelopmentLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    selfDevelopmentPanel.add(selfDevelopmentLabel);
  }

  public void initEconomicsBusinessForm() {
    JPanel economicsBusinessPanel = new JPanel();
    economicsBusinessPanel.setLayout(new BorderLayout());
    economicsBusinessPanel.setOpaque(false);
    choicePanel.add(economicsBusinessPanel);

    economicsBusinessCheckBox = new JCheckBox();
    economicsBusinessPanel.add(economicsBusinessCheckBox, BorderLayout.WEST);

    JLabel economicsBusinessLabel = new JLabel("경제/경영\uD83C\uDF93");
    economicsBusinessLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    economicsBusinessPanel.add(economicsBusinessLabel);
  }

  public void initMarketingForm() {
    JPanel marketingPanel = new JPanel();
    marketingPanel.setLayout(new BorderLayout());
    marketingPanel.setOpaque(false);
    choicePanel.add(marketingPanel);

    marketingCheckBox = new JCheckBox();
    marketingPanel.add(marketingCheckBox, BorderLayout.WEST);

    JLabel marketingLabel = new JLabel("마케팅\uD83D\uDD76");
    marketingLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    marketingPanel.add(marketingLabel);
  }

  public void initMoneyManagementForm() {
    JPanel moneyManagementPanel = new JPanel();
    moneyManagementPanel.setLayout(new BorderLayout());
    moneyManagementPanel.setOpaque(false);
    choicePanel.add(moneyManagementPanel);

    moneyManagementCheckBox = new JCheckBox();
    moneyManagementPanel.add(moneyManagementCheckBox, BorderLayout.WEST);

    JLabel moneyManagementLabel = new JLabel("재테크\uD83D\uDCC8");
    moneyManagementLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    moneyManagementPanel.add(moneyManagementLabel);
  }

  public void initArtsCultureForm() {
    JPanel artsCulturePanel = new JPanel();
    artsCulturePanel.setLayout(new BorderLayout());
    artsCulturePanel.setOpaque(false);
    choicePanel.add(artsCulturePanel);

    artsCultureCheckBox = new JCheckBox();
    artsCulturePanel.add(artsCultureCheckBox, BorderLayout.WEST);

    JLabel artsCultureLabel = new JLabel("예술/문화\uD83C\uDF39");
    artsCultureLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    artsCulturePanel.add(artsCultureLabel);
  }

  public void initSocialPoliticsForm() {
    JPanel socialPoliticsPanel = new JPanel();
    socialPoliticsPanel.setLayout(new BorderLayout());
    socialPoliticsPanel.setOpaque(false);
    choicePanel.add(socialPoliticsPanel);

    socialPoliticsCheckBox = new JCheckBox();
    socialPoliticsPanel.add(socialPoliticsCheckBox, BorderLayout.WEST);

    JLabel socialPoliticsLabel = new JLabel("사회/정치\uD83D\uDC40");
    socialPoliticsLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    socialPoliticsPanel.add(socialPoliticsLabel);
  }

  public void initScienceForm() {
    JPanel sciencePanel = new JPanel();
    sciencePanel.setLayout(new BorderLayout());
    sciencePanel.setOpaque(false);
    choicePanel.add(sciencePanel);

    scienceCheckBox = new JCheckBox();
    sciencePanel.add(scienceCheckBox, BorderLayout.WEST);

    JLabel scienceLabel = new JLabel("과학\uD83D\uDEF0");
    scienceLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    sciencePanel.add(scienceLabel);
  }

  public void initTravelForm() {
    JPanel travelPanel = new JPanel();
    travelPanel.setLayout(new BorderLayout());
    travelPanel.setOpaque(false);
    choicePanel.add(travelPanel);

    travelCheckBox = new JCheckBox();
    travelPanel.add(travelCheckBox, BorderLayout.WEST);

    JLabel travelLabel = new JLabel("여행\uD83D\uDEE9");
    travelLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    travelPanel.add(travelLabel);
  }

  public void initReligionForm() {
    JPanel religionPanel = new JPanel();
    religionPanel.setLayout(new BorderLayout());
    religionPanel.setOpaque(false);
    choicePanel.add(religionPanel);

    religionCheckBox = new JCheckBox();
    religionPanel.add(religionCheckBox, BorderLayout.WEST);

    JLabel religionLabel = new JLabel("종교\uD83D\uDE4F");
    religionLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    religionPanel.add(religionLabel);
  }

  public void initLifeStyleForm() {
    JPanel lifeStylePanel = new JPanel();
    lifeStylePanel.setLayout(new BorderLayout());
    lifeStylePanel.setOpaque(false);
    choicePanel.add(lifeStylePanel);

    lifeStyleCheckBox = new JCheckBox();
    lifeStylePanel.add(lifeStyleCheckBox, BorderLayout.WEST);

    JLabel lifeStyleLabel = new JLabel("라이프\uD83C\uDFD6");
    lifeStyleLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    lifeStylePanel.add(lifeStyleLabel);
  }

  public void initWeddingChildcareForm() {
    JPanel weddingChildcarePanel = new JPanel();
    weddingChildcarePanel.setLayout(new BorderLayout());
    weddingChildcarePanel.setOpaque(false);
    choicePanel.add(weddingChildcarePanel);

    weddingChildcareCheckBox = new JCheckBox();
    weddingChildcarePanel.add(weddingChildcareCheckBox, BorderLayout.WEST);

    JLabel weddingChildcareLabel = new JLabel("결혼/육아\uD83D\uDC8D");
    weddingChildcareLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    weddingChildcarePanel.add(weddingChildcareLabel);
  }

  public void initHealthForm() {
    JPanel healthPanel = new JPanel();
    healthPanel.setLayout(new BorderLayout());
    healthPanel.setOpaque(false);
    choicePanel.add(healthPanel);

    healthCheckBox = new JCheckBox();
    healthPanel.add(healthCheckBox, BorderLayout.WEST);

    JLabel healthLabel = new JLabel("건강\uD83C\uDFD3");
    healthLabel.setFont(new Font("Verdada", Font.PLAIN, 14));
    healthPanel.add(healthLabel);
  }

  public int count(JCheckBox checkBox) {
    if (checkBox.isSelected()) {
      return 1;
    }
    return 0;
  }
}
