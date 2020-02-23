package BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class bridge {
	int x;
	int y;

	bridge(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_3213 {
	static int N;
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans = 200;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N + 1][N + 1];
		used = new boolean[N + 1][N + 1];
		int groupCnt = 0;
		Deque<bridge> queue = new LinkedList<bridge>();
		ArrayList<bridge> list = new ArrayList<bridge>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (used[i][j] || map[i][j] == 0)
					continue;
				groupCnt++;
				queue.add(new bridge(i, j));
				used[i][j] = true;
				while (!queue.isEmpty()) {
					bridge b = queue.poll();
					map[b.x][b.y] = groupCnt;
					boolean check = false;
					for (int k = 0; k < 4; k++) {
						int ax = b.x + dx[k];
						int ay = b.y + dy[k];
						if (ax < 1 || ax > N || ay < 1 || ay > N || used[ax][ay])
							continue;
						if(map[ax][ay] == 0) {
							check = true;
							continue;
						}
						used[ax][ay] = true;
						queue.add(new bridge(ax, ay));
					}
					if(check) {
						list.add(new bridge(b.x, b.y));
					}
				}
			}
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			used = new boolean[N + 1][N + 1];
			queue.add(list.get(i));
			int group = map[list.get(i).x][list.get(i).y];
			int cnt = 0;
			loop: while(!queue.isEmpty()) {
				if(cnt > ans) {
					queue.clear();
					break;
				}
				int size = queue.size();
				for(int s = 0 ; s < size ; s++) {
					bridge b = queue.poll();
					if(map[b.x][b.y] != 0 && map[b.x][b.y] != group) {
						if(ans > cnt-1)
							ans = cnt-1;
						queue.clear();
						break loop;
					}
					
					for(int k = 0 ; k < 4 ; k++) {
						int ax = b.x + dx[k];
						int ay = b.y + dy[k];
						
						if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
						if(used[ax][ay] || map[ax][ay] == group) continue;
						used[ax][ay] = true;
						queue.add(new bridge(ax, ay));
					}
				}
				cnt++;
			}
			
		}
		System.out.println(ans);
		sc.close();
	}
}
