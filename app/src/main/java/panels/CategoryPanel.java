//TODO. 아직 사용하지 않고 있으므로 추후 활용 필요

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

  public JCheckBox checkBox() {
    return checkBox;
  }
}
