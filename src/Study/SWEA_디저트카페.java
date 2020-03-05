package Study;

import java.util.Scanner;

public class SWEA_디저트카페 {
	static int N, ans;
	static int startX, startY;
	static int[][] map;
	static boolean[] used;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			used = new boolean[101];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					startX = i;
					startY = j;
					used[map[i][j]] = true;
					solve(startX, startY, 1, 0);
					used[map[i][j]] = false;
				}
			}
			System.out.print("#" + tc + " ");
			if(ans == 0)
				System.out.println(-1);
			else
				System.out.println(ans);
			sc.close();
		}
	}

	static void solve(int x, int y, int cnt, int dir) {
		if (dir == 2 && cnt <= ans / 2) {
			return;
		}
		
		int ax = x + dx[dir];
		int ay = y + dy[dir];
		
		if (ax < 0 || ax > N-1 || ay < 0 || ay > N-1)
			return;

		if (ax == startX && ay == startY) {
//			System.out.println(cnt);
			ans = ans < cnt ? cnt : ans;
			return;
		}
		
		if(used[map[ax][ay]])
			return;
		
		used[map[ax][ay]] = true;
		solve(ax, ay, cnt+1, dir);
		if(dir < 3)
			solve(ax,ay,cnt+1,dir+1);
		used[map[ax][ay]] = false;

	}
}
