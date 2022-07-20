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
  private String title;
  private String bookAuthor;
  private String introduce;
  private String link;
  private String category;

  public Book(String imageRoot, String title, String bookAuthor, String introduce, String link, String category) {
    this.imageRoot = imageRoot;
    this.title = title;
    this.bookAuthor = bookAuthor;
    this.introduce = introduce;
    this.link = link;
    this.category = category;
  }

  public String imageRoot() {
    return imageRoot;
  }

  public String title() {
    return title;
  }

  public String bookAuthor() {
    return bookAuthor;
  }

  public String introduce() {
    return introduce;
  }

  public String link() {
    return link;
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
        && Objects.equals(this.title, otherBook.title)
        && Objects.equals(this.bookAuthor, otherBook.bookAuthor)
        && Objects.equals(this.introduce, otherBook.introduce)
        && Objects.equals(this.link, otherBook.link)
        && Objects.equals(this.category, otherBook.category);
  }
}
