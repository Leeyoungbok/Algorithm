package BFS;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class monkey {
	int x;
	int y;
	int horseCnt;

	monkey(int x, int y, int horseCnt) {
		this.x = x;
		this.y = y;
		this.horseCnt = horseCnt;
	}
}

public class BFS_1600 {

	static int[] horse_dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] horse_dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] monkey_dx = { 0, 0, 1, -1 };
	static int[] monkey_dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Deque<monkey> queue = new LinkedList<monkey>();

		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		int[][] map = new int[M + 1][N + 1];
		boolean[][][] used = new boolean[M + 1][N + 1][32];

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean finalCheck = false;
		queue.add(new monkey(1, 1, 0));
		used[1][1][0] = true;

		loop: while (!queue.isEmpty()) {
			int size = queue.size();
			ans++;
			for (int s = 0; s < size; s++) {
				monkey m = queue.poll();

				for (int k = 0; k < 4; k++) {
					int ax = m.x + monkey_dx[k];
					int ay = m.y + monkey_dy[k];

					if (ax < 1 || ax > M || ay < 1 || ay > N || map[ax][ay] == 1 || used[ax][ay][m.horseCnt])
						continue;
					if (ax == M && ay == N) {
						finalCheck = true;
						break loop;
					}
					used[ax][ay][m.horseCnt] = true;
					queue.add(new monkey(ax, ay, m.horseCnt));
				}

				if (m.horseCnt < K) {
					for (int k = 0; k < 8; k++) {
						int ax = m.x + horse_dx[k];
						int ay = m.y + horse_dy[k];
						if (ax < 1 || ax > M || ay < 1 || ay > N || map[ax][ay] == 1 || used[ax][ay][m.horseCnt + 1])
							continue;
						if (ax == M && ay == N) {
							finalCheck = true;
							break loop;
						}
						used[ax][ay][m.horseCnt + 1] = true;
						queue.add(new monkey(ax, ay, m.horseCnt + 1));
					}
				}
			}
		}
		if (finalCheck)
			System.out.println(ans);
		else
			System.out.println(-1);
		sc.close();
	}
}