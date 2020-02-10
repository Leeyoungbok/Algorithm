package BruteForce;

import java.util.Scanner;

public class BruteForce_9663 {
	static int N;
	static int[][] chess;
	static int[][] res;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		chess = new int[N+1][N+1];
		res = new int[N+1][N+1];
		combination(0);
	}
	static void combination(int idx) {
		if(idx == N) {
			// Á¶°Ç
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				
			}
		}
	}
}
