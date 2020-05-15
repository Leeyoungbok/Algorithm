package Study;

import java.util.Scanner;

public class SWEA_최장경로 {
	static int N, M, ans;
	static int[] node;
	static boolean[] used;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			node = new int[N + 1];
			used = new boolean[N + 1];
			map = new int[N + 1][N + 1];
			ans = 0;

			for (int i = 0; i < M; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();

				map[n1][n2] = map[n2][n1] = 1;
			}

			for (int i = 1; i <= N; i++) {
				used[i] = true;
				dfs(i, 1);
				used[i] = false;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int node, int cnt) {
		if(cnt > ans)
			ans = cnt;
		
		for(int i = 1 ; i <= N ; i++) {
			if(!used[i] && map[node][i] == 1) {
				used[i] = true;
				dfs(i, cnt+1);
				used[i] = false;
			}
		}
	}

}
