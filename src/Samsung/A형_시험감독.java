package Samsung;

import java.util.Scanner;

public class A형_시험감독 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		�� N���� �������� �ְ�, ������ �����帶�� �����ڵ��� �ִ�. i�� �����忡 �ִ� �������� ���� Ai���̴�.
//
//		�������� �Ѱ������� �ΰ��������� �� ������ �ִ�. �Ѱ������� �� �濡�� ������ �� �ִ� �������� ���� B���̰�, �ΰ������� �� �濡�� ������ �� �ִ� �������� ���� C���̴�.
//
//		������ �����忡 �Ѱ������� ���� 1�� �־�� �ϰ�, �ΰ������� ���� �� �־ �ȴ�.
//
//		�� �����帶�� ���û����� ��� �����ؾ� �Ѵ�. �̶�, �ʿ��� ������ ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

//		ù° �ٿ� �������� ���� N(1 �� N �� 1,000,000)�� �־�����.
//
//		��° �ٿ��� �� �����忡 �ִ� �������� �� Ai (1 �� Ai �� 1,000,000)�� �־�����.
//
//		��° �ٿ��� B�� C�� �־�����. (1 �� B, C �� 1,000,000)

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
