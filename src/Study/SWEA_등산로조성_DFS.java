package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_등산로조성_DFS {

	static int N, K, Ans;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			Ans = 0;
			map = new int[N + 1][N + 1];
			used = new boolean[N + 1][N + 1];
			int max = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
					max = max < map[i][j] ? map[i][j] : max;
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == max) {
						used[i][j] = true;
						dfs(i, j, max, false, 1);
						used[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + Ans);

		}
	}

	static void dfs(int x, int y, int cur, boolean check, int cnt) {
		boolean end = false;

		for(int k = 0 ; k < 4 ; k++) {
			int ax = x + dx[k];
			int ay = y + dy[k];
			
			if(ax < 1 || ax > N || ay < 1 || ay > N || used[ax][ay]) continue;
			if(check) {
				if(map[ax][ay] < cur && !used[ax][ay]) {
					used[ax][ay] = true;
					end = true;
					dfs(ax, ay, map[ax][ay], true, cnt+1);
					used[ax][ay] = false;
				}
			} else {
				if(map[ax][ay] < cur && !used[ax][ay]) {
					used[ax][ay] = true;
					end = true;
					dfs(ax, ay, map[ax][ay], false, cnt+1);
					used[ax][ay] = false;
				}else if(map[ax][ay] >= cur) {
					for(int i = 1 ; i <= K ; i++) {
						if(map[ax][ay] - i < cur  && !used[ax][ay]) {
							used[ax][ay] = true;
							end = true;
							dfs(ax, ay, map[ax][ay] - i, true, cnt+1);
							used[ax][ay] = false;
						}
					}
				}
			}
		}
		if(!end) {
			Ans = Ans < cnt ? cnt : Ans;
//			if(cnt == 6) {
//				for(int i = 1 ; i <= N ; i++) {
//					for(int j = 1 ; j <= N ; j++) {
//						System.out.print(used[i][j] + " ");
//					}System.out.println();
//				}System.out.println();
//				
//			}
			return;
		}
		
	}
	public static class Mountain {
		int x, y, cur;
		boolean check;

		Mountain(int x, int y, int cur, boolean check) {
			this.x = x;
			this.y = y;
			this.cur = cur;
			this.check = check;
		}
	}
}
