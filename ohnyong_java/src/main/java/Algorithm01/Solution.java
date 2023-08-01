package Algorithm01;

import java.util.Scanner;

public class Solution {
    //note* 전역(Global) 변수로 선언되어 있어서 메뉴 변경이 어려웠던 부분
    //note* 메뉴 변경과 연결 된 selectNum을 해당 메서드 내부에 지역 변수로 반복문에서 초기화를 시키도록 재 배치 함.
    //int selectNum;

    //note* 필요없는 중복 변수인 calNum 제거, selectNum이 조건문을 혼자 컨트롤 할 수 있음
    //int calNum;

    //연산하고자하는 두 수의 유효성검사 -50000~50000 범위를 체크한 후, 계산할 준비가 된 숫자를 담을 *전역 변수*
    int num1; //입력 1
    int num2; //입력 2
    int result; //결과
    Scanner sc = new Scanner(System.in); //입력용 스캐너

    //Constructor 생성
    public Solution() {
        System.out.println("Calculator is ready to use");
    }

    //--START----------[프로그램 핵심 비지니스 로직 부분]-------------------
    //계산기 메인 실행 메서드 runCalculator()
    void runCalculator() {
        while (true) {
            // 메뉴 호출
            showMenu();

            //selectNum을 지역변수로 만들어서 continue로 반복 되어 돌아 올 때, 해당 값을 다시 초기화 할 수 있도록
            int selectNum = sc.nextInt();

            //Menu 선택하는 부분
            if (selectNum >= 1 || selectNum <= 5) {
                if (selectNum == 1) {
                    System.out.println("더하기 연산을 시작합니다.");
                    inputNum(selectNum);
                    continue;
                } else if (selectNum == 2) {
                    System.out.println("빼기 연산을 시작합니다.");
                    inputNum(selectNum);
                    continue;
                } else if (selectNum == 3) {
                    System.out.println("곱하기 연산을 시작합니다.");
                    inputNum(selectNum);
                    continue;
                } else if (selectNum == 4) {
                    System.out.println("나누기 몫 연산을 시작합니다.");
                    inputNum(selectNum);
                    continue;
                } else if (selectNum == 5) {
                    System.out.println("나누기 나머지 연산을 시작합니다.");
                    inputNum(selectNum);
                    continue;
                } else if (selectNum == 0) {
                    exit();
                    break;
                } else {
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    tryAagin();
                }
            }
        }
    }

    //계산 할 2개의 값을 입력 받는 메서드 inputNum()
    void inputNum(int selectNum) {
        //note* 기존 중복되는 의머없는 변수인 calNum을 모두 제거함
        //note* calculate(calNum, ...) 메서드의 매개 변수도 모두 calculate(selectNum, ...)으로 변경하여 간결하게 작성함.
        //int calNum = selectNum

        //----Num1 입력 및 유효성 검사 부분----
        while (true) {
            //note* 전역 변수였던 num1을 반복문 내 지역 변수로 만들어서 유효성검사의 초기화를 진행
            int num1 = 0;
            //Num1 입력 및 입력 가능 범위 유효성검사
            System.out.print("num1을 입력해주세요. ==> ");
            num1 = sc.nextInt();
            if (num1 <= -50000 || num1 >= 50000) {
                System.out.println("입력 값은 -50000~50000 범위로만 입력해주세요.");
                continue;
            }
            //note* 지역변수인 num1(반복문내)의 유효성 검사가 통과하면, 전역 변수인 num1에 할당하면서 계산기에 전달 준비
            this.num1 = num1;
            break;
        }

        //----Num2 입력 및 유효성 검사 부분----
        while (true) {
            //note* 전역 변수였던 num2을 반복문 내 지역 변수로 만들어서 유효성검사의 초기화를 진행
            int num2 = 0;
            //Num2 입력 및 입력 가능 범위 유효성검사
            System.out.print("num2를 입력해주세요. ==> ");
            num2 = sc.nextInt();
            if (num2 <= -50000 || num2 >= 50000) {
                System.out.println("입력 값은 -50000~50000 범위로만 입력해주세요.");
                continue;
            }
            //note* 지역변수인 num2(반복문내)의 유효성 검사가 통과하면, 전역 변수인 num2에 할당하면서 계산기에 전달 준비
            this.num2 = num2;
            break;
        }
        //note* 유효성 검사가 완료된 Global 스코프의 준비된 계산 숫자 num1, num2을 파라미터에 담아 계산 메서드에 전달
        calculate(selectNum, num1, num2);
    }

    //메뉴에 따라 선택된 연산 메서드에 연결 및 반환 된 결과를 출력 하는 메서드 calculate()
    //note* inputNum() 메서드에서 유효성검사를 통과하여 전역변수에 담긴 num1, num2는 이곳으로 옵니다.
    int calculate(int selectNum, int num1, int num2) {
        if (selectNum == 1) {
            result = summary(num1, num2);
            showOutput(selectNum, num1, num2, result);
        } else if (selectNum == 2) {
            result = subtract(num1, num2);
            showOutput(selectNum, num1, num2, result);
        } else if (selectNum == 3) {
            result = multiplication(num1, num2);
            showOutput(selectNum, num1, num2, result);
        } else if (selectNum == 4) {// int == 4
            result = divisionQuiotient(num1, num2);
            showOutput(selectNum, num1, num2, result);
        } else if (selectNum == 5) {// int == 4
            result = divisionRemainder(num1, num2);
            showOutput(selectNum, num1, num2, result);
        } else {
            exit();
        }
        return result;
    }
    //--END------------[프로그램 핵심 비지니스 로직 부분]-------------------


    //--START----------[VIEW, OUTPUT PRINT, EXIT 기능적 부분]-------------------
    // Menu판 View 구성 메서드 showMenu()
    void showMenu() {
        System.out.println("==========================");
        System.out.println("||\t\t김인용의 계산기\t\t||");
        System.out.println("|| 원하시는 연산을 선택해주세요 ||");
        System.out.println("==========================");
        System.out.println("||\t[1] 더하기\t\t\t||");
        System.out.println("||\t[2] 빼기\t\t\t\t||");
        System.out.println("||\t[3] 곱하기\t\t\t||");
        System.out.println("||\t[4] 나눈몫\t\t\t||");
        System.out.println("||\t[5] 나눈나머지\t\t\t||");
        System.out.println("==========================");
        System.out.println("||\t[0] 프로그램 종료\t\t||");
        System.out.println("==========================");
        System.out.print("원하는 기능 번호를 기입해주세요. ==> ");
    }

    // 결과 출력 View 구성 메서드 showOutput()
    void showOutput(int selectNum, int num1, int num2, int result) {
        switch (selectNum) {
            case 1:
                System.out.printf("result : %d + %d = %d%n", num1, num2, result);
                tryAagin();
                break;
            case 2:
                System.out.printf("result : %d - %d = %d%n", num1, num2, result);
                tryAagin();
                break;
            case 3:
                System.out.printf("result : %d * %d = %d%n", num1, num2, result);
                tryAagin();
                break;
            case 4:
                System.out.printf("result : %d / %d = %d%n", num1, num2, result);
                tryAagin();
                break;
            case 5:
                System.out.printf("result : %d % %d = %d%n", num1, num2, result);
                tryAagin();
                break;
            default:
                break;
        }
    }

    void tryAagin() {
        while (true) {
            System.out.println("계산기를 계속 이용하시겠습니까?\n[1]예 [2]아니오");
            int tryNum = sc.nextInt();
            if (tryNum == 1) {
                break;
            } else {
                exit();
                break;
            }
        }
    }

    // 프로그램 종료 선택 시 Run을 종료하는 메서드 exit()
    void exit() {
        System.out.println("프로그램을 종료합니다. 좋은하루되세요!");
        System.exit(0);
    }
    //--END------------[VIEW, OUTPUT PRINT, EXIT 기능적 부분]-------------------


    //--START----------[핵심 4칙 연산 메서드 부분]-------------------
    //두 수의 합를 구하는 메서드 summary()
    int summary(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    //두 수의 차를 구하는 메서드 subtract()
    int subtract(int num1, int num2) {
        result = num1 - num2;
        return result;
    }

    //두 수의 곱을 구하는 메서드 multiplication()
    int multiplication(int num1, int num2) {
        result = num1 * num2;
        return result;
    }

    //두 수의 나눈 몫을 구하는 메서드 divisionQuiotient()
    int divisionQuiotient(int num1, int num2) {
        result = num1 / num2;
        return result;
    }

    //두 수의 나눈 나머지를 구하는 메서드 divisionQuiotient()
    int divisionRemainder(int num1, int num2) {
        result = num1 % num2;
        return result;
    }
}
//--END------------[핵심 4칙 연산 메서드 부분]-------------------