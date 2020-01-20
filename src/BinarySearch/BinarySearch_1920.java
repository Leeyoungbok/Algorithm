package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_1920 {

	public static void solve(int[] input, int key) {
		Arrays.sort(input);
		int start = 0, end = input.length - 1, mid = end / 2;

		while (true) {
			
			
			if (start > end) {
				System.out.println("0");
				break;
			}if (key == input[mid]) {
				System.out.println("1");
				break;
			}
			 else if (key < input[mid])
				end = mid - 1;
			else
				start = mid + 1;

			mid = (start + end) / 2;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int key = sc.nextInt();
			BinarySearch_1920.solve(input, key);
		}
		sc.close();
	}
}
