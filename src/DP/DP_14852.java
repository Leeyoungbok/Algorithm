package DP;

import java.util.Scanner;

public class DP_14852 {
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[1000001];
		int N = sc.nextInt();
		
		dp[1] = 2;
		
		for(int i = 2 ; i <= N ; i++) {
			dp[i] = ((3*dp[i-1])%MOD + 1)% MOD;
		}
		
		System.out.println(dp[N]);
	}

}
