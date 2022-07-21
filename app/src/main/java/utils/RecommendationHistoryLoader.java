package utils;

import models.Book;
import models.RecommendationHistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationHistoryLoader {
  public List<RecommendationHistory> load() throws FileNotFoundException {
    List<RecommendationHistory> recommendationHistories = new ArrayList<>();

    File file = new File("recommendationhistories.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      RecommendationHistory recommendationHistory= parseRecommendationHistory(line);
      recommendationHistories.add(recommendationHistory);
    }

    return recommendationHistories;
  }

  public void save(List<RecommendationHistory> recommendationHistories) throws IOException {
    FileWriter fileWriter = new FileWriter("recommendationhistories.csv");
    for (RecommendationHistory recommendationHistory : recommendationHistories) {
      String line = recommendationHistory.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }

  public RecommendationHistory parseRecommendationHistory(String text) {
    String[] words = text.split("///");

    return new RecommendationHistory(new Book(words[0], words[1], words[2], words[3], words[4]),
        new Book(words[5], words[6], words[7], words[8], words[9]));
  }
}
