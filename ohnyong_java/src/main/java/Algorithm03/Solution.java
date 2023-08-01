package Algorithm03;

import java.util.Scanner;

public class Solution {


    int num1;
    int num2;
    int result;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }
    //    필요 데이터 파악
    //    두개의 정수 num1, num2
    //    제약 조건
    //    0<=num1<=10000
    //    0<=num2<=10000

    //    정수는 파라미터가 될 것입니다.
    //inputNum(){}
    //스캐너 필요
    void inputNum() {
        while (true) {
            int num1;
            System.out.println("Num1을 입력해 주세요.");
            num1 = sc.nextInt();
            if (0 >= num1 || num1 >= 10000) {
                System.out.println("값을 0<=num1<=10000 범위로 넣어주세요.");
                continue;
            }
            this.num1 = num1;
            break;
        }

        while (true) {
            int num2;
            System.out.println("Num2를 입력해 주세요.");
            num2 = sc.nextInt();
            if (0 >= num2 || num2 >= 10000) {
                System.out.println("값을 0<=num2<=10000 범위로 넣어주세요.");
                continue;
            }
            this.num2 = num2;
            break;
        }
        receive(num1, num2);
    }

    //    받는 메서드 receive(int num1, num2){}
    //조건문으로 아래 컨트롤if(){}else if
    //    비교 연산 같으면(==) 1이란 숫자 return,
    //    비교 연산 다르면(!=) -1이란 숫자 return
    void receive(int num1, int num2) {
        if (num1 == num2) {
            result = 1;
            outputResult(result);
        } else if (num1 != num2) {
            result = -1;
            outputResult(result);
        } else {
            System.out.println("잘못된 접근입니다.");
        }
    }

    //outputResult(){}
    void outputResult(int result) {
        if (result == 1) {
            System.out.printf("두 숫자는 같으며 결과는 %d 입니다", result);
        } else if (result == -1) {
            System.out.printf("두 숫자는 다르며 결과는 %d 입니다", result);
        }
    }
}
