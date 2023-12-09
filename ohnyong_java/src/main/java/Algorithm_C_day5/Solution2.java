package Algorithm_C_day5;

import java.util.Arrays;

public class Solution2 {

    int solution(int k, int[][] dungeons) {
        int answer = 0;
        int currentStamina = k;

        // 던전을 "소모 피로도" 기준으로 오름차순 정렬
        Arrays.sort(dungeons, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < dungeons.length; i++) {
            if (currentStamina >= dungeons[i][0]) {
                // 현재 피로도가 해당 던전을 탐험하기에 충분하면
                currentStamina -= dungeons[i][1]; // 던전을 탐험하고 소모 피로도만큼 감소
                answer++;
            } else {
                // 던전을 탐험하기에 피로도가 부족하면 종료
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int k = 80;
        int[][] dungeons = {{80, 20}, {30, 10}, {50, 40}};

        System.out.println(sol.solution(k, dungeons));
    }
}
