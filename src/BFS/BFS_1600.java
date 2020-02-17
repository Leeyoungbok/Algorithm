package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class monkey {
	int x;
	int y;
	int cnt;
	int horseCnt;

	monkey(int x, int y, int cnt, int horseCnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.horseCnt = horseCnt;
	}
}

public class BFS_1600 {

	static int[] horse_dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] horse_dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] monkey_dx = { 0, 0, 1, -1 };
	static int[] monkey_dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<monkey> queue = new LinkedList<monkey>();
		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		int[][] map = new int[N + 1][M + 1];
		int[][] monkey = new int[N + 1][M + 1];
		boolean[][] used = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					used[i][j] = true;
				}
			}
		}
		int sum = 0;
		boolean k = false;
		queue.add(new monkey(1, 1, 0, K));
		used[1][1] = true;

		loop : while (!queue.isEmpty()) {
			monkey p = queue.poll();
			boolean check = false;
			for (int i = 0; i < 4; i++) {
				int ax = p.x + monkey_dx[i];
				int ay = p.y + monkey_dy[i];
				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (used[ax][ay])
					continue;
				if(ax == N && ay == M) {
					sum += (p.cnt+1);
					sum -= (p.horseCnt*2);
					k = true;
					break loop;
				}
				check = true;
				queue.add(new monkey(ax, ay, p.cnt + 1, p.horseCnt));
				used[ax][ay] = true;
			}
			if (!check && p.horseCnt > 0) {
				for (int i = 0; i < 8; i++) {
					int ax = p.x + horse_dx[i];
					int ay = p.y + horse_dy[i];
					if (ax < 1 || ax > N || ay < 1 || ay > M)
						continue;
					if (used[ax][ay])
						continue;
					if(ax == N && ay == M) {
						k = true;
						sum += (p.cnt+1);
						sum -= ((p.horseCnt-1)*2);
						break loop;
					}
					queue.add(new monkey(ax, ay, p.cnt+1, p.horseCnt-1));
					used[ax][ay] = true;
				}
			}
		}
		if(k)
			System.out.println(sum);
		else
			System.out.println(-1);

	}
}
