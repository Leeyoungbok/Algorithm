package Search;

import java.util.Arrays;
import java.util.Scanner;

public class Search_1920 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int input = sc.nextInt();
			System.out.println(findNum(input));
		}
		sc.close();
	}

	static int findNum(int input) {
		int mid;
		int start = 0;
		int end = arr.length - 1;
		while (end >= start) {
			mid = (start + end) / 2;
			if (arr[mid] == input) {
				return 1;
			} else if (arr[mid] > input)
				end = mid - 1;
			else if (arr[mid] < input)
				start = mid + 1;
		}
		return 0;
	}
}
