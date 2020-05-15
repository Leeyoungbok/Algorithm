package Study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_성수의프로그래밍강좌시청 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			double res = 0;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			for (int i = N - K; i < N; i++) {
				res = (res+arr[i])/2;
			}
			
			System.out.printf("#%d %.6f\n", tc, res);
		}
	}

}
