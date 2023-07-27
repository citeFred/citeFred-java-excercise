package _05collection;

import java.util.ArrayList;

public class Col_01ArrayList01 {
    public static void main(String[] args) {
        //Collection - List
        // 순서가 있는 데이터의 집합이다. 중복을 허용 한다.
        // 그럼 Array랑 무엇이 다른가? => Array는 최초 길이를 알아야 했었다. (ex int[] = new int[2] => [{},{}] 처럼)
        // 그런데 List는 처음에 길이를 몰라도 만들 수 있다!!
        // 1) Array -> 그래서 정적배열이라 부른다
        // 2) List(ArrayList) -> 동적배열이라 부른다 => 크기가 가변적으로 늘어난다)
        //  - 생성 시점에 작은 연속된 공간을 요청해서 참조형 변수들을 담아놓는다.
        //  - 값이 추가될 때 더 큰 공간이 필요하면 더 큰 공간을 받아서 저장하니까 상관없다.

        //List 선언 + (객체)생성
        ArrayList<Integer> intList = new ArrayList<Integer>();

        //ArrayList의 메서드를 사용 할 수 있다.
        //추가(c)
        //add(element) 메서드로 생성한 List에 element를 넣어보자.
        intList.add(99);
        intList.add(15);
        intList.add(3);
        //->[{99}, {15}, {3}]

        //읽기(r)
        //get(index) 메서드로 List의 index값을 통해서 List에 추가한 element를 찾아보자.
        System.out.println(intList.get(2));
        //->{3}
        //toString() 메서드로 List 전체 element들을 조회 할 수 있다.
        System.out.println(intList.toString());


        //수정(u)
        //set(index, element) 메서드로 List의 대상 index의 element를 입력한 element로 변경하자.
        intList.set(1, 10);
        //->[{99},  {10}  , {3}]

        //삭제(d)
        //remove(index) 메서드로 List의 index값을 통해서 element를 삭제하자.
        intList.remove(2);
        System.out.println(intList.toString());
        //->[{99}, {10}, {}]

        //clear() 메서드로 List의 모든 element를 삭제하자.
        intList.clear();
        System.out.println(intList.toString());
    }
}
