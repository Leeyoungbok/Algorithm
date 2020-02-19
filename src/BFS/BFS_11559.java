package BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class game {
	int x;
	int y;
	char color;

	game(int x, int y, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class BFS_11559 { // DFS로 순회하면서 4개 이상나오면 재귀가 풀리며 다 F로 바꿔줄수있는지.
	static int N = 12;
	static int M = 6;
	static char[][] map = new char[N + 1][M + 1];
	static boolean[][] used = new boolean[N + 1][M + 1];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deque<game> queue = new LinkedList<game>();
		ArrayList<game> list = new ArrayList<game>();

		for (int i = 1; i <= 12; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= 6; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		for (int i = 12; i >= 1; i--) {
			for (int j = 1; j <= 6; j++) {
				if (map[i][j] != '.' && map[i][j] != 'X') {
					list.clear();
					queue.add(new game(i, j, map[i][j]));
					while (!queue.isEmpty()) {
						game g = queue.poll();
						list.add(g);

						for (int k = 0; k < 4; k++) {
							int ax = g.x + dx[k];
							int ay = g.y + dy[k];

							if (ax < 1 || ax > 12 || ay < 1 || ay > 6)
								continue;

						}
					}
				}
			}
		}
	}
}