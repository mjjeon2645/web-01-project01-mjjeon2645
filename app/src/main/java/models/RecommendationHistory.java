package models;

public class RecommendationHistory {

  private Book favoriteBook;
  private Book challengeBook;

  public RecommendationHistory(Book favoriteBook, Book challengeBook) {
    this.favoriteBook = favoriteBook;
    this.challengeBook = challengeBook;
  }

  public String toCsvRow() {
    return String.join("///", favoriteBook.imageRoot(), favoriteBook.bookTitle(),
        favoriteBook.bookAuthor(), favoriteBook.url(), favoriteBook.category(),
        challengeBook.imageRoot(), challengeBook.bookTitle(), challengeBook.bookAuthor(),
        challengeBook.url(), challengeBook.category());
  }

  public String favoriteBookTitle() {
    return favoriteBook.bookTitle();
  }

  public String favoriteBookAuthor() {
    return favoriteBook.bookAuthor();
  }

  public String favoriteBookUrl() {
    return favoriteBook.url();
  }

  public String challengeBookTitle() {
    return challengeBook.bookTitle();
  }

  public String challengeBookAuthor() {
    return challengeBook.bookAuthor();
  }

  public String challengeBookUrl() {
    return challengeBook.url();
  }
}
