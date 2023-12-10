package Algorithm_C_day5;

public class Solution2 {

    public int solution(int k, int[][] dungeons) {
        /*
        ABC 이렇게 있다면
        ABC ACB BAC BCA CAB CBA 이렇게 던전을 갈 수 있다.

        모두 탐색을 하면서 visited의 최대값을 구하면 된다.
        * */

        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited);

        return max;

    }

    int max = Integer.MIN_VALUE;
    public void dfs(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        for(int i = 0; i<visited.length; i++) {
            if(visited[i]) {
                count++;
            }
        }
        if(count > max) {
            max = count;
        }


        for(int i = 0; i<dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(k, dungeons, visited);
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int k = 80;
        int[][] dungeons = {{80, 20}, {30, 10}, {50, 40}};

        System.out.println(sol.solution(k, dungeons));
    }
}
