package Samsung;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A형_다리만들기2_ver2 {
	static int N, M, groupCnt = 0;
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		Deque<Point> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0 || used[i][j])
					continue;
				groupCnt++;
				map[i][j] = groupCnt;
				used[i][j] = true;
				queue.add(new Point(i, j));
				while (!queue.isEmpty()) {
					Point p = queue.poll();
					for (int k = 0; k < 4; k++) {
						int ax = p.x + dx[k];
						int ay = p.y + dy[k];
						if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] != 1)
							continue;
						map[ax][ay] = groupCnt;
						used[ax][ay] = true;
						queue.add(new Point(ax, ay));
					}
				}
			}
		}
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		init();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j] == 0) continue;
				for (int k = 0; k < 4; k++) {
					int ax = i;
					int ay = j;
					int cnt = 0;
					while (true) {
						ax += dx[k];
						ay += dy[k];
						cnt++;
						if (ax < 1 || ax > N || ay < 1 || ay > M || map[i][j] == map[ax][ay])
							break;
						if (map[ax][ay] != 0 && map[ax][ay] != map[i][j] && cnt >= 2) {
							pq.add(new Bridge(map[i][j], map[ax][ay], cnt-1));
							break;
						}
					}
				}
			}
		}
		int connectedCnt = 0;
		int totalCost = 0;
		while (!pq.isEmpty()) {
			if (connectedCnt == groupCnt - 1) {
				System.out.println(totalCost);
				return;
			}
			Bridge b = pq.poll();
			if(b.cost < 2) continue;
			if (find(b.start) != find(b.end)) {
				connectedCnt++;
				union(b.start, b.end);
				totalCost += b.cost;
			}
		}
		System.out.println(-1);

	}

	static void init() {
		dj = new int[groupCnt+1];
		for (int i = 0; i <= groupCnt; i++) {
			dj[i] = i;
		}
	}

	static int find(int n1) {
		if (dj[n1] == n1)
			return n1;

		return dj[n1] = find(dj[n1]);
	}

	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2)
			dj[p2] = p1;
		else
			dj[p1] = p2;
	}

	static class Bridge implements Comparable<Bridge> {
		int start, end, cost;

		Bridge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.cost - o.cost;
		}
	}
}
