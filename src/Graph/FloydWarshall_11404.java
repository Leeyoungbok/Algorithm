package Graph;

import java.util.Scanner;

public class FloydWarshall_11404 {
	static final int INF = 1000000010;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(i == j)
					map[i][j] = 0;
				else
					map[i][j] = INF;
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			map[n1][n2] = map[n1][n2] > n3 ? n3 : map[n1][n2];
		}
		
		for(int k = 1 ; k <= N ; k++) {
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j] >= INF)
					System.out.print(0 + " ");
				else
					System.out.print(map[i][j] + " ");
			}System.out.println();
		}
		sc.close();
	}

}
