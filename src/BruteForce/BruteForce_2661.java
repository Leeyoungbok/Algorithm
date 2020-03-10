package BruteForce;

import java.util.Scanner;

public class BruteForce_2661 {
	static int[] input = {1,2,3};
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		result = new int[N];
		
		solve(0);
		sc.close();
	}
	
	static void solve(int idx) {
		if(idx > 1 && check(idx-1))
			return;
		
		if(idx == result.length) {
			for(int i = 0 ; i < idx ; i++) {
				System.out.print(result[i]);
			}
			System.exit(0);
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			result[idx] = input[i];
			solve(idx+1);
		}
		
	}
	static boolean check(int idx) {
		int mid = idx / 2;
		int k = 0;
		int start = mid -1;
		for(int i = 1 ; i <= mid ; i++) {
			if(result[start-i] != result[start])
				return false;
			k++;
		}
		
		return true;
	}

}
