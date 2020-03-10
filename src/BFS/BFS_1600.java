package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<monkey> queue = new LinkedList<monkey>();
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[][] map = new int[N + 1][M + 1];
		boolean[][][] used = new boolean[N + 1][M + 1][32];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
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

					if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 1 || used[ax][ay][m.horseCnt])
						continue;
					if (ax == N && ay == M) {
						break loop;
					}
					used[ax][ay][m.horseCnt]=true;
					queue.add(new monkey(ax, ay, m.horseCnt));
				}

				if (m.horseCnt <K) {
					for (int k = 0; k < 8; k++) {
						int ax = m.x + horse_dx[k];
						int ay = m.y + horse_dy[k];
						if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 1 || used[ax][ay][m.horseCnt + 1])
							continue;
						if (ax == N && ay == M) {
							break loop;
						}
						used[ax][ay][m.horseCnt+1]=true;
						queue.add(new monkey(ax, ay, m.horseCnt + 1));
					}
				}
			}
		}
		System.out.println(ans);

	}
}
