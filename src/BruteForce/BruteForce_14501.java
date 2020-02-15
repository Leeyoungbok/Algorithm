package BruteForce;

import java.util.Scanner;

public class BruteForce_14501 {
	static int N;
	static int[] days;
	static int[] profit;
	static int[] result;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		days = new int[N+1];
		profit = new int[N+1];
		result = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			days[i] = sc.nextInt();
			profit[i] = sc.nextInt();
		}
		
		solve(0, 1);
		System.out.println(max);
	}
	
	static void solve(int idx, int n) {
		if(n >= N+1) {
			if(n > N+1)
				idx--;
			int sum = 0;
			for(int i = 0 ; i < idx; i++) {
				sum += result[i];
				System.out.print(result[i] + " ");
			}
			max = max < sum ? sum : max;
			System.out.println(sum);
			return;
		}
		
		result[idx] = profit[n];
		solve(idx+1, n+days[n]);
		solve(idx,n+1);
		return;
		
	}

}
