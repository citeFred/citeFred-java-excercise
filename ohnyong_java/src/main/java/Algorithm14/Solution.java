package Algorithm14;
//문제 설명
//정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
//
//제한 조건
//num은 int 범위의 정수입니다.
//0은 짝수입니다.
//입출력 예
//num	return
//3	"Odd"
//4	"Even"

class Solution {

    //input이 뭔가?
    int num;

    //계산해야할것은 무엇인가.
    ////몫, 나머지
    //num%2 == 1 홀
    //num%2 == 0 짝

    //output은 뭔가?
    String result = "text";
    //짝수면, "Even"
    //홀수면, "Odd"

    public String solution(int num) {
        System.out.println();
        if (num%2 == 1){
            result = "Odd";
        } else {
            result = "Even";
        }
        return result;
    }
}
