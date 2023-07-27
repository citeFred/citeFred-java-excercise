package _03controlflow;

public class _06ControlFlowStatements {
    public static void main(String[] args) {
        //제어문(프로그램의 실행 방향을 제어하는 기능)
        // - 조건문 (if, Switch)
        // - 반복문 (for)

        //1.1)조건문 - if문
        //boolean flag = true;

        //기본 if, else
        boolean flag = false;

        if (flag) {
            //true인 경우
            System.out.println("값이 True입니다");
        } else {
            System.out.println("값이 False입니다");
        }

        //if, else if, else
        int number = 2;

        if (number == 1) {
            System.out.println("number값은 1입니다");
        } else if (number == 2) {
            System.out.println("number값은 2입니다");
        } else {
            System.out.println("number값은 모르는 값입니다.");
        }

        //중첩 if
        if (flag) {
            System.out.println("flag가 true입니다.");

            if (number == 1) {
                System.out.println("flag=true고, number=1");
            } else if (number == 2) {
                System.out.println("flag=true고, number=2");
            }
        } else {

            if (number == 1) {
                System.out.println("flag=false고, number=1");
            } else if (number == 2) {
                System.out.println("flag=false고, number=2");
            }
            System.out.println("flag가 false입니다");
        }

        //1.2)조건문 - Switch문
        int month = 8;
        String monthString = " ";

        switch (month) {
            // case ~ : 연산
            case 1:
                monthString = "1월";
                break;
            case 2:
                monthString = "2월";
                break;
            case 3:
                monthString = "3월";
                break;
            case 4:
                monthString = "4월";
                break;
            case 5:
                monthString = "5월";
                break;
            case 6:
                monthString = "6월";
                break;
            case 7:
                monthString = "7월";
                break;
            case 8:
                monthString = "8월";
                break;
            case 9:
                monthString = "9월";
                break;
            case 10:
                monthString = "10월";
                break;
            case 11:
                monthString = "11월";
                break;
            case 12:
                monthString = "12월";
                break;
            default:
                monthString = "알수없음";
        }
        System.out.println(monthString);

        //2)반복문

        //for (초기값 ; 조건문 ; 증가연산) {}
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " 번쨰 출력");
        }

        //향상된 for문
        // 기존 : for문안에 3개의 표현을 2개로 줄여줌
        // 배열에서 사용 할 수 있다. [{0, 1, 2}]에 각각 0, 1, 2 인덱스 번호를 활용한 것으로
        // number1에 index 한개씩 numbers 배열의 길이만큼 반복을 도는 것이다.
        int[] numbers = {3, 6, 8, 12, 15};
        for (int number1 : numbers) {
            System.out.println(number1 + " ");
        }


        //while문
        int number2 = 0;
        while (number2 < 3) {
            number2++;
            System.out.println(number2 + "출력");
        }
        //do while문
        int number3 = 5;
        do {
            //이 로직을 선행해야 하는 경우 do while을 쓴다.
            System.out.println(number3 + "출력");
        } while (number3 < 3);

        //break; <- 를 만나자마자 아래로 흐르지 않고 가장 가까운 블록의 for, while, switch을 중단! ,if를 중단시키는것이 아니다!!
        int number4 = 0;
        while (number4 < 3) {
            number4++;
            if (number4 == 2) {
                break;//num4가 2가 되면 while을 종료시킨다.
            }
            System.out.println(number4 + "출력");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("i= " + i);
            if (i == 2) {
                break; //i == 2일때 i로 도는 for문 종료
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("j= " + j);
                if (j == 2) {
                    break;//j == 2일때 j로 도는 for문 종료
                }
            }
        }

        //continue; <-를 만나면 바로 가까운 for while switch를 건너 수행 한다.

        int number5 = 0;
        while(number5 <3){
            number5++;
            if(number5==2){
                continue;
            }
            System.out.println(number5 + ":n5 출력");
        }
    }
}
