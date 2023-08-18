package Algorithm15;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n;
        Solution solution = new Solution();
        while(true) {
            System.out.println("n을 입력해주세요.");
            n = sc.nextInt();
            if(n > 100000000 || n< 0){
                System.out.println("유효된 숫자 범위를 벗어났습니다.");
                continue;
            }
            solution.calculate(n);
            int result = 10%3;
            System.out.println(result);
            break;
        }

    }
}
