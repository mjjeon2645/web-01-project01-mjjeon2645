package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
  @Test
  void creation() {
    Book book = new Book("images/books/1.png", "객체지향의 사실과 오해", "조영호",
        "객체지향의 사실과 오해』는 객체지향이란 무엇인가라는 원론적면서도 다소 위험한 질문에 답하기 위해 쓰여진 책이다. " +
            "안타깝게도 많은 사람들이 객체지향의 본질을 오해하고 있다. 가장 널리 퍼져있는 오해는 클래스가 객체지향 프로그래밍의 중심이라는 것이다. " +
            "객체지향으로 향하는 첫 걸음은 클래스가 아니라 객체를 바라보는 것에서부터 시작한다.",
        "http://www.yes24.com/Product/Goods/18249021",
        "과학/IT");
  }
}
