package Study;

import java.util.Scanner;

public class A형_시험감독 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.
//
//		감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 방에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 방에서 감시할 수 있는 응시자의 수가 C명이다.
//
//		각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
//
//		각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.

//		첫째 줄에 시험장의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
//
//		둘째 줄에는 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)가 주어진다.
//
//		셋째 줄에는 B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)

		int N = sc.nextInt();

		int[] room = new int[N];

		for (int i = 0; i < N; i++) {
			room[i] = sc.nextInt();
		}

		int B = sc.nextInt();
		int C = sc.nextInt();

		long ans = 0 ;
		for (int i = 0; i < N; i++) {
			room[i] -= B;
			ans++;
			if(room[i] <= 0) continue;
			ans += (room[i] / C) + 1;
			if (room[i] % C == 0)
				ans--;
		}
		System.out.println(ans);
		sc.close();
	}

}
