package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class biber {
	int x;
	int y;
	int cnt;
	boolean isRain;

	biber(int x, int y, int cnt, boolean isRain) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.isRain = isRain;
	}
}

public class BFS_3055 {
	static int[][] map;
	static boolean[][] rainCheck;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N + 1][M + 1];
		rainCheck = new boolean[N + 1][M + 1];
		boolean isAnswer = false;
		Queue<biber> queue = new LinkedList<biber>();

		int start_X = 0;
		int start_Y = 0;
		sc.nextLine();
		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j - 1) == 'D') {
					map[i][j] = -3; // -3 : 도착지점
					rainCheck[i][j] = true;
				} else if (str.charAt(j - 1) == 'S') {
					map[i][j] = -2; // -2 : 출발지점
					rainCheck[i][j] = true;
					start_X = i;
					start_Y = j;
				} else if (str.charAt(j - 1) == 'X') {
					map[i][j] = -1; // -1 : 돌
					rainCheck[i][j] = true;
				} else if (str.charAt(j - 1) == '*') {
					queue.add(new biber(i, j, 0, true));
					rainCheck[i][j] = true;
				}

			}
		}

		queue.add(new biber(start_X, start_Y, 0, false));
		loop: while (!queue.isEmpty()) {
			biber b = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ax = b.x + dx[i];
				int ay = b.y + dy[i];
				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (b.isRain && !rainCheck[ax][ay]) { // 비일경우
					queue.add(new biber(ax, ay, b.cnt + 1, true));
					rainCheck[ax][ay] = true;
//					System.out.println(1);
				} else if (!b.isRain) {
					if (map[ax][ay] == -3) {
						System.out.println(b.cnt + 1);
						isAnswer = true;
						break loop;
					}
					if (!rainCheck[ax][ay]) {
						if (map[ax][ay] == 0) {
							map[ax][ay] = b.cnt + 1;
//							System.out.println(ax + " + " + ay);
							queue.add(new biber(ax, ay, b.cnt + 1, false));
						}
					}
				}
			}
		}
		if(!isAnswer)
			System.out.println("KAKTUS");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(3);
	}

}
