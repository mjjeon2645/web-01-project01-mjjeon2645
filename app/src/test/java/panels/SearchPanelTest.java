package panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchPanelTest {
  @Test
  void comboBox() {
    String[] words = {"작성자", "제목", "내용"};

    JComboBox comboBox = new JComboBox(words);
    comboBox.setSelectedItem("작성자");

    assertEquals(0, comboBox.getSelectedIndex());

    comboBox.setSelectedItem("제목");

    assertEquals("제목", comboBox.getSelectedItem());
  }
}
