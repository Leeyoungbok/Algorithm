package Samsung;

import java.util.Scanner;

public class A형_경사로 {
	static int N, L, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		rowCal();
		columnCal();
		System.out.println(ans);
		sc.close();
	}

	static void rowCal() {
		for (int i = 1; i <= N; i++) {
			int cnt = 1;
			boolean toLowCheck = false;
			boolean retCheck = false;
			int height = map[i][1];
			for (int j = 2; j <= N; j++) {
				if(Math.abs(map[i][j] - height) > 1) {
					retCheck = true;
					break;
				}
				if (map[i][j] == height) {
					cnt++;
					if (toLowCheck && cnt == L) {
						toLowCheck = false;
						cnt = 0;
					}
				} else if (map[i][j] < height) { // ���������� ���������� ���� ���
					if (toLowCheck) {
						retCheck = true;
						break;
					}
					toLowCheck = true;
					cnt = 1;
					if (toLowCheck && cnt == L) {
						toLowCheck = false;
						cnt = 0;
					}
					height = map[i][j];
				} else if (map[i][j] > height) { // ���������� ���������� ���� ���
					if (toLowCheck) {
						retCheck = true;
						break;
					}
					if (cnt >= L) {
						cnt = 1;
						height = map[i][j];
					} else {
						retCheck = true;
						break;
					}
				}
			}
			if (!retCheck && !toLowCheck) {
//				System.out.println(i+"��");
				ans++;
			}
		}
	}

	static void columnCal() {
		for (int j = 1; j <= N; j++) {
			int cnt = 1;
			boolean toLowCheck = false;
			boolean retCheck = false;
			int height = map[1][j];
			for (int i = 2; i <= N; i++) {
				if(Math.abs(map[i][j] - height) > 1) {
					retCheck = true;
					break;
				}
				if (map[i][j] == height) {
					cnt++;
					if (toLowCheck && cnt == L) {
						toLowCheck = false;
						cnt = 0;
					}
				} else if (map[i][j] < height) { // ���������� ���������� ���� ���
					
					if (toLowCheck) {
						retCheck = true;
						break;
					}
					toLowCheck = true;
					cnt = 1;
					if (toLowCheck && cnt == L) {
						toLowCheck = false;
						cnt = 0;
					}
					height = map[i][j];
				} else if (map[i][j] > height) { // ���������� ���������� ���� ���
					if (toLowCheck) {
						retCheck = true;
						break;
					}
					if (cnt >= L) {
						cnt = 1;
						height = map[i][j];
					} else {
						retCheck = true;
						break;
					}
				}
			}
			if (!retCheck && !toLowCheck) {
//				System.out.println(j+"��");
				ans++;
			}
		}
	}
}
