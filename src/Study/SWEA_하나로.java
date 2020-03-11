package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

class Land implements Comparable<Land>{
	int n1,n2;
	double fee;
	
	Land(int n1, int n2, double fee){
		this.n1 = n1;
		this.n2 = n2;
		this.fee = fee;
	}

	@Override
	public int compareTo(Land o) {
		if(this.fee >= o.fee)
			return 1;
		else
			return -1;
	}
}

public class SWEA_ÇÏ³ª·Î {
	static int N;
	static double E;
	static PriorityQueue<Land> list = new PriorityQueue<>();
	static int[] disjoint;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			disjoint = new int[N];
			int[][] map = new int[N][2];
			
			for(int i = 0 ; i < N ; i++) {
				map[i][0] = sc.nextInt();
			}
			for(int i = 0 ; i < N ; i++) {
				map[i][1] = sc.nextInt();
			}
			
			E = sc.nextDouble();
			for(int i = 0 ; i < N -1 ; i++) {
				for(int j = i + 1 ; j < N ; j++) {
					list.add(new Land(i, j, E * (Math.pow(map[i][0]-map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2))));
				}
			}
			double sum = 0;
			init();
			while(!list.isEmpty()) {
				Land l = list.poll();
				if(find(l.n1) != find(l.n2)) {
					sum += l.fee;
					union(l.n1, l.n2);
				}
			}
			System.out.println("#" + tc + " " + Math.round(sum));
			sc.close();
		}
	}
	
	static void init() {
		for(int i = 0 ; i < N ; i++) {
			disjoint[i] = i;
		}
	}
	
	static int find(int n1) {
		if(disjoint[n1] == n1)
			return n1;
		
		return disjoint[n1] = find(disjoint[n1]);
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 > p2)
			disjoint[p1] = p2;
		else
			disjoint[p2] = p1;
	}
}
