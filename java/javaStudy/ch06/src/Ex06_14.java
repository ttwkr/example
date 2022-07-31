package ch06.src;

public class Ex06_14 {
    public static void main(String[] args) {

    }
}

class Car2{
    String color;
    String gearType;
    int door;

//    Car2(){
//        door = 4;
//        Car2("white", "auto", door); //다른 생성자 호출시 무조건 첫줄에 해야한다 , 다른 생성자 호출시 this 를 써라
//    }

    Car2(){
        this("white", "auto", 4); // 생성자 안에서 다른 생성자를 호출할때 this 를 쓴다
    }

    Car2(String color){
        this(color, "auto", 3);
    }

    Car2(String color, String gearType, int door){
        this.color = color; // 원래 인스턴스변수는 참조변수.변수이름으로 선언한다
        this.gearType = gearType;
        this.door = door;
    }
}

