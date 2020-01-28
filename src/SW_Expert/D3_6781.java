package SW_Expert;

import java.util.Scanner;

public class D3_6781 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			int[] red = new int[9];
			int[] green = new int[9];
			int[] blue = new int[9];
			for (int i = 0; i < 9; i++) {
				if (str2.charAt(i) == 'R')
					red[Integer.parseInt(str1.charAt(i) + "") - 1]++;
				else if (str2.charAt(i) == 'G')
					green[Integer.parseInt(str1.charAt(i) + "") - 1]++;
				else if (str2.charAt(i) == 'B')
					blue[Integer.parseInt(str1.charAt(i) + "") - 1]++;
			}
			int total = 0;
			total += triplet(red) + run(red) + triplet(green) + run(green) + triplet(blue) + run(blue);
			System.out.print("#" + tc + " ");
			if (total >= 3)
				System.out.println("Win");
			else
				System.out.println("Continue");
		}
		sc.close();
	}

	static int triplet(int[] color) {
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if (color[i] > 0 && color[i + 1] > 0 && color[i + 2] > 0) {
				color[i]--;
				color[i + 1]--;
				color[i + 2]--;
				i--;
				cnt++;
			}
		}
		return cnt;
	}

	static int run(int[] color) {
		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			if (color[i] > 2) {
				color[i] -= 3;
				cnt++;
			}
		}
		return cnt;
	}

}
