package Greedy;

import java.util.Scanner;

public class Greedy_11047 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int res = sc.nextInt();
		int ans = 0;
//		System.out.println("cnt ="+ cnt + "res ="+ res);
		int[] money = new int[cnt];
		for(int i = 0 ; i < cnt ; i++) {
			money[i] = sc.nextInt();
		}
//		System.out.println(money);
		for(int i = cnt-1 ; i >= 0 ; i--) {
			if(res/money[i] >= 1) {
				ans += res/money[i];

				res = res - money[i]*(res/money[i]);
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
