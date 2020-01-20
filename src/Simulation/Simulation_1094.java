package Simulation;

import java.util.Scanner;

public class Simulation_1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int stick = 64, cnt = 0;
		while (input > 0) {
			if(stick > input) {
				stick /=2 ;
			} else {
				cnt++;
				input -= stick;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
