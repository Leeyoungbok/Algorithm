package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] weight = new int[N];
		int ret = 0;
		int a = 0;
		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
		}
		Arrays.sort(weight);
        ret = weight[0];
		for (int i = 0; i < N-1; i++) {
			int comp = 0;
			a = weight[i] * (N - i);

			comp = weight[i + 1] * (N - i - 1);
			if (a > comp && a > ret) {
				ret = a;
			} else if (a < comp && comp > ret) {
				ret = comp;
			}
		}
		System.out.println(ret);
		sc.close();
	}
}
