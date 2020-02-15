package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class parameter {
	int x;
	int y;

	parameter(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_4485 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;

			Queue<parameter> queue = new LinkedList<parameter>();

			int[][] map = new int[N + 1][N + 1];
			int[][] used = new int[N + 1][N + 1];
			boolean[][] check = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			queue.add(new parameter(1, 1));
			used[1][1] -= map[1][1];
			check[1][1] = true;
			while (!queue.isEmpty()) {
				parameter p = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ax = p.x + dx[i];
					int ay = p.y + dy[i];

					if (ax < 1 || ax > N || ay < 1 || ay > N)
						continue;
					if ((!check[ax][ay] && used[ax][ay] == 0) || used[ax][ay] < used[p.x][p.y] - map[ax][ay]) {
						used[ax][ay] = used[p.x][p.y] - map[ax][ay];
						queue.add(new parameter(ax, ay));
						check[ax][ay] = true;
					}
				}
			}
			
			System.out.println("Problem " + cnt + ": " + used[N][N] * (-1));
			cnt++;
			
		}
		sc.close();
	}

}
