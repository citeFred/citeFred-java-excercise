package Algorithm_C_day10;

//코드 2(인접행렬, BFS)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main4 {
    static int map[][];		// 각 정점간 탐색 경로 저장
    static boolean visit[];	// 정점 탐색여부 체크
    static int n, m, v;		// 정점, 간선, 시작 정점
    static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수

    public static int bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visit[i] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int k=1; k<=n; k++) {
                if(map[temp][k] == 1 && visit[k] == false) {
                    q.offer(k);
                    visit[k] = true;
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();	// 컴퓨터 수(정점)
        m = scan.nextInt();	// 연결된 컴퓨터 쌍의 수(간선)
        v = 1;	// 탐색 시장할 정점의 번호
        map = new int[n+1][n+1];	// 각 정점간 탐색 경로를 저장할 배열
        visit = new boolean[n+1];	// 정점의 탐색 여부 체크

        // 인접행렬을 이용한 풀이
        for(int i=0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            map[a][b] = map[b][a]= 1;
        }

        System.out.println(bfs(1));
        scan.close();

    }

}