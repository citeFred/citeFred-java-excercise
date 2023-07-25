import java.util.Objects;
import java.util.Scanner;

public class _07RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //A에게 값 입력 받기
        System.out.println("A입력 : ");
        String aHand = sc.nextLine();

        //B에게 값 입력 받기
        System.out.println("B입력 : ");
        String bHand = sc.nextLine();

        //두개의 값을 비교하는 메서드 ->Object.equals(좌,우) : 좌우가 같은 경우 true, 다른 경우 false.
        if (Objects.equals(aHand, "가위")) {
            if (Objects.equals(bHand, "가위")) {
                System.out.println("A랑 B랑 비겼습니다");
            } else if (Objects.equals(bHand, "바위")) {
                System.out.println("B가 이겼습니다.");
            } else if (Objects.equals(bHand, "보")) {
                System.out.println("A가 이겼습니다.");
            } else {
                System.out.println("B가 이상한 값을 입력했습니다.");
            }
        } else if (Objects.equals(aHand, "바위")) {
            if (Objects.equals(bHand, "가위")) {
                System.out.println("A랑 가 이겼습니다");
            } else if (Objects.equals(bHand, "바위")) {
                System.out.println("비겼습니다.");
            } else if (Objects.equals(bHand, "보")) {
                System.out.println("B가 이겼습니다.");
            } else {
                System.out.println("B가 이상한 값을 입력했습니다.");
            }
        } else if (Objects.equals(aHand, "보")) {
            if (Objects.equals(bHand, "가위")) {
                System.out.println("B가 이겼습니다");
            } else if (Objects.equals(bHand, "바위")) {
                System.out.println("A가 이겼습니다.");
            } else if (Objects.equals(bHand, "보")) {
                System.out.println("비겼습니다.");
            } else {
                System.out.println("B가 이상한 값을 입력했습니다.");
            }
        } else {
            System.out.println("A가 이상한 값을 입력했습니다.");
        }
    }
}
