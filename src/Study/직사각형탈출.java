package Study;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 직사각형탈출 {
	static int N, M, H, W, Sr, Sc, Fr, Fc;
	static int[][] map;
	static boolean[][] used;
	static ArrayList<Point> list = new ArrayList<>();
	static Deque<Point> queue = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					list.add(new Point(i, j));
			}
		}

		H = sc.nextInt();
		W = sc.nextInt();
		Sr = sc.nextInt();
		Sc = sc.nextInt();
		Fr = sc.nextInt();
		Fc = sc.nextInt();

		queue.add(new Point(Sr, Sc));
		used[Sr][Sc] = true;
		int cnt = 1;
		boolean check = false;
		bfs: while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();
				for (int k = 0; k < 4; k++) {
					int ax = p.x + dx[k];
					int ay = p.y + dy[k];

					if (ax < 1 || ay < 1 || (ax + H - 1) > N || (ay + W - 1) > M || used[ax][ay])
						continue;
					if (!isContinue(ax, ay))
						continue;
					if (ax == Fr && ay == Fc) {
						check = true;
						break bfs;
					}
					queue.add(new Point(ax, ay));
					used[ax][ay] = true;
				}
			}
			cnt++;
		}
		if (check)
			System.out.println(cnt);
		else
			System.out.println(-1);

	}

	static boolean isContinue(int x, int y) {
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			if ((x <= p.x && p.x <= (x + H - 1)) && (y <= p.y && p.y <= (y + W - 1)))
				return false;
		}
		return true;
	}

}
