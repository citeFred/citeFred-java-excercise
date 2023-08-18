import java.util.Arrays;

public class Main {
    static int[] arr2;
    static long answer;
    static int n;
    //Q1. 90점을 넘으면 A등급, 아니라면 B등급을 출력하는 소스코드입니다. 빈칸에 들어갈 알맞은 소스코드는?
    public static void main(String[] args){
        n = 3;
        double n2 = n;
        double x = Math.sqrt(n2);
        System.out.println(x); //1
        if(n%x == 0){
            answer = (long) ((x+1)*(x+1));
        }else if(n%x != 0){
            answer = -1;
        }
        System.out.println(answer);
    }
}