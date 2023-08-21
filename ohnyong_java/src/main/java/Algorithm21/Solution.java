package Algorithm21;
/*내적
문제 설명
길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다.
 a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
입출력 예
a	b	result
[1,2,3,4]	[-3,-1,0,2]	3
[-1,0,1]	[1,0,-1]	-2
*/
public class Solution {
    public int Solution(int[] a, int[] b){
        //길이가 같다 = 하나의 배열의 길이만 써도 된다.
        //하나의 배열 길이 만큼 돌면서 무엇을 할까?
        //cnt를 궂이 사용해야 할까?i로 대체 될 듯한데,
        int answer = 0;
        for(int i=0;i<a.length;i++){
            //두배열에 idx에 해당되는 값끼리 * 연산을 해서 answer에 넣자. 누적
            answer += a[i]*b[i];
        }

        return answer;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a={1,2,3,4};
        int[] b={-3,-1,0,2};
        System.out.println(solution.Solution(a, b));
    }
}
