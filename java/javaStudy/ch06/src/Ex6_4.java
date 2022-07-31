package ch06.src;

public class Ex6_4 {
    public static void main(String[] args) {

        MyMath myMath = new MyMath();
        long addResult = myMath.add(4L, 5L);
        long subResult = myMath.subtract(5L, 6L);
        long mulResult = myMath.multiply(100L, 2L);
        long divResult = myMath.divide(100L, 2L);

        myMath.printGugudan(3);

        System.out.println(addResult);
        System.out.println(subResult);
        System.out.println(mulResult);
        System.out.println(divResult);
    }
}

class MyMath {
    void printGugudan(int dan) {
        if( !(2 < dan && dan < 9)){
            return;
        }
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", dan, i, dan * i);
        }
    }

    long add(long a, long b) {
        return a + b;
    }

    long subtract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    long divide(long a, long b) {
        return a / b;
    }
}
