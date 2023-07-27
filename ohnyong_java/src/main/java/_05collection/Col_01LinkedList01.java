package _05collection;

import java.util.LinkedList;

public class Col_01LinkedList01 {
    public static void main(String[] args) {
        // Linked List
        // 메모리에 남는 공간을 요청해서 여기 저기 나누어서 실제 값을 담아놓는다.
        // 실제 값이 있는 주소값으로 목록을 구성하고 저장하는 자료 구조

        // 기본적인 기능은 -> ArrayList와 동일!
        // LinkedList 는 값 -> 여기저기 나누어 놓는다? => 조회, 찾는속도가 느리다
        // 하지만 값을 추가하거나, 삭제할 때는 빠르다. 아무렇게나 알아서 저장하기 때문에

        //LinkedList 선언 + (객체)생성
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //LinkedList의 메서드를 사용 할 수 있다.
        //추가(c)
        //add(element) 메서드로 생성한 Linked List에 element를 넣어보자.
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(200);
        linkedList.add(2, 4);
        //[{1},{2},{4},{3},{200}]


        //읽기(r)
        //get(index) 메서드로 Linked List의 index값을 통해서 List에 추가한 element를 찾아보자.
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        //toString() 메서드로 Linked List 전체 element들을 조회 할 수 있다.
        System.out.println(linkedList.toString()); // 조회 할 때 ArrayList보다 속도가 현저히 느리다.

        //수정(u)
        //set(index, element) 메서드로 Linked List의 대상 index의 element를 입력한 element로 변경하자.
        linkedList.set(1, 30);
        System.out.println(linkedList.toString());
        //[{1},{30},{4},{3},{200}]


        //삭제(d)
        //remove(index) 메서드로 Linked List의 index값을 통해서 element를 삭제하자.
        linkedList.remove(1);
        System.out.println(linkedList.toString());
        //[{1},{4},{3},{200}]

        //clear() 메서드로 List의 모든 element를 삭제하자.
        linkedList.clear();
        //[]

    }
}
