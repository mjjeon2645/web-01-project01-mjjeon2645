package models;

import java.util.Objects;

public class Book {
  private String imageRoot;
  private String bookTitle;
  private String bookAuthor;
  private String url;
  private String category;

  public Book(String imageRoot, String bookTitle, String bookAuthor, String url, String category) {
    this.imageRoot = imageRoot;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.url = url;
    this.category = category;
  }

  public String imageRoot() {
    return imageRoot;
  }

  public String bookTitle() {
    return bookTitle;
  }

  public String bookAuthor() {
    return bookAuthor;
  }

  public String url() {
    return url;
  }

  public String category() {
    return category;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Book otherBook = (Book) other;
    return Objects.equals(this.imageRoot, otherBook.imageRoot)
        && Objects.equals(this.bookTitle, otherBook.bookTitle)
        && Objects.equals(this.bookAuthor, otherBook.bookAuthor)
        && Objects.equals(this.url, otherBook.url)
        && Objects.equals(this.category, otherBook.category);
  }

  @Override
  public String toString() {
    return "이미지주소: " + imageRoot + "책 제목: " + bookTitle +
        "책 저자: " + bookAuthor + "링크: " + url + "카테고리: " + category;
  }
}
