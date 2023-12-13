package Algorithm_C_day8;
/*게임 맵 최단거리
문제 설명
ROR 게임은 두 팀으로 나누어서 진행하며,
상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서,
각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.

지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다.
 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고,
 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.

최단거리1_sxuruo.png

위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다.
캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.

첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
최단거리2_hnjd3b.png

두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
최단거리3_ntxygd.png

위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로,
 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.

만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다.
 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.

최단거리4_of9xfg.png

게임 맵의 상태 maps가 매개변수로 주어질 때,
캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

제한사항
maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며,
상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
입출력 예
maps	answer
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
입출력 예 설명
입출력 예 #1
주어진 데이터는 다음과 같습니다.

최단거리6_lgjvrb.png

캐릭터가 적 팀의 진영까지 이동하는 가장 빠른 길은 다음 그림과 같습니다.

최단거리2_hnjd3b (1).png

따라서 총 11칸을 캐릭터가 지나갔으므로 11을 return 하면 됩니다.

입출력 예 #2
문제의 예시와 같으며, 상대 팀 진영에 도달할 방법이 없습니다. 따라서 -1을 return 합니다.*/

import java.util.*;

public class Solution2 {
    //    최단 경로를 찾는 문제로 BFS와 DFS 중 BFS가 더 유리
    //DFS는 모든 경로를 탐색한 후 거리를 비교해야하는 반면 BFS는 탐색 도중 타겟이 발견되면 바로 종료할 수 있기 때문
    //BFS기초 - Queue


    int[] dx = {1, 0, -1, 0}; // 이동 방향 x축
    int[] dy = {0, 1, 0, -1}; // 이동 방향 y축

    public int solution(int[][] maps) {
        int answer = 0;

        //맵의 크기에 맞게 visited 배열을 초기화하고,
        int[][] visited = new int[maps.length][maps[0].length];

        //BFS를 호출해서 최단거리를 찾아내는 역할을 하는 bfs 메서드를 호출
        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        //큐를 활용해서 탐색을 진행하고, 이동할 수 있는 경우에는 visited 배열에 거리를 업데이트하고 큐에 추가
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1)
                    continue;

                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }
    }

    public static void main(String[] args){
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(maps));
    }
}
