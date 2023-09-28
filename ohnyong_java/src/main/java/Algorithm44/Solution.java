package Algorithm44;

/*2016년
문제 설명
2016년 1월 1일은 금요일입니다.
2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수,
solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	"TUE"*/
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution {
    public String findDay(int a, int b) {
        //날짜를 나타낼 수 있는 LocalDate 클래스를 사용해보자.
        // 지정된 년도인 2016년을 입력
        int month = a;
        int day = b;
        LocalDate date = LocalDate.of(2016, month, day); //2016년의 a,b를 입력 받은 날짜 객체를 생성
        //이러면 a,b 에 따라 그 날짜 객체가 생성되는데, 거기서 결국 요일을 필요로 한다.
        System.out.println(date.getDayOfWeek()); // getDayOfWeek을 통해 TUESDAY를 추출 가능
        System.out.println(date.getDayOfWeek()); // 그 날짜의 .getDisplayName을 통해 짧은표현 TUE를 추출 가능
        //참고로 Locale을 KOREAN으로 하면 월,화,수 목금토일 같이 뽑아 낼 수도 있다.
        //toUpperCase로 대문자 치환.
        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24; //입력값은 필요시 Scanner로 입력 받을 수도 있다.
        Solution solution = new Solution();

        String result = solution.findDay(a, b);
        System.out.println(result); // "TUE"
    }
}

