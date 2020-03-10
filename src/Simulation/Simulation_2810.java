package Simulation;

import java.util.Scanner;

public class Simulation_2810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;

		String str = sc.next();
		if (str.length() == 1)
			System.out.println(1);
		else {
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);
				if (ch == 'L') {
					cnt++;
				}
			}
			
			if(str.length() < str.length() - (cnt/2) + 1)
				System.out.println(str.length());
			else
				System.out.println(str.length() - (cnt/2) + 1);
		}
		sc.close();
		
	}

}
