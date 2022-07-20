package panels;

import models.Book;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendedBookPanelTest {
  @Test
  void loadFavoriteBook() throws FileNotFoundException {
    String selectedCategory = "소설";

    RecommendedBookPanel recommendedBookPanel = new RecommendedBookPanel(selectedCategory);

    List<Book> books = new ArrayList<>();

    assertNotNull(recommendedBookPanel.recommendFavoriteBook(books, selectedCategory));
  }
}
