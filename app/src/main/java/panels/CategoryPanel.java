package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryPanel extends JPanel {
  private JCheckBox checkBox;
  private String category;

  public CategoryPanel(String category) {
    this.category = category;

    this.setLayout(new BorderLayout());
    this.setOpaque(false);
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }

        if (!checkBox.isSelected()) {
          checkBox.setSelected(true);
        }
      }
    });

    checkBox = new JCheckBox();
    this.add(checkBox, BorderLayout.WEST);

    JLabel label = new JLabel(category);
    label.setFont(new Font("Verdada", Font.PLAIN, 15));
    label.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }

        if (!checkBox.isSelected()) {
          checkBox.setSelected(true);
        }
      }
    });

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
