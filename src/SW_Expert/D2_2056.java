package SW_Expert;

import java.util.Scanner;

public class D2_2056 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			String input = sc.next();
			String output = "";
			int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			if (days[Integer.parseInt(input.substring(4, 6))] >= Integer.parseInt(input.substring(6, 8))) {
				output = input.substring(0, 4) + "/" + input.substring(4, 6) + "/" + input.substring(6, 8);
				System.out.println("#" + tc + " " + output);
			} else {
				System.out.println("#" + tc + " -1");
			}
		}
		sc.close();
	}

}
