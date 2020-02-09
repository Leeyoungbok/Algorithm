package SW_Expert;

import java.util.Scanner;

public class D3_7234 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc<= TC ;tc++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int max = 0;
			
			int[][] map = new int[N+1][N+1];
			for(int b = 0 ; b<B; b++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for(int i = 0 ; i < 4 ; i++) {
					int ax = x + dx[i];
					int ay = y + dy[i];
					for(int j = 0 ; j < 2 ; j++) {
						if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
						map[ax][ay]++;
						max = Math.max(map[ax][ay], max);
						ax += dx[i];
						ay += dy[i];
					}
					
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
