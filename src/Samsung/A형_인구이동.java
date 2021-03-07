package Samsung;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class nation {
	int x;
	int y;

	nation(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class A형_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] used;
	static boolean[][] checked;
	static boolean isTrue = false;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {
			isTrue = false;
			check();
			if (!isTrue)
				break;
			ans++;
		}
		
		System.out.println(ans);
		sc.close();
	}

	static void check() {
		used = new boolean[N+1][N+1];
		checked = new boolean[N+1][N+1];

		Deque<nation> queue = new LinkedList<nation>();
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(!used[i][j]) {
					int sum = map[i][j];
					int cnt = 1;
					used[i][j] = true;
					checked[i][j] = true;
					queue.add(new nation(i,j));
					while(!queue.isEmpty()) {
						nation n = queue.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int ax = n.x + dx[k];
							int ay = n.y + dy[k];
							if(ax < 1 || ax > N || ay < 1 || ay > N || used[ax][ay]) continue;
							int gap = Math.abs(map[ax][ay] - map[n.x][n.y]);
							if(gap >= L && gap <= R) {
								used[ax][ay] = true;
								checked[ax][ay] = true;
								sum += map[ax][ay];
								cnt++;
								queue.add(new nation(ax,ay));
							}
						}
					}
					if(cnt == 1) {
						checked[i][j] = false;
						continue;
					}
					isTrue = true;
					int avg = sum / cnt;
					for(int ii = 1 ; ii <= N ; ii++) {
						for(int jj = 1 ; jj <= N ; jj++) {
							if(checked[ii][jj]) {
								map[ii][jj] = avg;
								checked[ii][jj] = false;
							}
						}
					}
				}
			}
		}
	}

}
