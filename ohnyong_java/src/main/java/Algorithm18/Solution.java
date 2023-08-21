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

        if (arr.length <= 1) { // 1. 첫 조건 요소가 1개인 경우.
            int[] answer = {-1};
            return answer;
        }

        int minValue = arr[0]; // 2. 최소값 초기화
        for(int i=1;i<arr.length;i++){ // 3. 최소값 찾기
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }

        int cnt = 0; //새로 만들 배열(array)이라 정적으로 cnt가 새로 필요함. -1해도되지않나?최소값만뺼껀데..?
        for(int i=0;i<arr.length;i++){
            if(arr[i] != minValue){
                cnt++;
            }
        }

        int[] answer= new int[cnt]; //결과배열 선언및 초기화
        int j=0; //새 배열에 대한 index번호 새로 초기화, 길이가 다르니까.
        //for(int i=0;i<answer.length;i++){ // answer 배열의 길이가 아니라 arr의 길이를 탐색해야 한다.
        for(int i=0;i<arr.length;i++){
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
