package Algorithm07;

import java.util.Scanner;

public class Solution {
    /*문제 설명
머쓱이네 피자가게는
 피자를 일곱 조각으로 잘라 줍니다. pizzaNum=1 -> pieceNum = 7 , 2->14, ...
  피자를 나눠먹을 사람의 수 n이 주어질 때, inputMemberNum(){}
   모든 사람이 피자를 한 조각 이상 먹기 위해 memberPizza >= 1  , calculate(){}
    필요한 피자의 수를 return 하는 solution 함수를 완성해보세요. outputPizzaNum(){}

제한사항
1 ≤ memberNum ≤ 100
    */
    double pizzaNum;//피자개수
    int pieceNum;//조각개수
    int memberNum;//인원수
    int orderNum;//주문필요피자개수
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void inputMemberNum() {
        System.out.println("피자를 나눠 드실 인원수를 말씀해주세요.\n저희 가게는 7조각으로 나눠드려요.\n");
        while (true) {
            memberNum = sc.nextInt();
            if (memberNum < 1 || memberNum > 100) {
                System.out.println("인원 수는 1~100명으로 입력해주세요.");
                continue;
            }
            calcultate(memberNum);
            break;
        }
    }

    void calcultate(int memberNum) {
        /*5명일때 1개면 7조각이니 가능
         * 7명일땐 딱 맞음
         * 8명일땐 1조각이 부족해서 피자 2개가 되야함(14피스가되고)
         * 그럼 1~7명 8~14명 15~21명 으로 된다는것이면
         * pizza 수는 7의 배수와 관계가 있음
         * memberNum가 6 7 8 9 10 11 12 13 14이 입력 되었을 때,
         * 7로 나눈몫  0.85 / 1 / 1.14 / 1.28 / ...     1.85 / 2.0 이 되는데,
         * 피자 수는 그럼 소수점 올림 처리해버리면 된다.
         * ex1)6명이면 0.85면 올림으로 1로 올라가면서 피자 1개면 된다는것이고
         * ex2)8명이면 1.14인데 올림으로 2가되면서 피자 2개면 된다는 것
         * 그럼 나에게 필요한 것은 pizzaNum은 실수(소수점) 를 받을 준비가 되어야 한다. => double 바꿔야할까?
         * 실수를 올림 처리할 메서드가 필요하다. Math.ceil() 써보자. 여기서 바로 int로 형변환해서 할당해도 된다. */
        pieceNum = 7;
        pizzaNum = Math.ceil((double) memberNum / pieceNum);
        outputPizzaNum((int) pizzaNum);
    }

    void outputPizzaNum(int pizzaNum) {

        System.out.println(memberNum);
        System.out.printf("%d분이 나눠 드시려면 피자를 %d판 시키셔야 할 듯합니다.", memberNum, pizzaNum);
    }
}
