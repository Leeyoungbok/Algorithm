package SW_Expert;

import java.util.Scanner;

public class D2_2019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int multi = 1;
		System.out.print(multi + " ");
		for (int i = 0; i < input; i++) {
			multi *= 2;
			System.out.print(multi + " ");
		}
		
		sc.close();
	}
}
