package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class friends {
	int i;
	int cnt;

	friends(int i, int cnt) {
		this.i = i;
		this.cnt = cnt;
	}
}

public class BFS_5567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<friends> queue = new LinkedList<friends>();

		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		int[][] friend = new int[N + 1][N + 1];
		boolean[] check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			friend[n1][n2] = friend[n2][n1] = 1;
		}

		queue.add(new friends(1, 0));
		check[1] = true;
		while (!queue.isEmpty()) {
			friends n = queue.poll();
			for (int j = 1; j <= N; j++) {
				if (check[j])
					continue;
				if (friend[n.i][j] == 0)
					continue;
				if (n.cnt + 1 > 2)
					continue;
				check[j] = true;
				ans++;
				queue.add(new friends(j, n.cnt + 1));
			}
		}
		System.out.println(ans);
		sc.close();
	}

}

//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= N ; j++) {
//				System.out.print(friend[i][j] + " ");
//			}
//			System.out.println();
//		}