/*
 * 1 = 1 -> 1가지
 * 2 = 1+1
 *     2 -> 2가지
 * 3 = 1+1+1
 * 	   1+2
 *     2+1
 *     3 -> 4가지
 * 4 = 1+1+1+1
 *     1+1+2
 *     1+2+1
 *     2+1+1
 *     2+2
 *     1+3
 *     3+1 -> 7가지
 *   점화식 : F(N) = F(N-1)+F(N-2)+F(N-3)
 */

package DP;

import java.util.Scanner;

public class DP_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[11];
		f[0] = 1;
		f[1] = 2;
		f[2] = 4;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			for(int j = 3; j < input; j++) {
				f[j] = f[j-1] + f[j-2] + f[j-3];
			}
			System.out.println(f[input-1]);
		}
		sc.close();
	}

}
