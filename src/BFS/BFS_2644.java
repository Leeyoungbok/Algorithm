package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		int N = sc.nextInt();
		int[] degree  = new int[N+1];
		
		
		for(int i = 1 ; i <= N ; i++) {
			degree[i] = -1;
		}
		
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		
		int M = sc.nextInt();
		
		int[][] person = new int[N+1][N+1];
		
		for(int i = 0 ; i < M ;i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			person[n1][n2] = 1;
			person[n2][n1] = 1;
		}
		for(int i = 1 ;i <= N ; i++) {
			for(int j =1 ; j <= N;j++) {
				System.out.print(person[i][j] + " ");
				
			}
			System.out.println();
		}
		queue.add(p1);
		degree[p1] = 0;
		while(!queue.isEmpty()) {
			int n1 = queue.poll();
			
			for(int i = 1 ; i<=N ; i++) {
				if(person[n1][i] != 1) continue;
				queue.add(i);
				degree[i] = degree[n1] + 1;
				person[n1][i] = person[i][n1] = 0;
			}
		}
//		for(int i = 1 ; i <= N ;i++) {
//			System.out.println(i + " " + degree[i]);
//		}
		if(degree[p2] == -1){
			System.out.println("-1");
		}else {
			System.out.println(Math.abs(degree[p1]-degree[p2]));
		}
	}
	
}


