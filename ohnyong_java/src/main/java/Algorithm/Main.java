package Algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Calculator calculator= new Calculator();
        System.out.println("num1을 입력해주세요");
        calculator.num1=sc.nextInt();
        System.out.println("num2를 입력해주세요");
        calculator.num2=sc.nextInt();
        System.out.println();
        calculator.result = calculator.subtract(calculator.num1, calculator.num2);
        System.out.println("result : "+calculator.num1+"-"+ calculator.num2+"="+ calculator.result);
    }
}
