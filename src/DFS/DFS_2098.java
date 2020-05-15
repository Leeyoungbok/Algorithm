package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class DFS_2098 {
	static int N, max = 987654321;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[16][16];
		dp = new int[16][1 << 16];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], max);
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(0, 1));

	}

	static int solve(int s, int e) {
		if (e == (1 << N) - 1) {
			if (map[s][0] != 0) {
				return map[s][0];
			}
			return max;
		}
		
		if (dp[s][e] != max)
			return dp[s][e];
		
		for (int i = 0; i < N; i++) {
			if (map[s][i] != 0 && (e & (1 << i)) == 0)
				dp[s][e] = Math.min(dp[s][e], map[s][i] + solve(i, e | (1 << i)));
		}
		return dp[s][e];
	}
}
