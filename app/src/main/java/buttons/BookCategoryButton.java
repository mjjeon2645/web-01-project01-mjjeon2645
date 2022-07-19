package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookCategoryButton extends JButton {
  public BookCategoryButton(String text) {
    this.setText(text);
    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        setBackground(Color.PINK);
      }
    });
  }
}
