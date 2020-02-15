package BruteForce;

import java.util.Scanner;

public class BruteForce_7568 {
	static int N;
	static int[][] info;
	static int[] person;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		info = new int[N][2];
		person = new int[N];

		for (int i = 0; i < N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
		}

		solve(0, 0, 1);
		sc.close();
	}

	static void solve(int idx, int n, int rank) {
		if(n == N) {
			person[idx] = rank;
			solve(idx+1, 0, 1);
			return;
		}
		
		if (idx == N) {
			for (int i = 0; i < N; i++)
				System.out.print(person[i] + " ");
			return;
		}
		
		else {
			if(info[idx][0] < info[n][0] && info[idx][1] < info[n][1])
				solve(idx,n+1,rank+1);
			else
				solve(idx,n+1,rank);
		}
		
		
	}

}
