package Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A형_파이프옮기기1 {
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 1, 0 };
	static int[][] myRoom;
	static int ans = 0;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		myRoom = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				myRoom[i][j] = sc.nextInt();
			}
		}
		solve(1, 2, 1);
		System.out.println(ans);
		// 1 -> ㅡ
		// 2 -> \
		// 3 -> |
	}

	static void solve(int x, int y, int prevShape) {
		if (x == N && y == N) {
			ans++;
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (prevShape == 1 && i == 3)
				continue;
			else if (prevShape == 3 && i == 1)
				continue;
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (ax > N || ay > N || myRoom[ax][ay] == 1)
				continue;
			if (i == 2 && (myRoom[ax - 1][ay] == 1 || myRoom[ax][ay] == 1 || myRoom[ax][ay - 1] == 1))
				continue;
			solve(ax, ay, i);
		}

	}

}
