package SW_Expert;

import java.util.Scanner;

public class D3_8741 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= TC; tc++) {
			String input = sc.nextLine();
			String[] upper = new String[3];
			upper = input.split(" ");
			System.out.println("#" + tc + " " + upper[0].substring(0, 1).toUpperCase()+ upper[1].substring(0, 1).toUpperCase()+ upper[2].substring(0, 1).toUpperCase());
		}
		sc.close();

	}

}
