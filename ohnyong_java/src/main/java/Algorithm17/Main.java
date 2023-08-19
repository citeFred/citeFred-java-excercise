package Algorithm17;

import java.util.Arrays;

public class Main {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr); //먼저 정렬

        int count = 0;

        for (int i=0;i<arr.length;i++){
            if(arr[i] % divisor == 0){ //나누어떨어지면
                count++;
            }
        }

        int[] answer = new int[count];

        for (int i=0;i<answer.length;i++){
            if(answer[i] % divisor == 0){
                answer[i] = arr[i];
            }
        }
        if(count == 0){
            answer = new int[]{-1};
        }
        return answer;
    }
}
