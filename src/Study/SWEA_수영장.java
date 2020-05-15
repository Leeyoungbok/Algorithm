package Study;

import java.util.Scanner;

public class SWEA_수영장 {
	static int[] arr = new int[13];
	static int[] cost = new int[5];
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			for (int i = 1; i < 5; i++) {
				cost[i] = sc.nextInt();
			}
			for (int i = 1; i <= 12; i++) {
				arr[i] = sc.nextInt();
			}

			ans = Integer.MAX_VALUE;
			solve(1, 0);
			System.out.println("#" + tc + " " + ans);
		}

	}

	static void solve(int i, int total) {
		if(total > ans)
			return;
		if (i >= 13) {
			ans = total < ans ? total : ans;
			return;
		}

		for (int j = 1; j <= 4; j++) {
				if (j == 1) {
					solve(i + 1, total + cost[j] * arr[i]);
				} else if (j == 2) {
					solve(i + 1, total + cost[j]);
				} else if (j == 3) {
					solve(i + 3, total + cost[j]);
				} else if (j == 4) {
					solve(i + 12, total + cost[j]);
				}
			}
	}

}
