package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class SafeQueen {
	int x, y;
	boolean check;

	SafeQueen(int x, int y, boolean check) {
		this.x = x;
		this.y = y;
		this.check = check;
	}
}

public class 공주님을구해라 {
	static int N, M, T, cnt;
	static int[][] map;
	static boolean[][][] used;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Deque<SafeQueen> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		queue.add(new SafeQueen(1, 1, false));
		used[1][1][0] = true;
		bfs();
		sc.close();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			if (cnt >= T) 
				break;
			int size = queue.size();
			cnt++;

			for (int s = 0; s < size; s++) {
				SafeQueen sq = queue.poll();
				for (int k = 0; k < 4; k++) {
					int ax = sq.x + dx[k];
					int ay = sq.y + dy[k];

					if (ax < 1 || ax > N || ay < 1 || ay > M)
						continue;
					if(ax == N && ay == M) {
						System.out.println(cnt);
						System.exit(0);
					}
					if (sq.check && used[ax][ay][1])
						continue;
					if(!sq.check) {
						if(map[ax][ay] == 1 || used[ax][ay][0])
							continue;
					}
					if (sq.check) {
						queue.add(new SafeQueen(ax, ay, true));
						used[ax][ay][1] = true;
					} else {
						if (map[ax][ay] == 2) {
							queue.add(new SafeQueen(ax, ay, true));
						} else {
							queue.add(new SafeQueen(ax, ay, false));
						}
						used[ax][ay][0] = true;
					}
				}
			}
		}
		System.out.println("Fail");
	}

}
