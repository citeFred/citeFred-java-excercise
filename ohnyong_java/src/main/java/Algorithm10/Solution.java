package Algorithm10;

import java.util.Scanner;

public class Solution {
    /*문제 설명
머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. int americanoCup
아이스 아메리카노는 한잔에 5,500원입니다. int americanoPrice
머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, int pocketMoney <- inputMoney(){}
머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 int maxBuy
 남는 돈을 순서대로  int leftMoney
 담은 배열을 -> arr[maxBuy, leftMoney]
 return 하도록 solution 함수를 완성해보세요.
*/
    int americanoCup;
    int americanoPrice = 5500;
    int pocketMoney;
    int leftMoney;
    int maxBuy;
    int arr[] = new int[2];
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    //제한사항

    //0 < money ≤ 1,000,000*
    void inputMoney() {
        System.out.println("머쓱이에게 줄 용돈 금액을 입력해주세요.");
        System.out.print("(원)==>");
        while (true) {
            pocketMoney = sc.nextInt();
            if (pocketMoney < 0 && pocketMoney > 1000000) {
                System.out.println("너무 많은 금액입니다. 100만원 이하로 입력해주세요.");
                continue;
            }
            calculate(pocketMoney);
            break;
        }
    }

    void calculate(int pocketMoney) {
    //    if 10000원 주면, 1잔 가지게되고, 4500원 남는다.
    //    if 13000원 주면, 2잔 가지게되고, 2000원 남는다.
    //        pocketmoney,  americanoPrice,  leftmoney
    //     10000/5500 = 1.818181..
    //     13000/5500 = 2.3636.. => 2 => americanoCup
    //    내림이 필요하다. Math
    //    Math.floor() 그럼, 잔수 해결, 남은돈? pocketMoney - (americanoCup*americanoPrice)
    //    돈을 double로 실수표현 강제형변환하고, 그 결과를 내려서, int로 형변환해서 cup에 담자.
        americanoCup = (int)Math.floor((double)pocketMoney/americanoPrice);
        leftMoney = pocketMoney - (americanoCup*americanoPrice);
        //담자.
        arr[0]=americanoCup;
        arr[1]=leftMoney;
        output(arr);
    }

    void output(int arr[]) {
        System.out.printf("머쓱이는 용돈을 %,d원 받았는데,\n이걸로 아메리카노 %d개를 사먹을 수 있어요.\n다 사먹으면 %,d원 남겠네요.",pocketMoney,arr[0],arr[1]);
    }
}
