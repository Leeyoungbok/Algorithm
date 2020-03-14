package Study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_´Þ¸®±â {
	static int N, M;
	static long ans;
	static int[][] arr;
	static int[] res;
	static boolean[] used;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ans = 0;
			arr = new int[M][2];
			res = new int[N];
			used = new boolean[N+1];
			for(int i = 0 ; i < M ; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			solve(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void solve(int idx) {
		if(idx == N) {
			if(check())
				ans++;
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(!used[i]) {
				res[idx] = i;
				used[i] = true;
				solve(idx+1);
				used[i] = false;
			}
		}
	}
	
	static boolean check() {
		for(int i = 0 ; i < M ; i++) {
			int idx1 = 0;
			int idx2 = 0;
			for(int j = 0 ; j < N ; j++) {
				if(res[j] == arr[i][0])
					idx1 = j;
				if(res[j] == arr[i][1])
					idx2 = j;
			}
			if(idx1 < idx2)
				return false;
		}
		return true;
	}

}
