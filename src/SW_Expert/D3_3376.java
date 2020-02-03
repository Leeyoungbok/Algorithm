package SW_Expert;

import java.util.Scanner;

public class D3_3376 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			int n = sc.nextInt();
			long[] p = new long[n];
			if(n <= 3) System.out.println("#" + tc + " " + "1");
			else if(n > 3 && n <= 5) System.out.println("#" + tc + " " + "2");
			else {
				p[0] = 1;
				p[1] = 1;
				p[2] = 1;
				p[3] = 2;
				p[4] = 2;
				for(int i = 5 ; i < n ; i++) {
					p[i] = p[i-5] + p[i-1];
				}
				System.out.println("#" + tc + " " + p[n-1]);
			}
			
		}
		sc.close();
	}
}
