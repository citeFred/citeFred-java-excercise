public class _06ControlFlowStatements {
    public static void main(String[] args) {
        //제어문(프로그램의 실행 방향을 제어하는 기능)
        // - 조건문 (if)
        // - 반복문 (for)

        //1)조건문
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
        //2)반복문


    }
}
