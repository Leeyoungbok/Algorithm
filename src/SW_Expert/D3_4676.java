package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class D3_4676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			String s = sc.next();
			int H = sc.nextInt();
			int[] arr = new int[H];
			for (int i = 0; i < H; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int i = H - 1; i >= 0; i--) {
				s = s.substring(0, arr[i]) + "-" + s.substring(arr[i], s.length());
			}
			System.out.println("#" + tc + " " + s);
		}
		sc.close();
	}

}
