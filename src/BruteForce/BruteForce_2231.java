package BruteForce;

import java.util.Scanner;

public class BruteForce_2231 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		boolean check = false;
		for(int i = 1 ; i < N ; i++) {
			if(solve(i, i)) {
				System.out.println(i);
				check = true;
				break;
			}
		}
		if(!check)
			System.out.println(0);
		sc.close();
	}
	
	static boolean solve(int num, int sum) {
		if(num  == 0) {
			if(sum == N) {
				return true;
			}
			return false;
		}
		
		return solve(num/10, sum + num % 10);
	}
}
