package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS_1012 {
	static class pos {
		int x, y;

		pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<pos> queue = new LinkedList<pos>();
		int t = sc.nextInt();
		for (int c = 0; c < t; c++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int cnt = 0;
			int[][] map = new int[n][m];
			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				map[x][y] = 1;
			}
//			1. for 문을 돌리면서 하나씩 찾음 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						queue.add(new pos(i, j));
						map[i][j] = 2;
						cnt++;
//			2. 하나 찾을때마다 queue에 넣고 bfs 실행
//			3. bfs 종료하면 cnt++ 시키고 다시 for문
//			4. for문에 1이 없으면 종료시키고 cnt 출력

						while (!queue.isEmpty()) {
							pos p = queue.poll();
							for (int q = 0; q < dx.length; q++) {
								int nx = p.x + dx[q];
								int ny = p.y + dy[q];
								if (0 <= nx && nx < n && 0 <= ny && ny < m) {
									if (map[nx][ny] == 1) {
										map[nx][ny] = 2;
										queue.add(new pos(nx, ny));
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