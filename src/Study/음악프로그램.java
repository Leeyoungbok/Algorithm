package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 음악프로그램 {
	static int N, M, idx;
	static int[] arr, res;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Deque<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		idx = 0;
		arr = new int[N + 1];
		res = new int[N];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			if (n1 == 0)
				break;
			int prev = sc.nextInt();
			for (int j = 0; j < n1-1; j++) {
				int cur = sc.nextInt();
				arr[cur]++;
				list.get(prev).add(cur);
				prev = cur;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				queue.add(i);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (queue.isEmpty()) {
				System.out.println(0);
				System.exit(0);
			}

			res[idx] = queue.poll();

			for (int n1 : list.get(res[idx])) {
				if(--arr[n1] == 0)
					queue.add(n1);
			}
			
			idx++;
		}
		
		for(int n1 : res) {
			System.out.println(n1);
		}
		sc.close();
	}

}
