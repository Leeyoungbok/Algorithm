package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();

		int N = sc.nextInt(); // Á¤Á¡ÀÇ °¹¼ö
		int M = sc.nextInt(); // °£¼±ÀÇ°¹¼ö
		int ans = 0;
		int[][] graph = new int[N + 1][N + 1];
		boolean[] check = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			graph[n1][n2] = graph[n2][n1] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			queue.add(i);
			ans++;
			check[i] = true;
			while (!queue.isEmpty()) {
				int n1 = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (graph[n1][j] == 1 && !check[j]) {
						queue.add(j);
						check[j] = true;
					}
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
