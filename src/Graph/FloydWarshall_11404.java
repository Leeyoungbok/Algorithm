package Graph;

import java.util.Scanner;

public class FloydWarshall_11404 {
//	static final int INF = 1000000010;
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int[][] map = new int[N+1][N+1];
//		
//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= N ; j++) {
//				if(i == j)
//					map[i][j] = 0;
//				else
//					map[i][j] = INF;
//			}
//		}
//		
//		for(int i = 0 ; i < M ; i++) {
//			int n1 = sc.nextInt();
//			int n2 = sc.nextInt();
//			int n3 = sc.nextInt();
//			
//			map[n1][n2] = map[n1][n2] > n3 ? n3 : map[n1][n2];
//		}
//		
//		for(int k = 1 ; k <= N ; k++) {
//			for(int i = 1 ; i <= N ; i++) {
//				for(int j = 1 ; j <= N ; j++) {
//					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
//				}
//			}
//		}
//		
//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= N ; j++) {
//				if(map[i][j] >= INF)
//					System.out.print(0 + " ");
//				else
//					System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
//		sc.close();
//	}
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();

			if (map[n1][n2] != 0) {
				map[n1][n2] = map[n1][n2] > n3 ? n3 : map[n1][n2];
			} else
				map[n1][n2] = n3;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0)
					map[i][j] = MAX;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(k == i) continue;
				for (int j = 1; j <= n; j++) {
					if(i==j) continue;
					if(map[i][k] == MAX || map[k][j] == MAX) continue;
					map[i][j] = map[i][j] < map[i][k] + map[k][j] ? map[i][j] : map[i][k] + map[k][j];
				}
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(map[i][j] == MAX)
					map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
		sc.close();
		
	}
}
