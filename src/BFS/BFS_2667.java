package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2667 {

	static class position {
		int x, y;

		position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int[] house = new int[(n * n) / 2 + 1];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int cnt = -1;

		Queue<position> queue = new LinkedList<position>();

		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input.substring(j, j + 1));
			}
		}
		
		sc.close();
		
		loop: while (true) {
			inner_loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						queue.add(new position(i, j));
						map[i][j] = 0;
						cnt++;
						house[cnt]++;
						break inner_loop;
					}
				}
			}
			if (queue.isEmpty()) break loop;
			while (!queue.isEmpty()) {
				position pos = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = pos.x + dx[i];
					int ny = pos.y + dy[i];

					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (map[nx][ny] == 1) {
							map[nx][ny] = 0;
							queue.add(new position(nx, ny));
							house[cnt]++;
						}
					}
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}
		Arrays.sort(house);
		System.out.println(cnt + 1);
		for (int i = 0; i < (n * n) / 2 + 1; i++) {
			if (house[i] != 0)
				System.out.println(house[i] + " ");
		}
	}
}
