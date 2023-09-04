package Algorithm36;

import java.util.Arrays;

/*문자열 내 마음대로 정렬하기
문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,

각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
입출력 예
strings	n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
입출력 예 설명
입출력 예 1
"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.

입출력 예 2
"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다. "abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.*/
public class Solution {
    public String[] Solution(String[] strings, int n){
        return Arrays.stream(strings) //스트림 메소드에 매개변수로 받은 strings 배열을 넣는다.
                .sorted((s1, s2) -> { //sorted 메소드로 기본적인 정렬이 진행된다. strings배열을 전체 순회 할 것이고, s1, s2라는 변수에 0번쨰, 1번째 문자열이 담긴다. ->2바퀴째에는 1번쨰, 2번째가 담긴다 ->> 버블정렬법을 사용하는 것이다.
                    char c1 = s1.charAt(n);//s1 (0번째 문자열)의 n번째 자릿수 문자를 c1에 넣는다.
                    char c2 = s2.charAt(n);//s2 (0번째 문자열)의 n번째 자릿수 문자를 c2에 넣는다.

                    if (c1 == c2) {//만약 두개를 비교해서 같을 경우,
                        return s1.compareTo(s2); //compareTo메소드를 통해서 아예 전체 문자열의 (보통 첫번째 자리수가 가장 커서 거기서 결정됨)s1, s2를 비교하는 메소드 compareTo를 통해 ASCII값의 연산결과로 양수 또는 음수가 반환된다.
                    } else {
                        return c1 - c2; //<- 이부분이 바로 위 compareTo() 메소드의 실제 모습이라 보면 된다, ASCII 숫자값들의 연산으로 양수 또는 음수가 반환된다.
                        // 음수는 내림차순(ex) a-b => 97-98 = -1처럼 음수가 나타나고 a,b,c,d같은 내림차순이 정렬된다.
                        // 반대로 b-a => 98-97 = 1 처럼 양수가 반환되면, 오름차순이 정렬된다.
                        // 이부분은 생각보다 햇갈릴 수 있다. 기억하기 쉬운방법으로 생각하면
                        //일반적으로 compareTo 메서드에서 s1이 s2보다 앞에 오게 하려면 s1.compareTo(s2)를 사용하고, s2가 s1보다 앞에 오게 하려면 s2.compareTo(s1)을 사용하면 된다.
                    }
                })
                .toArray(String[]::new); //결과를 배열로 만든다.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] result = sol.Solution(strings, n);
        String resultString = Arrays.toString(result);
        System.out.println(resultString);
    }
}
