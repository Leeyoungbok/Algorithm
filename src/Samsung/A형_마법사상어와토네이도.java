package Samsung;

import java.util.Scanner;

public class A형_마법사상어와토네이도 {

	static int N, x, y, answer;
	static int[][] map;
	static int[][] dx = {
			{-2,-1,-1,-1,0,1,1,1,2,0}, // 왼
			{0,1,0,-1,2,1,0,-1,0,1}, // 아래
            {-2,-1,-1,-1,0,1,1,1,2,0}, // 오른
            {0,-1,0,1,-2,-1,0,1,0,-1}}; // 위
	static int[][] dy = {
			{0,-1,0,1,-2,-1,0,1,0,-1}, 
			{-2,-1,-1,-1,0,1,1,1,2,0},
            {0,1,0,-1,2,1,0,-1,0,1},
            {2,1,1,1,0,-1,-1,-1,-2,0}};
	static double[] per = {0.02,0.1,0.07,0.01,0.05,0.1,0.07,0.01,0.02};


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// input

		x = N / 2;
		y = N / 2;
		answer = 0;
		int cnt = 1;

		loop: while (true) {
			for (int i = 0; i < cnt; i++) {
				if (x == 0 && y == 0) {
					System.out.println(answer);
					break loop;
				}
				y--;
				spread(0);
			}

			for (int i = 0; i < cnt; i++) {
				x++;
				spread(1);
			}

			cnt++;

			for (int i = 0; i < cnt; i++) {
				y++;
				spread(2);
			}

			for (int i = 0; i < cnt; i++) {
				x--;
				spread(3);
			}
			

			cnt++;
		}

	}
	
	private static void spread(int dir) {
		int sand = map[x][y];
		for(int k = 0 ; k < 9 ; k++) {
			int ax = x + dx[dir][k];
			int ay = y + dy[dir][k];
			
			if(ax < 0 || ax >= N || ay < 0 || ay >= N) {
				answer += sand * per[k];
			}else {
				map[ax][ay] += sand * per[k];
			}
			map[x][y] -= (int)(sand * per[k]);
		}
		int ax = x + dx[dir][9];
		int ay = y + dy[dir][9];
		
		if(ax < 0 || ax >= N || ay < 0 || ay >= N) {
			answer += map[x][y];
		}else {
			map[ax][ay] += map[x][y];
		}
		
		map[x][y] = 0;
	}
	
	

}
