package ch06.src;

public class Ex06_13 {
    public static void main(String[] args) {
        Car car = new Car("White", "Auto", 4);
        // 1. 참조변수 car 가 메모리에 생성
        // 2. new 로 객체 메모리에 생성(주소저장)
        // 3. Car(...) 객체 초기화
        // 4. car 에 대입
    }
}

class Car{
    String color;
    String gearType;
    int door;

    Car(String c, String g, int d){
        color = c;
        gearType = g;
        door = d;
    }
}
