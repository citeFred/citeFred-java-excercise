package Algorithm_C_day8;

/*타겟 넘버
문제 설명
n개의 음이 아닌 정수들이 있습니다.
이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.

입출력 예 #2

+4+1-2+1 = 4
+4-1+2-1 = 4
총 2가지 방법이 있으므로, 2를 return 합니다.*/
public class Solution {
    //처음에 올 수 있는 숫자가 +1, -1이 올 수 있고 +1을 선택했다고 가정하자
    //2. 그다음에는 역시나 +1, -1이 올 수 있다.
    //3. 이렇게 모든 경우의 수를 탐색하여 target이 되는 값을 찾아 나서면 된다.
    int answer = 0;

    //solution 메서드는 주어진 숫자 배열(numbers)과 목표 숫자(target)를 받아서
    // 그 조건에 맞는 방법의 수를 찾아 반환하는 역할.
    // 이 메서드에서는 dfs(Depth-First Search) 알고리즘을 사용해서 모든 경우의 수를 탐색해나가고,
    // 조건에 맞는 경우에는 정답(answer)을 증가시키고 리턴
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    //dfs 메서드는 재귀적으로 호출돼서 숫자를 더하거나 빼는 모든 경우의 수를 확인하는 역할
    // 이때, idx는 현재 확인하고 있는 숫자의 인덱스를 나타내고, sum은 누적된 합계
    private void dfs(int sum, int idx, int[] numbers, int target) {
        if (idx == numbers.length && sum == target) {
            answer++;
            return;
        }
        if (idx >= numbers.length) {
            return;
        }
        dfs(sum + numbers[idx], idx + 1, numbers, target); //+에대한 재귀 호출
        dfs(sum - numbers[idx], idx + 1, numbers, target); //-에대한 재귀 호출
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }
}
