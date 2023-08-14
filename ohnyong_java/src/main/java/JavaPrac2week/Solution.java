package JavaPrac2week;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    //CPU Hold input
    int ranNum1;
    int calNum1;
    int ranNum2;
    int calNum2;
    int ranNum3;
    int calNum3;
    int tryNum;
    int[] cpuNum;

    //User Hold input
    String inputNumOrigin;
    int inputNumOriginParseInt;
    int inputNum1;
    int inputNum2;
    int inputNum3;
    int[] playerNum;

    //ouput
    String resultStr[]; //S, B
    int outputTryNum;

    Scanner sc = new Scanner(System.in);

    public Solution() {

    }


    void run() throws InterruptedException {
        while (true) {
            showTopMenu();
            Thread.sleep(2000);
            int[] playerNum = inputPlayer();
            Thread.sleep(2000);
            int[] cpuNum = inputCPU();
            Thread.sleep(2000);
            String[] resultStr = calculate(cpuNum, playerNum);
            Thread.sleep(2000);
            output(resultStr);
            if (!tryAgain()) {
                break;
            }
        }
    }


    int[] inputCPU() throws InterruptedException {
        showCpuTurn();
        //Thread.sleep(2000);
        System.out.println("========== 첫번째 공을 쳐봅니다. =========");
        while (true) {
            ranNum1 = (int) Math.round((Math.random() * 9));
            if (ranNum1 > 9 || ranNum1 < 0) {
                showCpuMistake();
                continue;
            } else if (ranNum1 >= 0 || ranNum1 < 10) {
                //System.out.println("ranNum1 생성 완료 ==>" + ranNum2);
                break;
            }
        }
        //Thread.sleep(2000);
        System.out.println("========== 두번째 공을 쳐봅니다. =========");
        while (true) {
            ranNum2 = (int) Math.round((Math.random() * 9));
            if (ranNum2 > 9 || ranNum2 < 0) {
                showCpuMistake();
                continue;
            } else if (ranNum2 >= 0 || ranNum2 < 10) {
                if (ranNum2 == ranNum1) {
                    showCpuMistake();
                    continue;
                }
                //System.out.println("ranNum2 생성 완료 ==>" + ranNum2);
                break;
            }
        }
        //Thread.sleep(1000);
        System.out.println("========== 세번째 공을 쳐봅니다. =========");
        while (true) {
            ranNum3 = (int) Math.round((Math.random() * 9));
            if (ranNum3 > 9 || ranNum3 < 0) {
                showCpuMistake();
                continue;
            } else if (ranNum3 >= 0 || ranNum3 < 10) {
                //System.out.println("ranNum3 생성 완료 ==>" + ranNum3);
                if (ranNum3 == ranNum1 && ranNum3 == ranNum2) {
                    showCpuMistake();
                    continue;
                }
                break;
            }
        }
        int[] cpuNum = new int[3];
        cpuNum[0] = ranNum1;
        cpuNum[1] = ranNum2;
        cpuNum[2] = ranNum3;
        return cpuNum;
    }

    int[] inputPlayer() {
        showPlayerTurn();
        while (true) {
            inputNumOrigin = sc.nextLine();
            inputNumOriginParseInt = Integer.parseInt(inputNumOrigin);

            if (inputNumOriginParseInt < 100 || inputNumOriginParseInt > 999) {
                showPlayerMistake1();
            } else {
                inputNum1 = Integer.parseInt(inputNumOrigin.substring(0, 1));
                inputNum2 = Integer.parseInt(inputNumOrigin.substring(1, 2));
                inputNum3 = Integer.parseInt(inputNumOrigin.substring(2, 3));

                if (inputNum1 == inputNum2 || inputNum1 == inputNum3 || inputNum2 == inputNum3) {
                    showPlayerMistake2();
                } else {
                    break;
                }
            }
        }

        int[] playerNum = new int[3];
        playerNum[0] = inputNum1;
        playerNum[1] = inputNum2;
        playerNum[2] = inputNum3;
        return playerNum;
    }

    String[] calculate(int[] cpuNum, int[] playerNum) {
        String[] resultStr = new String[3];

        for (int i=0;i<3;i++) {
            if (cpuNum[i] == playerNum[i]) {
                System.out.println("================ Strike!! ================");
                resultStr[i] = "S";
            }else{
                System.out.println("================= Ball!! =================");
                resultStr[i] = "B";
            }
        }
        return resultStr;
    }

    void output(String[] resultStr) throws InterruptedException {
        boolean flag = true;
        for(int i = 0; i < resultStr.length; i++){
            if (resultStr[i].equals("S")) {
                flag = true;
            } else if (resultStr[i].equals("B")) {
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("삼진아웃! 모두 Strike!! Player가 이겼습니다.");
        } else if (!flag) {
            System.out.println("CPU에게 기회가있네요.. 처음부터 다시하죠?");
        }
    }

    boolean tryAgain() throws InterruptedException {
        System.out.println("  [1] YES  /  [2] No Thanks  ");
        tryNum = sc.nextInt(); // 전역 선언된 tryNum 변수에 값을 저장
        sc.nextLine();

        if (tryNum == 1) {
            System.out.println("게임을 다시 시작합니다.");
            return true;
        } else if (tryNum == 2) {
            System.out.println("즐거운 게임이었습니다!! 좋은 하루 되세요.");
            return false;
        } else {
            System.out.println("잘못된 접근입니다. 프로그램을 종료합니다.");
            return false;
        }
    }
    void showTopMenu() {
        System.out.println("==========================================");
        System.out.println("<<<<<< Player VS CPU BASEBALL GAME >>>>>>>");
        System.out.println("==========================================");
    }

    void showPlayerTurn() {
        System.out.println("==========================================");
        System.out.println("============== Player's Turn =============");
        System.out.println("==========================================");
        System.out.println("======= 3자리 숫자를 입력해 주세요 =======");
        System.out.println("===== 숫자를 맞춰서 아웃 시킬겁니다. =====");
        System.out.println("===== 중복 숫자는 허용되지 않습니다. =====");
        System.out.println("==========================================");
        System.out.print("ex)123==>");
    }

    void showCpuTurn() {
        System.out.println("==========================================");
        System.out.println("=============== CPU' s Turn ==============");
        System.out.println("==========================================");
        System.out.println("======= CPU가 방망이를 휘두릅니다. =======");
        System.out.println("========= 잠시만 기다려 주세요. ==========");
        System.out.println("==========================================");
    }

    void showCpuMistake() {
        System.out.println("======= 미끄러져서 다시 하자네요;; =======");
    }

    void showPlayerMistake1() {
        System.out.println("=== 숫자는 3자리를 입력해주세요 ex)123 ===");
    }

    void showPlayerMistake2() {
        System.out.println("=== 중복된 숫자는 허용되지 않는다구요! ===");
        System.out.println("=========== 다시 입력해주세요. ===========");
    }
}
