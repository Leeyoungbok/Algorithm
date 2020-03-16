package Study;

import java.util.ArrayList;
import java.util.Scanner;

public class __서울지하철2호선 {
	static int N;
	static boolean[] used;
	static boolean[] cycle;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		used = new boolean[N + 1];
		cycle = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}
		used[1] = true;
		cycle[1] = true;
		dfs(1);

	}

	static void dfs(int idx) {
		System.out.println(idx);

		for (int i : list.get(idx)) {
			if (!used[i]) {
				used[i] = true;
				dfs(i);
			}
		}
	}
}
