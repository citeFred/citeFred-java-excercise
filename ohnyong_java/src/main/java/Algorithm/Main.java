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
        //선택 연산확인 메서드
        solution.chooseMenu(solution.selectNum = sc.nextInt());
    }
}
