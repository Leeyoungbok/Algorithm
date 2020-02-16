package BruteForce;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class house {
	int x;
	int y;

	house(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class chicken{
	int x;
	int y;
	
	chicken(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class BruteForce_15686 {
	static int N;
	static int M;
	static int[][] map;
	static int ans = -1;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static LinkedList<chicken> list = new LinkedList<chicken>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					list.add(new chicken(i,j));
			}
		}
		solve(0, list.size());
		System.out.println(ans);
		sc.close();
	}

	static void solve(int n, int idx) {
		if (idx == M) {
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int n1  = bfs();
//			System.out.println(n1);
			if(ans == -1 || ans > n1)
				ans = n1;
			return;
		} else if (n == list.size())
			return;
		
		map[list.get(n).x][list.get(n).y] = 0;
		solve(n+1, idx-1);
		map[list.get(n).x][list.get(n).y] = 2;
		solve(n+1, idx);
	}

	static int bfs() {
		int dist = 0;
		Deque<house> queue = new LinkedList<house>();
		boolean[][] check;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					queue.add(new house(i, j));
					check = new boolean[N + 1][N + 1];
					loop: while (!queue.isEmpty()) {
						house h = queue.poll();
						for (int l = 0; l < 4; l++) {
							int ax = h.x + dx[l];
							int ay = h.y + dy[l];
							if (ax < 1 || ax > N || ay < 1 || ay > N || check[ax][ay])
								continue;
							if (map[ax][ay] == 2) {
//								System.out.println(i + " " + j + " " + ax + " " + ay);
								dist += Math.abs(i - ax) + Math.abs(j - ay);
								queue.clear();
								break loop;
							}
							queue.add(new house(ax, ay));
							check[ax][ay] = true;
						}
					}

				}
			}
		}
		return dist;
	}
}
