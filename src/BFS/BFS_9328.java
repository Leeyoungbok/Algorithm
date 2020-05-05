package BFS;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS_9328 {
	static int N, M, keyLen, ans;
	static String key;
	static char[][] map;
	static boolean[][] used;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N + 1][M + 1];
			used = new boolean[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				for (int j = 1; j <= M; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}

			key = sc.next().toUpperCase();
			if (key.equals("0"))
				key = "";
			Deque<Point> queue = new LinkedList<>();
			ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (i == 1 || i == N || j == 1 || j == M) {
						if (map[i][j] == '*')
							continue;
						if ('a' <= map[i][j] && map[i][j] <= 'z') {
							key += (map[i][j] + "").toUpperCase();
						}
						if(map[i][j] == '$') {
							ans++;
						}
						queue.add(new Point(i, j));
						used[i][j] = true;
					}
				}
			}

			while (!queue.isEmpty()) {
				int Size = queue.size();
				boolean breakCheck = false;
				for (int size = 0; size < Size; size++) {
					Point p = queue.poll();

					// map[p.x][p.y] 이게 대문자인데 내가 가지고 있는게 아니라면 그대로 다시 큐에 넣어줌
					if ('A' <= map[p.x][p.y] && map[p.x][p.y] <= 'Z') {
						boolean check = false;
						for (int k = 0; k < key.length(); k++) {
							if (map[p.x][p.y] == key.charAt(k)) {
								check = true;
							}
						}
						if (!check) {
							queue.add(p);
							continue;
						}
					}

					for (int k = 0; k < 4; k++) {
						int ax = p.x + dx[k];
						int ay = p.y + dy[k];

						if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] == '*')
							continue;

						if (map[ax][ay] == '$') {
							ans++;
						} else if ('a' <= map[ax][ay] && map[ax][ay] <= 'z') {
							key += (map[ax][ay] + "").toUpperCase();
						}
						queue.add(new Point(ax, ay));
						used[ax][ay] = true;
						breakCheck = true;
					}
				}
				if (!breakCheck)
					break;
			}
			System.out.println(ans);
		}
	}
}
