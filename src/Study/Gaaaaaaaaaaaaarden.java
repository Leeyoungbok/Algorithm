package Study;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Gaaaaaaaaaaaaarden {
	public static class Flower {
		int x, y, cnt;
		boolean check;

		Flower(int x, int y, boolean check) {
			this.x = x;
			this.y = y;
			this.check = check;
		}
	}

	static int N, M, G, R, totalCnt, ans = 0;
	static int[][] map, copy, cnt;
	static boolean[][] used;
	static ArrayList<Point> list = new ArrayList<>();
	static Deque<Flower> queue = new LinkedList<>();
	static Flower[] flower;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		G = sc.nextInt();
		R = sc.nextInt();

		totalCnt = G + R;
		flower = new Flower[totalCnt];

		map = new int[N + 1][M + 1];
		copy = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					list.add(new Point(i, j));
				}

			}
		}

		solve(0, 0); // idx, cnt
		System.out.println(ans);
	}

	static void solve(int idx, int cnt) {
		if (cnt == totalCnt) {
			solve2(0, 0);
			return;
		}
		if (idx == list.size())
			return;
		Point p = list.get(idx);
		flower[cnt] = new Flower(p.x, p.y, false);
		solve(idx + 1, cnt + 1);
		solve(idx + 1, cnt);
	}

	static void solve2(int idx, int cnt) {
		if (cnt == G) {
//			for (int i = 0; i < flower.length; i++) {
//				System.out.println(flower[i].x + " " + flower[i].y + " " + flower[i].check);
//			}
//			System.out.println();
			int ret = bfs();
			if (ret > ans)
				ans = ret;
			return;
		} else if (idx == flower.length)
			return;

		flower[idx].check = true;
		solve2(idx + 1, cnt + 1);
		flower[idx].check = false;
		solve2(idx + 1, cnt);
	}

	static int bfs() {
		copyMap();
		used = new boolean[N + 1][M + 1];
		cnt = new int[N + 1][M + 1];
		int when = 0;
		int ret = 0;
		for (int i = 0; i < flower.length; i++) {
			queue.add(flower[i]);
		}

		while (!queue.isEmpty()) {// ¼öÁ¤
			int size = queue.size();
			when++;
			for (int s = 0; s < size; s++) {
				Flower f = queue.poll();
				if (copy[f.x][f.y] == 5)
					continue;
				for (int k = 0; k < 4; k++) {
					int ax = f.x + dx[k];
					int ay = f.y + dy[k];

					if (ax < 1 || ax > N || ay < 1 || ay > M || copy[ax][ay] == 0)
						continue;

					if (!f.check) {
						if (cnt[ax][ay] == when && copy[ax][ay] == 4) {
							copy[ax][ay] = 5;
						} else if (cnt[ax][ay] == 0) {
							queue.add(new Flower(ax, ay, f.check));
							copy[ax][ay] = 3;
							cnt[ax][ay] = when;
						}
					} else {
						if (cnt[ax][ay] == when && copy[ax][ay] == 3) {
							copy[ax][ay] = 5;
						} else if (cnt[ax][ay] == 0) {
							queue.add(new Flower(ax, ay, f.check));
							copy[ax][ay] = 4;
							cnt[ax][ay] = when;
						}
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
//				System.out.print(copy[i][j] + " ");
				if (copy[i][j] == 5)
					ret++;
			}
//			System.out.println();
		}
//		System.out.println();
//		System.out.println(ret);
		return ret;
	}

	static void copyMap() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}
