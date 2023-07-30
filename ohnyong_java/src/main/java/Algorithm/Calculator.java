package Algorithm;

public class Calculator {
    int num1;
    int num2;
    int result;
    boolean flag;

    public Calculator() {
        System.out.println("생성자호출됨");
    }

    int subtract(int num1, int num2) {
        result = 0;
        //if(num1 <= -50000 && num1 >= 50000){
        //    flag = false;
        //} else if (num2 <= -50000 && num2 >=50000) {
        //    flag = false;
        //} else{
        //    flag = true;
        //}

        //while(flag) {
        if((num1 <= -50000 && num1 >= 50000)&&(num2 <= -50000 && num2 >=50000) ){
        result = num1 - num2;

        }
        //}
        return result;
    }
}
