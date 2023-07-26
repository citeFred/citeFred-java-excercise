package array;

public class Arr01 {
    public static void main(String[] args) {
        // 배열 생성
        int[] intArray = new int[3]; //정수형 배열 초기값 0 => {0,0,0}
        boolean[] booleanArray = new boolean[3]; //논리형 배열 초기값 false => {false, false, false}
        String[] stringArray = new String[3]; //문자형 배열 초기값 null => {"", "", ""}

        // 배열 선언 -> 나중에 초기화 하는 생성법
        int[] intArray2;
        intArray2 = new int[3]; //{0,0,0}

        // 생성한 배열을 '순회' -> 배열의 값을 하나씩 뽑아서 조회한다.
        // 1) 단건 조회
        System.out.println(intArray[0]); //index 0,1,2 처럼 접근
        // 2) 다건 조회 => 반복문을 이용하자 --------IMPORTANT---------
        for (int i = 0; i < intArray2.length; i++) {
            System.out.println(intArray2[i]); //i => index로 대입되니까
        }

    }
}
