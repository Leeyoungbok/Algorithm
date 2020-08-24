package Study;

import java.util.Scanner;

public class A형_어른상어 {

	/* ------------------------------------------ */
	static class Shark {
		int curX, curY, curDir;
		int[][] priority;
		boolean liveCheck;

		public Shark(int curX, int curY, int curDir, int[][] priority, boolean liveCheck) {
			this.curX = curX;
			this.curY = curY;
			this.curDir = curDir;
			this.priority = priority;
			this.liveCheck = liveCheck;
		}
	}
	/* ------------------------------------------ */

	static int N, M, K, totalCnt;
	static int[][] map;
	static int[][][] smellMap;
	static Shark[] shark;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// init

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		totalCnt = M;
		map = new int[N + 1][N + 1];
		smellMap = new int[N + 1][N + 1][2];
		shark = new Shark[M + 1];

		int[][] arr0 = new int[M + 1][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int n1 = sc.nextInt();
				map[i][j] = n1;
				if (n1 == 0)
					continue;
				arr0[n1][0] = i;
				arr0[n1][1] = j;
				smellMap[i][j][0] = n1;
				smellMap[i][j][1] = K;
			}
		}

		int[] arr1 = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			arr1[i] = sc.nextInt() - 1;
		}

		for (int i = 1; i <= M; i++) {
			int[][] arr2 = new int[4][4];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					arr2[j][k] = sc.nextInt() - 1;
				}
			}
			shark[i] = new Shark(arr0[i][0], arr0[i][1], arr1[i], arr2, true);
		}

		// Algorithm

		for (int i = 1; i <= 1000; i++) {

//			for (int a = 1; a <= N; a++) {
//				for (int b = 1; b <= N; b++) {
//					System.out.print(smellMap[a][b][0]+""+smellMap[a][b][1] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

//			for (int a = 1; a <= N; a++) {
//				for (int b = 1; b <= N; b++) {
//					System.out.print(map[a][b] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int sharkNum = 1; sharkNum <= M; sharkNum++) {
				if (!shark[sharkNum].liveCheck)
					continue; // 죽었으면 패쓰
				move(sharkNum);

			}

			smellMark();

			if (totalCnt == 1) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);

	}

	static void move(int sharkNum) {
		// 1. 상어가 이동을 하는데, 자기가 보고 있는 방향으로 이동함.
		// 만약 그 공간에 smell이 없다면 이동
		// smell이 있다면 다음 단계로 이동

		int curX = shark[sharkNum].curX;
		int curY = shark[sharkNum].curY;
		int curDir = shark[sharkNum].curDir;
		// 현재 상어의 위치

		int ax = -1;
		int ay = -1;
		int aDir = -1;

		boolean check = false;
		for (int k = 0; k < 4; k++) {
			ax = curX + dx[shark[sharkNum].priority[curDir][k]];
			ay = curY + dy[shark[sharkNum].priority[curDir][k]];
			aDir = shark[sharkNum].priority[curDir][k];
			if (ax < 1 || ax > N || ay < 1 || ay > N)
				continue;
			if (smellMap[ax][ay][0] != 0)
				continue;

			if (map[ax][ay] != 0) {
				if (map[ax][ay] < sharkNum) {
					shark[sharkNum].liveCheck = false;
					totalCnt--;
					map[curX][curY] = 0;
					return;
				} else {
					shark[map[ax][ay]].liveCheck = false;
					totalCnt--;
					map[ax][ay] = sharkNum;
					map[curX][curY] = 0;
					shark[sharkNum].curX = ax;
					shark[sharkNum].curY = ay;
					shark[sharkNum].curDir = aDir;
				}
			} else {
				map[curX][curY] = 0;
				map[ax][ay] = sharkNum;
				shark[sharkNum].curX = ax;
				shark[sharkNum].curY = ay;
				shark[sharkNum].curDir = aDir;
			}
			check = true;
			break;
		}

		if (!check) { // 냄새가 모두 있는 경우 내가 지나온 공간으로 간다.
			for (int k = 0; k < 4; k++) {
				ax = curX + dx[shark[sharkNum].priority[curDir][k]];
				ay = curY + dy[shark[sharkNum].priority[curDir][k]];
				aDir = shark[sharkNum].priority[curDir][k];
				if (ax < 1 || ax > N || ay < 1 || ay > N)
					continue;
				if (smellMap[ax][ay][0] == sharkNum) {
					map[curX][curY] = 0;
					map[ax][ay] = sharkNum;
					shark[sharkNum].curX = ax;
					shark[sharkNum].curY = ay;
					shark[sharkNum].curDir = aDir;
					break;
				}
			}
		}

	}

	static void smellMark() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (smellMap[i][j][1] != 0) {
					smellMap[i][j][1]--;
					if (smellMap[i][j][1] == 0)
						smellMap[i][j][0] = 0;
				}

				if (map[i][j] != 0) {
					smellMap[i][j][0] = map[i][j];
					smellMap[i][j][1] = K;
				}
			}
		}
	}

}
