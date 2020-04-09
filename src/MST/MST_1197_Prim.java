package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST_1197_Prim {
	static class Node{
		int e, cost;
		Node(int e, int cost){
			this.e = e;
			this.cost = cost;
		}
	}
	
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
	
	public static void main(String[] args) {

// ============== 1197 prim ==================
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		boolean[] used = new boolean[V+1];
		long cost = 0;
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		for(int i = 0 ; i <= V ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < E ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			list.get(n1).add(new Node(n2, n3));
			list.get(n2).add(new Node(n1, n3));
		}
		
		queue.add(new Edge(0, 1, 0));
		int k = 0;
		
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			if(used[e.e]) continue;
			used[e.e] = true;
			cost += e.cost;
			k++;
			if(k == V) {
				System.out.println(cost);
				sc.close();
				break;
			}
			for(Node n : list.get(e.e)) {
				if(used[n.e]) continue;
				queue.add(new Edge(e.e, n.e, n.cost));
			}
		}
		sc.close();
	}
}


//1. ���� MST ���� ��� ����
//2. ���� 1197���� ���� �迭 �������� ����
//3. ���� 1197���� ���� PQ �������� ����
//���� ����
//1197�� ũ�罺Į�� Ǯ��
//�߰�����: 2887�� �������� �����غ���

