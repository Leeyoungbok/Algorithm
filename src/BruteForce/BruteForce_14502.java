package BruteForce;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class virus {
	int x;
	int y;

	virus(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BruteForce_14502 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		copy = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		System.out.println("원래 맵 입니다.");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		solve(3);
		System.out.println(ans);
		sc.close();
	}

	static void solve(int cnt) {
		if(cnt ==0) {
			bfs();
//			System.out.println("virus가 퍼져나갔습니다.");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(copy[i][j] + " ");
//				}
//				System.out.println();
//			}
			int max = countZero(copy);
			ans = ans < max ? max : ans;
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j= 1 ; j <= M ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					solve(cnt-1);
					map[i][j] = 0;
				}
			}
		}
	}
	static int countZero(int[][] map) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	static void bfs() {
		copyMap();
		Deque<virus> queue = new LinkedList<virus>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (copy[i][j] == 2)
					queue.add(new virus(i, j));
			}
		}
		while (!queue.isEmpty()) {
			virus v = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ax = v.x + dx[i];
				int ay = v.y + dy[i];

				if (ax < 1 || ax > N || ay < 1 || ay > M)
					continue;
				if (copy[ax][ay] == 1 || copy[ax][ay] == 2)
					continue;
				copy[ax][ay] = 2;
				queue.add(new virus(ax, ay));
			}
		}
	}
	static void copyMap() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}
