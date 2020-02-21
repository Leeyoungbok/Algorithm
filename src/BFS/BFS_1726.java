package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class robot {
	int x;
	int y;
	int cnt;
	int dir;

	robot(int x, int y, int cnt, int dir) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dir = dir;
	}
}

public class BFS_1726 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int M;
	static int turnDir; // left = 0 , right = 1
	static int[][] map;
	static boolean[][] check;

	static int startX;
	static int startY;
	static int startDir;

	static int endX;
	static int endY;
	static int endDir;
	static int ans;
	static Deque<robot> queue = new LinkedList<robot>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					check[i][j] = true;
			}
		}

		startX = sc.nextInt();
		startY = sc.nextInt();
		startDir = sc.nextInt() - 1;

		endX = sc.nextInt();
		endY = sc.nextInt();
		endDir = sc.nextInt() - 1;

		queue.add(new robot(startX, startY, 0, startDir));
		map[startX][startY] = 0;
		check[startX][startY] = true;
		bfs();
		System.out.println(ans);
		sc.close();
	}

	static int findDir(int d, int dir) {
//		{ 0, 0, 1, -1 };
//		{ 1, -1, 0, 0 };
		if (d == dir)
			return 0;
		if (d == 0 && dir == 1 || d == 1 && dir == 0)
			return 2;
		if (d == 2 && dir == 3 || d == 3 && dir == 2)
			return 2;
		else
			return 1;
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			robot r = queue.poll();
			if (r.x == endX && r.y == endY) {
				int cnt = r.cnt;
				cnt += findDir(r.dir, endDir);
				if (ans == 0 || ans > cnt)
					ans = cnt;
			}
			for (int k = 0; k < 4; k++) {
				for (int i = 1; i <= 3; i++) {
					int ax = r.x + dx[k] * i;
					int ay = r.y + dy[k] * i;

					if (ax < 1 || ax > N || ay < 1 || ay > M || check[ax][ay])
						break;

					int cnt = r.cnt;
					int d = r.dir;
					cnt += findDir(d, k);
//				System.out.println(ax + " " + ay + " " + cnt + " " + d + " " + k);
					if (map[ax][ay] == 0 || cnt + 3 <= map[ax][ay]) { // 2 or 3
						map[ax][ay] = cnt + 1;
						queue.add(new robot(ax, ay, cnt + 1, k));

					}
				}

			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}
}
