package SW_Expert;

import java.util.Scanner;

public class SWEA_준환이의양팔저울 {
	static int[] arr, res;
	static boolean[] used;
	static int N;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			res = new int[N];
			used = new boolean[N];
			for(int i = 0 ; i < N ; i ++) {
				arr[i] = sc.nextInt();
			}
			ans = 0;
			perm(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	// combination + permutation
	static void combi(int cnt, int left, int right) {
		// backtracking
		if(left < right)
			return;
		
		if(cnt == N) {
			ans++;
			return;
		}
		
		//combi
		combi(cnt+1, left+res[cnt], right);
		combi(cnt+1, left, right+res[cnt]);
	}
	
	static void perm(int cnt, int idx) {
		if(cnt == N) {
			combi(0, 0, 0);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!used[i]) {
				used[i] = true;
				res[idx] = arr[i];
				perm(cnt+1, idx+1);
				used[i] = false;
			}
		}
	}
}
