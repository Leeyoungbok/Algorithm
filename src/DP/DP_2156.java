package DP;

import java.util.Scanner;

public class DP_2156 {
	public static int solution(int[] input,int n) {
		int cnt = input.length;
		int[] dp = new int[n+1];

		dp[1] = input[1];
		if(n>1)
		dp[2] = input[1]+input[2];
		
		 for(int i=3; i<cnt; i++){
	            //연속 0 번 마신경우   //연속 1번 마신경우 //연속 2번마신 경우
	            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+input[i],dp[i-3]+input[i-1]+input[i]));
	 
	        }
		/*
		 *		점화식
		 *		dp[n] = dp[n] + dp[n-2]
		 *		dp[n] = dp[n-3] + dp[n-1] + dp[n]
		 *		두개의 최댓값을 저장함
		 *		n-3이 있기때문에 편의상 0, 1, 2는 초기화 시켜줌
		 */
		
		
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] grapes = new int[n+1];
		for(int i = 1 ; i < n+1 ; i ++) {
			grapes[i] = sc.nextInt();
		}
			
		System.out.println(DP_2156.solution(grapes,n));
		sc.close();
	}

}
