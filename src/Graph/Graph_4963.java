package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pos {
	int x;
	int y;

	pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Graph_4963 {
	static int[] dx = { -1, -1, 1, 1, 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 1, -1, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			int cnt = 0;
			int[][] map = new int[h][w];
			Queue<pos> queue = new LinkedList<pos>();

			if (w == 0 && h == 0)
				break;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			=================================ют╥б

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						queue.add(new pos(i, j));
						map[i][j] = 0;
						cnt++;
						while (!queue.isEmpty()) {
							pos p = queue.poll();
							for (int k = 0; k < 8; k++) {
								int nx = p.x + dx[k];
								int ny = p.y + dy[k];
								if (0 <= nx && nx < h && 0 <= ny && ny < w) {
									if (map[nx][ny] == 1) {
										queue.add(new pos(nx, ny));
										map[nx][ny] = 0;
									}
								}
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
