package _05collection;

import java.util.Stack;
public class Col_01Stack {
    public static void main(String[] args) {
        //Stack
        //수직으로 값을 쌓아놓고, 넣었다가 뺀다. Last In First Out(Basket) LIFO
        //push, peek, pop
        //사용 이유1)최근 저장된 데이터를 나열하고 싶거나
        //사용 이유2)데이터의 중복처리를 막고 싶을 때 사용

        //Stack 선언 + (객체)생성
        Stack<Integer> intStack = new Stack<Integer>();

        //Stack 메서드를 사용 할 수 있다.
        //추가
        //push(E item) 메서드로 생성한 Linked List에 item을 넣어보자.
        intStack.push(10);
        intStack.push(15);
        intStack.push(1);

        //읽기
        //peek() 메서드로 Stack의 item을 읽을 수 있다.
        //10 -> 15 -> 1 순서로 들어갔기 때문에, 맨 위에는 1이있다. 그래서 1이 나온다. basket같이 들어가기 때문에.
        System.out.println(intStack.peek());

        //추출
        //pop()은 가장 위 item을 특이하게 말그대로 꺼내면서 제거 한다.
        //ex) 1 2 3 이 차례대로 있는 Stack의 경우 peek를 하면 1 2 3 이 그대로 있지만 pop을 하면 1 2 만 남게된다.
        //pop() 메서드로 Stack의 가장 위 item을 제거하면서 value를 반환한다.
        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }
    }
}
