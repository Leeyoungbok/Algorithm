package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class snow {
	int x;
	int y;
	int size;
	int cnt;

	snow(int x, int y, int size, int cnt) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.cnt = cnt;
	}
}

public class 빙산 {
	static int N, M, ans = 0;
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		ArrayList<snow> list = new ArrayList<>();
		Deque<snow> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0)
					list.add(new snow(i, j, map[i][j], 0));
			}
		}

		while (true) {
			int size = list.size();
			
			if(size == 0) {
				break;
			}
			
			used = new boolean[N+1][M+1];
			int groupCnt = 0;
			
			for(int i = 0 ; i < size ; i++) {
				if(!used[list.get(i).x][list.get(i).y]) {
					groupCnt++;
					if(groupCnt == 2) {
						System.out.println(ans);
						return;
					}
					queue.add(list.get(i));
					used[list.get(i).x][list.get(i).y] = true;
					while(!queue.isEmpty()) {
						snow s = queue.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int ax = s.x + dx[k];
							int ay = s.y + dy[k];
							if(ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] == 0) continue;
							queue.add(new snow(ax,ay,1,1));
							used[ax][ay] = true;
						}
					}
				}
			}
			
			for (int i = 0; i < size; i++) {
				int cnt = 0;
				snow s = list.get(i);
				for (int k = 0; k < 4; k++) {
					int ax = s.x + dx[k];
					int ay = s.y + dy[k];
					if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] != 0)
						continue;
					cnt++;
					list.get(i).cnt = cnt;
				}
			}

			for (int i = 0; i < size; i++) {
				snow s = list.get(i);
				if (s.size - s.cnt > 0) {
					map[s.x][s.y] = s.size - s.cnt;
					list.get(i).size = s.size - s.cnt;
				} else {
					map[s.x][s.y] = 0;
					list.remove(i);
					size--;
					i--;
				}
			}
			
			ans++;
		}
		System.out.println(0);
		sc.close();
	}

}
//bfs �ȵ����� �ݷʰ� �־��