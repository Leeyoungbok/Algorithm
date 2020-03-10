package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class color {
	int x;
	int y;

	color(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_10026 {
	static int N;
	static char[][] map;
	static boolean[][][] used;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		Deque<color> queue = new LinkedList<color>();
		map = new char[N + 1][N + 1];
		used = new boolean[N+1][N+1][2];
		

		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!used[i][j][0]) {
					char ch = map[i][j];
					cnt++;
					queue.add(new color(i, j));
					used[i][j][0] = true;
					while(!queue.isEmpty()) {
						color c = queue.poll();
						
						for(int k = 0 ; k < 4 ; k++) {
							int ax = c.x + dx[k];
							int ay = c.y + dy[k];
							
							if(ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] != ch || used[ax][ay][0]) continue;
							queue.add(new color(ax,ay));
							used[ax][ay][0] = true;
						}
					}
				}
				if (!used[i][j][1]) {
					char ch = map[i][j];
					cnt2++;
					queue.add(new color(i, j));
					used[i][j][1] = true;
					while(!queue.isEmpty()) {
						color c = queue.poll();
						
						for(int k = 0 ; k < 4 ; k++) {
							int ax = c.x + dx[k];
							int ay = c.y + dy[k];
							
							if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
							if(((ch == 'R' || ch == 'G') && map[ax][ay] == 'B') || used[ax][ay][1]) continue;
							if(ch == 'B' && (map[ax][ay] == 'R' || map[ax][ay] == 'G')) continue;
							queue.add(new color(ax,ay));
							used[ax][ay][1] = true;
						}
					}
				}
					
			}
		}
		System.out.println(cnt + " " + cnt2);
		sc.close();
	}
}
