package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_1182 {
	static int[] arr;
	static int[] res;
	static int N;
	static int S;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		
		for(int i =0 ; i < N  ; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(arr));
		for(int i = 1 ; i <= N ; i++) {
			res = new int[i];
			comb(0,0,i);
		}
		System.out.println(ans);
		sc.close();
	}
	static void comb(int idx, int n, int i) {
		if(idx == i) {
			int sum =0;
			for(int j = 0 ; j < res.length; j++) {
				sum += res[j];
			}
			if(sum == S) ans++;
			return;
		}else if(n == arr.length)
			return;
		res[idx] = arr[n];
		comb(idx+1,n+1,i);
		comb(idx,n+1,i);
	}
}

