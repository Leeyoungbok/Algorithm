package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 환승 { // dummy node�� �̿��� bfs;
	static int N, M, K;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] used;
	static int[] cost;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		
		used = new boolean[N+M+1];
		cost = new int[N+M+1];
		Arrays.fill(cost, 987654321);
		for(int i = 0 ; i <= N + M ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = N + 1 ; i <= N+M ; i++) {
			for(int j = 0 ; j < K ; j++) {
				int n1 = sc.nextInt();
				list.get(i).add(n1);
				list.get(n1).add(i);
			}
		}
		
		Deque<Integer> queue = new LinkedList<>();
		queue.add(1);
		used[1] = true;
		cost[1] = 1;
		while(!queue.isEmpty()) {
			int n1 = queue.poll();
			if(n1 == N) {
				System.out.println((cost[N] + 1)/2);
				return;
			}
			for(int n2 : list.get(n1)) {
				if(!used[n2] && cost[n2] > cost[n1] + 1) {
					queue.add(n2);
					used[n2] = true;
					cost[n2] = cost[n1] + 1;
				}
			}
		}
		System.out.println(-1);
	}
	

}
