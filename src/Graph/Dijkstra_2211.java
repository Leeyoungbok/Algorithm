package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_2211 {
	static class V{
		int end, cost;
		V(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
	static class Edge implements Comparable<Edge>{
		int start, end, cost;
		Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M;
	static boolean[] used;
	static int[] dist;
	static ArrayList<ArrayList<V>> list = new ArrayList<>();
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static final int INF = 20000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		used = new boolean[N+1];
		dist = new int[N+1];

		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1 ; i <= N ; i++) {
			dist[i] = INF;
		}
		
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			list.get(n1).add(new V(n2, n3));
			list.get(n2).add(new V(n1, n3));
		}
		
		queue.add(new Edge(0,1,0));
		dist[1] = 0;
		int cnt = N;
		System.out.println(N-1);
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			if(used[e.end]) continue;
			cnt--;
			used[e.end] = true;
			
			if(e.start != 0 && e.end != 1) {
				System.out.println(e.start + " " + e.end);
			}
			
			if(cnt == 0)
				break;
			
			for(V v : list.get(e.end)) {
				if(used[v.end]) continue;
				if(dist[v.end] > v.cost + dist[e.end]) {
					dist[v.end] =  v.cost + dist[e.end];
					queue.add(new Edge(e.end, v.end, dist[v.end]));
				}
			}
		}
	}

}
