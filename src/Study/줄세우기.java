package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 줄세우기 {
	static int N, M, idx = 0;
	static int[] arr, res;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Deque<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		res = new int[N];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			int prev = sc.nextInt();
			int cur = sc.nextInt();
			arr[cur]++;
			list.get(prev).add(cur);
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
			System.out.print(n1 + " ");
		}
		sc.close();

	}

}
