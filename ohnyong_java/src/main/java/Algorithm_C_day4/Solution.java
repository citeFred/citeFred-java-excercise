package Algorithm_C_day4;



/*가장 큰 수
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"*/
import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public String solution(int[] numbers){
        String answer = "";

        // 기본 정렬 내림차순 하고 하나씩 뺴면 되지않을까?
        //int[] sortedArr = Arrays.sort(numbers, Comparator.reverseOrder());
        //for(int i=0;i<sortedArr.length;i++){
        //    answer+= sortedArr[i];
        //}
        //기본 자료형 배열에 대해서는 사용할 수 없다
        //Integer[] numbersArr = new Integer[numbers.length];
        //for (int i=0;i<numbers.length;i++){
        //    numbersArr[i] = numbers[i];
        //}
        //Arrays.sort(numbersArr, Comparator.reverseOrder());
        //
        //for(int i=0;i<numbersArr.length;i++){
        //    answer += numbersArr[i];
        //}
        // 여기까지하면 34,30,9,5,3 처럼 숫자 자체의 내림차순이 된다.
        // 내가 원하는건 글자의 내림차순이 필요하다.

        String[] numToStrArr = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            numToStrArr[i] = String.valueOf(numbers[i]);
        }

        //Arrays.sort(numToStrArr, Comparator.reverseOrder());
        // 단순 sort 로는 안된다. 9,5,34,30,3 에서 마지막 30 3과 3 30 중에 큰값이 나와야하는데
        // 비교 함수를 사용하여 정렬하는것을 참고했다. Comparator를 오버라이딩하여 재정의한다.
        Arrays.sort(numToStrArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // o1과 o2를 이어붙였을 때 더 큰 수가 나오도록 비교
                return (o2 + o1).compareTo(o1 + o2);
            }
        });


        for(int i=0;i<numToStrArr.length;i++){
            answer += numToStrArr[i];
        }

        // 테스트케이스 11번이 계속 틀려서 뭔가 잘못되었다.
        // 다른 풀이를 살펴보니 0이 되는 경우를 살펴보라고 한다.
        // 맨 앞이 0이면 전체가 0이므로 "0"으로 반환
        // 그런데 0을 줄여도되는건가?
        // 000 = 0이 맞으니까 0이다.
        if (answer.charAt(0) == '0') {
            return "0";
        }

        // 9,5,34,30,3 이 나온다. 가장 큰 값은 9,5,34,3,30 아닌가?
        return answer;
    }

    public static void main(String[] args){
    Solution sol = new Solution();
    int[] numbers = {3,30,34,5,9};
        System.out.println(sol.solution(numbers));
    }
}
