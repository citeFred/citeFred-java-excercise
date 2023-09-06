package Algorithm39;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*두 개 뽑아서 더하기
문제 설명
정수 배열 numbers가 주어집니다.
 numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
입출력 예
numbers	result
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]*/
public class Solution {
    // 더하는데, 중복이 안되도록 !
    // 중복안되는건 Map? -> 아니 Set HashSet!
    public Solution(){

    }
    public int[] Solution(int[] numbers){
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<numbers.length - 1; i++){
            for (int j=i+1;j<numbers.length;j++) { // <- num[0] + num[0] 과 같은 중복을 피하기 위해 j=i+1처럼 시작하면 된다.
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        // set을 리스트로해서 정렬 -> 왜? -> Set 컬렉션은 순서를 보장하지 않기때문
        List<Integer> listSet = new ArrayList<>(set);
        listSet.sort(null); // comparator -> compareTo 로 그 a,b b,c 정렬하던것 그런데 디폴트값이 오름차순 마치 숫자면 1,2,3,4 문자면 a,b,c,d 가 디폴트값이다

        //다시 배열로 반환
        int[] answer = new int[listSet.size()]; //사이즈로 배열 크기 초기화
        for (int i=0;i<listSet.size();i++){
            answer[i] = listSet.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
    int[] numbers = {2,1,3,4,1};
    Solution sol = new Solution();
    int[] result = sol.Solution(numbers);
    String resultStr = Arrays.toString(result);
        System.out.println(resultStr);
    }
}
