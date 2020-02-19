package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class game implements Comparable<game> {
	int x;
	int y;

	game(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(game o) {
		return this.x - o.x;
	}
}

public class BFS_11559 { // DFS로 순회하면서 4개 이상나오면 재귀가 풀리며 다 F로 바꿔줄수있는지.
	static int N = 12;
	static int M = 6;
	static char[][] map = new char[N + 1][M + 1];
	static boolean[][] used;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deque<game> queue = new LinkedList<game>();
		ArrayList<game> list = new ArrayList<game>();
		ArrayList<game> copy = new ArrayList<game>();

		for (int i = 1; i <= 12; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= 6; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		while (true) {
			used = new boolean[N+1][M+1];
			for (int i = 12; i >= 1; i--) {
				for (int j = 1; j <= 6; j++) {
					if (map[i][j] != '.' && !used[i][j]) {
						queue.add(new game(i, j));
						used[i][j] = true;
						while (!queue.isEmpty()) {
							game g = queue.poll();
							copy.add(g);

							for (int k = 0; k < 4; k++) {
								int ax = g.x + dx[k];
								int ay = g.y + dy[k];

								if (ax < 1 || ax > 12 || ay < 1 || ay > 6 || used[ax][ay]) // 외곽으로 나가면 탐색 중지
									continue;
								if (map[ax][ay] == map[i][j]) {
									queue.add(new game(ax, ay));
									used[ax][ay] = true;
								}

							}
						}
						if (copy.size() > 3) {
							while (copy.size() > 0)
								list.add(copy.remove(0));
						} else {
							copy.clear();
						}

					}
				}
			}
			if (list.size() < 4) {
				break;
			}
			ans++;
			Collections.sort(list);
			while (list.size() > 0) {
				game g = list.remove(0);
				map[0][g.y] = '.'; 
				for (int ii = g.x; ii > 0; ii--) {
					if (map[ii][g.y] == '.')
						break;
					map[ii][g.y] = map[ii - 1][g.y];
					
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}


