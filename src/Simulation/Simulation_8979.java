package Simulation;

import java.util.Scanner;

public class Simulation_8979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] nation = new int[N + 1];
		int[] gold = new int[N + 1];
		int[] silver = new int[N + 1];
		int[] bronze = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nation[i] = sc.nextInt();

			gold[i] = sc.nextInt();
			silver[i] = sc.nextInt();
			bronze[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			if (nation[i] == M) {
				M = i;
				break;
			}
		}

		int ans = 1;
		for (int i = 1; i <= N; i++) {
			if (M == i)
				continue;
			if (gold[M] < gold[i]) {
				ans++;
				continue;
			}
			if (gold[M] > gold[i])
				continue;
			if (silver[M] < silver[i]) {
				ans++;
				continue;
			}
			if (silver[M] > silver[i])
				continue;
			if (bronze[M] < bronze[i])
				ans++;
		}
		System.out.println(ans);
		sc.close();
	}

}
