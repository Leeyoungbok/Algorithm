package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class param {
	int x;
	int y;

	param(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BruteForce_14500 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] used;
	static boolean[][] copy;
	static int ans;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		copy = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 1, 1);
		System.out.println(ans);
	}

	static void solve(int cnt, int x, int y) {
		if (cnt == 4) {
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= M ; j++) {
					System.out.print(used[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			int sum = bfs(0, x, y);
			ans = ans < sum ? sum : ans;
			return;
		}

		if (cnt > 1) {
			int n1 = 0;
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (used[ax][ay]) {
					n1++;
					break;
				}
			}
			if(n1 == 0) {
				return;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!used[i][j]) {
					used[i][j] = true;
					solve(cnt + 1, i, j);
					used[i][j] = false;
				}
			}
		}
	}

	static int bfs(int sum, int x, int y) {
		Deque<param> queue = new LinkedList<param>();
		copyMap();
		int cnt = 1;
		queue.add(new param(x, y));
		sum += map[x][y];
		copy[x][y] = false;
		while (!queue.isEmpty()) {
			param p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ax = p.x + dx[i];
				int ay = p.y + dy[i];
				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (!copy[ax][ay])
					continue;
				queue.add(new param(ax, ay));
				copy[ax][ay] = false;
				sum += map[ax][ay];
				cnt++;
			}
		}
		if (cnt != 4)
			return 0;
		return sum;
	}

	static void copyMap() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copy[i][j] = used[i][j];
			}
		}
	}
}
