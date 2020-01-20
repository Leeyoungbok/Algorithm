package String;

import java.util.Scanner;

public class String_1152 {

	public static void solve(String s) {
		int ret = 1;
		char check = ' ';
		s = s.trim();
		if (s.length() == 0)
			System.out.println("0");
		else {
			for (int i = 0; i < s.length(); i++) {
				if (check == s.charAt(i))
					ret++;
			}
			System.out.println(ret);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String_1152.solve(input);
		sc.close();
	}

}
