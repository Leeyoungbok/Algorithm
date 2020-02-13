package BruteForce;

import java.util.Scanner;

public class BruteForce_10597 {
	static int[] arr;
	static String str;
	static boolean[] check = new boolean[51];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.next();

		arr = new int[str.length()];

		solve(0, 0);
	}

	static void solve(int idx, int n) {
		if (n == str.length()) {
			for (int i = 0; i < 50; i++) {
				if (arr[i] == 0)
					break;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.exit(0);
		}

		int n1 = Integer.parseInt(str.substring(n, n + 1));
			if (n1 > 50 || n1 <= 0)
				return;
			if (!check[n1]) {
				arr[idx] = n1;
				check[n1] = true;
				solve(idx + 1, n + 1);
				check[n1] = false;
		}
		if (n + 2 < str.length()) {
			
			int n2 = Integer.parseInt(str.substring(n, n + 2));
			if (n2 > 50 || n1 <= 0)
				return;
			if (!check[n2]) {
				arr[idx] = n2;
				check[n2] = true;
				solve(idx + 1, n + 2);
				check[n2] = false;
			}
		}
	}

}
