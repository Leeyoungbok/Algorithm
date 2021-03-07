package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_건포도와초콜릿_ver2 {
	static int result;
	static int n, m;
	static int[][] map;
	static int[][][][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			dp = new int[n+1][m+1][n+1][m+1];
			for(int[][][] d1 : dp) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);;
					}
				}
			}
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			result = dfs(0,0,n,m);
		}
	}
	
	static int dfs(int y, int x, int h, int w) {
		if(w == 1 && h == 1) {
			return 0;
		}
		
		if(dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
		
		int sum = 0;
		for(int i = y ; i < y+h ; i++) {
			for(int j = x ; j < x+w; j++) {
				sum += map[i][j];
			}
		}
		// ���κ�� �ּڰ�
		for(int i = 1 ; i < h ; i++) {
			if(dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y,x,i,w);
			}
			if(dp[y+i][x][h-i][w] == Integer.MAX_VALUE) {
				dp[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
			}
			int sum3 = sum + dp[y][x][h][w] + dp[y+i][x][h-i][w];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		// ���κ�� �ּڰ�
		for(int i = 1 ; i < w ; i++) {
			if(dp[y][x][h][w] == Integer.MAX_VALUE) {
				dp[y][x][h][w] = dfs(y,x,h,i);
			}
			if(dp[y][x+i][h][w-i] == Integer.MAX_VALUE) {
				dp[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
			}
			int sum3 = sum + dp[y][x][h][w] + dp[y][x+i][h][w-i];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		return dp[y][x][h][w];
	}

}
