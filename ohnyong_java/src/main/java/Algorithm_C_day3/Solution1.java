package Algorithm_C_day3;

/*더 맵게
문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로
섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
입출력 예
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
입출력 예 설명
스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
가진 음식의 스코빌 지수 = [13, 9, 10, 12]

모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.*/

import java.util.ArrayList;
import java.util.Comparator;

public class Solution1 {
    public int Solution1 (int[] scovilleArr, int targetK){
        // 1. 정렬이 되야한다.
        // 2. 0번째 값이 k보다 커져야 한다.
            // 3-1. 작은 경우, 0,1 번째 음식을 빼낸다.
            // 3-2 두개를 섞는다. newFood = arr[0] + (arr[1]*2)
            // 3-3 섞은 횟수가 1 증가한다 mixCnt++;
            // 3-3. newFood 는 다시 음식 배열에 들어간다
        // 4. 다섞어서 음식이 하나남았는데도 K보다 작다면 -1을 반환한다.

        int answer = 0;
        int mixCnt = 0;
        ArrayList<Integer> foods = new ArrayList<>();
        for(int i=0;i< scovilleArr.length;i++) {
            foods.add(scovilleArr[i]);
            foods.sort(Comparator.naturalOrder());
        }

        while (foods.get(0) < targetK) {
            if (foods.size() < 2) {
                // 음식이 하나만 남았는데도 K 이상이 되지 않으면 -1 반환
                return -1;
            }

            int newFood = foods.get(0) + (foods.get(1) * 2);
            mixCnt++;
            foods.remove(0); // 첫 번째 음식 제거
            foods.remove(0); // 두 번째 음식 제거
            foods.add(newFood); // 새로운 음식 추가
            foods.sort(Comparator.naturalOrder()); // <<<<<<< - 매번 정렬하는 것에서 효율성 테스트에서 문제가 발생하고 있다.
            //그럼 foods에서 가장 작은값, 그다음 값을 정렬에서 0,1번째 말고 다른 방법으로 빼올 수 있을까?

        }
        answer = mixCnt;
        return answer;
    }
    public static void main(String[] args){
        Solution1 sol = new Solution1();
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(sol.Solution1(scoville, k));
    }
}
