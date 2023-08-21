package Algorithm23;

/*문자열 내림차순으로 배치하기
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
입출력 예
s	return
"Zbcdefg"	"gfedcbZ"

이 문제를 Stream을 활용해서 풀고싶어
코드는 작성하지 말고 주석으로 어떤 방식으로 다가가야 하는지 가이드를 작성해줘
-------------------------

1]문자열을 문자 배열로 변환합니다.
2]문자 배열을 스트림으로 변환합니다.
3]대문자는 소문자보다 작은 것으로 간주하므로 대소문자를 구분하지 않고 정렬하려면 문자를 모두 소문자로 변환합니다.
4]문자를 역순으로 정렬합니다.
5]정렬된 문자들을 문자열로 다시 결합합니다



*/

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public String Solution(String s){
        // 1. 주어진 문자열 s를 문자 배열로 변환
        char[] arr = s.toCharArray();

        // 2. 문자 배열을 대소문자를 구분하여 내림차순으로 정렬
        Arrays.sort(arr);

        // 3. 정렬된 문자 배열을 문자열로 결합
        // 결과에 append를 쓰기위해 StringBuilder() 객체 생성
        StringBuilder answer = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            answer.append(arr[i]);
        }

        // 4. 결과 문자열 반환
        return answer.toString();
    }
    /**/
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "HeD1Allo.";
        System.out.println(solution.Solution(s));
    }
}
