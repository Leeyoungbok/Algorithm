package MST;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Tunnel implements Comparable<Tunnel>{
	int x, y, cost;
	Tunnel(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Tunnel o) {
		return this.cost - o.cost;
	}
	
}

class Node{
	int idx,x,y,z;
	Node(int idx, int x, int y, int z){
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class MST_2887_Kru {
	static int N;
	static Node[] node;
	static int[] dj;
//	static int[][] arr, map;
//	static boolean[] isUsed;
	static PriorityQueue<Tunnel> queue = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
//		arr = new int[N+1][3];
//		map = new int[N+1][N+1];
//		isUsed = new boolean[N+1];
		long ans = 0;
		node = new Node[N];
		dj = new int[N];
		for(int i = 0 ; i < N ; i++) {
			node[i] = new Node(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Comparator<Node> cmp = (o1,o2)-> o1.x-o2.x;
		Arrays.sort(node,cmp);
        for (int i = 1; i <N ; i++) {
        	queue.add(new Tunnel(node[i-1].idx, node[i].idx, Math.abs(node[i].x-node[i-1].x)));
        }
        
        Comparator<Node> cmp2 = (o1,o2)-> o1.y-o2.y;
		Arrays.sort(node,cmp2);
        for (int i = 1; i <N ; i++) {
        	queue.add(new Tunnel(node[i-1].idx, node[i].idx, Math.abs(node[i].y-node[i-1].y)));
        }
        
        Comparator<Node> cmp3 = (o1,o2)-> o1.z-o2.z;
		Arrays.sort(node,cmp3);
        for (int i = 1; i <N ; i++) {
        	queue.add(new Tunnel(node[i-1].idx, node[i].idx, Math.abs(node[i].z-node[i-1].z)));
        }
        
        init();
        int k = N-1;
        while(!queue.isEmpty()) {
        	Tunnel t = queue.poll();
			if(k == 0) {
				System.out.println(ans);
				break;
			}
        	if(find(t.x) != find(t.y)) {
        		union(t.x, t.y);
        		k--;
        		ans += t.cost;
        	}
        }
//		queue.add(new Tunnel(0,1,0));
//		isUsed[1] = true;
//		int k = N-1;
//		
//		while(!queue.isEmpty()) {
//			Tunnel t = queue.poll();
//			ans += t.cost;
//			k--;
//			if(k == 0) {
//				System.out.println(ans);
//				break;
//			}
//			for(int i = 1 ; i <= N ; i++) {
//				if(isUsed[i]) continue;
//				queue.add(new Tunnel(t.y, i, map[t.y][i]));
//				isUsed[i] = true;
//			}
//		}
	}
	
	static void init() {
		for(int i = 0 ; i < N ; i++) {
			dj[i] = i;
		}
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
