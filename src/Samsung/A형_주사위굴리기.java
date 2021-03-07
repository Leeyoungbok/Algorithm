package Samsung;

import java.util.Scanner;

public class A형_주사위굴리기 {
	static int N, M, X, Y;
	static int[][] map;
	static int[] cube = new int[7];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		
		X = sc.nextInt()+1;
		Y = sc.nextInt()+1;
		
		int orderCnt = sc.nextInt();
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < orderCnt ; i++) {
			int order = sc.nextInt();
			
			int ax = X + dx[order-1];
			int ay = Y + dy[order-1];
			
			if(ax < 1 || ax > N || ay < 1 || ay > M) continue;
			
			X = ax;
			Y = ay;
			
			changeCube(order);
			
			if(map[ax][ay] == 0)
				map[ax][ay] = cube[6];
			else {
				cube[6] = map[ax][ay];
				map[ax][ay] = 0;
			}
			
			System.out.println(cube[1]);
		}
		sc.close();
		
		
		
	}

	static void changeCube(int order) {
		int temp = cube[1];
		int temp2 = cube[6];
		if (order == 1) {
			cube[1] = cube[4];
			cube[6] = cube[3];
			cube[3] = temp;
			cube[4] = temp2;
		} else if (order == 2) {
			cube[1] = cube[3];
			cube[6] = cube[4];
			cube[4] = temp;
			cube[3] = temp2;
		} else if (order == 3) {
			cube[1] = cube[5];
			cube[6] = cube[2];
			cube[2] = temp;
			cube[5] = temp2;
		} else {
			cube[1] = cube[2];
			cube[6] = cube[5];
			cube[5] = temp;
			cube[2] = temp2;
		}
	}

}
