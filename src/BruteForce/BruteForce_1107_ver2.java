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
			arr[sc.nextInt()] = true; // 버튼이 망가져 있으면 true, 아니면 false
		}

		/** 100에서 n까지 숫자 버튼을 누르지 않고, +와 -만을 눌러서 이동하는 코드 */
		int answer = N - 100; // n >= 100
		if (answer < 0) {
			answer = -answer; // n < 100
		}

		/** 이동할 채널 c를 결정한 다음, 가능하면, 버튼을 총 몇번 눌러야 하는지 */
		for (int i = 0; i <= 1000000; i++) { // 숫자 버튼으로 이동하는 채널
			int c = i;
			int length = canMove(c); // 길이를 잰다.
			if (length > 0) {
				int press = c - N; // +나 -를 몇 번 눌러야 하는지 계산
				if (press < 0) {
					press = -press; // +를 누르는 경우
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
