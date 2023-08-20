package Algorithm18;

import java.util.Arrays;

/*제일 작은 수 제거하기
문제 설명
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
입출력 예
arr	return
[4,3,2,1]	[4,3,2]
[10]	[-1]*/
public class Solution {

    public int[] solution(int[] arr) {


        if (arr.length <= 1) {
            int[] arr2 = new int[1];
            arr2[0] = -1;
            return arr2;
        }
        int minValue = arr[0]; // 첫 번째 요소로 초기화
        for(int i=1;i<arr.length;i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != minValue){
                cnt++;
            }
        }
        int[] answer= new int[cnt];
        int j=0;
        for(int i=0;i<answer.length;i++){
            if(arr[i] != minValue){
                answer[j] = arr[i];
                j++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {10,19,2,1,5};
        int[] lda = solution.solution(arr);
        for (int i=0;i<lda.length;i++){
            System.out.println(lda[i]);
        }
    }
}
