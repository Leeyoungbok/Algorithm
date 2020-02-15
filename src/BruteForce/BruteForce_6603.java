package BruteForce;

import java.util.Scanner;

public class BruteForce_6603 {
	static String str;
	static int N;
	static int[] arr;
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;
			arr = new int[N];
			res = new int[6];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(arr));

			solve(0, 0);
			System.out.println();
		}
		sc.close();
	}

	static void solve(int idx, int n) {
		if (idx == res.length) {
			for (int i = 0; i < idx; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		} else if (n == arr.length)
			return;

		res[idx] = arr[n];
		solve(idx + 1, n + 1);
		solve(idx, n + 1);
	}

}
