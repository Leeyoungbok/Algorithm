package Study;

import java.util.Scanner;

class sharkInfo {
	boolean alive;
	int moveCheck;
	int x;
	int y;
	int s;
	int d;
	int z;

	sharkInfo(boolean alive, int moveCheck, int x, int y, int s, int d, int z) {
		this.alive = alive;
		this.moveCheck = moveCheck;
		this.x = x;
		this.y = y;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

public class A형_낚시왕 {
	static int N, M, sharkCnt, fishingKing = 0;
	static int[][] map;
	static sharkInfo[] list;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		sharkCnt = sc.nextInt();
		list = new sharkInfo[sharkCnt + 1];
		if(sharkCnt == 0) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 1; i <= sharkCnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[i] = new sharkInfo(true, 0, x, y, sc.nextInt(), sc.nextInt(), sc.nextInt());
			map[x][y] = i;
		}

		for (int i = 0; i < M; i++) {
			fishing();
			sharkMove();
		}
		System.out.println(ans);
		sc.close();
	}

	static void fishing() {
		fishingKing++; // ���������� �Ű���
		for (int i = 1; i <= N; i++) {
			if (map[i][fishingKing] != 0) { // 0�ΰŸ� list�� map���� ������
				ans += list[map[i][fishingKing]].z;
				list[map[i][fishingKing]].alive = false;
				map[i][fishingKing] = 0;
				break;
			}
		}
	}

	static void sharkMove() {
		for (int i = 1; i < list.length; i++) {
			if (!list[i].alive) continue;
			int cnt = 0;
			if(list[i].d == 1 || list[i].d == 2)
				cnt = list[i].s%(2*N-2);
			else if(list[i].d == 3 || list[i].d == 4)
				cnt = list[i].s%(2*M-2);
			list[i].moveCheck++;
			int ax = list[i].x;
			int ay = list[i].y;
			if(map[ax][ay] == i)
				map[ax][ay] = 0;
			for (int j = 0; j < cnt; j++) {
				ax = list[i].x + dx[list[i].d];
				ay = list[i].y + dy[list[i].d];
				if (ax < 1 || ax > N || ay < 1 || ay > M) {
					changeDir(i);
					ax = list[i].x + dx[list[i].d];
					ay = list[i].y + dy[list[i].d];
				}
				list[i].x = ax;
				list[i].y = ay;
			}
			if (map[ax][ay] == 0) {
				map[ax][ay] = i;
			} else {
				if (list[map[ax][ay]].moveCheck < list[i].moveCheck) {
					map[ax][ay] = i;
				}else {
					if (list[map[ax][ay]].z > list[i].z) {
						list[i].alive = false;
					} else {
						list[map[ax][ay]].alive = false;
						map[ax][ay] = i;
					}
				}
			}
		}
	}

	static void changeDir(int i) {
		if (list[i].d == 1)
			list[i].d = 2;
		else if (list[i].d == 2)
			list[i].d = 1;
		else if (list[i].d == 3)
			list[i].d = 4;
		else if (list[i].d == 4)
			list[i].d = 3;
	}
}
