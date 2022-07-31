package ch06.src;

public class Ex06_11 {
    public static void main(String[] args) {
        Data_1 d1 = new Data_1(); // 기본 생성자가 컴파일러가 자동으로 생성해준다
//        Data_2 d2 = new Data_2(); // 여기에는 생성자를 따로 만들어줘서 기본생성자를 컴파일러가 만들어주지 않는다
    }


}

class Data_1{
    int value;
}


class Data_2{

    int value;

    Data_2(int x){
        value = x;
    }
}