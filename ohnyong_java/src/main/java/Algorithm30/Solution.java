package Algorithm30;
/*문제
N*M크기의 두 행렬 A와 B가 주어졌을 때,
두 행렬을 더하는 프로그램을 작성하시오.

입력
첫째 줄에 행렬의 크기 N 과 M이 주어진다.
둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다.
N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력
첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.

예제입력
------ N,M
3 3
------ A[][]
1 1 1
2 2 2
0 1 0
------ B[][]
3 3 3
4 4 4
5 5 100

예제출력
4 4 4
6 6 6
5 6 100
*/


import java.util.Arrays;

public class Solution {
    public int[][] Solution(int[][] arrA, int[][] arrB){
        //초기화용 length 필요
        int rowLength = arrA.length;
        int colLength = arrA[0].length;
        int[][] answer = new int[rowLength][colLength];
        for (int i=0;i<answer.length;i++){
            for (int j=0;j<answer.length;j++){
                answer[i][j] = arrA[i][j] + arrB[i][j];
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        int m = 3;
        int[][] arrA = {{1,1,1}, {2,2,2}, {0,1,0}};
        int[][] arrB = {{3,3,3}, {4,4,4}, {5,5,100}};
        //answer Sample {{4,4,4}, {6,6,6}, {5,6,100}};
        System.out.println(Arrays.deepToString(sol.Solution(arrA, arrB)));
        /*result
        *
            > Task :Solution.main()
            [[4, 4, 4], [6, 6, 6], [5, 6, 100]]*/
    }
}
