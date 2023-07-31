package Algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 객체 생성(입력위해)
        Scanner sc = new Scanner(System.in);
        //계산기 객체 생성
        Solution solution = new Solution();
        //메뉴 보여주기 메서드
        solution.showMenu();
        int selectNum = sc.nextInt();
        //선택 연산확인 메서드
        solution.chooseMenu(selectNum);

        //Num1 입력
        System.out.println("num1을 입력해주세요");
        int num1 = sc.nextInt();
        //Num1 입력
        System.out.println("num2를 입력해주세요");
        int num2 = sc.nextInt();

        System.out.println();
        //선택 메뉴 메서드로 이동하여 내부 연산 메서드 호출, 반환 값을 result 저장
        int result = solution.calculate(selectNum, num1, num2);
    }
}
