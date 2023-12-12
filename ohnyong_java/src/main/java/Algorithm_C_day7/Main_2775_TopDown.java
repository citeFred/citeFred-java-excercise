package Algorithm_C_day7;
/**/

    /*Top-Down VS Bottom-Up
Bottom-Up은 for문을 돌면서 DP에 담길 모든 값을 계산해야 한다.
Top-Down은 재귀 호출을 하면서 필요한 값만 계산한다.
 계산하는 횟수의 차이가 크다면 Top-Down이 유리할 수 있다.
 하지만 그 차이가 크지 않다면 Top-Down이 Method를 재귀 호출하면서 쌓이는 System Stack 때문에 Bottom-Up이 더 유리할 수 있다.
 https://velog.io/@rurry/%EB%B0%B1%EC%A4%80-2775-%EB%B6%80%EB%85%80%ED%9A%8C%EC%9E%A5%EC%9D%B4-%EB%90%A0%ED%85%8C%EC%95%BC-%EC%9E%90%EB%B0%94-JAVA

 이걸 참고해서 두방법 모두 사용해봐야겠다
 아래는 재귀호출을 통한
 Top-Down방법의 예시

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_TopDown {
    static int[][] dp;
    static int K, N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        //		B1 부녀회장이 될테야
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            dp = new int[K + 1][N + 1];

            for (int i = 1; i <= K; i++) {
                int sum = dp[i - 1][0];
                for (int j = 0; j <= N; j++) {
                    sum += dp[i - 1][j];
                    dp[i][j] = sum;
                }
            }
            rec(K, N);
            System.out.println(dp[K][N]);
        }
    }

    private static int rec(int k, int n) {
        // 기저 조건
        if (k == 0) {
            return n;
        }

        // 값이 있으면 계산하지 않고 바로 넘겨주기
        if (dp[k][n] != 0) {
            return dp[k][n];
        }

        // 값이 없으면 계산하기
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += rec(k - 1, i);
        }

        // 배열의 값을 저장함과 동시에 리턴하기
        return dp[k][n] = sum;
    }

}
/*Bottom-Up 방식이란?
가장 작은 문제들부터 답을 찾아가면서 전체 문제의 답을 구하는 방식이다.
보통 반복문을 이용해 구현한다.
상향식 접근법이라고도 한다.*/

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_BottomUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		B1 부녀회장이 될테야
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[K + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				dp[0][i] = i;
			}

			for (int i = 1; i <= K; i++) {
				int sum = dp[i - 1][0];
				for (int j = 0; j <= N; j++) {
					sum += dp[i - 1][j];
					dp[i][j] = sum;
				}
			}
//			for (int i = 0; i <= K; i++) {
//				for (int j = 0; j <= N; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(dp[K][N]);
		}
	}

}*/