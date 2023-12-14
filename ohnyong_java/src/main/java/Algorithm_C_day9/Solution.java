package Algorithm_C_day9;
/*징검다리
문제 설명
출발지점부터 distance만큼 떨어진 곳에 도착지점이 있습니다.
그리고 그사이에는 바위들이 놓여있습니다.
 바위 중 몇 개를 제거하려고 합니다.

예를 들어, 도착지점이 25만큼 떨어져 있고,
 바위가 [2, 14, 11, 21, 17] 지점에 놓여있을 때 바위 2개를 제거하면 출발지점,
 도착지점, 바위 간의 거리가 아래와 같습니다.

제거한 바위의 위치	각 바위 사이의 거리	거리의 최솟값
[21, 17]	[2, 9, 3, 11]	2
[2, 21]	[11, 3, 3, 8]	3
[2, 11]	[14, 3, 4, 4]	3
[11, 21]	[2, 12, 3, 8]	2
[2, 14]	[11, 6, 4, 4]	4
위에서 구한 거리의 최솟값 중에 가장 큰 값은 4입니다.

출발지점부터 도착지점까지의 거리 distance,
바위들이 있는 위치를 담은 배열 rocks, 제거할 바위의 수 n이 매개변수로 주어질 때,
 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 return 하도록 solution 함수를 작성해주세요.

제한사항
도착지점까지의 거리 distance는 1 이상 1,000,000,000 이하입니다.
바위는 1개 이상 50,000개 이하가 있습니다.
n 은 1 이상 바위의 개수 이하입니다.
입출력 예
distance	rocks	n	return
25	[2, 14, 11, 21, 17]	2	4
입출력 예 설명
문제에 나온 예와 같습니다.*/



    //https://gom20.tistory.com/204
    //이분 탐색 문제와 동일한 유형의 문제
    //2021.11.29 - [Problem Solving/BOJ] - [BOJ 2110] 공유기 설치 (Java)
    //2021.12.01 - [Problem Solving/BOJ] - [BOJ 1654] 랜선 자르기 (Java)
    //2021.11.30 - [Problem Solving/BOJ] - [BOJ 2805] 나무 자르기 (Java)


    // 지점 간 최소 거리를 이분 탐색하면서 최대 값을 찾는 것이 핵심
    // 바위를 2개 파괴했을 때, 지점 간의 최소 거리의 최대 값을 찾아야 한다.

import java.util.Arrays;

public class Solution {

    int solution(int distance, int[] rocks, int n){
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = (left + right)/2;
            if(getRemovedRockCnt(rocks, mid, distance) <= n){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    public int getRemovedRockCnt(int[] rocks, int mid, int distance){
        // mid가 바위(지점) 간 최소 거리가 되어야 함
        // 그렇게 하기 위해 제거 해야할 바위의 개수를 리턴한다.
        int before = 0;
        int end = distance;

        int removeCnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - before < mid) {
                removeCnt++;
                continue;
            }
            before = rocks[i];
        }
        if(end - before < mid) removeCnt++;

        return removeCnt;
    }
    public static void main(String[] args){
        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        Solution sol = new Solution();
        System.out.println(sol.solution(distance, rocks, n));
    }
}
