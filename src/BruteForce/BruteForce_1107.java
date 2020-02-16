package BruteForce;

import java.util.Scanner;

public class BruteForce_1107 {
	static String N;
	static int M;
	static boolean[] arr = new boolean[10];
	static int[] res;
	static int[] res2;
	static int ans = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextLine();
		M = sc.nextInt();
		res = new int[N.length()];
		res2= new int[N.length()+1];
		int start = 100;
		for (int i = 0; i < M; i++) {
			arr[sc.nextInt()] = true;
		}
		if(M == 10)
			System.out.println(Math.abs(Integer.parseInt(N) - start));
		else {
			solve(0);
			solve2(0);
			System.out.println(Math.min(Math.abs(Integer.parseInt(N) - start), ans));
			sc.close();
		}
	}
	
	static void solve(int idx) {
		if(idx == N.length()) {
			
			int n1 = N.length();
			String str = "";
			for(int i =0 ; i < idx ; i++) {
				str += res[i];
			}
			n1 += Math.abs(Integer.parseInt(N) - Integer.parseInt(str));
			if(ans == -1 || ans > n1)
				ans = n1;
			
			if(N.length() > 1) {
				int n2 = N.length();
				String str2 = "";
				for(int i =0 ; i < idx-1 ; i++) {
					str2 += res[i];
				}
				n2 += Math.abs(Integer.parseInt(N) - Integer.parseInt(str2))-1;
				if(ans == -1 || ans > n2)
					ans = n2;
				
			}
			return;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(!arr[i]) {
				res[idx] = i;
				solve(idx+1);
			}
		}
	}
	
	static void solve2(int idx) {
		if(idx == N.length()+1) {
			int n1 = N.length()+1;
			String str = "";
			for(int i =0 ; i < idx ; i++) {
				str += res2[i];
			}
			n1 += Math.abs(Integer.parseInt(N) - Integer.parseInt(str));
			if(ans == -1 || ans > n1)
				ans = n1;
			return;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(!arr[i]) {
				res2[idx] = i;
				solve2(idx+1);
			}
		}
	}

}
