package Algorithm09;

import java.util.Scanner;

public class Solution {
    /*문제 설명
사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다.
사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
스크린샷 2022-07-07 오후 3.27.04 복사본.png

x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
x 좌표 (x, y)를 차례대로 담은 정수 배열 dot이 매개변수로 주어집니다.
좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 return 하도록 solution 함수를 완성해주세요.*/
    //    dot의 길이 = 2
    //    dot[0]은 x좌표를, dot[1]은 y좌표를 나타냅니다
    //-500 ≤ dot의 원소 ≤ 500
    //    dot의 원소는 0이 아닙니다.

    //필요한 데이터
    //int x 입력 y 입력 2개
    //x, y 2개 값을 담는 배열
    //////////// [{x,y}, {x,y}, ... ] XXXX
    //////////// 그럼 가변배열이여야 되는가. XXXX
    //////////// 배열의 [n][0] idx = x XXXX
    //////////// 배열의 [n][1] idx = y XXXX
    // 제한조건을 늦게 봤다. 1차배열로 진행
    // [{x}, {y}] <- 1개의 배열, length = 2
    // 단건으로 찍어내는 것이다. 착각함.

    //연산은
    //x>0 && y>0 = 1 + "사분면"
    //x<0 && y>0 = 2 + "사분면"
    //x<0 && y<0 = 3 + "사분면"
    //x>0 && y<0 = 4 + "사분면"

    //메서드는 input x, y
    //계산 calculate(){}
    //output(){}

    int x;
    int y;
    String locationStr = "사분면";
    int[] arr;
    int locationNum;
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void inputElement() {
        //System.out.println("몇개의 점을 찍으시겠습니까?"); //배열의 크기 설정
        //arrSize = sc.nextInt();
        System.out.println("좌표의 x값을 입력하십시오.");
        arr = new int[2];
        while (true) {
            x = sc.nextInt();
            if (x < -500 || x > 500) {
                System.out.println("좌표 값은 -500~500 사이의 값을 입력해주십시오.");
                continue;
            }
            arr[0] = x;
            break;
        }

        System.out.println("좌표의 y값을 입력하십시오.");
        while (true) {
            y = sc.nextInt();
            if (y < -500 || y > 500) {
                System.out.println("좌표 값은 -500~500 사이의 값을 입력해주십시오.");
                continue;
            }
            arr[1] = y;
            break;
        }
        System.out.println("입력한 값은 [" + x + ", " + y + "] 입니다.");
        calculate(arr);
    }

    void calculate(int[] arr) {
        //x>0 && y>0 = 1 + "사분면"
        //x<0 && y>0 = 2 + "사분면"
        //x<0 && y<0 = 3 + "사분면"
        //x>0 && y<0 = 4 + "사분면"
        if (arr[0] > 0 && arr[1] > 0) {
            locationNum = 1;
        } else if (arr[0] < 0 && arr[1] > 0) {
            locationNum = 2;
        } else if (arr[0] < 0 && arr[1] < 0) {
            locationNum = 3;
        } else {
            locationNum = 4;
        }
        outputLocation(locationNum);
    }

    void outputLocation(int locationNum) {
        System.out.printf("입력한 좌표의 위치는 %d%s 입니다.", locationNum, locationStr);
    }
}
