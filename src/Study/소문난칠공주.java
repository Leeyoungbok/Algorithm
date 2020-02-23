package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class member {
	int x;
	int y;

	member(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 소문난칠공주 {
	static int N = 5;
	static char[][] map = new char[N + 1][N + 1];
	static boolean[][] used = new boolean[N + 1][N + 1];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans = 0;
	static ArrayList<member> list = new ArrayList<member>();
	static int totalCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j );
				if (map[i][j] == 'S') {
					totalCnt++;
				}
			}
		}
		if (totalCnt < 4)
			System.out.println(0);
		else {
			solve(0, 0, 0);
			System.out.println(ans);
		}
		sc.close();
	}

	static void solve(int idx, int cnt, int n) {
		if (cnt - n >= 4)
			return;
		
		
		if (cnt == 7 && n >= 4) {
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(used[i][j]) {
						if(bfs(7,i,j)) {
							ans++;
						}
						return;
					}
				}
			}
			return;
		}

		for(int i = idx ; i < 5*5 ; i++) {
			int x = i/5;
			int y = i%5;
			if(!used[x][y]) {
				used[x][y] = true;
				if(map[x][y] == 'S')
					solve(i+1, cnt+1,n+1);
				else
					solve(i+1, cnt+1,n);
				used[x][y] = false;
			}
		}
	}

//
	static boolean bfs(int cnt, int x, int y) {
		Deque<member> queue = new LinkedList<member>();
		boolean[][] check = new boolean[5][5];
		queue.add(new member(x, y));
		check[x][y] = true;
		int n = 1;
		while (!queue.isEmpty()) {
			member m = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ax = m.x + dx[k];
				int ay = m.y + dy[k];
				if (ax < 0 || ax > 4 || ay <0 || ay > 4 || !used[ax][ay] || check[ax][ay])
					continue;
				check[ax][ay] = true;
				queue.add(new member(ax, ay));
				n++;
			}
		}
		if (n == cnt)
			return true;
		else
			return false;
	}
}