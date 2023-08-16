package JavaPrac2week;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    //CPU Hold input
    int ranNum1;
    int ranNum2;
    int ranNum3;
    int tryNum;
    int[] cpuNum = new int[3];

    //User Hold input
    String inputNumOrigin;
    int inputNumOriginParseInt;
    int inputNum1;
    int inputNum2;
    int inputNum3;
    int[] playerNum;

    //ouput
    int loseCnt = 0; // 시도 횟수
    boolean playerWon = false; // 성공 여부

    Scanner sc = new Scanner(System.in);

    public Solution() {

    }


    void run() throws InterruptedException {
        boolean continueGame = true;
        showTopMenu();

        while (continueGame) {
            try {
                if (!playerWon) {
                    cpuNum = inputCPU(); // 기존 cpuNum을 업데이트하여 중복 생성하지 않도록 수정
                    tryNum++;
                }

                int[] playerNum = inputPlayer(); // 사용자의 턴에서 입력 받음
                calculate(cpuNum, playerNum);
                output();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("InterruptedException occurred: " + e.getMessage());
            }
            continueGame = tryAgain();
        }
    }




    boolean cpuNumGenerated = false;

    int[] inputCPU() throws InterruptedException {
        if (!cpuNumGenerated) {
            // 첫 번째 게임에서만 랜덤한 값을 생성하여 cpuNum 배열에 저장
            ranNum1 = (int) Math.round((Math.random() * 9));
            ranNum2 = (int) Math.round((Math.random() * 9));
            ranNum3 = (int) Math.round((Math.random() * 9));

            cpuNum[0] = ranNum1;
            cpuNum[1] = ranNum2;
            cpuNum[2] = ranNum3;

            cpuNumGenerated = true;
        }

        showCpuTurn();
        //Thread.sleep(2000);

        // 첫 번째 공을 바라볼 때만 숫자를 생성하도록 수정
        System.out.println("========= 첫번째 공을 바라봅니다. ========");
        while (ranNum1 > 10 || ranNum1 <= 0) {
            showCpuMistake();
            ranNum1 = (int) Math.round((Math.random() * 9));
        }

        // 두 번째 공을 바라볼 때만 숫자를 생성하도록 수정
        System.out.println("========= 두번째 공을 바라봅니다. ========");
        while (ranNum1 > 10 || ranNum1 <= 0 || ranNum2 == ranNum1) {
            showCpuMistake();
            ranNum2 = (int) Math.round((Math.random() * 9));
        }

        // 세 번째 공을 바라볼 때만 숫자를 생성하도록 수정
        System.out.println("========= 세번째 공을 바라봅니다. ========");
        while (ranNum1 > 10 || ranNum1 <= 0 || ranNum3 == ranNum1 || ranNum3 == ranNum2) {
            showCpuMistake();
            ranNum3 = (int) Math.round((Math.random() * 9));
        }

        cpuNum[0] = ranNum1;
        cpuNum[1] = ranNum2;
        cpuNum[2] = ranNum3;
        System.out.println("cpuNum[0]: " + cpuNum[0]);
        System.out.println("cpuNum[1]: " + cpuNum[1]);
        System.out.println("cpuNum[2]: " + cpuNum[2]);
        return cpuNum;
    }

    int[] inputPlayer() {
        showPlayerTurn();
        while (true) {
            inputNumOrigin = sc.nextLine();
            System.out.println("입력된 값: " + inputNumOrigin); // 입력 값을 확인하기 위해 출력

            if (inputNumOrigin.isEmpty()) {
                System.out.println("값을 입력해주세요.");
                continue;
            }

            inputNumOriginParseInt = Integer.parseInt(inputNumOrigin);

            if (inputNumOriginParseInt < 0 || inputNumOriginParseInt > 999) {
                showPlayerMistake1();
            } else {
                inputNum1 = inputNumOriginParseInt / 100;
                inputNum2 = (inputNumOriginParseInt / 10) % 10;
                inputNum3 = inputNumOriginParseInt % 10;

                System.out.println("inputNum1: " + inputNum1);
                System.out.println("inputNum2: " + inputNum2);
                System.out.println("inputNum3: " + inputNum3);

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


    void calculate(int[] cpuNum, int[] playerNum) {
        String[] resultStr = new String[3];
        int strikeChecker = 0; // SSS 체크용
        for (int i = 0; i < 3; i++) {
            if (cpuNum[i] == playerNum[i]) {
                System.out.println("================ Strike!! ================");
                resultStr[i] = "S";
                strikeChecker++;
            } else {
                System.out.println("================= Ball!! =================");
                resultStr[i] = "B";
            }
        }
        if (strikeChecker == 3) {
            playerWon = true; // SSS일때만 넘어가게
        }
    }

    void output() throws InterruptedException {
        if (playerWon) {
            System.out.println("성공하셨습니다! " + tryNum + "번만에 성공하셨습니다!");
        } else {
            System.out.println("앗.. 잘못 던져서 쫓겨났어요, 다음 투수로 도전합니다.");
        }
    }

    boolean tryAgain() throws InterruptedException {
        if (playerWon) {
            System.out.println("재도전하시겠습니까?");
            System.out.println("  [1] YES  /  [2] No Thanks  ");
            tryNum = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            if (tryNum == 1) {
                System.out.println("게임을 다시 시작합니다.");
                cpuNumGenerated = false; // cpuNum 초기화
                playerWon = false; // playerWon 초기화
                loseCnt = 0; // 실패 횟수 초기화
                return true;
            } else if (tryNum == 2) {
                System.out.println("즐거운 게임이었습니다!! 좋은 하루 되세요.");
                return false;
            } else {
                System.out.println("잘못된 접근입니다. 프로그램을 종료합니다.");
                return false;
            }
        } else {
            // 성공하지 못한 경우에는 바로 다시 시작
            System.out.println("게임을 다시 시작합니다.");
            loseCnt = 0; // 실패 횟수 초기화
            return true;
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
        System.out.println("=========== 당신은 투수입니다. ===========");
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
        System.out.println("=========== 다시 입력해주세요. ===========");
    }

    void showPlayerMistake2() {
        System.out.println("=== 중복된 숫자는 허용되지 않는다구요! ===");
        System.out.println("=========== 다시 입력해주세요. ===========");
    }
}
