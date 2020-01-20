package DP;

import java.util.Scanner;

public class DP_1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		int ret = -1001;
		
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		dp[0] = arr[0];
		
		for(int i = 1 ; i < N; i++) {
			dp[i] = (dp[i-1] + arr[i]) > arr[i] ? dp[i-1]+arr[i] : arr[i];
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(ret < dp[i]) ret = dp[i];
		}
		
		System.out.println(ret);
		
		sc.close();
	}
}
