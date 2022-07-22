package panels;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
  private Image backgroundImage;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.backgroundImage = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(backgroundImage, 0, 0, null);
  }
}
