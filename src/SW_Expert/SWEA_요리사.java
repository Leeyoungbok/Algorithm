package SW_Expert;

import java.util.Scanner;

public class SWEA_요리사 {
	static int N, ans;
	static int[][] map;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			solve(0, 0);
			System.out.println("#" + tc + " " + ans);
			sc.close();
		}
	}

	static void solve(int idx, int n) {
		if(idx > 0 && !check[0])
			return;
		
		if(n == N/2) {
			int trueSum = 0;
			int falseSum = 0;
			for(int i = 0 ; i < N - 1 ; i++) {
				for(int j = i+1 ; j < N ; j++) {
					if(check[i] == check[j]) {
						if(check[i])
							trueSum += map[i][j] + map[j][i];
						if(!check[i])
							falseSum += map[i][j] + map[j][i];
					}
					
				}
			}
			int sum = Math.abs(trueSum - falseSum);
			ans = ans > sum ? sum : ans;
			return;
		}
		
		for(int i = idx ; i < N ; i++) {
			check[i] = true;
			solve(i+1, n+1);
			check[i] = false;
		}
	}
}
