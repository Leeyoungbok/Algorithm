package SW_Expert;

import java.util.Scanner;

public class D3_6913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] score = new int[m + 1];
			for (int i = 0; i < n; i++) {
				int total = 0;
				for (int j = 0; j < m; j++) {
					int input = sc.nextInt();
					if (input == 1)
						total++;
				}
				score[total]++;
			}
			for (int i = m; i >= 0; i--) {
				if (score[i] != 0) {
					System.out.println("#" + tc + " " + score[i] + " " + i);
					break;
				}
			}
		}
		sc.close();

	}

}
