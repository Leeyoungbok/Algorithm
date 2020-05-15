package Study;

import java.util.Scanner;

public class SWEA_추억의2048게임 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			String str = sc.next();
			int[][] map = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc);

			if (str.equals("up")) {
				print(cal(map));
			} else if (str.equals("down")) {
				print(rotate(1, cal(rotate(1, map))));
			} else if (str.equals("left")) {
				print(rotate(2, cal(rotate(3, map))));
			} else if (str.equals("right")) {
				print(rotate(3, cal(rotate(2, map))));
			}
		}
	}

	static int[][] rotate(int n1, int[][] arr) {
		int[][] map = new int[N + 1][N + 1];
		if (n1 == 1) { // down
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = arr[N - i + 1][j];
				}
			}
		} else if (n1 == 2) { // left
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					map[i][j] = arr[j][N - i + 1];
				}
			}
		} else if (n1 == 3) { // right
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					map[i][j] = arr[N - j + 1][i];
				}
			}
		}

		return map;

	}

	static void print(int[][] map) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] cal(int[][] map) {
		for (int j = 1; j <= N; j++) {
			// 1. ������ ��������.
			for (int i = 1; i < N; i++) {
				if (map[i][j] == 0)
					continue;
				for (int k = i + 1; k <= N; k++) {
					if (map[k][j] != 0) {
						if (map[i][j] == map[k][j]) {
							map[i][j] *= 2;
							map[k][j] = 0;
						}
						break;
					}
				}
			}
			// 2. ���� �� �÷������.
			int idx = 0;
			boolean check = false;
			for (int i = 1; i <= N; i++) {
				if (map[i][j] == 0 && !check) {
					idx = i;
					check = true;
				}
				if (map[i][j] != 0 && check) {
					map[idx][j] = map[i][j];
					map[i][j] = 0;
					i = idx;
					check = false;
				}
			}
		}
		return map;
	}

}
