package SW_Expert;

import java.util.Scanner;

public class D3_8104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int cnt = 1;
			boolean check = false;
			int[] score = new int[K+1];
			for (int i = 1; i <= (N * K); i++) {
				score[cnt] += i;
				if(check == false) cnt++;
				else cnt--;
				if(cnt == K+1) {
					cnt--;
					check = true;
				}
				else if(cnt == 0){
					cnt++;
					check = false;
				}
			}
			System.out.print("#" + tc);
			for (int i = 1; i <= K; i++)
				System.out.print(" " + score[i]);
			System.out.println("");
		}
		sc.close();
	}
}
