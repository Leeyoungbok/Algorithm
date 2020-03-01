package Study;

import java.util.ArrayList;
import java.util.Scanner;

class cctvInfo {
	int x;
	int y;
	int num;
	int info;

	cctvInfo(int x, int y, int num, int info) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.info = info;
	}
}

public class AÇü_°¨½Ã {
	static int N, M, ans;
	static int[][] map, copyMap;
	static ArrayList<cctvInfo> list = new ArrayList<>();

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		copyMap = new int[N + 1][M + 1];

		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0 && map[i][j] != 6)
					list.add(new cctvInfo(i, j, map[i][j], 0));
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0)
					ans++;
			}
		}
//		for (cctvInfo c : list) {
//			System.out.println(c.x + " " + c.y);
//		}
		if (list.size() != 0) {
			solve(0);
			System.out.println(ans);
		}
		else
			System.out.println(ans);
		sc.close();
	}

	static void solve(int idx) {
		if (idx == list.size()) {
			int cnt = 0;
			copy();
			for (int i = 0; i < list.size(); i++) {
				makeDir(list.get(i));
			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(copyMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
//			System.out.println();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (copyMap[i][j] == 0)
						cnt++;
				}
			}
			ans = ans > cnt ? cnt : ans;
			return;
		}

		list.get(idx).info = 1;
		solve(idx + 1);
		if (list.get(idx).num != 5) {
			list.get(idx).info = 2;
			solve(idx + 1);
		}
		if (list.get(idx).num != 2 || list.get(idx).num != 5) {
			list.get(idx).info = 3;
			solve(idx + 1);
			list.get(idx).info = 4;
			solve(idx + 1);
		}
	}

	static void copy() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static void makeDir(cctvInfo cctv) {
//		System.out.println(cctv.x + " " + cctv.y + " " + cctv.num +" " + cctv.info);
		if (cctv.num == 1) {
			int x = cctv.x;
			int y = cctv.y;
			while (true) {
				int ax = x + dx[cctv.info];
				int ay = y + dy[cctv.info];
				if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
					break;
				copyMap[ax][ay] = -1;
				x = ax;
				y = ay;

			}
		} else if (cctv.num == 2) {
			if (cctv.info == 1) {
				int x = cctv.x;
				int y = cctv.y;
				while (true) {
					int ax = x + dx[1];
					int ay = y + dy[1];

					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
				x = cctv.x;
				y = cctv.y;
				while (true) {
					int ax = x + dx[3];
					int ay = y + dy[3];
					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
			} else {
				int x = cctv.x;
				int y = cctv.y;
				while (true) {
					int ax = x + dx[2];
					int ay = y + dy[2];
					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
				x = cctv.x;
				y = cctv.y;
				while (true) {
					int ax = x + dx[4];
					int ay = y + dy[4];
					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
			}
		} else if (cctv.num == 3) {
			int x = cctv.x;
			int y = cctv.y;
			int k = cctv.info;
			int k2 = cctv.info + 1;
			if (k2 == 5)
				k2 = 1;
			while (true) {
				int ax = x + dx[k];
				int ay = y + dy[k];
				if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
					break;
				copyMap[ax][ay] = -1;
				x = ax;
				y = ay;
			}
			x = cctv.x;
			y = cctv.y;
			while (true) {
				int ax = x + dx[k2];
				int ay = y + dy[k2];
				if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
					break;
				copyMap[ax][ay] = -1;
				x = ax;
				y = ay;
			}
		} else if (cctv.num == 4) {
			for (int k = 1; k < 5; k++) {
				if (k == cctv.info)
					continue;
				int x = cctv.x;
				int y = cctv.y;
				while (true) {
					int ax = x + dx[k];
					int ay = y + dy[k];
					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
			}
		} else if (cctv.num == 5) {
			for (int k = 1; k < 5; k++) {
				int x = cctv.x;
				int y = cctv.y;
				while (true) {
					int ax = x + dx[k];
					int ay = y + dy[k];
					if (ax < 1 || ax > N || ay < 1 || ay > M || copyMap[ax][ay] == 6)
						break;
					copyMap[ax][ay] = -1;
					x = ax;
					y = ay;
				}
			}
		}
	}
}
