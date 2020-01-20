package DP;

import java.util.Scanner;

public class DP_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n];
		
		dp[0] = 1;
		if(n >= 2) {
			dp[1] = 3;
			for(int i = 2 ; i < n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
			}
		}
		System.out.println(dp[n-1]);
	}

}
