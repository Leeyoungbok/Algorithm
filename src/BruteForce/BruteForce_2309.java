package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_2309 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] nje = new int[9];
		int total = 0, i = 0, j = 0;

		for (i = 0; i < 9; i++) {
			nje[i] = sc.nextInt();
			total += nje[i];
		}

		Arrays.sort(nje);

//		for(int i =0 ; i < 9 ; i++) System.out.println(nje[i]);
		loop:
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				if (total - nje[i] - nje[j] == 100)
					{
						break loop;
					}
			}
		}
//		System.out.println(i + " " + j);
		for (int k = 0; k < 9; k++) {
			if (k == i || k == j) continue;
			System.out.println(nje[k]);
		}
		sc.close();
	}
}
