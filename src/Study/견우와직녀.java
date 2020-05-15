package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 견우와직녀 {

	static class Meet implements Comparable<Meet> {
		int x, y, cnt, jump;
		boolean check;

		Meet(int x, int y, int cnt, int jump, boolean check) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
			this.check = check;
		}

		@Override
		public int compareTo(Meet o) {
			return this.cnt - o.cnt;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][][] used;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][N + 1];
		used = new boolean[N + 1][N + 1][2];
		PriorityQueue<Meet> queue = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		queue.add(new Meet(1, 1, 0, 0, false));
		used[1][1][0] = true;

		while (!queue.isEmpty()) {
			Meet m = queue.poll();
			if(m.x == N && m.y == N) {
				System.out.println(m.cnt);
				break;
			}
			for (int k = 0; k < 4; k++) {
				int ax = m.x + dx[k];
				int ay = m.y + dy[k];

				if (ax < 1 || ax > N || ay < 1 || ay > N)
					continue;

				if(map[ax][ay] == 0 && !m.check && m.jump == 0) {
					int n1 = m.cnt;
					while(true) {
						if((++n1) % M == 0) 
							break;
					}
					queue.add(new Meet(ax, ay, n1, 1, true));
				} else if (map[ax][ay] == 1 && !used[ax][ay][m.jump]) {
					used[ax][ay][m.jump] = true;
					queue.add(new Meet(ax, ay, m.cnt + 1, m.jump, false));
				} else if(map[ax][ay] > 1 && !m.check) {
					int n1 = m.cnt;
					while(true) {
						if((++n1) % map[ax][ay] == 0)
							break;
					}
					queue.add(new Meet(ax, ay, n1, m.jump, true));
				}
			}
		}
		sc.close();
	}
}
