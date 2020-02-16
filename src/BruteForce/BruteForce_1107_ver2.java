package BruteForce;

import java.util.Scanner;

public class BruteForce_1107_ver2 {

	static boolean[] arr = new boolean[10];

	public static int canMove(int channel) {
		int length = 0;

		if (channel == 0) {
			return arr[0] ? 0 : 1;
		}

		while (channel > 0) {
			if (arr[channel % 10]) {
				return 0;
			}
			length += 1;
			channel /= 10;
		}
		return length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			arr[sc.nextInt()] = true; // ��ư�� ������ ������ true, �ƴϸ� false
		}

		/** 100���� n���� ���� ��ư�� ������ �ʰ�, +�� -���� ������ �̵��ϴ� �ڵ� */
		int answer = N - 100; // n >= 100
		if (answer < 0) {
			answer = -answer; // n < 100
		}

		/** �̵��� ä�� c�� ������ ����, �����ϸ�, ��ư�� �� ��� ������ �ϴ��� */
		for (int i = 0; i <= 1000000; i++) { // ���� ��ư���� �̵��ϴ� ä��
			int c = i;
			int length = canMove(c); // ���̸� ���.
			if (length > 0) {
				int press = c - N; // +�� -�� �� �� ������ �ϴ��� ���
				if (press < 0) {
					press = -press; // +�� ������ ���
				}
				if (answer > length + press) {
					answer = length + press;
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
