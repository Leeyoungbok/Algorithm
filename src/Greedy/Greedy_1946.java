package Greedy;

import java.util.Scanner;

public class Greedy_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int p = 0; p < t; p++) {
			int n = sc.nextInt();
			int cnt = 1;
			int min;
			int[] person = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				person[sc.nextInt()] = sc.nextInt();
			}
			min = person[1];
			for (int i = 2; i <= n; i++) {
				if (person[i] < min) {
					cnt++;
					min = person[i];
				}
			}
			System.out.println(cnt);
		}
		sc.close();

	}

}
