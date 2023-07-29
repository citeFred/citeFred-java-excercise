package _06OOP;

import java.util.Scanner;
//#Algorithm Test 문제용 테스트#

/*정수 num1과 num2가 주어질 때,

num1과 num2의 합을 return

하도록 soltuion 함수를 완성해주세요.
*/

//클래스를 생성하여 설계도를 만들자.
public class _02Prac_Summary {
    // sum() 이라는 메서드는 입력된 두 수를 더하는 "동작"을 한다.
    static int num1;
    static int num2;

    //두 수의 합
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        //Prac02_SolutionClass 클래스의 설계도를 살펴 볼 객체 생성
        _01Prac_HowToMakeClass test = new _01Prac_HowToMakeClass(); // 위 선언한 생성자를 호출하여, 객체를 new로 생성 했다. -> Prac02()가 메모리에 올라갔다.
        System.out.println("이 값은 인스턴스 변수입니다. :" + test.x);
        System.out.println("이 값은 클래스 변수(Static으로 패키지 내 공유됨//중복을 조심)입니다. :" + _01Prac_HowToMakeClass.z);


        //두 수의 합 테스트
        Scanner sc = new Scanner(System.in);
        _02Prac_Summary solution = new _02Prac_Summary();
        //solution이라는 객체를 생성한다.

        //스캐너로 입력 받은 값을 변수 num1, num2에 저장한다.
        System.out.println("#알고리즘 문제용 변수 Num1입력해주세요. :");
        num1 = sc.nextInt();
        System.out.println("#알고리즘 문제용 변수 Num2입력해주세요. :");
        num2 = sc.nextInt();

        //solution객체의 sum이라는 메서드에 변수로 저장한 num1, num2을 파라미터로 전달한다.
        int sum = solution.sum(num1, num2);
        System.out.println("#알고리즘 문제용 Num1+Num2의 합은 :" + sum);
    }

}
