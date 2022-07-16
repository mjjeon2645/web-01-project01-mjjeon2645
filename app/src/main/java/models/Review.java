package models;

public class Review {
  private static final String DISPLAY = "DISPLAY";
  private static final String DELETED = "DELETED";

  private String author;
  private String title;
  private String text;
  private String state;

  public Review(String author, String title, String text) {
    this.author = author;
    this.title = title;
    this.text = text;
    this.state = DISPLAY;
  }

  public Review(String author, String title, String text, String state) {
    this.author = author;
    this.title = title;
    this.text = text;
    this.state = state;
  }
}
