package Study;
//����. arraylist�� ����


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		boolean[] check = new boolean[N + 1];
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		queue.add(V);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			if (check[v])
				continue;
			check[v] = true;
			System.out.println(v);
			for (int i = 1; i <= N; i++) {
				if (arr[v][i] == 1) {
					queue.add(i);
				}
			}
		}
		sc.close();
	}
}
