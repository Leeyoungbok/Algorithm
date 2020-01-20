package DP;

import java.util.Scanner;

public class DP_1149 {
	static int solution(int[][] arr, int n) {
		int ret = 0;
		int[][] save = new int[n][3];
		for (int i = 0; i < 3; i++) {
			save[0][i] = arr[0][i];
			
		}
		for(int i = 1; i < n ; i ++) {
			save[i][0] = Math.min(save[i-1][1], save[i-1][2])+arr[i][0];
			save[i][1] = Math.min(save[i-1][0], save[i-1][2])+arr[i][1];
			save[i][2] = Math.min(save[i-1][0], save[i-1][1])+arr[i][2];
		}
		ret = Math.min(Math.min(save[n-1][0] ,save[n-1][1]),save[n-1][2]);

		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				input[i][j] = sc.nextInt();
			}
		}

//		=======================================
		System.out.println(DP.DP_1149.solution(input, n));
		sc.close();
	}

}
