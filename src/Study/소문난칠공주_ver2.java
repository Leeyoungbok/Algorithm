package Study;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 소문난칠공주_ver2 {
	static int ans = 0;
	static int[][] map = new int[5][5];
	static boolean[][] check = new boolean[5][5];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String str = sc.next();
			for (int j = 0; j < 5; j++) {
				if (str.charAt(j) == 'Y') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		solve(0, 0, 0);
		System.out.println(ans);
	}

	static void solve(int idx, int totalCnt, int qCnt) {
		if (totalCnt - qCnt >= 4)
			return;
		
		if (totalCnt == 7) {
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 5 ; j++) {
					System.out.print(check[i][j] + " ");
				}System.out.println();
			}System.out.println();
			Deque<Point> queue = new LinkedList<>();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (check[i][j]) {
						boolean[][] used = new boolean[5][5];
						used[i][j] = true;
						queue.add(new Point(i, j));
						int cnt = 0;
						while (!queue.isEmpty()) {
							Point p = queue.poll();
							cnt++;
							for (int k = 0; k < 4; k++) {
								int ax = p.x + dx[k];
								int ay = p.y + dy[k];
								if (ax < 0 || ax >= 5 || ay < 0 || ay >= 5 || !check[ax][ay] || used[ax][ay])
									continue;
								queue.add(new Point(ax, ay));
								used[ax][ay] = true;
							}
						}
						if (cnt == 7) {
							ans++;
						}
						return;
					}
				}
			}
			return;
		}

		for (int i = idx; i < 5 * 5; i++) {
			int x = i / 5;
			int y = i % 5;
			if(!check[x][y]) {
				check[x][y] = true;
				if (map[x][y] == 1)
					solve(i + 1, totalCnt + 1, qCnt + 1);
				else
					solve(i + 1, totalCnt + 1, qCnt);
				check[x][y] = false;
			}
		}
	}
}
