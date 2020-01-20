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
	            //���� 0 �� ���Ű��   //���� 1�� ���Ű�� //���� 2������ ���
	            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+input[i],dp[i-3]+input[i-1]+input[i]));
	 
	        }
		/*
		 *		��ȭ��
		 *		dp[n] = dp[n] + dp[n-2]
		 *		dp[n] = dp[n-3] + dp[n-1] + dp[n]
		 *		�ΰ��� �ִ��� ������
		 *		n-3�� �ֱ⶧���� ���ǻ� 0, 1, 2�� �ʱ�ȭ ������
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
