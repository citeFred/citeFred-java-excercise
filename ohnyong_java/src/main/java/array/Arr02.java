package array;

import java.util.Arrays;

public class Arr02 {
    public static void main(String[] args) {
        // 초기화
        // 1. 배열에 특정값 대입해서 선언
        int[] intArr = {1,2,3,4,5};
        String[] stringArr = {"a", "b", "c", "d"};

        // 2. for문을 통해서 대입
        for(int i=0;i<intArr.length;i++){
            intArr[i] = i;// i를 왼쪽 intArr에 대입한다(대입연산) == 넣는다, 담는다.
        }
        System.out.println("------");
        //2를 출력해보자. 일반 for문
        for (int i=0;i<intArr.length;i++){
            System.out.println(intArr[i]);
        }
        System.out.println("--EF--");
        //향상된 for문으로 써보자
        for (int item: intArr){
            System.out.println(item);
        }

        //Arrays Class의 메서드 사용해보기
        //Arrays.fill => 배열의 주소를 모두 같은 값으로 초기화
        Arrays.fill(intArr, 1);
        System.out.println("--after fill--");
        //향상된 for문으로 써서 값이 할당되었는지 보자.
        for (int item: intArr){
            System.out.println(item);


        }
    }
}
