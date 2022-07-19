package utils;

import models.Review;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ReviewsLoaderTest {
  @Test
  void load() throws FileNotFoundException {
    ReviewsLoader reviewsLoader = new ReviewsLoader();

    assertNotNull(reviewsLoader.load());

    List<Review> reviews = reviewsLoader.load();

    Review review1 = reviews.get(0);
    Review review2 = reviews.get(1);

    assertEquals(review1, new Review("봄이1", "1234", "객체 지향", "어렵지만 재밌네요~", 6, "DISPLAY"));
    assertEquals(review2, new Review("봄이2", "abcd", "클린 코드", "다 읽으셨나요?", 12, "DELETED"));
  }
}
