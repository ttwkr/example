package ch06.src;

import java.util.Arrays;

public class Ex6_8 {
    public static void main(String[] args) {
        Data3 d = new Data3(); // 인스턴스 생성 주소값이 d 에 저장 (0x100)
        d.x = 10;

        Data3 d2 = copy(d); // d가 복사되어  copy 함수 매개변수로 들어간다

        System.out.println("d.x = " + d.x); // d1.x 에는 0x100의 x의 값
        System.out.println("d2.x = " + d2.x); // d2.x 에는 0x200의 x의 값
    }
    static Data3 copy(Data3 d){ // 복사된 값(0x100)이 매개변수로 들어옴
        Data3 tmp = new Data3(); // 인스턴스 생성성 주소값이 tmp 에 저장된다 (0x200)
        tmp.x = d.x; //0x200의 x에 0x100의 x값이 들어간다
        return tmp; // tmp 에 저장된 주소가 리턴된다
    }
}

class Data3{
    int x;
}
