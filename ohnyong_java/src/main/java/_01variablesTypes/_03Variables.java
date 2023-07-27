package _01variablesTypes;

import java.util.Arrays;

public class _03Variables {
    public static void main(String[] args) {
        //Primary Types
        // 변수를 선언 해보자 => 타입 이름 = 값;
        //1) 논리 Boolean
        boolean flag = true;
        System.out.println(flag);
        flag = false;
        System.out.println(flag);
        //        flag = 1;

        //2) 문자 char
        //        char alphabet = a;
        char alphabet2 = 'B';

        //        System.out.println(alphabet);
        System.out.println(alphabet2);

        //3) 정수
        byte byteNumber = 127; // -127 ~ 127(1byte)
        //        byte byteNumber = 300; // Over
        short shortNumber = 32767; // 32,768 ~ 32767
        int intNumber = 2147483647;
        long longNumber = 214783647L;

        System.out.println(byteNumber);
        System.out.println(shortNumber);
        System.out.println(intNumber);
        System.out.println(longNumber);

        //4) 실수
        float floatNumber = 0.123F;
        double doubleNumber = 0.1231231;

        System.out.println(floatNumber);
        System.out.println(doubleNumber);

        //Reference Types
        //1) 문자열 변수
        String helloWorld = "Hello World!";
        String helloWorld2 = "Hello World!";

        System.out.println(helloWorld);

        System.out.println(helloWorld == helloWorld2); //Hash 값이 같다. 다르게 하려면, New로 객체 생성

        String helloWorld3 = new String("helloworld");
        String helloWorld4 = new String("helloworld");

        System.out.println(helloWorld3 == helloWorld4); //Hash 값이 다르다. New로 객체 생성했기 때문에.

        //2) 배열
        int[] a = {1, 2, 3};

        System.out.println(a); //주소값 Heap
        //실제 값을 출력하려면
        System.out.println(Arrays.toString(a));


        //3) Wrapper Class
        int number = 21;
        Integer num = new Integer(number); //<- 이 과정을 boxing 한다고 함
        //위 표현은 'Integer(int)' is deprecated 옛날 방식이라서 이렇게 안해도 된다.
        System.out.println(num);

        Integer num2 = 23;
        System.out.println(num2);

    }
}
