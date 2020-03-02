package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

class island implements Comparable<island> {
	int x;
	int y;
	int cnt;

	island(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(island o) {
		return this.cnt - o.cnt;
	}

}

public class A형_다리만들기2 {
	static int N, M, ans;
	static int[] disjoint;
	static int[][] map, cntMap;
	static boolean[] cntUsed;
	static boolean[][] used;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		PriorityQueue<island> queue = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int groupCnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!used[i][j] && map[i][j] == 1) {
					groupCnt++;
					map[i][j] = groupCnt;
					used[i][j] = true;
					queue.add(new island(i, j, 0));
					while (!queue.isEmpty()) {
						island land = queue.poll();
						for (int k = 0; k < 4; k++) {
							int ax = land.x + dx[k];
							int ay = land.y + dy[k];
							if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] == 0)
								continue;
							queue.add(new island(ax, ay, 0));
							map[ax][ay] = groupCnt;
							used[ax][ay] = true;
						}
					}
				}
			}
		}
		cntMap = new int[groupCnt + 1][groupCnt + 1];
		disjoint = new int[groupCnt + 1];

		for (int i = 1; i <= groupCnt; i++) {
			disjoint[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int x = i;
					int y = j;
					int cnt = 0;
					int ax, ay;
					while (true) {
						cnt++;
						ax = x + dx[k];
						ay = y + dy[k];
						if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == map[i][j])
							break;
						if (map[ax][ay] != 0 && map[ax][ay] != map[i][j]) {
							if (cnt > 2) {
								if (cntMap[map[i][j]][map[ax][ay]] == 0 || cntMap[map[i][j]][map[ax][ay]] > cnt-1) {
									cntMap[map[i][j]][map[ax][ay]] = cnt-1;
									break;
								}
							}
							break;
						}
						x = ax;
						y = ay;
					}
				}
			}
		}

		for (int i = 1; i <= groupCnt; i++) {
			for (int j = i; j <= groupCnt; j++) {
				if (cntMap[i][j] > 1)
					queue.add(new island(i, j, cntMap[i][j]));
			}
		}

		int sum = 0;
		int k = 0;
		while (!queue.isEmpty()) {
			island land = queue.poll();
			if (find(land.x) != find(land.y)) {
				sum += land.cnt;
				union(land.x, land.y);
				k++;
			}
		}
		if (sum == 0 || k != groupCnt - 1)
			System.out.println(-1);
		else
			System.out.println(sum);
		sc.close();
	}

	static int find(int n1) {
		if (disjoint[n1] == n1)
			return n1;
		return disjoint[n1] = find(disjoint[n1]);
	}

	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2)
			disjoint[p2] = p1;
		else
			disjoint[p1] = p2;
	}
}
