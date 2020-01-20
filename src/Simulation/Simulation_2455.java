package Simulation;

import java.util.Scanner;

public class Simulation_2455 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int save =0;
		
		int[][] train = new int[4][2];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0 ; j< 2; j++) {
				train[i][j] = sc.nextInt();
			}
		}
		
//		===================================
		
		for(int i = 0 ; i < 4 ; i++) {
			save += train[i][1] - train[i][0];
			max = Math.max(max, save);
		}
		System.out.println(max);
		sc.close();
	}
}
