package Study;

import java.util.Scanner;

public class A형_색종이붙이기 {
	static int[] coloredPaper = { 0, 5, 5, 5, 5, 5 };
	static int[][] map = new int[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ansCheck = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					if (solve(i, j) == -1) {
						ansCheck = true;
						break loop;
					}
				}
			}
		}
		if (ansCheck)
			System.out.println(-1);
		else {
			int sum = 25;
			for (int i = 0; i < 6; i++) {
				sum -= coloredPaper[i];
			}
			System.out.println(sum);
		}
	}

	static int solve(int x, int y) {
		int cnt = check(x, y);
		System.out.println(x + " " + y + " " + cnt);
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				map[x + i][y + j] = 0;
			}
		}
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
		coloredPaper[cnt]--;
		return coloredPaper[cnt];
	}

	static int check(int x, int y) {
		int cnt;
		int max = 5;
		boolean zeroCheck = false;
		while (true) {
			cnt = 0;
			for (int i = 0; i < max; i++) {
				if(y + i > 9) break;
				if (map[x][y + i] == 1)
					cnt++;
				else
					break;
			}
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {  // 0 ~ cnt 랑 1~ cnt랑 2~ cnt랑 해서 가장 큰 cnt값
					if(x + i > 9) break;
					if (map[x + i][y + j] == 0) {
						zeroCheck = true;
						break;
					}
				}
			}
			if (!zeroCheck) {
				return cnt;
			}
			max = cnt - 1;
			zeroCheck = false;
		}

	}
}

