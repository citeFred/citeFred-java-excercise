package Algorithm11;

import java.util.Scanner;

public class Solution {
    //옷가게 할인 받기
    //문제 설명
    //int price 옷 가격 input scanner
    //int bill 결제 금액 outputBill(){}
    //머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
    //구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
    //
    //제한사항
    //10 ≤ price ≤ 1,000,000
    //price는 10원 단위로(1의 자리가 0) 주어집니다.
    //소수점 이하를 버린 정수를 return합니다. Math
    double price;
    double discount5 = 0.95;
    double discount10 = 0.90;
    double discount20 = 0.80;
    String dcFlag;
    int bill;
    int dcDifferbill;
    Scanner sc = new Scanner(System.in);


    public Solution() {
        //기본성생저
    }

    void inputPrice() {
        while (true) {
            System.out.println("옷 가격을 입력해주세요.");
            //10 ≤ price ≤ 1,000,000
            price = sc.nextInt();
            if (price < 10 || price > 1000000) {
                System.out.println("금액은 10원~100만원 범위로 입력해주세요.");
                continue;
            }
            System.out.println(price);
            calculate(price);
            break;
        }
    }
    //price는 10원 단위로(1의 자리가 0) 주어집니다.
    //소수점 이하를 버린 정수를 return합니다. Math

    void calculate(double price) {
        if (price >= 100000 && price < 300000) {
            bill = (int)(discount5 * this.price);
            dcFlag = "5%";
            dcDifferbill = (int)this.price - bill;
        } else if (price >= 300000 && price < 500000) {
            bill = (int)(discount10 * this.price);
            dcFlag = "10%";
            dcDifferbill = (int)this.price - bill;
        } else if (price >= 500000) {
            bill = (int)(Math.floor(discount20 * this.price));
            dcFlag = "20%";
            dcDifferbill = (int)this.price - bill;
        }else{
            dcFlag = "0";
            bill = (int)price;
        }
        System.out.println(bill);
        outputBill(bill, dcFlag, dcDifferbill);
    }

    void outputBill(int bill, String dcFlag, int dcDifferbill) {
        if (dcFlag == "0"){
            System.out.printf("해당 상품은 추가 할인이 없으며 결제하실 금액은 %,d원 입니다.",bill);
        }else {
            System.out.printf("주문하신 상품은 %s할인이 적용되어\n할인 금액은 %,d원이며\n 결제하실 금액은 %,d입니다.", dcFlag,dcDifferbill,bill);
        }
    }
}
