package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 탈출 {
	static int N, T, G;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		T = sc.nextInt();
		G = sc.nextInt();
		int cnt = 0;
		used = new boolean[100000];
		Deque<Integer> queue = new LinkedList<>();

		queue.add(N);
		used[N] = true;
		while (!queue.isEmpty()) {
			if (cnt == T + 1) {
				break;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int n1 = queue.poll();
				if (n1 == G) { // queue ���� ���� ���� G�� ������ ��
					System.out.println(cnt);
					sc.close();
					return;
				}
				if (n1 + 1 <= 99999 && !used[n1 + 1]) { // max �� �ȳѾ�� ������� �ʾ����� ����
					queue.add(n1 + 1);
					used[n1 + 1] = true;
				}

				if (n1 != 0 && 2 * n1 > 99999) // 0 �ϰ�� , 2�� ������ max �� �Ѿ�� +1 ���길 ����
					continue;

				int n2 = 2 * n1; // 2*n , �� ���ڸ� -1 �ϴ� ����
				int mul = 1;
				while (n2 >= 10) {
					n2 /= 10;
					mul *= 10;
				}
//				System.out.println((2*n1)%mul + " " + (n2-1)*mul);
				int n3 = (2 * n1) % mul + (n2 - 1) * mul;
				if (n3 >= 0 && n3 <= 99999 && !used[n3]) { // 0���� ũ�� 
					queue.add(n3);
					used[n3] = true;
				}
			}
			cnt++;
		}
		System.out.println("ANG");
		sc.close();
	}
}