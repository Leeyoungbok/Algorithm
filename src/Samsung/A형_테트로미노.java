package Samsung;

import java.util.Scanner;

public class A형_테트로미노 {
	
	static int N, M;
	static int[][] map;
	
	static int[][] dx = {
			{0,0,0,0},{0,1,2,3},
			{0,0,1,1},
			{0,1,2,2},{0,0,0,-1},{0,0,1,2},{0,1,0,0},
			{0,0,-1,-2},{0,0,0,1},{0,0,1,2},{0,1,1,1},
			{0,1,1,2},{0,0,-1,-1},{0,-1,-1,-2},{0,0,1,1},
			{0,0,0,1},{0,1,2,1},{0,-1,0,1},{0,-1,0,0}
	};
	static int[][] dy = {
			{0,1,2,3},{0,0,0,0},
			{0,1,0,1},
			{0,0,0,1},{0,1,2,2},{0,1,1,1},{0,0,1,2},
			{0,1,1,1},{0,1,2,2},{0,1,0,0},{0,0,1,2},
			{0,0,1,1},{0,1,1,2},{0,0,1,1},{0,1,1,2},
			{0,1,2,1},{0,0,0,1},{0,1,1,1},{0,1,1,2}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int max = 0 ;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int k = 0 ; k < 19 ; k ++) {
					int sum = 0;
					for(int l = 0 ; l < 4 ; l++) {
						int ax = i + dx[k][l];
						int ay = j + dy[k][l];
						
						if(ax < 0 || ax >= N || ay < 0 || ay >= M) {
							sum = 0;
							break;
						}
						sum += map[ax][ay];
					}
					
					max = max > sum ? max : sum;
				}
			}
		}
		System.out.println(max);
		
		
	}
}
