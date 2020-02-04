package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class param {
	int x;
	int y;

	param(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_7562 {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			Queue<param> queue = new LinkedList<param>();
			int I = sc.nextInt();

			int[][] map = new int[I + 1][I + 1];
			boolean[][] used = new boolean[I + 1][I + 1];
			int start_X = sc.nextInt() + 1;
			int start_Y = sc.nextInt() + 1;

			int end_X = sc.nextInt() + 1;
			int end_Y = sc.nextInt() + 1;
			if (start_X == end_X && start_Y == end_Y) {
				System.out.println(0);
			} else {
				queue.add(new param(start_X, start_Y));
				used[start_X][start_Y] = true;
				loop: while (!queue.isEmpty()) {
					param p = queue.poll();
					for (int i = 0; i < 8; i++) {
						int ax = p.x + dx[i];
						int ay = p.y + dy[i];
						if ( ax < 1 || ax > I || ay < 1 || ay > I || used[ax][ay] )
							continue;
						map[ax][ay] = map[p.x][p.y]+1;
						if(ax == end_X && ay == end_Y)
							break loop;
						queue.add(new param(ax, ay));
						used[ax][ay] = true;
					}
				}
				System.out.println(map[end_X][end_Y]);
			}
		}
	}

}
