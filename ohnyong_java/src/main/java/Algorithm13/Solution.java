package Algorithm13;


public class Solution {
    static String my_string = "REVERSE TEST";
    //Solution을 클래스 메소드로 선언
    public static String solution(String my_string) {
        //StringBuffer 클래스의 reverse() 메소드를 사용 해보자.
        StringBuffer sb = new StringBuffer(my_string);
        String answer = "";

        answer = sb.reverse().toString();
        return answer;
    }
    //코테 작성 부분에서 메인이 없을 수 있다. 메인 작성해주자!
    public static void main(String[] args) {
        //클래스 메소드(Static Method) 기 때문에
        //객체를 생성 안해도 메소드를 호출 할 수 있다.
        //Solution solution = new Solution();
        String result = solution(my_string);
        System.out.println(result);
    }
}