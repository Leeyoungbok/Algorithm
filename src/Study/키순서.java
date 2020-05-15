package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 키순서 {
	static int memo;
	static boolean[] used;
	static int[] res;
	static ArrayList<ArrayList<Integer>> list;
	static ArrayList<ArrayList<Integer>> backList;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		res = new int[N+1];
		
		list = new ArrayList<>();
		backList = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
			backList.add(new ArrayList<>());
		}
		
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			backList.get(n2).add(n1);
		}
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			used = new boolean[N+1];
			memo = 0;
			solve(i);
			solve_back(i);
//			System.out.println(i + " " + memo);
			if(memo == N-1)
				ans++;
		}
		System.out.println(ans);
	}
	static void solve(int node) {
		
		for(int n1 : list.get(node)) {
			if(used[n1]) continue;
			used[n1] = true;
			memo ++;
			solve(n1);
		}
	}
	static void solve_back(int node) {
		for(int n1 : backList.get(node)) {
			if(used[n1]) continue;
			used[n1] = true;
			memo++;
			solve_back(n1);
		}
	}
}
