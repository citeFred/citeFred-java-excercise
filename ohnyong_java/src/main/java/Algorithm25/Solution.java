package Algorithm25;

import java.util.Arrays;

/*최대공약수와 최소공배수
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
 solution을 완성해 보세요.

  배열의 맨 앞에 최대공약수,
   그다음 최소공배수를 넣어 반환하면 됩니다.

    예를 들어 두 수 3, 12의 최대공약수는 3,
     최소공배수는 12이므로

     solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.*/
public class Solution {
    public int[] Solution(int n, int m){
        // --------------------------잘못된 접근방법을 선택한 나----------------------------
        ////3 약수-> 1, 3
        ////4 -> 1, 2, 4
        //// n%i == 0인것
        ////12 약수-> 1, 3, 4, 6, 12
        //// m%i == 0인것
        ////실수가 필요함.
        //double doubleN = n;
        //double doubleM = m;
        //int divNCnt = 0;
        //int divMCnt = 0;
        //for(int i=1;i<=n;i++){
        //    if(doubleN%i == 0){
        //        divNCnt++;
        //    }
        //}
        //for(int i=1;i<=n;i++){
        //    if(doubleM%i == 0){
        //        divMCnt++;
        //    }
        //}
        //int[] nArr = new int[divNCnt];
        //int[] mArr = new int[divMCnt];
        //for (int i=0;i<nArr.length;i++){
        //    if(doubleN%i == 0){
        //        nArr[i] = n%i;
        //    }
        //}
        //for (int i=0;i<mArr.length;i++){
        //    if(doubleM%i == 0){
        //        mArr[i] = m%i;
        //    }
        //}
        //int minLength = 0;
        //if(mArr.length<= nArr.length){
        //    minLength = mArr.length;
        //}else{
        //    minLength = nArr.length;
        //}
        //
        //
        //int sameDivLength = 1;
        //int[] sameDiv = new int[sameDivLength];
        //for (int i=0;i<minLength;i++){
        //    for(int j=0;j<minLength;j++) {
        //        if (nArr[i] == mArr[i]) {
        //            sameDiv[0] = nArr[i];
        //        }
        //    }
        //}
        //String answer = Arrays.toString(sameDiv);
        ////int[] answer = new int[sameLength];
        // --------------------------잘못된 접근방법을 선택한 나----------------------------
        // --------------------------ChatGPT로부터 유클리드 호제법으로 접근한 나----------------------------

        int[] answer = new int[2];

        // 매개변수로부터 최대값과 최소값을 구해놓자.
        int max = Math.max(n, m);
        int min = Math.min(n, m);

        // 최대 공약수는 큰값을 작은값으로 나누는데 작은값에서부터 하나씩 줄이다 보면 첫번째로 둘다 나눠지는 값이 있다. 그게 최대 공약수다.
        //위에 구한 최소값부터 시작, i--로 1씩 줄여나가보자.
        for (int i = min; i >= 1; i--) {
            //최대값과 최소값을 동시에(&&) 나눠지는 값이 있을 것이다. 그게 공약수들이고, 그 중 최소값의 최대치부터 시작해서 첫번째 만나서 탈출시키면 최대 공약수만 담은 상태로 나가게 된다.
            //계속 진행시키면 최소 공약수인 "1"에서 멈추게 된다. 모든 양수 정수의 최소공약수는 1이기 때문에 "break;"를 꼭 첫번째에 탈출 시키자.
            if (max % i == 0 && min % i == 0) {
                answer[0] = i; // 최대공약수(GCD)
                break;
            }
        }
        // 최소 공배수는 두 수를 곱하고 최대공약수로 나누면 된다. 단순하다. 외우자.
        // 최소공배수(LCM)를 구하기 위해 두 수를 곱하고 최대공약수로 나눕니다.
        answer[1] = (n * m) / answer[0]; // 최소공배수(LCM)

        // --------------------------ChatGPT로부터 유클리드 호제법으로 접근한 나----------------------------

        return answer;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int n = 3;
        int m = 12;
        int[] answer = sol.Solution(n, m);
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");

    }
}
