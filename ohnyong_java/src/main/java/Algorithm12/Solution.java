package Algorithm12;

import java.util.Scanner;

public class Solution {
    /*문제 설명
    어떤 자연수를 제곱했을 때 나오는 정수를
     제곱수라고 합니다.
      n^2 = result  => int jegopsu

      정수 n이 매개변수로 주어질 때,
      if result == jegopsu =>return 1
      else =2

      n이 제곱수라면 1을
      아니라면 2를 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ n ≤ 1,000,000*/
    int inputNum;
    double rootRow;
    int rootResult;
    int resultFlag;
    int tryNum;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void input() {
        while (true) {
            System.out.println("아무 숫자를 입력해 보세요. 제곱수 판별기입니다.");
            inputNum = sc.nextInt();
            if (inputNum < 1 || inputNum > 1000000) {
                System.out.println("숫자는 1~100만까지만 입력하세요.");
                continue;
            }
            calculate(inputNum);
            break;
        }
    }

    void calculate(int inputNum) {
        //    만약 4를 입력하면 2가 제곱수
        //     input 4         jegopsu 2
        //    16을 입력하면 4가 제곱수.
        //    16 = 4*4  :  input = je*je
        rootRow = Math.sqrt(inputNum);
        rootResult = (int) rootRow;
        System.out.println(rootRow);
        System.out.println(rootResult);
        if (rootRow == rootResult) {
            resultFlag = 1;
            outputRoot(inputNum, rootRow, rootResult, resultFlag);
        } else {
            resultFlag = 2;
            outputRoot(inputNum, rootRow, rootResult, resultFlag);
        }
    }

    void outputRoot(int inputNum, double rootRow, int rootResult, int resultFlag) {
        if (resultFlag == 1) {
            System.out.printf("입력하신 %d는 제곱수로, 제곱근은 %d입니다. -%d", inputNum, rootResult, resultFlag);
        } else {
            System.out.printf("입력하신 %d는 제곱수가 아닙니다. -%d\n", inputNum, resultFlag);
        }
        tryAgain();
    }

    void tryAgain() {
        System.out.println("다시 실행하시겠습니까?\n[1] YES   [2] NO");
        tryNum = sc.nextInt();
        while (true) {
            if (tryNum == 1) {
                input();
                break;
            } else if (tryNum == 2) {
                System.out.println("안녕히가세요.");
                System.exit(0);
                break;
            }
        }
    }
}
