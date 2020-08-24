package Study;

import java.util.Scanner;

/*
 * 풀이법 : 적은거 -> 많은거 탐색이 아니라 많은거 -> 적은것으로 탐색을 돌린다.
 * 즉, return 하면서 적은거를 dp에 넣어주는게 아니다.
 */
public class 욕심쟁이판다 {

	static int N, total;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(dp[i][j] == 0) {
					solve(i,j);
				}
			}
		}
		
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				ans = ans > dp[i][j] ? ans : dp[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	static void solve(int x, int y) {
		int val = 0;
		int ax = 0, ay = 0;
		for(int k = 0 ; k < 4 ; k++) {
			ax = x + dx[k];
			ay = y + dy[k];
			
			if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
			
			if(map[x][y] > map[ax][ay]) {
				if(dp[ax][ay] == 0)
					solve(ax,ay);
				
				if(val < dp[ax][ay])
					val = dp[ax][ay];
			}
		}
		
		dp[x][y] = val + 1;
		
	}
}
