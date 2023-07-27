package _04array;

public class Arr05 {
    public static void main(String[] args) {
        //문자(char / 1byte), 문자열(String)
        //String = char[] 문자열은 문자 배열이기도 하다. = 문자열은 참조형 변수이다.

        // [ 기본형 변수 vs 참조형 변수 ]
        // 1. 기본형 변수는 '소문자로 시작함' 반면, 참조형 변수는 '대문자로 시작함'
        //    - Wrapper class에서 기본형 변수를 감싸줄 때(Boxing), int -> Integer
        // 2. 기본형 변수는 값 자체를 저장, 참조형 변수는 별도의 공간에 값을 저장한 후 그 주소를 저장함(= 주소형 변수)

        // char < String 을 자주 쓰긴한다
        // String은 배열이기 때문에 기능이 너무 많아서.
        // Wrapper class와도 상당히 비슷..! => 기본형 변수가 가지고 있는 기능이 제한 -> 다양한 기능을 제공하는 Wrapper를 감쌈으로써, 추가 기능을 더함

        // String 기능 활용 예시
        String str = "ABCD";

        // 1) length 길이(배열 길이 = 문자 몇개인지)
        int strLength = str.length();
        System.out.println(strLength);

        // 2) charAt(int index) index에 해당되는 문자 추출
        char strChar = str.charAt(1);
        System.out.println(strChar);

        // 3) substring(int fromIdx, int toIdx) 문자 자르기 slice 나타낼 시작 인덱스, 나타낼 끝 인덱스
        String strSub = str.substring(0, 3);
        System.out.println(strSub);

        // 4) equals(String str) 어떠한 문자열이(입력받거나 가져온 값이) 이 문자열과 같는지 체크하는 것
        String newStr="ABCD";
        String newStr2="abcd";
        boolean strEquals1 = str.equals(newStr);
        boolean strEquals2 = str.equals(newStr2);
        System.out.println(strEquals1);
        System.out.println(strEquals2);

        // 5) toCharArray() : String을 char[] 배열로 변경하는 기능
        char[] strCharArray = str.toCharArray();
        System.out.println(strCharArray[2]);

        // 6) 반대로 char[] -> String -> char
        char[] charArray = {'A','B','C'};
        String charArrayString = new String(charArray);
        System.out.println(charArrayString);
    }
}
