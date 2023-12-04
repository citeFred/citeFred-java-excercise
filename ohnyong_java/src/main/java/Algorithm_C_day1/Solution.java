package Algorithm_C_day1;
/*전화번호 목록
문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
같은 전화번호가 중복해서 들어있지 않습니다.
입출력 예제
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
입출력 예 설명
입출력 예 #1
앞에서 설명한 예와 같습니다.

입출력 예 #2
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

입출력 예 #3
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
*/


import java.util.Arrays;

// 기본 for loop 풀이.
public class Solution {
    public boolean solution(String[] phone_book){
        // 참고에서 추가한 정렬
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String a = "119";
        String b = "97674223";
        String c = "1195524421";
        String[] phone_book = {a,b,c};
        System.out.println(sol.solution(phone_book));
    }
}
// [질문] 왜 정렬을 추가하니까 테스트 통과가 되는가?
// 정렬을 하면 앞뒤로 위치한 문자열들이 유사한 부분을 가질 가능성이 높아져서,
// 접두어를 찾는 비교 과정이 효율적으로 이루어질 수 있다?
// 그럼 실제로 어떤 차이가 있길레?
/*
테스트 1
입력값 〉	["119", "97674223", "1195524421"]
기댓값 〉	false
실행 결과 〉	실행한 결괏값 true이 기댓값 false과 다릅니다.

i = 0 일때 97674223에도 119가 없으며
i = 1 일때 1195524421에도 97674223가 없으므로
반복문이 종료되고 true가 반환된다.
하지만 여기서
        Arrays.sort(phone_book);
를 통해서 정렬하면
 ["119", "1195524421", "97674223"]가 된다.
 그럼 i = 0 일때 1195524421에 119가 있는가?에 대한 반복문 startsWith조건문에서
 true가 나오면서 return false;로 흘러 전체 반복문을 탈출한다.

 ""사전 순 정리"" 를 통해 정렬된 배열을 사용하면
 이진 탐색(Binary Search) 같은 효율적인 검색 알고리즘을 활용할 수 있게 된다.
 정렬된 상태에서는 특정 값의 존재 여부를 더 빠르게 판단할 수 있어서
 검색에 대한 성능이 향상되는 효과가 있다.

전화번호부의 길이를 N이라고 할 때,
기본 for loop를 사용한 경우에는 O(N^2)이 될 것이고,
Arrays.sort를 사용한 경우에는 정렬의 시간복잡도가 O(N log N)이 된다.
대부분의 상황에서는 Arrays.sort를 사용한 경우가 더 빠를 것이라고 기대된다.
*/
