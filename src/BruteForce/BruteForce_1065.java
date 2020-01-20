package BruteForce;

import java.util.Scanner;

public class BruteForce_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int res = 0;

		if (n < 100)
			res = n;
		else {
			int n2, d, nmg1, nmg2;
			res = 99;
			while (100 <= n) {
				n2 = n;
				while (true) {
					if (n2 < 100) {
						res++;
						break;
					}
					nmg1 = n2 % 10;
					n2 = n2 / 10;
					nmg2 = n2 % 10;
					d = nmg1 - nmg2;
					if (d - (nmg2 % 10 - (n2 / 10) % 10) != 0)
						break;
				}
				n--;
			}
		}
		System.out.println(res);
		sc.close();
	}

}
