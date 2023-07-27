package _05collection;

import java.util.Set;
import java.util.HashSet;

public class Col_03Set {
    public static void main(String[] args) {
        //Set(집합)
        // 순서가 없고, 중복이 없다.
        // 순서가 보장되지 않는 대신 중복을 허용하지 않도록하는 프로그램에서 사용 할 수 있는 자료구조.
        // Set -> 그냥 쓸수도 있음,
        // 그러나 HashSet, TreeSet 등으로 응용해서 같이 사용 가능
        // HashSet은 Set 인터페이스를 구현한 가장 대표적인 컬렉션이다.
        // 저장순서를 유지하고자 한다면 LinkedHashSet을 사용해야한다.
        // Set은 생성자가 없는 껍데기라서 바로 생성 할 수 없음!!
        // 그래서 생성자가 존재하는 HashSet을 이용해서 -> Set을 구현해볼 수 있음

        //Set 선언 + (객체)생성
        Set<Integer> intSet = new HashSet<>();

        //추가(c)
        //add(element) 메서드로 생성한 Set에 element를 넣어보자.
        intSet.add(2);
        intSet.add(51);
        intSet.add(2);
        intSet.add(6);
        intSet.add(2);
        intSet.add(282);

        //읽기
        for (Integer value: intSet){
            System.out.println(value);
        }
        //2, 51, 6, 282 => 2가 3번 add됐지만 중복을 허용하지 않아 1개로만 나타난다.

        //포함여부확인
        //contains()
        System.out.println(intSet.contains(3));
        System.out.println(intSet.contains(2));

        //size()
        System.out.println(intSet.size());
        //isEmpty()
        System.out.println(intSet.isEmpty());
    }
}
