package DP;

import java.util.Scanner;

public class DP_2193 {
	public static long solution(int input) {
		long ret = 0;
		long[][] arr = new long[input+1][2];
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		for(int i = 2; i < input+1; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-1][1];
			arr[i][1] = arr[i-1][0];
		}
		ret = arr[input][0] + arr[input][1];
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(DP_2193.solution(n));
		sc.close();
	}
}
/*
 * 1磊府 1
 * 2磊府 10
 * 3磊府 100, 101
 * 4磊府 1000, 1010, 1001
 * 5磊府 10000,10001, 10101, 10100, 10010
 */
