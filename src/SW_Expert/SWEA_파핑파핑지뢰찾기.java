package SW_Expert;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			int ans = 0;
			ArrayList<Point> list = new ArrayList<>();
			map = new char[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				for (int j = 1; j <= N; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == '.') {
						boolean check = false;
						for (int k = 0; k < 8; k++) {
							int ax = i + dx[k];
							int ay = j + dy[k];

							if (ax < 1 || ax > N || ay < 1 || ay > N)
								continue;
							if (map[ax][ay] == '*') {
								check = true;
								break;
							}
						}
						if (!check) {
							list.add(new Point(i, j));
							map[i][j] = 'k';
							ans++;
							while (!list.isEmpty()) {
								Point p = list.remove(0);
								for (int k = 0; k < 8; k++) {
									int ax = p.x + dx[k];
									int ay = p.y + dy[k];
									if (ax < 1 || ax > N || ay < 1 || ay > N)
										continue;
									if (map[ax][ay] == '.') {
										boolean check2 = false;
										for (int kk = 0; kk < 8; kk++) {
											int ax2 = ax + dx[kk];
											int ay2 = ay + dy[kk];
											if (ax2 < 1 || ax2 > N || ay2 < 1 || ay2 > N)
												continue;
											if (map[ax2][ay2] == '*') {
												check2 = true;
												break;
											}
										}
										if (!check2) {
											list.add(new Point(ax, ay));
										}
										map[ax][ay] = 'k';
									}
								}
							}
						}
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == '.')
						ans++;
				}
			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			System.out.println("#" + tc + " " + ans);
			sc.close();
		}
	}

}
