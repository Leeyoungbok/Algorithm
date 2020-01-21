package SW_Expert;

import java.util.Scanner;

public class D2_1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int[][] arr = new int[9][9];
			boolean finalCheck = false;
			for (int i = 0; i < 9; i++) {
				boolean[] tCheck = new boolean[9];
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
					if (tCheck[arr[i][j] - 1] == true) {
						finalCheck = true;
					}
					tCheck[arr[i][j] - 1] = true;
				}
			}
			for (int i = 0; i < 9; i++) {
				boolean[] tCheck = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (tCheck[arr[j][i] - 1] == true) {
						finalCheck = true;
					}
					tCheck[arr[j][i] - 1] = true;
				}
			}

			for (int k = 0; k < 9; k++) {
				int x = 0;
				int y = 0;
				boolean[] tCheck = new boolean[9];
				if (k < 3) {
					x = 3 * k;
					y = 0;
				}
				if (3 <= k && k < 6) {
					x = 3 * (k - 3);
					y = 3;
				}
				if (6 <= k && k < 9) {
					x = 3 * (k - 6);
					y = 6;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (tCheck[arr[x + i][y + j] - 1] == true) {
							finalCheck = true;
						}
						tCheck[arr[x + i][y + j] - 1] = true;
					}
				}
			}

			if (finalCheck == true)
				System.out.println("#" + tc + " 0");
			else
				System.out.println("#" + tc + " 1");
		}
		sc.close();
	}

}
