package Algorithm04;

import java.util.Scanner;

public class Solution {
    //필요데이터
    //angleInputNum <-input 스캐너, int형, 0<angle<=180 제한사항 유효성체크 while,
    // angleStr <- 예각, 직각, 둔각, 평각 표현
    // angleOutputNum <-output
    //필요메서드
    //inputAngle()
    //calculate()
    //outputAngle()
    int angleInputNum;
    String angleStr;
    int angleOutputNum;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void intputAngle() {
        while (true) {
            System.out.println("각도를 입력해주세요.");
            angleInputNum = sc.nextInt();
            if (angleInputNum < 0 || angleInputNum > 180) {
                System.out.println("각도는 0~180도까지만 입력해주세요.");
                continue;
            } else {
                calculate(angleInputNum);
                break;
            }
        }
    }

    void calculate(int angleInputNum) {
        if (angleInputNum > 0 && angleInputNum < 90) {
            angleStr = "예각";
            angleOutputNum = 1;
            outputAngle(angleStr, angleOutputNum);
        } else if (angleInputNum == 90) {
            angleStr = "직각";
            angleOutputNum = 2;
            outputAngle(angleStr, angleOutputNum);
        } else if (angleInputNum > 90 && angleInputNum < 180) {
            angleStr = "둔각";
            angleOutputNum = 3;
            outputAngle(angleStr, angleOutputNum);
        } else if (angleInputNum == 180) {
            angleStr = "평각";
            angleOutputNum = 4;
            outputAngle(angleStr, angleOutputNum);
        } else {
            System.out.println("잘못된 접근 입니다.");

        }
    }

    void outputAngle(String angleStr, int angleOutputNum) {
        System.out.printf("입력하신 값은 %s이며 표현값은 '%d' 입니다.", angleStr, angleOutputNum);
    }
}
