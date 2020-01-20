package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n + 1];
		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		sc.close();
		
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int visit = queue.poll();
			System.out.print(visit + " ");
			for (int i = 1; i <= n; i++) {
				if (map[visit][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

}
