package Algorithm08;

import java.util.Scanner;

public class Solution {
    /*문제 설명
머쓱이네 피자가게는
피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다. pizza 1 -> piece 2~10
 피자 조각 수 slice(piece)와 piece -> how many slices do you want to cut it. inputPizzaCutAsk(){}
  피자를 먹는 사람의 수 n이 memberNum , how many people? inputMemberAsk(){}
   매개변수로 주어질 때,
   n명의 사람이 최소 한 조각 이상 피자를 먹으려면 memberNum
    최소 몇 판의 피자를 시켜야 하는지 orderPizzaNum
    를 return 하도록 solution 함수를 완성해보세요.

   비지니스 로직정리
   피자를 몇등분 해드릴까요? -> 몇명이서 드시나요? -> 그럼 몇판 시키셔야 합니다.

제한사항
2 ≤ slice ≤ 10
1 ≤ n ≤ 100*/
    double pizzaNum;
    int pieceNum;
    int memberNum;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void inputPizzaCutAsk() {
        System.out.println("피자를 몇등분 해드릴까요?");
        pieceNum = sc.nextInt();
        while (true) {
            if (pieceNum > 2 && pieceNum > 10) {
                System.out.println("피자는 2~10조각까지만 커팅해드릴 수 있어요.");
                continue;
            }
            break;
        }
        inputMemberAsk();
        calculate(pieceNum, memberNum);

    }
    void inputMemberAsk() {
        System.out.println("몇명이서 드실건가요?");
        memberNum = sc.nextInt();
        while (true) {
            if (memberNum < 1 && memberNum > 100) {
                System.out.println("인원은 1~100명으로만 입력해주세요.");
                continue;
            }
            break;
        }
    }

    void calculate(int pieceNum, int memberNum) {
    //    5조각을 해주세요, 3명입니다. == 피자 1개로 가능
    //    5*1 > 3
    //    piece*pizza >member
    //    member/piece < pizza
    //    3/5(==0.6) => 1
    //    5조각을 해주세요, 6명입니다. == 피자 2개 필요
    //    6/5(==1.2) => 2
    //    9조각을 해주세요 14명입니다.
    //    14/9 == 1.55.. 올림 =>2
        pizzaNum = Math.ceil((double)memberNum/pieceNum); //member는 int니 double형변환
        outputOrder((int)pizzaNum);//pizzaNum은 double이니 int로 형변환

    }

    void outputOrder(int pizzaNum) {
        System.out.printf("%d명이 드시려면 %d판을 시키셔야 합니다.", memberNum, pizzaNum);
    }

}
