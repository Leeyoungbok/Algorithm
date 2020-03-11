package MST;

import java.util.PriorityQueue;
import java.util.Scanner;

class Network implements Comparable<Network>{
	int start, end, cost;
	Network(int start, int end, int cost){
		this.start = start;
		this.end  = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Network o) {
		return this.cost - o.cost;
	}
}

public class MST_1922 {
	static int N, M;
	static boolean[] nodes;
	static int[][] matrix;
	static PriorityQueue<Network> queue = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nodes = new boolean[N+1];
		matrix = new int[N+1][N+1];
		
		for(int m = 0 ; m < M ; m++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			matrix[n1][n2] = matrix[n2][n1] = n3;
		}
		
		int k = 0;
		int ans = 0;
		nodes[1] = true;
		for(int i = 1 ; i <= N ; i++) {
			if(matrix[1][i] != 0) {
				queue.add(new Network(1,i,matrix[1][i]));
			}
		}
		
		while(!queue.isEmpty()) {
			Network nw = queue.poll();
			if(nodes[nw.end]) continue;
			nodes[nw.end]= true;
//			System.out.println(nw.end);
//			System.out.println(nw.start + " " + nw.end + " " + nw.cost);
			ans += nw.cost;
			k++;
			if(k == N - 1) {
				System.out.println(ans);
				break;
			}
			for(int i = 1 ; i <= N ; i++) {
				if(matrix[nw.end][i] != 0 && !nodes[i]) {
					queue.add(new Network(nw.end, i, matrix[nw.end][i]));
//					System.out.println(nw.end + " " + i + " " + matrix[nw.end][i]);
				}
			}
		}
	}
//805049
}
