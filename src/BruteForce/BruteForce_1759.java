package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_1759 {
	static int L;
	static int S;
	static char[] arr;
	static char[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		S = sc.nextInt();
		
		arr = new char[S];
		res = new char[L];
		
		for(int i = 0 ; i < S ; i++) {
			arr[i] = sc.next().charAt(0);
		}
		Arrays.sort(arr);
		
		combi(0,0);
		sc.close();
	}
	static void combi(int idx, int n) {
		if(idx == L) {
			if(check()) {
				for(int i =0  ; i < L ; i++) {
					System.out.print(res[i]);
				}
				System.out.println();
			}
			return;
		}else if(n == S) return;
		
		res[idx] = arr[n];
		combi(idx+1,n+1);
		combi(idx,n+1);
			
	}
	static boolean check() {
		int m=0;
		int j=0;
		for(int i =0 ; i < L ; i++) {
			if(res[i] == 'a' || res[i]  == 'e' || res[i] == 'i' || res[i] == 'o' || res[i] == 'u')
				m++;
			else
				j++;
			if(m >= 1 && j >= 2)
				return true;
		}
		return false;
	}
}

