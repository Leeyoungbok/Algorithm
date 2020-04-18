package Search;

import java.awt.Point;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Search_1043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[][] map = new boolean[N+1][N+1];
		boolean[] used = new boolean[N+1];
		int[][] party = new int[M][];
		int O = sc.nextInt();
		int[] user = new int[O];
		for(int i = 0 ; i < O ; i++) {
			user[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int idx = 0;
			party[i] = new int[n1];
			int n2 = sc.nextInt();
			party[i][idx++] = n2;
			for(int j = 1 ; j < n1 ; j++){
				int n3 = sc.nextInt();
				party[i][idx++] = n3;
				map[n2][n3] = map[n3][n2] = true;
			}
		}
		
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i = 0 ; i < O ; i++) {
			if(!used[user[i]]) {
				queue.add(user[i]);
				while(!queue.isEmpty()) {
					int a = queue.poll();
					if(used[a]) continue;
					used[a] = true;
					for(int k = 1 ; k <= N ; k++) {
						if(!map[a][k]) continue;
						queue.add(k);
					}
				}
			}
		}
		int ans = M;
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < party[i].length ; j++) {
				if(used[party[i][j]]) {
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
