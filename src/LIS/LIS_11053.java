package LIS;

import java.util.Scanner;

public class LIS_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
			
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = 0;
		for(int n1 : dp)
			max = n1 > max ? n1 : max;
		System.out.println(max);
		sc.close();
	}
}
