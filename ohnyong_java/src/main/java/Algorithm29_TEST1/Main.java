package Algorithm29_TEST1;

import java.util.Arrays;

public class Main {

    //[2]계산부
    public int[][] solution(int[][] arr1, int[][] arr2, boolean[][] signs) {
        //행의 길이
        int answerRow = arr1.length;
        //열의 길이
        int answerCol = arr1[0].length;
        //답을 담을 배열 초기화
        int[][] answer = new int[answerRow][answerCol];

        for(int i=0;i<answerRow;i++){
            for(int j=0;j<answerCol;j++){
                if(signs[i][j] == true) {                                           //조건문으로 sign이 true이면 더하자. 빼는것은 그 외로 하자.
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }else{ //(signs[i][j] ==false)
                    answer[i][j] = -arr1[i][j] + -arr2[i][j];
                }
            }
        }

        return answer;                                                              //[3] 출력부 시작
    }
    public static void main(String[] args) {
        //[1] 계산기 생성으로부터 입력부 시작
        Main method = new Main();                                                       //계산기 생성
        int[][] arr1 = {{5,7,1},{2,3,5},{2,3,5}};                                                   //입력값 1
        int[][] arr2 = {{5,1,6},{7,5,6},{3,1,3}};                                                   //입력값 2
        boolean[][] signs={{true,true,false},{false,true,false},{true,true,true}};                           //입력값 3
        System.out.println(Arrays.deepToString(method.solution(arr1, arr2, signs)));
    }
}