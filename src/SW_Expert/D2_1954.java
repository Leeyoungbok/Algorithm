package SW_Expert;

import java.util.Scanner;

public class D2_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int num = 1, iStart = 0, jStart = 0, iEnd = n - 1, jEnd = n - 1;

			while (num <= n * n) {
				for (int j = jStart; j <= jEnd; j++) {
					map[iStart][j] = num++;
				}
				iStart++;
				for (int i = iStart; i <= iEnd; i++) {
					map[i][jEnd] = num++;
				}
				jEnd--;
				for (int j = jEnd; j >= jStart; j--) {
					map[iEnd][j] = num++;
				}
				iEnd--;
				for (int i = iEnd; i >= iStart; i--) {
					map[i][jStart] = num++;
				}
				jStart++;

			}
			System.out.println("#"+ tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println("");
			}
		}
		sc.close();
	}
}
