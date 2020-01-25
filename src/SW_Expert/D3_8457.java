package SW_Expert;

import java.util.Scanner;

public class D3_8457 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int E = sc.nextInt();
			int total = 0;
			for (int n = 0; n < N; n++) {
				int n1 = sc.nextInt();
				int cnt = 1;
				while (n1 * cnt <= B + E) {
					if (((n1 * cnt) >= (B - E)) && ((n1 * cnt) <= (B + E))) {
						total++;
						break;
					}
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + total);
		}
		sc.close();
	}
}
