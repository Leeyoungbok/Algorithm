package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class D3_8500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int total = n;
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
				total += arr[j];
			}
			Arrays.sort(arr);
			total += arr[n-1];
			System.out.println("#" + i + " " + total);
		}
		sc.close();
	}

}
