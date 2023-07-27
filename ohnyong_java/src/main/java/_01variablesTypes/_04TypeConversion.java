package _01variablesTypes;// import

import java.util.Scanner;

public class _04TypeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //형변환
        //ASCii Code -> TEXT
        //        int asciiNumber = sc.nextInt();
        //        char ch = (char)asciiNumber; // 문자로 형변환 해주면 숫자에 맞는 문자로 표현

        //        System.out.println(ch);

        //TEXT -> ASCii Code
        //        char letter = sc.nextLine().charAt(0);
        //        int asciiNumber2 = (int)letter;
        //
        //        System.out.println(asciiNumber2);
        // 형 변환이란? - 변수의 타입을 바꾸는 방법
        // 명시적 형변환(강제 형변환) Type Conversion
        // 문자열 -> 숫자
        // 정수 -> 실수
        // 실수 -> 정수

        // [1]double형 or float형 -> int
        // 실수 -> 정수   (0.xxxx -> 0)
        double doubleNumber = 10.12358;
        float floatNumber = 13.193F;

        int intNumber;
        intNumber = (int) doubleNumber;// double -> int
        System.out.println(intNumber);
        int intNumber2;
        intNumber2 = (int) floatNumber;
        System.out.println(intNumber2);

        // [2]int -> double
        int intNumber3 = 30;
        double doubleNumber3 = (double) intNumber3;
        System.out.println(doubleNumber3);

        ////////위 처럼 직접 지정하는 것들을 명시적인 형 변환이라 한다.

        ////////암시적인 형 변환은 아래와 같다. 자동 형변환 - Promotion
        //변수 타입별 크기 순서
        //byte(1) -> short(2) ->int(4) ->long(8) -> float(4) ->double(8)
        //1) 작은 크기의 타입이 큰 크기의 타입으로 변환은 암시적으로 형변환 가능하다.
        //byte(1) ->int(4)
        byte byteNumber = 10;
        int intNumber4 = byteNumber; //(int)를 적지 않았지만 int로 바뀌었다.
        System.out.println(intNumber4);
        //char(1 byte) ->int(4)
        char charAlphabet = 'A';
        int intNumber6 = charAlphabet; // char ->int 자동 형변환
        System.out.println(intNumber6);
        int intNumber7 = 200;
        double doubleNumber7 = intNumber7;
        System.out.println(intNumber7);

        //2) 작은 크기의 타입이 큰 크기 타입과 '계산' 될 때
        //자동으로 큰 크기의 타입으로 형 변환 된다.
        int intNumber10 = 10;
        double doubleNumber10 = 5.13;
        double result = intNumber10 + doubleNumber10;

        System.out.println("Plus=>" + result);
        //나누기
        //정수로 나누기
        int iResult = intNumber10 / 3;
        //실수로 나누기
        double dResult = intNumber10 / 12.141;

        System.out.println(iResult);
        System.out.println(dResult);
    }
}
