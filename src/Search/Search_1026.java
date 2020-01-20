package Search;

import java.util.Arrays;
import java.util.Scanner;

public class Search_1026 {

	public static int solve(int[] input_a, int[] input_b) {
		int ret = 0;
		Arrays.sort(input_a);
		Arrays.sort(input_b);
		
		for(int i = 0 ; i < input_a.length ; i++) {
			ret += input_a[i] * input_b[input_b.length-1-i];
		}
		
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0 ; i < n ; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(Search_1026.solve(a, b));
		sc.close();
	}

}
