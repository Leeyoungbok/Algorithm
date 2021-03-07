package SW_Expert;

import java.util.Scanner;

public class SWEA_초콜릿과건포도_완탐{
	static int result;
	static int n, m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			result = dfs(0,0,n,m,Integer.MAX_VALUE);
		}
	}
	
	static int dfs(int y, int x, int h, int w, int min) {
		if(w == 1 && h == 1) {
			return 0;
		}
		
		int sum = 0;
		for(int i = y ; i < y+h ; i++) {
			for(int j = x ; j < x+w; j++) {
				sum += map[i][j];
			}
		}
		
		for(int i = 1 ; i < h ; i++) {
			int sum1 = dfs(y,x,i,w,min);
			int sum2 = dfs(y+i,x,h-i,w,min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		
		for(int i = 1 ; i < w ; i++) {
			int sum1 = dfs(y,x,h,i,min);
			int sum2 = dfs(y,x+i,h,w-i,min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		return min;
	}

}
