package DP;

import java.util.Scanner;

public class DP_11726 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long[] cache = new long[1000];

		cache[0] = 1;
		cache[1] = 2;

		for (int i = 2; i < n; i++) {
			cache[i] = (cache[i - 1] + cache[i - 2]) % 10007;
		}
		System.out.println(cache[n - 1]);
		sc.close();
	}
}
