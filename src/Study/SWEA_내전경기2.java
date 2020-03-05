package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_내전경기2 {
	static int K;
	static int[] used;
	static boolean[][] map;
	static ArrayList<String> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			Deque<Integer> queue = new LinkedList<>();
			list = new ArrayList<>();
			K = sc.nextInt();
			map = new boolean[2 * K][2 * K];
			used = new int[2 * K];
			for (int i = 0; i < K; i++) {
				String str01 = sc.next();
				String str02 = sc.next();
				if (list.size() == 0) {
					list.add(str01);
					list.add(str02);
				} else {
					boolean str01Check = false;
					boolean str02Check = false;
					for (int s = 0; s < list.size(); s++) {
						if (list.get(s).equals(str01))
							str01Check = true;
						if (list.get(s).equals(str02))
							str02Check = true;
					}
					if (!str01Check)
						list.add(str01);
					if (!str02Check)
						list.add(str02);
				}

				int idx01 = list.indexOf(str01);
				int idx02 = list.indexOf(str02);
				map[idx01][idx02] = map[idx02][idx01] = true;
			}
			boolean check = false;
			loop: for (int i = 0; i < list.size(); i++) {
				if (used[i] == 0) {
					queue.add(i);
					used[i] = 1;
					while (!queue.isEmpty()) {
						int n1 = queue.poll();

						for (int j = 0; j < list.size(); j++) {
							if(n1==j) continue;
							if (used[j] == 0) {
								if(map[n1][j] == true) {
									used[j] = used[n1] * -1;
									queue.add(j);
								}
							}

							else if(map[n1][j] == true && used[n1] == used[j]) {
								if (used[n1] == used[j]) {
									check = true;
									break loop;
								}
							}
						}
					}
				}
			}
			if (check)
				System.out.println("#" + tc + " No");
			else
				System.out.println("#" + tc + " Yes");
			sc.close();
		}
	}
}
