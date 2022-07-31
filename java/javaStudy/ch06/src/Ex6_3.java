package ch06.src;

public class Ex6_3 {
    public static void main(String[] args) {
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println(c1.kind+ ", " + c1.number + ", " + Card.width + " + " + Card.height);
        System.out.println(c2.kind+ ", " + c2.number + ", " + Card.width + " + " + Card.height);

        Card.height = 10; // 클래스 변수(static)라서 한번만 바꿔도 다른 인스턴스의 값이 다 바뀐다
        Card.width = 5;

        System.out.println(c1.kind+ ", " + c1.number + ", " + Card.width + " + " + Card.height);
        System.out.println(c2.kind+ ", " + c2.number + ", " + Card.width + " + " + Card.height);
    }
}

class Card {
    String kind;
    int number;

    static int width = 100;
    static int height = 250;
}
