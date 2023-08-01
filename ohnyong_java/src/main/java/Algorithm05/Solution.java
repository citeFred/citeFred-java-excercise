package Algorithm05;

import java.util.Scanner;

public class Solution {
    //정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //0 < n ≤ 1000

    //필요데이터
    //입력값 n
    //스캐너
    //0 < n ≤ 1000 유효성검사 while
    //result

    //필요메서드
    //inputNum()
    //calculate()
    //n이하의 짝수
    //ex) 5면, 2, 4이다. (2*i) < n
    //i가 증가하면서 2의 배수로 진행, result에 값을 누적하면서 n전까지 가는 방식으로 가보자.
    //outputSum()
    int inputNum;
    int result;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void inputNum() {
        while (true) {
            System.out.println("짝수합을 구할 최대 숫자를 입력하세요.");
            inputNum = sc.nextInt();
            if (inputNum < 0 || inputNum > 1000) {
                System.out.println("최대 숫자는 1~1000범위로 입력해주세요.");
                continue;
            } else {
                calculate(inputNum);
                break;
            }

        }
    }

    void calculate(int inputNum) {
        for (int i = 1; i <= inputNum; i++) {
            if (i * 2 <= inputNum) {
                result += i * 2;
            } else {
                break;
            }
        }
        outputSum(inputNum, result);
    }

    void outputSum(int intputNum, int result) {
        System.out.printf("0부터 %d까지의 짝수를 모두 더한 값은 %d와 같습니다.", intputNum, result);
    }

}
