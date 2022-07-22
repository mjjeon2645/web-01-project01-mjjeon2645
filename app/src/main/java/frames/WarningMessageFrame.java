package frames;

import javax.swing.*;
import java.awt.*;

public class WarningMessageFrame extends JFrame {
  public WarningMessageFrame(String message) {
    this.setTitle("warning");
    this.setLayout(new GridLayout(2, 1));
    this.setSize(250, 130);
    this.setLocation(700, 300);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);

    JLabel messageLabel = new JLabel(message);
    messageLabel.setHorizontalAlignment(JLabel.CENTER);
    this.add(messageLabel);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      this.setVisible(false);
    });
    this.add(button);
  }
}
