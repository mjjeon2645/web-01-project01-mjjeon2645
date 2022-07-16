package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
  @Test
  void creation() {
    Review review = new Review(
        "봄이엄마",
        "객체 지향의 사실과 오해 재밌어요",
        "객체지향의사실과오해 어렵지만 재밌네요~");
  }
}
