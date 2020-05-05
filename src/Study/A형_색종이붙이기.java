package Study;

import java.util.Scanner;

public class A형_색종이붙이기 {
	static int ret = 26;
	static int nmg = 0;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int[][] map = new int[10][10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					nmg++;
			}
		}
		solve(0, nmg, 0);
		ret = ret == 26 ? -1 : ret;
		System.out.println(ret);
	}

	static void solve(int start, int nmg, int cnt) {
//		print();
		if (cnt > ret)
			return;
		if (start == 100) {
			ret = ret > cnt ? cnt : ret;
			return;
		}

		int i = start / 10;
		int j = start % 10;
		if (map[i][j] == 1) {
			for (int k = 5; k > 0; k--) {
				if (paper[k] > 0) {
					if (plus(i, j, k)) {
						paper[k]--;
						solve(start + 1, nmg - k * k, cnt + 1);
						paper[k]++;
						minus(i, j, k);
					}
				}
			}
		} else {
			solve(start + 1, nmg, cnt);
		}
	}

	static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean plus(int x, int y, int size) {
		if (10 - x - size < 0 || 10 - y - size < 0)
			return false;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 0;
			}
		}
		return true;
	}

	static void minus(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = 1;
			}
		}
	}
}
