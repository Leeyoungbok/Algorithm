package Study;

import java.util.Scanner;

public class SWEA_의석이의우뚝선산 {
	static int N, ans;
	static long[] h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			h = new long[N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				h[i] = sc.nextLong();
			}

			int upCnt = 0;
			int downCnt = 0;
			for (int i = 1; i < N; i++) {
				if(h[i-1] < h[i]) {
					if(downCnt != 0){
						ans += upCnt * downCnt;
						upCnt = 0;
						downCnt = 0;
					}
					upCnt++;
				}
				else {
					downCnt++;
				}
			}
			if(upCnt != 0 && downCnt != 0)
				ans += upCnt * downCnt;
			System.out.println("#" + tc + " " + ans);
			sc.close();
		}
	}
}