package _05collection;

import java.util.LinkedList;
import java.util.Queue;

public class Col_02Queue {
    public static void main(String[] args) {
        // Queue
        //원통에 한쪽으로 값이 들어가고 반대쪽으로 먼저들어간것이 나온다. FirstInFisrtOut FIFO
        //add, peek, poll
        //생성자가 없는 인터페이스라서 => new 로 만들수가 없다. 생성자가 없기 때문.

        //Queue 선언 + (객체)생성
        Queue<Integer> intQueue = new LinkedList<>();

        //인터페이스기 때문에 Linked List의 메서드를 사용 해야 한다.
        //추가(c)
        //add(element) 메서드로 생성한 Queue에 element를 넣어보자.
        intQueue.add(1);
        intQueue.add(5);
        intQueue.add(9);

        //읽기(r)
        //peek(item) 메서드로 Stack의 item을 읽을 수 있다.
        //10 -> 15 -> 1 순서로 들어갔기 때문에, 맨 위에는 1이있다. 그래서 1이 나온다. basket같이 들어가기 때문에.
        System.out.println(intQueue.peek());

        //추출(r-d)
        //poll() 메서드로 Queue에 추가한 element를 들어간 순서대로 꺼내면서 제거 한다.
        while(!intQueue.isEmpty()){
            System.out.println(intQueue.poll());
        }
        //1-5-9순서로 넣었는데 1-5-9 순서로 나왔다.

    }
}
