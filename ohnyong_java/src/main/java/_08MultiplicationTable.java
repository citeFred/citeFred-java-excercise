import java.util.Scanner;

public class _08MultiplicationTable {
    public static void main(String[] args) {
        //구구단 만들어 보기
        //2단부터 9단까지
        //Scanner sc = new Scanner(System.in);
        //int passNum = sc.nextInt(); // 출력을 제외 할 구구단 수 입력
        //for (int i = 2; i <= 9; i++) {//구구단의 첫번쨰 수
        //    if(i== passNum){
        //        continue;//Scanner 인풋값의 단은 건너 뛰고 출력
        //    }
        //    for (int j = 2; j <= 9; j++) {//구구단의 두번째 수
        //        System.out.println(i + " * " + j + " = " + (i * j) + "입니다.");
        //    }
        //}

        //특정한 단만 출력하는 구구단 연습
        // 그 출력할 단수는 앞의 숫자가 단을 나타낸다.
        // => 받은 값이 아닌 단들은 Continue하라는 의미로 해석
        // 어짜피 반복문은 계속 돈다, 그럼 출력 위치를 조절해야 한다.
        // 그 조건은 인풋값과 i값이 같을 때 인데 뒷수까지 나오는 곳은 j반복문 안쪽이다.
        // j 반복문 안에서 출력에 대한 조건이 있어야 한다.
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt(); //출력 할 구구단 수 입력.
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                if (inputNum == i) {
                    System.out.println(i + " * " + j + " = " + (i * j) + "입니다.");
                }
            }
        }
    }
}
