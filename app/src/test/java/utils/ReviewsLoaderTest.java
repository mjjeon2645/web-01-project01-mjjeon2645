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

    assertNotNull(reviewsLoader.load());;
  }
}
