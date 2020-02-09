package BFS;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class par implements Comparable<par> {
	int x;
	int y;
	int cnt;
	int[] used;

	par(int x, int y, int cnt, int[] used) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.used = used;
	}

	@Override
	public int compareTo(par o) {
		return o.cnt - this.cnt;
	}
}

public class BFS_1987 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PriorityQueue<par> queue = new PriorityQueue<par>();
		int R = sc.nextInt();
		int C = sc.nextInt();
		ans = 0;
		sc.nextLine();
		char[][] map = new char[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		queue.add(new par(1, 1, 1, new int[26]));
		while (!queue.isEmpty()) {
			par p = queue.poll();
			p.used[(int) map[p.x][p.y] - 65]++;
			ans = Math.max(p.cnt, ans);
			if (ans == 26)
				break;

			for (int i = 0; i < 4; i++) {
				int ax = p.x + dx[i];
				int ay = p.y + dy[i];
				if (ax >= 1 && ax <= R && ay >= 1 && ay <= C && p.used[(int) map[ax][ay] - 65] == 0) {
					queue.add(new par(ax, ay, p.cnt + 1, Arrays.copyOf(p.used, p.used.length)));
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
