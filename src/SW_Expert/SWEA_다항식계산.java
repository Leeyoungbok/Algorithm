package SW_Expert;

import java.util.Scanner;

public class SWEA_다항식계산 {
	static int N, M;
	static long[] arr, res;
	static int[] t, a, b;
	static final long MOD = 998244353;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			
			t = new int[N+1];
			a = new int[N+1];
			b = new int[N+1];
			
			for(int i = 2 ; i <= N ; i++) {
				t[i] = sc.nextInt();
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			M = sc.nextInt();
			
			res = new long[M];
			
			for(int i = 0 ; i < M ; i++){
				arr = new long[N+1];
				arr[0] = 1;
				arr[1] = sc.nextInt();
				for(int j = 2 ; j <= N ; j++) {
					if(t[j] == 1) {
						arr[j] = calType1(j)%MOD;
					}else if(t[j] == 2) {
						arr[j] = calType2(j)%MOD;
					}else
						arr[j] = calType3(j)%MOD;
				}
				res[i] = arr[N];
			}
			
			System.out.print("#" + tc);
			for(long n1 : res)
				System.out.print(" " + n1);
			System.out.println();
		}
	}
	
	static long calType1(int i) {
		return (arr[a[i]] + arr[b[i]])%MOD;
	}
	
	static long calType2(int i) {
		return (a[i] * arr[b[i]])%MOD;
	}
	
	static long calType3(int i) {
		return (arr[a[i]] * arr[b[i]])%MOD;
	}

}
