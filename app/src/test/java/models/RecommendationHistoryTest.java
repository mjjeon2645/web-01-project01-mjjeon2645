package models;

import org.junit.jupiter.api.Test;

import java.util.List;

class RecommendationHistoryTest {
  @Test
  void creation() {
    List<Book> books = List.of(
        new Book("images/books/1.png", "소년이 온다", "한강", "http://www.yes24.com/Product/Goods/13137546", "소설"),
        new Book("images/books/15.png", "기획의 정석", "박신영", "http://www.yes24.com/Product/Goods/110241725", "자기계발")
    );

    Book favoriteBook = books.get(0);
    Book challengeBook = books.get(1);

    RecommendationHistory bookRecommendationHistory = new RecommendationHistory(favoriteBook, challengeBook);
  }
}
