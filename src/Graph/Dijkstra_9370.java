package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int end, cost;

	Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

class Destination implements Comparable<Destination>{
	int end, cost, cnt;

	Destination(int end, int cost, int cnt) {
		this.end = end;
		this.cost = cost;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Destination o) {
		return this.cost - o.cost;
	}
}
public class Dijkstra_9370 {
	static int T, n, m, t, s, g, h, cnt;
	static int[] dist;
	static ArrayList<Integer> destiList;
	static ArrayList<Integer> answer;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] lastVisitCheck;
	static boolean[] used;

	static final int INF = 20000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			t = sc.nextInt();
			s = sc.nextInt();
			g = sc.nextInt();
			h = sc.nextInt();
			used = new boolean[n + 1];
			lastVisitCheck = new boolean[n+1];
			dist = new int[n + 1];
			
			destiList = new ArrayList<>();
			answer = new ArrayList<>();
			list = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 1; i <= n; i++) {
				dist[i] = INF;
			}

			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int d = sc.nextInt();

				list.get(a).add(new Node(b, d));
				list.get(b).add(new Node(a, d));
			}

			for (int i = 0; i < t; i++) {
				destiList.add(sc.nextInt());
			}

			// input

			PriorityQueue<Destination> queue = new PriorityQueue<>();

			queue.add(new Destination(s, 0, 0));
			dist[s] = 0;
			used[s] = true;
			lastVisitCheck[s] = true;
			int cnt = n;
			
			loop : while (!queue.isEmpty()) {
				Destination destination = queue.poll();
				cnt--;
				
				loop2 : for(int desti : destiList) {
					if(destination.end == desti) {
						if(destination.cnt == 2) {
							answer.add(destination.end);
						}
						for(int ans : answer) {
							if(destination.end == ans)
								break loop2;
						}
						answer.add(destination.end);
					}
				}
				
				if(cnt == 0) break;
				for (Node n : list.get(destination.end)) {
//					if (used[n.end])
//						continue;

					if (dist[n.end] >= n.cost + dist[destination.end]) {
						dist[n.end] = n.cost + dist[destination.end];
						if(n.end == g || n.end == h) {
							queue.add(new Destination(n.end, dist[n.end], destination.cnt + 1));
						}
						else
							queue.add(new Destination(n.end, dist[n.end], destination.cnt));
					}
				}
			}
			
			Collections.sort(answer);
			
			for(int ans : answer)
				System.out.print(ans + " ");
			System.out.println("");
			//test
//			for(int i = 1 ; i < dist.length ; i ++) {
//				System.out.println(dist[i]);
//			}

		}
	}
}
