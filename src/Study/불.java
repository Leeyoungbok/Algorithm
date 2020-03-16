package Study;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Fire {
	int x, y, cnt;

	Fire(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class บา {
	static int N, M;
	static int[][] map;
	static boolean[][] used;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		boolean check = false;
		Deque<Fire> FireQueue = new LinkedList<>();
		Deque<Point> stoneQueue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				char ch = str.charAt(j - 1);
				if (ch == '#')
					map[i][j] = -3;
				else if (ch == 'J') {
					map[i][j] = 0;
					FireQueue.add(new Fire(i, j, 1));
					used[i][j] = true;
				} else if (ch == 'F') {
					map[i][j] = 1;
					stoneQueue.add(new Point(i, j));
				}
			}
		}

		while (!stoneQueue.isEmpty()) {
			Point p = stoneQueue.poll();
			for (int k = 0; k < 4; k++) {
				int ax = p.x + dx[k];
				int ay = p.y + dy[k];

				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;

				if (map[ax][ay] == 0) {
					map[ax][ay] = map[p.x][p.y] + 1;
					stoneQueue.add(new Point(ax, ay));
				}
			}
		}
		loop: while (!FireQueue.isEmpty()) {
			Fire q = FireQueue.poll();
			if (q.x == 1 || q.x == N || q.y == 1 || q.y == M) {
				System.out.println(q.cnt);
				check = true;
				break loop;
			}
			for (int k = 0; k < 4; k++) {
				int ax = q.x + dx[k];
				int ay = q.y + dy[k];

				if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] == -3)
					continue;


				if (map[ax][ay] > q.cnt + 1 || map[ax][ay] == 0) {
					FireQueue.add(new Fire(ax, ay, q.cnt + 1));
					used[ax][ay] = true;
				}
			}
		}

		if (!check)
			System.out.println("IMPOSSIBLE");
		sc.close();
	}
}
