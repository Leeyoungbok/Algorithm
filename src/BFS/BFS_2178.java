package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2178 {
	static class position {
		int x, y, cnt;

		position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<position> queue = new LinkedList<position>();

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			String st = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.substring(j, j + 1));
			}
		}

//		for(int i = 0 ; i < n ; i ++) {
//			for(int j = 0 ; j < m ; j ++) {
//				System.out.print(input[i][j]);
//			}
//			System.out.println("");
//		}

		queue.add(new position(0, 0));

		while (!queue.isEmpty()) {
			position pos = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] == 1) {
						map[nx][ny] = map[pos.x][pos.y] + 1;
						queue.add(new position(nx, ny));
					}
				}

			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}
		System.out.println(map[n-1][m-1]);
		sc.close();

	}
}
