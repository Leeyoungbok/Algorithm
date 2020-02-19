package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class DFS_10971 {
	static int N;
	static int[][] map;
	static boolean[] used;
	static int[] res;
	static int ans = 10000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		map = new int[N + 1][N + 1];
		used = new boolean[N + 1];
		res = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		solve(0);
		System.out.println(ans);
	}

	static void solve(int idx) {
		if (idx == res.length - 1) {
			res[res.length - 1] = res[0];
			int sum = 0;
			System.out.println(Arrays.toString(res));
			for (int i = 0; i < res.length - 1; i++) {
				if (map[res[i]][res[i + 1]] == 0)
					return;
				sum += map[res[i]][res[i + 1]];
			}
			System.out.println(sum);
			if (ans > sum)
				ans = sum;
			return;
		}

		for (int i = 1; i < res.length; i++) {
			if (!used[i]) {
				res[idx] = i;
				used[i] = true;
				solve(idx + 1);
				used[i] = false;
			}
		}
	}

}