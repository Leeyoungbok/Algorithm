package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class paramMoneky {
	int x;
	int y;

	paramMoneky(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_1600 {

	static int[] horse_dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] horse_dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] monkey_dx = { 0, 0, 1, -1 };
	static int[] monkey_dy = { 1, -1, 0, 0 };

//3차원 배열을 만들어서 그 말이 지나갈 수 없는 경우에만 말의 움직임을 쓰도록 나타낸다.
// 만약 말이 움직일 수 있는 카운트가 남아있다면, 그 값을 --
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<paramMoneky> queue = new LinkedList<paramMoneky>();
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
		queue.add(new paramMoneky(1, 1));
		monkey[1][1] = 1;
		used[1][1] = true;

		while (!queue.isEmpty()) {
			paramMoneky p = queue.poll();
			int ax = 0;
			int ay = 0;
			int cnt = 0;
			if (monkey[p.x][p.y] <= K) {
				for (int i = 0; i < 8; i++) {
					ax = p.x + horse_dx[i];
					ay = p.y + horse_dy[i];
					if (ax < 1 || ax > N || ay < 1 || ay > M)
						continue;
					if (used[ax][ay])
						continue;

					monkey[ax][ay] = monkey[p.x][p.y] + 1;
					queue.add(new paramMoneky(ax, ay));
					used[ax][ay] = true;
					cnt = 1;
				}
			}
			if (monkey[p.x][p.y] > K || cnt == 0) {
				for (int i = 0; i < 4; i++) {
					ax = p.x + monkey_dx[i];
					ay = p.y + monkey_dy[i];
					if (ax < 1 || ax > N || ay < 1 || ay > M)
						continue;
					if (used[ax][ay])
						continue;

					monkey[ax][ay] = monkey[p.x][p.y] + 1;
					queue.add(new paramMoneky(ax, ay));
					used[ax][ay] = true;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(monkey[i][j] + " ");
			}
			System.out.println();
		}
		if ((N != 1 && M != 1) && monkey[N][M] == 0)
			System.out.println("-1");
		else
			System.out.println(monkey[N][M] - 1);

	}
}
