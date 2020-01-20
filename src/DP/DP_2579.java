package DP;

import java.util.Scanner;

public class DP_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] input = new int[301];
		int[] cache = new int[301];

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			input[i] = sc.nextInt();
		}
		cache[1] = input[1];
		cache[2] = input[1] + input[2];
		cache[3] = Math.max(input[2] + input[3], input[1] + input[3]);

		for (int i = 4; i <= n; i++) {
			cache[i] = Math.max(input[i] + input[i - 1] + cache[i - 3], input[i] + cache[i - 2]);
		}

		System.out.println(cache[n]);

		sc.close();
	}
}
