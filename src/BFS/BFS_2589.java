package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class island {
	int x;
	int y;

	island(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_2589 {
	static char[][] map;
	static int ans = 0;
	static boolean[][] used;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<island> queue = new LinkedList<island>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new char[N + 1][M + 1];
		sc.nextLine();
		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= M ; j++) {
//				System.out.print(map[i][j] + " " );
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 'L') {
					used = new boolean[N + 1][M + 1];
					int cnt = -1;
					queue.add(new island(i, j));
					used[i][j] = true;
					while (!queue.isEmpty()) {
						int size = queue.size();
						cnt++;
						for (int s = 0; s < size; s++) {
							island land = queue.poll();
							for (int k = 0; k < 4; k++) {
								int ax = land.x + dx[k];
								int ay = land.y + dy[k];
								if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 'W' || used[ax][ay])
									continue;
								queue.add(new island(ax, ay));
								used[ax][ay] = true;
							}
						}

					}
					if (ans < cnt)
						ans = cnt;
				}

			}

		}
		System.out.println(ans);
		sc.close();
	}

}
