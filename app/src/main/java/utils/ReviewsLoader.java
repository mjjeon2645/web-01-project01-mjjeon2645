package utils;

import models.Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewsLoader {
  public List<Review> load() throws FileNotFoundException {
    List<Review> reviews = new ArrayList<>();

    File file = new File("reviewsdata.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Review review = parseReview(line);
      reviews.add(review);
    }

    return reviews;
  }

  public void saveReviews(List<Review> reviews) throws IOException {
    FileWriter fileWriter = new FileWriter("reviewsdata.csv");
    for(Review review : reviews) {
      String line = review.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }

  public Review parseReview(String text) {
    String[] words = text.split(",");

    return new Review(words[0], words[1], words[2], words[3]);
  }
}
