package SW_Expert;

import java.util.Scanner;

public class SWEA_조합 {
	final static long MOD = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long TC = sc.nextLong();
		
		for(long tc = 1 ; tc <= TC ; tc++) {
			long N = sc.nextLong();
			long R = sc.nextLong();
			if(R == 0)
				System.out.println("#" + tc + " " + 1);
			else if(R == 1)
				System.out.println("#" + tc + " " + N);
			else {
				R = N-R > R ? R : N - R;
				long res = ((facto(N,R)%MOD) * pow(facto(R,R), MOD-2)%MOD);
				System.out.println("#" + tc + " " +res);
			}
		}
		sc.close();
	}
	
	static long facto(long n1, long cnt) {
		long ret = n1;
		while(cnt > 1) {
			ret = (ret*(n1-1))%MOD;
			n1--;
			cnt--;
		}
		return ret;
	}
	
	static long pow(long n, long e) {
		if(e==1)
			return n;
		
		if(e%2 == 0) {
			long half = pow(n, e/2);
			return half%MOD*half%MOD;
		}else {
			long half = pow(n, e/2);
			return half%MOD*half%MOD*n%MOD;
		}
	}
}
