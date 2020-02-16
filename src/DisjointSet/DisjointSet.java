package DisjointSet;

import java.util.Scanner;

public class DisjointSet {
	static int[] disjoint;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		
		disjoint = new int[N+1];
		
		for(int i =0 ; i <= N ; i++) {
			disjoint[i] = i;
		}
		
		for(int i = 0 ; i < M ; i++) {
			int a1 = sc.nextInt();
			int p1 = find(a1); 
			if(p1 == 0) break;
			ans++;
			union(p1,p1-1);
		}
		System.out.println(ans);
	}
	static int find(int n1) {
		if(disjoint[n1] == n1)
			return n1;
		
		return disjoint[n1] = find(disjoint[n1]);
	}
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2)
			disjoint[p1] = p2;
	}

}
