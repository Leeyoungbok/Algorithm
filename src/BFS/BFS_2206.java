package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class wall {
	int x;
	int y;
	boolean wall;

	wall(int x, int y, boolean wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}

public class BFS_2206 {
	static int[][] map;
	static int N;
	static int M;
	static boolean finalCheck;
	static boolean[][][] used;
	static int ans = 0;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j - 1) + "");
			}
		}
		bfs();
		if (N == 1 && M == 1)
			System.out.println(1);
		else if (finalCheck)
			System.out.println(ans);
		else
			System.out.println(-1);
		sc.close();
	}

	static void bfs() {
		Deque<wall> queue = new LinkedList<wall>();
		ans = 0;
		queue.add(new wall(1, 1, false));
		used[1][1][0] = true;

		loop: while (!queue.isEmpty()) {
			int size = queue.size();
			ans++;
			for (int s = 0; s < size; s++) {
				wall w = queue.poll();
				for (int k = 0; k < 4; k++) {
					int ax = w.x + dx[k];
					int ay = w.y + dy[k];
					if (ax < 1 || ax > N || ay < 1 || ay > M)
						continue;

					if (ax == N && ay == M) {
						ans++;
						finalCheck = true;
						break loop;
					}

					if (!w.wall && !used[ax][ay][0]) {
						if (map[ax][ay] == 1) {
							queue.add(new wall(ax, ay, true));
							used[ax][ay][1] = true;
						} else {
							queue.add(new wall(ax, ay, w.wall));
							used[ax][ay][0] = true;
						}
					} else if (w.wall && !used[ax][ay][1]) {
						if (map[ax][ay] == 1)
							continue;
						else {
							queue.add(new wall(ax, ay, w.wall));
							used[ax][ay][1] = true;
						}
					}
				}
			}
		}
	}
}
