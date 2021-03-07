package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A형_로봇청소기 {
	// dir = 0 - �� / 1 - �� / 2 - �� / 3 - ��
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] check;
	static int N;
	static int M;
	static int x;
	static int y;
	static int dir;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken()) + 1;
		y = Integer.parseInt(st.nextToken()) + 1;
		dir = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		loop: while(true) {
			cnt = 0;
			if(!check[x][y]) {    // 1�� ����
				check[x][y] = true;
				ans++;
			}
			while(!isDir()) {
				cnt++;
				if(cnt == 4) {
					if(!isExit()) {
						break loop;
					} else
						break;
				}
			}
		}
		System.out.println(ans);
	}

	static boolean isDir() {
		if (dir == 0)
			dir = 3;
		else
			dir--;
		int ax = x + dx[dir];
		int ay = y + dy[dir];

		if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 1 || check[ax][ay])
			return false;
		x = ax;
		y = ay;

		return true;
	}

	static boolean isExit() {
		int dir2;
		if (dir == 0)
			dir2 = 2;
		else if (dir == 1)
			dir2 = 3;
		else
			dir2 = dir - 2;

		int ax = x + dx[dir2];
		int ay = y + dy[dir2];

		if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 1)
			return false;
		
		x = ax;
		y = ay;
		return true;
	}
}
