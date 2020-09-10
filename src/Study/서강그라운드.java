package Study;

import java.util.Scanner;

public class 서강그라운드 {
	static int N, M, R;
	   static int[] itemCnt;
	   static int[][] map, copyMap;

	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);

	      N = sc.nextInt();
	      M = sc.nextInt();
	      R = sc.nextInt();
	      
	      itemCnt = new int[N + 1];
	      map = new int[N + 1][N + 1];
	      copyMap = new int[N + 1][N + 1];

	      int answer = 0;
	      
	      for(int i = 1 ; i <= N ; i++) {
	         itemCnt[i] = sc.nextInt();
	      }
	      
	      for (int i = 1; i <= N; i++) {
	         for (int j = 1; j <= N; j++) {
	            map[i][j] = 123456;
	         }
	      }

	      for (int i = 0; i < R; i++) {
	         int n1 = sc.nextInt();
	         int n2 = sc.nextInt();
	         int n3 = sc.nextInt();
	         map[n1][n2] = n3;
	         map[n2][n1] = n3;
	      }

	      for (int n = 1; n <= N; n++) {
	         floydWarshall();
	         int cost = itemCnt[n];
	         copy();
	         for (int j = 1; j <= N; j++) {
	            System.out.print(copyMap[n][j] + " ");
	            if (copyMap[n][j] <= M && n != j)
	               cost += itemCnt[j];
	         }
	         System.out.println(cost);
	         answer = answer < cost ? cost : answer;
	      }
	      
	      System.out.println(answer);
	   }

	   static void floydWarshall() {
	      for (int k = 1; k <= N; k++) {
	         for (int i = 1; i <= N; i++) {
	            for (int j = 1; j <= N; j++) {
	               if (map[i][k] + map[k][j] < map[i][j])
	                  map[i][j] = map[i][k] + map[k][j];
	            }
	         }
	      }
	   }
	   
	   static void copy() {
	      for(int i = 1 ; i <= N ; i++) {
	         for(int j = 1 ; j <= N ; j++) {
	            copyMap[i][j] = map[i][j];
	         }
	      }
	   }
	}