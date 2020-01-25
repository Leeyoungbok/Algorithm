package SW_Expert;

import java.util.Scanner;

public class D3_8821 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= TC; tc++) {
			int[] checkNum = new int[10];
			String input = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < input.length(); i++) {
				if (checkNum[Integer.parseInt(input.substring(i, i + 1))] == 0)
					checkNum[Integer.parseInt(input.substring(i, i + 1))] = 1;
				else
					checkNum[Integer.parseInt(input.substring(i, i + 1))] = 1;
			}
			for (int i = 0; i < 10; i++) {
				if (checkNum[i] == 1) {
					System.out.println(i);
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}

}
