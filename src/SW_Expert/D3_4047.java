package SW_Expert;

import java.util.Scanner;

public class D3_4047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int[] s = new int[13];
			int[] d = new int[13];
			int[] h = new int[13];
			int[] c = new int[13];
			boolean check = false;
			int[] cnt = { 13, 13, 13, 13 };
			String str = sc.nextLine();
			for (int i = 0; i < str.length() -2; i+=3) {
				int n = Integer.parseInt(str.substring(i+1, i+3));
				if (str.charAt(i) == 'S') {
					s[n - 1]++;
				} else if (str.charAt(i) == 'D') {
					d[n - 1]++;
				} else if (str.charAt(i) == 'H') {
					h[n - 1]++;
				} else if (str.charAt(i) == 'C') {
					c[n - 1]++;
				}
			}
			for (int i = 0; i < 13; i++) {
				if (s[i] > 1) {
					check = true;
					break;
				} else {
					cnt[0] -= s[i];
				}
				if (d[i] > 1) {
					check = true;
					break;
				} else {
					cnt[1] -= d[i];
				}
				if (h[i] > 1) {
					check = true;
					break;
				} else {
					cnt[2] -= h[i];
				}
				if (c[i] > 1) {
					check = true;
					break;
				} else {
					cnt[3] -= c[i];
				}
			}
			if (check)
				System.out.println("ERROR");
			else
				System.out.println("#" + tc + " " + cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3]);

		}
		sc.close();
	}
}
