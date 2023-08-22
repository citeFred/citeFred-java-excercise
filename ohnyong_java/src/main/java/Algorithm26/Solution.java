package Algorithm26;

public class Solution {
    public int Solution(int n){
        //10진법 3 / 10 / 32
        //3진법 = 3 / 91 /
        /*  3/32    / 1012
            3/10 - 2  ^
            3/ 3 - 1  |
               1 - 0  |
              ------>
              10진법 32 - 3진법 1012
                     3진법 반전 2101
                    다시 10진법 3^3*2 + 3^2*1 + 3^1*0 + 3^0*1
                                27*2  + 9*1   + 3*0   + 1*1
                               =54    +   9   +   0   +   1
                               = 64

        n을 3진법으로 만들어야 한다.
        몇자리인줄 알아야 하는데,


        * *
         */
        int[] threeNum = new int[100];
        //3진수 나머지로 변환과 동시에 idx = 0부터 들어가니 반전까지 동시에 됨
        int i = 0;//3진수 마지막 idx가 여기에 누적되서 아래 10진법 바꿀 때 역으로(j--)로 순회함
        while(n>0){
            threeNum[i] = n % 3; //나머지가 3진수 숫자, idx 0부터 하나씩 기록됨,
            n = n/3; //3으로 나눈 몫이 다시 위로 전달됨
            i++; //i를 loop 밖에서 누적시켜서 10진수 변환에 활용될 예정
        }
        int answer = 0;
        int prom = 1;
        for(int j= i-1 ; j>=0; j--){ // 10진법에서는 위 3진법의 거꾸로 3진수를 계산되도록 idx가 가장높은 위 i값부터 시작하면서 역으로 배열에 넣게됨
            answer += threeNum[j] * prom;  // 모든 숫자의 0승은 1이기 때문에 1부터 시작해서 들어감
            prom *= 3; //3진수이기 때문에 1승, 2승을 곱한것을 순회마다 누적시키도록 작동시킴
        }
        return answer;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int n = 45;
        System.out.println(sol.Solution(n));
    }
}
