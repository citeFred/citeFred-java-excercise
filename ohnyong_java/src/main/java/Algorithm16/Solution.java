package Algorithm16;

/*
* 콜라츠 추측
문제 설명
1937년 Collatz란 사람에 의해 제기된 이 추측은,
* 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.
* 작업은 다음과 같습니다.

1-1. 입력된 수(int num)가 짝수라면 2로 나눕니다.
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
2. 결과로 나온 수(tempNum)에 같은 작업을 1이 될 때까지 반복합니다.
예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.
*  위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
*
* 단, 주어진 수가 1인 경우에는 0을,
* 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.
*제한 사항
입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.
*
* 필요변수
* int tempNum = 0;
* int cnt = 0;
* boolean flag = true;
* 우선순위
* 1) if(num >= 1 && num < 8000000){ 이어야 한다.
    *   while(tempNum != 1){
    *   2-1) if(num % 2 == 0){
    *       tempNum = num / 2;
    *       }
    *   2-2) else if(num % 2 != 0){
    *       tempNum = num * 3 + 1;
    *       }
    *   2-3) if(cnt<=500){
    *       cnt++;
            }else if(cnt == 500){
                cnt = -1;
                break;
            }
        2-4) if(tempNum == 1){
                break;
            }
    }
제한 사항
입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.
*
* */
public class Solution {
    int tempNum; //0
    int cnt;
    //나는 tempNum을 통해 저장하려 했지만 예로 15라는 인풋이 들어 왔을때 첫번째 반복 이후 두번째 반복에 들어 왔을때
    // tempNum은 변했지만 첫 if문에서 인풋인 num은 그대로 15로 첫 초기화 상태 그대로 유지되었기 때문에
    // 잘못된 접근 방법이다. 주어진 num 변수만 사용했어야 됨.
    //    *   while(tempNum != 1){
    //*   2-1) if(num % 2 == 0){   <<<<<<<--------- 이부분이 두번째 이상 반복에서 의미가 없다.
    //*       tempNum = num / 2;
    //*       }
    //*   2-2) else if(num % 2 != 0){     <<<<<<<--------- 이부분이 두번째 이상 반복에서 의미가 없다.
    //*       tempNum = num * 3 + 1;
    //*       }
    public int solution(int num) { //15
        //if (num >= 1 && num < 8000000) { //코테에서 주어지는 값의 범위는 테스트 실행에서 신뢰하고 진행하는 것이 맞다.
            while (num != 1) { // == 1인 순간이 false로 반복문이 탈출되기 때문에 아래 if(num == 1)은 불필요한 코드다.
                if (num % 2 == 0) { //15
                    num = num / 2; //7
                } else if (num % 2 != 0) {
                    num = num * 3 + 1;
                }
                System.out.println("num==>"+ num);
                if (cnt < 500) { // (cnt <= 500) 로 작성했었는데 500이 되는 순간을 생각하면 cnt가 501로 증가하기 때문에 아래 else if문의 500을 건너 뛰게 된다.
                    cnt++; //1
                } else if (cnt == 500) {
                    cnt = -1;
                    break;
                }
                //if (num == 1) { //  1이 되는 순간 알아서 false로 while loop를 탈출하게 되기 때문에 불필요한 부분이다.
                //    break;
                //} 불필요한부분.
            }
        //}
        return cnt;
    }
    public static void main (String[]args){
        Solution solution = new Solution();
        System.out.println(solution.solution(626331));
    }
}