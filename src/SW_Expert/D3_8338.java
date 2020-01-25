package SW_Expert;

import java.util.Scanner;

public class D3_8338 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int total = sc.nextInt();
			for (int n = 0; n < N-1; n++) {
				int k = sc.nextInt();
				total = Math.max(total + k, total * k);
			}
			System.out.println("#" + tc + " " + total);
		}
		sc.close();
	}

}
