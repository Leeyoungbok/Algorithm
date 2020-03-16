package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class __¹ÂÅ»¸®½ºÅ© {

	static int N, ans = 61;
	static int[] arr;
	static int[] res;
	static ArrayList<int[]> list = new ArrayList<>();
	static boolean[] used;
	static int[][][][] dp = new int[61][61][61][61];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[3];
		res = new int[3];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i <= 60; i++) {
			for (int j = 0; j <= 60; j++) {
				for (int k = 0; k <= 60; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		findSet(0);
		solve(arr[0], arr[1], arr[2], 0);
		System.out.println(ans);
		sc.close();
	}

	static void findSet(int idx) {
		if (idx == N) {
			int[] copyArr = res.clone();
			list.add(copyArr);
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				res[idx] = i;
				used[i] = true;
				findSet(idx + 1);
				used[i] = false;
			}
		}
	}

	static int solve(int a, int b, int c, int cnt) {
		a = a < 0 ? 0 : a;
		b = b < 0 ? 0 : b;
		c = c < 0 ? 0 : c;
		//		System.out.println(n1 + " " + n2 + " " + n3 + " " + cnt);

		if (cnt >= ans) {
			dp[a][b][c][cnt] = 0;
			return 0;
		}

		if (a == 0 && b == 0 && c== 0) {
			ans = cnt;
			dp[a][b][c][cnt] = 1;
			return 1;
		}
		
		if(dp[a][b][c][cnt] != -1) {
			return dp[a][b][c][cnt];
		}

		for (int i = 0; i < list.size(); i++) {
			int attack = 9;
			int n1 = a, n2 = b, n3 = c;
			for (int j = 0; j < N; j++) {
				if (list.get(i)[j] == 0)
					n1 -= attack;
				else if (list.get(i)[j] == 1)
					n2 -= attack;
				else
					n3 -= attack;
				attack /= 3;
			}
			if(solve(n1, n2, n3, cnt + 1) == 1) {
				dp[a][b][c][cnt] = 1;
			}
		}
		
		dp[a][b][c][cnt] = 0;
		return 0;
	}
}
