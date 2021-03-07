package Samsung;

import java.util.ArrayList;
import java.util.Scanner;

class air {
	int x;
	int y;
	int cnt;

	air(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class A형_미세먼지안녕 {
	static int N, M, T;
	static int[][] map, machine;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<air> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		///////////////
		map = new int[N + 1][M + 1];
		machine = new int[2][2];
		int n1 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					machine[n1][0] = i;
					machine[n1][1] = j;
					n1++;
				} else if (map[i][j] != 0 && map[i][j] != -1)
					list.add(new air(i, j, map[i][j]));
			}
		}
		////////////// input
		for (int t = 0; t < T; t++) {
			situation01();
			situation02();
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= M ; j++) {
					if (map[i][j] != 0 && map[i][j] != -1)
						list.add(new air(i, j, map[i][j]));
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == -1) {
					continue;
				}
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		sc.close();
	}

	// ���� Ȯ��

	static void situation01() {
		while (!list.isEmpty()) {
			air a = list.remove(0);
			int n1 = 0;
			for (int k = 0; k < 4; k++) {
				int ax = a.x + dx[k];
				int ay = a.y + dy[k];

				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (map[ax][ay] == -1)
					continue;
				map[ax][ay] += a.cnt / 5;
				n1++;
			}
			map[a.x][a.y] -= ((a.cnt / 5) * n1);
		}
	}

	// û�ұ�
	static void situation02() {
		// ���� û�ұ�
		for (int i = machine[0][0] - 1; i > 1; i--) {
			map[i][1] = map[i - 1][1];
		}
		for (int j = 1; j < M; j++) {
			map[1][j] = map[1][j + 1];
		}
		for (int i = 1; i < machine[0][0]; i++) {
			map[i][M] = map[i + 1][M];
		}
		for (int j = M; j > machine[0][1] + 1; j--) {
			map[machine[0][0]][j] = map[machine[0][0]][j - 1];
		}
		
		// �Ʒ��� û�ұ�
		for (int i = machine[1][0]+1 ; i < N; i++) {
			map[i][1] = map[i + 1][1];
		}
		for (int j = 1; j < M; j++) {
			map[N][j] = map[N][j + 1];
		}
		for (int i = N; i > machine[1][0]; i--) {
			map[i][M] = map[i - 1][M];
		}
		for (int j = M; j > machine[1][1] + 1; j--) {
			map[machine[1][0]][j] = map[machine[1][0]][j - 1];
		}
		map[machine[0][0]][2] = 0;
		map[machine[1][0]][2] = 0;
	}
}
