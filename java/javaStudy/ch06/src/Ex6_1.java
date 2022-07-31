package ch06.src;

public class Ex6_1 {
    public static void main(String[] args){

        Tv tv1 = new Tv();
        Tv tv2 = new Tv();
        System.out.println(tv1); // new 는 변수에  주소를 저장한다
        System.out.println(tv2); // new 는 변수에 주소를 넣는데 새로운 객체니까 tv1과 다른 주소에 넣는다

        tv2 = tv1;
        System.out.println(tv2); // tv2에 tv1 객체의 주소를 넣는다 -> t2 객체는 필요없어진다


        tv1.channel = 8;
        tv1.channelDown();

        System.out.println(tv1.channel);
        System.out.println(tv2.channel);

    }
}

class Tv {
    String color;
    boolean power;
    int channel;

    void power() { power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}

}

