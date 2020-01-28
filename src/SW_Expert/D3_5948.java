package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class D3_5948 {
	static int[] max = new int[35];
	static int i = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int[] arr = new int[7];
			int[] result = new int[3];

			for (int i = 0; i < 7; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);

			comb(0, 6, arr, result);
			Arrays.sort(max);
			int cnt = 1;
			int max2 = max[34];
			for (int i = 33; i >= 0; i--) {
				if (cnt == 5) {
					cnt = i+1;
					break;
				}
				if (max[i] != max2) {
					max2 = max[i];
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + max[cnt]);
			i = 0;
		}
		sc.close();
	}

	static void comb(int cnt, int idx, int[] arr, int[] result) {
		if (cnt == result.length) {
			int sum = 0;
			for (int i = 0; i < 3; i++)
				sum += result[i];
			max[i++] = sum;
			return;
		} else if (idx == -1)
			return;

		result[cnt] = arr[idx];
		comb(cnt + 1, idx - 1, arr, result);
		comb(cnt, idx - 1, arr, result);
	}

}
