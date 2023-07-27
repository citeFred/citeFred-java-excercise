package _01variablesTypes;

public class _01VarFinal {
    public static void main(String[] args) {
//        변수(int라는 데이터 타입을 지정하면서 Memory(방)의 크기를 결정한다.
        int number = 5;//< 5자체가 literal == data 그 자체이며 데이터의 크기 또한 정해짐
        System.out.println(number);
//      문자(위 숫자인 int와 방의 크기가 다름)
        String ohnyong = "Hello ohnyong";
        System.out.println(ohnyong);
//        문자 타입의 a변수 에 literal Nice 값이 들어감
        String a = "Nice";
        System.out.println(a);

        //상수
        final int fianlNumber = 1;//<final 상수는 컴파일(실행) 된 후 final이란 변수에 1이란 데이터가 고정됨,
        System.out.println(fianlNumber);
//        finalNumber = 2;//<상수가 이미 윗 줄에서 실행(순차적 실행에서 해당 부분은 두번쨰임)되었기 때문에 오류가 발생함
        // a는 위에서 문자 타입 변수고 다른 값이 들어왔지만 변수기 때문에 데이터가 변함
        a = "HI";
        System.out.println(fianlNumber);//finalNumber 처럼 카멜표기법을 사용함.
        System.out.println(a);
//        const int constNumber = 2; //java에서는 const를 선언 할 수 없다? 왜일까?
        //1. 찾아보니 Java는 static final을 붙이면 된다고만 나오지 정확하게 javascript의 const와 어떤 차이가 있는지 궁금하다.
        //2. 이전 실습에서도 추상화(Abstract) 부분에서 배운 것 같다. 이부분 추상 클래스를 만들거나 인터페이스 클래스는 자동 public static final인 것으로 적용된다고 들었다.
//        안그래도 이러한 비어있는 클래스들을 만들고 연결했었는데 왜? 인것을 생각안하고 클론코딩만 했었다.
//        일단 빠르게 훑어본 것으론 키워드는 "객체 지향적 설계"를 하기 위해서고, 그렇기 때문에 상수를 따로 클래스를 만들어 줘야 한다.
//        내가 궁금한 포인트와 수준에 맞게  https://jaykaybaek.tistory.com/4에 정리되어있다. 정리를 해봐야 겠다.


//        개념 정리 필요 부분
        //Java란? 간단 역사 및 개요도 읽어보기
        //변수란? 상수란?
        //Java에서는 Camel Case로 표기한다 ex)fianlNumber - 왜? 역사나 개념 조사 필요
        //그럼 Camel Case 말고는 뭐가있을까?
//        java에선 보통 어떻게 표기하는게 일반적일까?

    }
}
