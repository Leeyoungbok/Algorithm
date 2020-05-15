package DP;

public class DP_막대기{

	public static void main(String[] args) {
		int[] dp = new int[100];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4 ; i <= 8 ; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[8]);
	}

}
