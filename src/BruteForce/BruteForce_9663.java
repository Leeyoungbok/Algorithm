package BruteForce;

import java.util.Scanner;

public class BruteForce_9663 {
	static int[] map;
	static int N;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			map = new int[N+1];
			map[1] = i;
			
			solve(1);
		}
		System.out.println(ans);
		
	}
	static void solve(int row) {
		if(row == N) {
			ans++;
			return;
		}else {
			
			for(int i = 1 ; i <= N ; i++) {
				map[row+1] = i;
				if(isPossible(row+1)) {
					solve(row+1);
				}else {
					map[row+1] = 0;
				}
			}
		}
		map[row] = 0;
	}
	static boolean isPossible(int row) {
		for(int i = 1 ; i < row ; i++) {
			if(map[i] == map[row])
				return false;
			if(Math.abs(i-row) == Math.abs(map[i] - map[row]))
				return false;
		}
		return true;
	}
}
