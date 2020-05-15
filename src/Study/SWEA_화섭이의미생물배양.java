package Study;

import java.util.Scanner;

public class SWEA_화섭이의미생물배양 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ans = 0;
			System.out.print("#" + tc + " ");
			if(b == 1) {
				if(((t-s) % a) != 0)
					System.out.println(-1);
				else
					System.out.println(((t-s) / a));
			}else {
				while (true) {
					if(t == s) {
						System.out.println(ans);
						break;
					}
					if(s > t) {
						System.out.println(-1);
						break;
					}
					if (t % b == 0) {
						if(t / b >= s)
							t /= b;
						else
							t -= a;
					} else {
						t -= a;
					}
					ans++;
				}
				
			}
		}
	}
}
