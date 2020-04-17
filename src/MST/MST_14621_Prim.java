package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST_14621_Prim {
	static class Univ implements Comparable<Univ>{
		int e, cost;
		Univ(int e, int cost){
			this.e = e;
			this.cost = cost;
		}
		@Override
		public int compareTo(Univ o) {
			return this.cost - o.cost;
		}
	}
	
	
	static int N, M;
	static boolean[] used, check;
	static ArrayList<ArrayList<Univ>> list = new ArrayList<>();
	static PriorityQueue<Univ> queue = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		check = new boolean[N+1];
		used = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			char ch = sc.next().charAt(0);
			if(ch == 'M')
				check[i] = true;
		}
		
		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();
			
			if(check[s] == check[e]) continue;
			list.get(s).add(new Univ(e,cost));
			list.get(e).add(new Univ(s,cost));
		}
		
		queue.add(new Univ(1,0));
		int ans = 0;
		int k = N;
		
		while(!queue.isEmpty()) {
			Univ u = queue.poll();
			if(used[u.e]) continue; // 반드시 넣어주어야함
			used[u.e] = true; 
			ans += u.cost;
			k--;
			if(k==0) {
				System.out.println(ans);
				break;
			}
			for(Univ u1 : list.get(u.e)) {
				if(used[u1.e]) continue;
				queue.add(new Univ(u1.e, u1.cost));
			}
		}
		if(k != 0)
			System.out.println(-1);
	}

}
