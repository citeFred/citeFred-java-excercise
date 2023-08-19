import java.util.Arrays;

public class Main {
    static int[] arr2;
    static long answer;
    static int n;
    static int x = 10;
    //Q1. 90점을 넘으면 A등급, 아니라면 B등급을 출력하는 소스코드입니다. 빈칸에 들어갈 알맞은 소스코드는?
    public static void main(String[] args){
        String xStr = Integer.toString(x);
        int sum = 0;
        boolean answer = true;
        for(int i=0;i<xStr.length();i++){

            sum += Character.getNumericValue(xStr.charAt(i)); // 문자열의 각 문자를 정수로 변환하여 더함
            // sum += Integer.parseInt(xStr[i]);
/*
13 -> 1+3 = 4 X
82 -> 8+2 = 10 X
18 -> 1+8 = 9 O
10 -> 1+0 = 1 O
20 -> 2+0 = 2 O
*/
        }
        System.out.println(sum);
        System.out.println(10/1);
        int hsdNum= sum%x;
        System.out.println(hsdNum);
        if(x%sum == 0 ){
            answer = true;
        }else if(x%sum != 0){
            answer = false;
        }

        System.out.println(answer);
    }

}