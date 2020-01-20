package String;

import java.util.Scanner;

public class String_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		int[] ret = new int[26];
		for (int i = 0; i < ret.length; i++)
			ret[i] = -1;
//		======================================================입력
		// 'a' - 97 = 0
		for (int i = 0; i < input.length(); i++) {
			if (ret[(int) input.charAt(i) - 97] == -1)
				ret[(int) input.charAt(i) - 97] = i;
		}
//		======================================================출력
		for (int i = 0; i < ret.length; i++)
			System.out.print(ret[i] + " ");
		sc.close();
	}
}
