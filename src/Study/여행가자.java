package Study;

import java.util.Scanner;

public class 여행가자 {
	static int N;
	static int M;
	static int[][] map;
	static int[] order, joint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][N + 1];
		order = new int[M];
		joint = new int[N + 1];

		init();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int n1 = sc.nextInt();
				map[i][j] = n1;
				if (i < j && n1 == 1) {
//					System.out.println(i + " " + j);
					union(i, j);
				}
			}
		}
//		System.out.println(Arrays.toString(joint));

		for (int i = 0; i < M; i++) {
			order[i] = sc.nextInt();
			if (i > 0 && find(order[i - 1]) != find(order[i])) {
				System.out.println("NO");
				sc.close();
				return;
			}
		}
		System.out.println("YES");
		sc.close();

	}

	static void init() {
		for (int i = 0; i <= N; i++) {
			joint[i] = i;
		}
	}

	static int find(int n1) {
		if (joint[n1] == n1)
			return n1;

		return joint[n1] = find(joint[n1]);
	}

	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2)
			joint[p1] = p2;
		else
			joint[p2] = p1;
	}
}
