package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class param {
//	int x;
//	int y;
//	int i;
//
//	param(int x, int y, int i) {
//		this.x = x;
//		this.y = y;
//		this.i = i;
//	}
//

public class D3_4615 {
	static int[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			map[(N + 1) / 2][(N + 1) / 2 + 1] = 1; // 1 - 흑돌
			map[(N + 1) / 2 + 1][(N + 1) / 2] = 1; // 2 - 백돌
			map[(N + 1) / 2 + 1][(N + 1) / 2 + 1] = 2;
			map[(N + 1) / 2][(N + 1) / 2] = 2;

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int dol_X = Integer.parseInt(st.nextToken());
				int dol_Y = Integer.parseInt(st.nextToken());
				int dol_Color = Integer.parseInt(st.nextToken());

				for (int i = 0; i < 8; i++) {
					if (search(dol_X, dol_Y, dol_Color, i)) {
						change(dol_X, dol_Y, dol_Color, i);
					}
				}
			}
			int black = 0;
			int white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1)
						black++;
					else if (map[i][j] == 2)
						white++;
				}
			}
			System.out.println("#" + tc + " " + black + " " + white);
		}

	}

	static void change(int x, int y, int color, int i) {
		map[x][y] = color;
		while (true) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax < 1 || ax > N || ay < 1 || ay > N || color == map[ax][ay])
				break;
			map[ax][ay] = color;
			x = ax;
			y = ay;
		}
	}

	static boolean search(int x, int y, int color, int i) {
		int ax = x + dx[i];
		int ay = y + dy[i];
		if (ax < 1 || ax > N || ay < 1 || ay > N || color == map[ax][ay] || map[ax][ay] == 0)
			return false;

		x = ax;
		y = ay;
		while (true) { // 흰 검 과 같은 경우에 들어옴
			ax = x + dx[i];
			ay = y + dy[i];
			if (ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] == 0)
				return false; // 계속 진행하는데 밖으로 벗어나면 끝
			if (color == map[ax][ay]) // 같은 색이 나왔음
				return true;
			x = ax;
			y = ay;
		}
	}
}
