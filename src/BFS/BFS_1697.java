package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1697 {

	static int MAX = 1000001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] visited = new int[MAX];
		int n = sc.nextInt(), k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(n);
		while (!queue.isEmpty()) {
			int visit = queue.poll();
			if (visit == k)
				break;

//			1. visit -1
			if (visit-1 >= 0 && visited[visit-1] == 0) {
				queue.add(visit - 1);
				visited[visit - 1] = visited[visit] +1;
			}
//			2. visit +1
			if (visit+1 < 100001 && visited[visit+1] == 0) {
				queue.add(visit + 1);
				visited[visit + 1] = visited[visit] +1;
			}
//			3. visit *2
			if (visit*2 < 100001 && visited[visit*2] == 0) {
				queue.add(visit * 2);
				visited[visit * 2] = visited[visit] +1;
			}
		}
		System.out.println(visited[k]);
		sc.close();
	}
}
