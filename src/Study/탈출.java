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
				if (n1 == G) { // queue 에서 나온 수가 G와 같으면 끝
					System.out.println(cnt);
					sc.close();
					return;
				}
				if (n1 + 1 <= 99999 && !used[n1 + 1]) { // max 값 안넘어가고 사용하지 않았으면 넣음
					queue.add(n1 + 1);
					used[n1 + 1] = true;
				}

				if (n1 != 0 && 2 * n1 > 99999) // 0 일경우 , 2배 했을때 max 값 넘어가면 +1 연산만 실행
					continue;

				int n2 = 2 * n1; // 2*n , 맨 앞자리 -1 하는 연산
				int mul = 1;
				while (n2 >= 10) {
					n2 /= 10;
					mul *= 10;
				}
//				System.out.println((2*n1)%mul + " " + (n2-1)*mul);
				int n3 = (2 * n1) % mul + (n2 - 1) * mul;
				if (n3 >= 0 && n3 <= 99999 && !used[n3]) { // 0보다 크고 
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