package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Dijkstra_1753 {
	
	static class edge implements Comparable<edge>{
		int u, v, w;
		edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}
		
	}
	static final int INF = 20000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int[] nodes = new int[V+1];
		for(int i = 1 ; i <= V ; i++) {
			nodes[i] = INF;
		}
		int E = sc.nextInt();
		
		
		ArrayList<ArrayList<edge>> list = new ArrayList<>();
		PriorityQueue<edge> queue = new PriorityQueue<>();
		
		for(int i = 0 ; i <= V ; i++) {
			list.add(new ArrayList<>());
		}
		
		int start = sc.nextInt();
		nodes[start] = 0;
		queue.add(new edge(0,start,0));
//		boolean[] used = new boolean[V+1];
		for(int i = 0 ; i < E ; i++) {
			int n1 = sc.nextInt();
			list.get(n1).add(new edge(n1, sc.nextInt(), sc.nextInt()));
		}
		
		while(!queue.isEmpty()) {
			edge e1 = queue.poll();
//			if(used[e1.v]) continue;
//			used[start] = true;
			for(edge e2 : list.get(e1.v)) {
				if(nodes[e2.v] > e2.w + nodes[e1.v]) {
					nodes[e2.v] = e2.w + nodes[e1.v];
					queue.add(new edge(e2.u, e2.v, nodes[e2.v]));
				}
			}
		}
		
		for(int i = 1 ; i <= V ; i++) {
			if(nodes[i] == INF)
				System.out.println("INF");
			else
				System.out.println(nodes[i]);
		}
		sc.close();
	}
}
