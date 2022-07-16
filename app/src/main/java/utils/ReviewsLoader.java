package utils;

import models.Review;

import java.io.File;
import java.io.FileNotFoundException;
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

      String[] words = line.split(",");

      Review review = new Review(words[0], words[1], words[2], words[3]);
      reviews.add(review);
    }

    return reviews;
  }
}
