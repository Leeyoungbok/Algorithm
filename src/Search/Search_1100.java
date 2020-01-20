package Search;

import java.util.Scanner;

public class Search_1100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] chess = new char[8][8];
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				chess[i][j] = input.charAt(j);
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
					if (chess[i][j] == 'F')
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
