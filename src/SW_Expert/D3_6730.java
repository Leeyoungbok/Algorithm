package SW_Expert;

import java.util.Scanner;

public class D3_6730 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			int N = sc.nextInt();
			int max = 0;
			int min = 0;
			int x1 = sc.nextInt();
			for(int i = 0 ; i < N-1 ; i ++) {
				int x2 = sc.nextInt();
				if(x2>x1 && max < x2-x1) max = x2-x1;
				else if(x2<x1 && min < x1-x2) min = x1-x2;
				x1 = x2;
			}
			System.out.println("#" + tc + " " + max + " " + min);
		}
		sc.close();
	}

}
