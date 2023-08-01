package Algorithm02;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Solution {
    int age; //입력 나이 //0<age<=120 //0=0+1=1살
    int birthYear; //출생 년도
    int currentYear; //현재 년도
    int result; //계산결과 = ????년생
    Scanner sc = new Scanner(System.in);

    public Solution() {
        //기본 생성자

    }

    //필요한 함수
    //inputAge(){}; 나이 입력
    //유효성검사 나이입력 범위 0<age<=120만 허용
    //calculate(){}; 나이 계산 = currentYear - (age -1) = birthYear //ex) 2023-(36-1) =
    //outputBirthYear(){} 계산 결과 알려주기

    void inputAge() {
        while (true) {
            int age;
            System.out.println("출생년도를 알고싶은 사람의 나이를 입력하세요");
            age = sc.nextInt();
            if (age < 0 || age >= 120) {
                System.out.println("나이는 1~120까지만 입력 할 수 있습니다.");
                continue;
            }else {
                calculate(age);
                outputBirthYear(result);
                break;
            }
        }
    }

    void calculate(int age) {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();

        result = currentYear - (age-1);
    }

    void outputBirthYear(int result) {
        System.out.println("당신은 "+result+"년생입니다.");
    }
}
