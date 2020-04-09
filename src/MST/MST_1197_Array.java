package MST;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MST_1197_Array {
	static class Edge implements Comparable<Edge>{
		int s, e, cost;
		Edge(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			if(this.cost > o.cost)
				return 1;
			else if(this.cost < o.cost)
				return -1;
			else
				return 0;
		}
	}

	static int[] dj;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		dj = new int[V+1];
		
		for(int i = 0 ; i <= V ; i++) {
			dj[i] = i;
		}
		long cost = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		for(int i = 0 ; i < E ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			queue.add(new Edge(n1, n2, n3));
		}
		int k = V-1;
        while(!queue.isEmpty()) {
        	Edge e = queue.poll();
			if(k == 0) {
				System.out.println(cost);
				sc.close();
				return;
			}
        	if(find(e.s) != find(e.e)) {
        		union(e.s, e.e);
        		k--;
        		cost += e.cost;
        	}
        }
        System.out.println(cost);
		sc.close();
	}
	
	static int find(int n1) {
		if(dj[n1] == n1)
			return n1;
		
		return dj[n1] = find(dj[n1]);
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 < p2)
			dj[p2] = p1;
		else
			dj[p1] = p2;
	}
	
}
