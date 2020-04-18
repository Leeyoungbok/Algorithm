package Study;

import java.util.Arrays;
import java.util.Scanner;

public class Æò¹üÇÑ¹è³¶ {
	static int N, M, ans = 0;
	static int[] arr, weight, value;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		weight = new int[N];
		value = new int[N];
		used = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		sol(0,0,0);
		System.out.println(ans);
	}

	static void sol(int cnt, int w, int v) {
		if(w > M) {
			v -= arr[cnt-1];
			if(v > ans)
				ans = v;
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!used[i]) {
				used[i] = true;
				arr[cnt] = value[i];
				sol(cnt+1, w+weight[i], v+value[i]);
				used[i] = false;
			}
		}
	}
	
}
