package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_재관이의대량할인 {
	static class A implements Comparable<A>{
		int a;
		A(int a){
			this.a = a;
		}
		
		@Override
		public int compareTo(A o) {
			return o.a - this.a;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			PriorityQueue<A> queue = new PriorityQueue<>();
			int N = sc.nextInt(), three = 0, ans = 0;

			for (int n = 0; n < N; n++) {
				queue.add(new A(sc.nextInt()));
			}

			while (!queue.isEmpty()) {
				three++;
				A a = queue.poll();
						
				if (three == 3) {
					three = 0;
					continue;
				}
				ans += a.a;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
