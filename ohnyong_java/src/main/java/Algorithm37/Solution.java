package Algorithm37;

import java.util.Arrays;

/*
K번째수
문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
* */
public class Solution {
    public Solution(){

    }

    public int[] Solution(int[] array, int[] commands){
        int i = commands[0];
        int j = commands[1];
        int k = commands[2];
        int[] subArr = Arrays.copyOfRange(array, i-1, j-1); //array의 i~j 번째 요소(index는 0부터라 -1)들을 복사해서 새로운 배열만들기
        int[] result = new int[1];
        result[0] = subArr[k-1];
        return result;

    }
// Arrays.copyOfRange(배열, 시작인덱스, 끝인덱스) -> 배열을 시작~끝 범위 인덱스들을 복사해서 추출

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1,5,2,6,3,7,4};
        int i = 2;
        int j = 5;
        int k = 3;
        int[] commands = {i, j, k};
        int[] result = sol.Solution(array, commands); //를 호출해서 반환값을 result배열에 담어
        String resultString = Arrays.toString(result); //출력하려면 문자열결과로 만들어
        System.out.println(resultString);//출력해
    }
}
