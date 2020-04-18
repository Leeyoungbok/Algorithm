package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_1916 {
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
	
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static int[] dist;
	static boolean[] used;
	static final int MAX = 2000000001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		used = new boolean[N+1];
		for(int i = 1 ; i <= N ; i++) {
			dist[i] = MAX;
		}
		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			list.get(n1).add(new Edge(n1,n2,n3));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		
		queue.add(new Edge(0,start,0));
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(edge.end == end) {
				System.out.println(dist[edge.end]);
				break;
			}
			if(used[edge.end]) continue;
			used[edge.end] = true;
			for(Edge e : list.get(edge.end)) {
				if(used[e.end]) continue;
				if(dist[e.end] > e.cost + dist[edge.end]) {
					dist[e.end] = e.cost + dist[edge.end];
					queue.add(new Edge(edge.end, e.end, dist[e.end]));
				}
			}
		}
	}
}
