package Study;

import java.util.ArrayList;
import java.util.Scanner;

public class AÇü_¾ß±¸ {
	static int[][] hit;
	static int[] person = new int[10];
	static int N;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		hit = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				hit[i][j] = sc.nextInt();
			}
		}
		int[] toSort = { 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] sortPerson = new int[toSort.length];
		boolean[] check = new boolean[toSort.length];
		perm(toSort, sortPerson, check, 0);
		System.out.println(ans);
	}

	static void perm(int[] toSort, int[] sortPerson, boolean[] check, int idx) {
		if (idx == toSort.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < toSort.length; i++) {
				if (i == 3)
					list.add(1);
				list.add(sortPerson[i]);
			}
			int score = 0;
			for (int i = 1; i <= N; i++) {
				int outCnt = 0;
				boolean[] round = new boolean[4];
				while (true) {
					int who = list.remove(0);
					int run = hit[i][who];
					if (run == 0) {
						outCnt++;
					} else {
						if (run == 4)
							score++;
						for (int j = 1; j <= 3; j++) {
							if (round[j]) {
								if (j + run > 3) {
									score++;
									round[j] = false;
								} else {
									round[j + run] = true;
									round[j] = false;
								}
							}
							if (j == run)
								round[j] = true;
						}
					}
					list.add(who);
					if (outCnt == 3)
						break;
				}
			}
			if (ans < score)
				ans = score;
			if(ans == 89){
				ArrayList<Integer> list2 = new ArrayList<Integer>();

				for (int i = 0; i < toSort.length; i++) {
					if (i == 3)
						list2.add(1);
					list2.add(sortPerson[i]);
				}
				System.out.println(list2);
			}
			return;
		}

		for (int i = 0; i < toSort.length; i++) {
			if (!check[i]) {
				sortPerson[idx] = toSort[i];
				check[i] = true;
				perm(toSort, sortPerson, check, idx + 1);
				check[i] = false;
			}
		}
	}
}
