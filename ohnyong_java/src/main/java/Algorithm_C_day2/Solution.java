package Algorithm_C_day2;

import java.util.Arrays;
import java.util.Stack;

/*
같은 숫자는 싫어
문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
  단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.

   예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
입출력 예
arr	answer
[1,1,3,3,0,1,1]	[1,3,0,1]
[4,4,4,3,3]	[4,3]
입출력 예 설명
입출력 예 #1,2
문제의 예시와 같습니다.
*/
public class Solution {
    public int[] Solution(int[] arr){
        //int[] answer = {};
        // 문제 핵심은 중복제거이다.
        // 중복을 허용하지 않는 자료구조를 사용하면 쉽게 해결될 것 같다.
        // 중복을 허용하지 않는 자료구조는 Set이 있으며 HashSet 또는 TreeSet으로 구현된다.
        //HashSet<Integer> arrSet = new HashSet<>();
        //for(int i=0;i<arr.length;i++) {
        //    arrSet.add(arr[i]);
        //}
        //return arrSet;

        //하지만 HashSet은 모든 중복을 제거해버린다. 내가원하는 결과와 달랐다.
        //> Task :Solution.main()
        //[0, 1, 3]
        // 문제의 의도에서는
        //{1,1,3,3,0,1,1}에서 {1,3,0,1}이 유지되어야 한다. 바로 연속된 중복만 제거되어야 한다.
        Stack<Integer> arrStack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            //스택에 들어간 맨위 숫자가 중복된다면, 다음 반복문으로 진입(중복을 건너뜀)
            if (!arrStack.isEmpty() && arrStack.peek() == arr[i]) {
                continue;
            }
                arrStack.push(arr[i]);
        }
        int[] answer = new int[arrStack.size()];
        //for (int i=0;i< answer.length;i++){
        //> Task :Solution.main()
        //[1, 0, 3, 1]
        //스택이기때문에 역순으로 팝된다.(LIFO)기때문에 다시 역순을 맞춰줘야한다.
        for (int i= answer.length -1 ;i >=0;i--){
            answer[i] = arrStack.pop();
        }
        return answer;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(sol.Solution(arr)));
    }
}
