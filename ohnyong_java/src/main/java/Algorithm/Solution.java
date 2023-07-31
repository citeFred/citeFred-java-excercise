package Algorithm;

import java.util.Scanner;

public class Solution {
    int selectNum;
    int calNum;
    int num1;
    int num2;
    int result;
    Scanner sc = new Scanner(System.in);

    //Constructor 생성
    public Solution() {
        System.out.println("생성자호출됨");
    }

    //Menu 보여주는 메서드 showMenu()
    void showMenu() {
        System.out.println("원하시는 연산을 입력해주세요.");
        System.out.println("[1]더하기");
        System.out.println("[2]빼기");
        System.out.println("[3]곱하기");
        System.out.println("[4]나누기");
    }

    //Menu 선택하는 메서드 chooseMenu()
    void chooseMenu(int selectNum) {
        for (; ; ) {
            if (selectNum == 1) {
                System.out.println("더하기 연산을 시작합니다.");
                break;
            } else if (selectNum == 2) {
                System.out.println("빼기 연산을 시작합니다.");
                break;
            } else if (selectNum == 3) {
                System.out.println("곱하기 연산을 시작합니다.");
                break;
            } else if (selectNum == 4) {
                System.out.println("나누기 연산을 시작합니다.");
                break;
            } else {
                System.out.println("잘못된 값을 입력했습니다.\n계산기를 다시 사용하시겠습니까?\n[1]예 [2]아니오");
                int tryNum = sc.nextInt();
                if (tryNum == 1) {
                    showMenu();
                } else {
                    System.out.println("프로그램을 종료합니다.");
                    exit();
                }
                break;
            }

        }
            inputNum(selectNum);

    }

void inputNum(int selectNum) {
        calNum = selectNum;
        //Num1 입력
        System.out.println("num1을 입력해주세요");
        num1 = sc.nextInt();
        //Num2 입력
        System.out.println("num2를 입력해주세요");
        num2 = sc.nextInt();

        calculate(calNum, num1, num2);
}

    //프로그램 종료 선택 시 Run을 종료하는 메서드 exit()
    void exit() {
        System.exit(0);
    }

    //메뉴에 따라 선택된 연산을 연결 후 반환 된 결과를 출력 하는 메서드 calculate()
    int calculate(int calNum, int num1, int num2) {
        if (calNum == 1) {
            result = summary(num1, num2);
            System.out.println("result : " + num1 + "+" + num2 + "=" + result);

        } else if (calNum == 2) {
            result = subtract(num1, num2);
            System.out.println("result : " + num1 + "-" + num2 + "=" + result);

        } else if (calNum == 3) {
            result = multiplication(num1, num2);
            System.out.println("result : " + num1 + "*" + num2 + "=" + result);

        } else {// int == 4
            result = division(num1, num2);
            System.out.println("result : " + num1 + "/" + num2 + "=" + result);

        }
        return result;
    }

    //-----------------연산 메서드-------------------
    //두 수의 합를 구하는 메서드 summary()
    int summary(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    //두 수의 차를 구하는 메서드 subtract()
    int subtract(int num1, int num2) {
        result = num1 - num2;
        return result;
    }

    //두 수의 곱을 구하는 메서드 multiplication()
    int multiplication(int num1, int num2) {
        result = num1 * num2;
        return result;
    }

    //두 수의 나눈 값을 구하는 메서드 division()
    int division(int num1, int num2) {
        result = num1 / num2;
        return result;
    }


}
