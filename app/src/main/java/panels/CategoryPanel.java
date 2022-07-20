package panels;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
  private JCheckBox checkBox;
  private String category;

  public CategoryPanel(String category) {
    this.category = category;

    this.setLayout(new BorderLayout());
    this.setOpaque(false);
    checkBox = new JCheckBox();
    this.add(checkBox, BorderLayout.WEST);

    JLabel label = new JLabel(category);
    label.setFont(new Font("Verdada", Font.PLAIN, 14));
    this.add(label);
  }

  public int countSelectedCheckBox() {
    if (checkBox.isSelected()) {
      return 1;
    }

    return 0;
  }

  public String selectedCategory() {
    if (checkBox.isSelected()) {
      String[] words = category.split(" ");
      return words[0];
    }

    return "";
  }
}
