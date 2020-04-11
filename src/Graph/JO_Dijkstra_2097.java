package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JO_Dijkstra_2097 {
	static class Subway implements Comparable<Subway>{
		int s, e, cost;
		Subway(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		@Override
		public int compareTo(Subway o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M, ans;
	static int[] dist;
	static int[][] map;
	static boolean[] used;
	static PriorityQueue<Subway> queue = new PriorityQueue<>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		dist = new int[N+1];
		used = new boolean[N+1];
		
		ans = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		
		// algo
		
		dist[1] = 0;
		queue.add(new Subway(0,1,0));
		
		while(!queue.isEmpty()) {
			Subway s = queue.poll();
			if(used[s.e]) continue;
			used[s.e] = true;
			for(int n1 : list.get(s.s))
				list.get(s.e).add(n1);
			list.get(s.e).add(s.e);
			if(s.e == M) {
				System.out.println(dist[M]);
				for(int n1 : list.get(M))
					System.out.print(n1 + " ");
				break;
			}
			
			for(int i = 1 ; i <= N ; i++) {
				if(used[i]) continue;
				if(dist[i] > dist[s.e] + map[s.e][i]) {
//					list.get(i).clear();
//                    for(int n1 : list.get(s.e))
//                        list.get(i).add(n1);
//                    list.get(i).add(i);
					dist[i] = dist[s.e] + map[s.e][i];
					queue.add(new Subway(s.e, i, dist[i]));
				}
			}
		}
		sc.close();
	}

}
