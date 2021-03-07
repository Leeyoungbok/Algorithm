package SW_Expert;

import java.util.Scanner;

public class SWEA_벌꿀채취 {
	static int N, M, C, max;
	static int[][] map, costMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			map = new int[N][N];
			costMap = new int[N][N - M + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					max = 0;
					solve(i, j, 0, 0, 0);
				}
			}
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					for (int k = i; k < N; k++) {
						for (int l = 0; l < N - M + 1; l++) {
							if (i == k && l < j + M)
								continue;
							max = Math.max(costMap[i][j] + costMap[k][l], max);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	static void solve(int i, int j, int n, int total, int pow) {
		if (total > C)
			return;
		if (n == M) {
			if (max < pow) {
				costMap[i][j] = pow;
				max = pow;
			}
			return;
		}
		solve(i, j, n + 1, total + map[i][j + n], pow + (int) Math.pow(map[i][j + n], 2));
		solve(i, j, n + 1, total, pow);
	}
}
