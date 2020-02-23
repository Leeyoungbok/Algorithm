package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class room {
	int x;
	int y;

	room(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_2234 {
	static int N, M;
	static int[][] map;
	static int[][] copy;
	static boolean[][] used;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		Deque<room> queue = new LinkedList<room>();
		int groupCnt = 0;
		int ans = 0;
		int[] arr = new int[2501];
		map = new int[N + 1][M + 1];
		copy = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!used[i][j]) {
					groupCnt++;
					int cnt = 1;
					used[i][j] = true;
					copy[i][j] = groupCnt;
					queue.add(new room(i, j));
					while (!queue.isEmpty()) {
						room r = queue.poll();
						for (int k = 3; k >= 0; k--) {
							if (!check(r.x, r.y, k)) {
								int ax = r.x + dx[k];
								int ay = r.y + dy[k];
								if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay])
									continue;
								queue.add(new room(ax, ay));
								used[ax][ay] = true;
								copy[ax][ay] = groupCnt;
								cnt++;
							}
						}
					}
					arr[groupCnt] = cnt;
					if (cnt > max)
						max = cnt;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (j < M && copy[i][j] != copy[i][j + 1]) {
					int n1 = arr[copy[i][j]] + arr[copy[i][j + 1]];
					if (ans < n1)
						ans = n1;
				}
				if (i < N && copy[i][j] != copy[i + 1][j]) {
					int n1 = arr[copy[i][j]] + arr[copy[i + 1][j]];
					if (ans < n1)
						ans = n1;
				}
			}
		}
		
		System.out.println(groupCnt);
		System.out.println(max);
		System.out.println(ans);
		sc.close();
	}

	static boolean check(int x, int y, int k) {
		int minus = (int) Math.pow(2, k);
		if (map[x][y] >= minus) {
			map[x][y] -= minus;
			return true;
		}
		return false;
	}

}
