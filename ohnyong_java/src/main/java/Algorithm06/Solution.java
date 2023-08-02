package Algorithm06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {
/*"머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다. \n" + // lambDish , sodaCharge, sodaFree=lambDish 10th +1
"양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.\n" + // lambPrice 12000, sodaPrice 2000
" 정수 n과 k가 매개변수로 주어졌을 때,\n" +
" 양꼬치 n인분과 음료수 k개를 먹었다면 \n" + order(int lambDish, int sodaCan){return bill}
"총얼마를 지불해야 하는지 return 하도록" +
"\b solution 함수를 완성해보세요.\n" +
"\n" +
"제한사항\n" +
"0 < n < 1,000\n" +
"n / 10 ≤ k < 1,000\n" +
"서비스로 받은 음료수는 모두 마십니다.");
*/
    int lambDish;
    int sodaCharge;
    int sodaFree;
    int lambPrice;
    int sodaPrice;
    int lambBill;
    int sodaBill;
    int totalBill;
    Scanner sc = new Scanner(System.in);

    public Solution(){

    }

    void inputOrder(){
        while(true) {
            System.out.println("양꼬치는 1인분에 12,000원입니다.\n몇인분 주문하시겠습니까?\n숫자로 입력해주세요.");
            lambDish = sc.nextInt();
            if(lambDish<0 && lambDish>1000){
                System.out.println("너무 많은 수를 입력하셨습니다. 1,000개 이하로 다시 입력해주세요.");
                continue;
            }
            break;
        }
        while(true){
            System.out.println("양꼬치 10인분에 음료수가 1개 무료로 제공되는 이벤트를 진행중입니다.");
            System.out.println("추가로 주문하시는 음료수는 1개에 2,000원입니다.\n음료는 몇개 주문하시겠습니까?\n숫자로 입력해주세요.");
            sodaCharge = sc.nextInt();
            if (sodaCharge<0 && sodaCharge>1000){
                System.out.println("너무 많은 수를 입력하셨습니다. 1000개 이하로 다시 입력해주세요.");
                continue;
            }
            break;
        }
        calculate(lambDish, sodaCharge);
    }

    void calculate(int lambDish, int sodaCharge) {
        lambPrice = 12000;
        sodaPrice = 2000;
        sodaFree = lambDish/10;
        lambBill = lambDish*lambPrice;
        sodaBill = sodaCharge*sodaPrice;
        totalBill = lambBill+sodaBill;
        outputBill(lambBill, sodaBill, sodaFree, totalBill);
    }


    void outputBill(int lambBill, int sodaBill, int sodaFree, int totalBill){
        System.out.printf("주문하신 내용은 다음과 같습니다.\n양꼬치 : %d인분\n음료수 : %d개\n무료음료수 : %d개 이벤트 서비스\n", lambDish, sodaCharge, sodaFree);
        System.out.printf("--------계산서-------- \n양꼬치 : %,d원\n음료수 : %,d원\n--------------------\n총 금액 : %,d원 입니다.\n--------------------", lambBill, sodaBill, totalBill);
    }
}
