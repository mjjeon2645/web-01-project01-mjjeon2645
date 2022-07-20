package models;

import java.util.Objects;

public class Book {
  public static final String NOVEL = "소설";
  public static final String ESSAY = "에세이";
  public static final String POEM = "시";
  public static final String HUMANITIES = "인문학";
  public static final String SELF_DEVELOPMENT = "자기계발";
  public static final String ECONOMICS_BUSINESS = "경제/경영";
  public static final String MARKETING = "마케팅";
  public static final String MONEY_MANAGEMENT = "재테크";
  public static final String ARTS_CULTURE = "예술/문화";
  public static final String SOCIAL_POLITICS = "사회/정치";
  public static final String SCIENCE_IT = "과학/IT";
  public static final String TRAVEL = "여행";
  public static final String RELIGION = "종교";
  public static final String LIFESTYLE = "라이프";
  public static final String WEDDING_CHILDCARE = "결혼/육아";
  public static final String HEALTH = "건강";

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
}
