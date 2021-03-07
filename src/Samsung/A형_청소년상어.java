package Samsung;

import java.util.Scanner;

public class A형_청소년상어 {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sharkInfo = new int[3];  // 0:x, 1:y, 2:dir
		int[][] fishInfo = new int[17][3]; 
		int[][] map = new int[5][5];
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				int n1 = sc.nextInt(), n2 = sc.nextInt() - 1;
				map[i][j] = n1;
				fishInfo[n1][0] = i;
				fishInfo[n1][1] = j;
				fishInfo[n1][2] = n2;
			}
		}
		
		answer = map[1][1];
		sharkInfo[0] = 1;
		sharkInfo[1] = 1;
		sharkInfo[2] = fishInfo[map[1][1]][2];
		fishInfo[map[1][1]][2] = -1;
		map[1][1] = 0;
		solve(answer, map, sharkInfo, fishInfo);
		System.out.println(answer);
	}

	static void solve(int totalEat, int[][] map, int[] sharkInfo, int[][] fishInfo) {
		answer = answer < totalEat ? totalEat : answer;

		
		int[] copySharkInfo = new int[3];
		copySharkInfo = copyShark(sharkInfo);
		int[][] copyFishInfo = new int[17][3];
		copyFishInfo = copyFish(fishInfo);
		int[][] copyMap = new int[5][5];
		copyMap = copyMap(map);
		fishMove(copyMap, copySharkInfo, copyFishInfo);
		
		for (int i = 1; i < 4; i++) {
			int ax = copySharkInfo[0] + dx[copySharkInfo[2]]*i;
			int ay = copySharkInfo[1] + dy[copySharkInfo[2]]*i;
			if(ax < 1 || ax > 4 || ay < 1 || ay > 4 || copyMap[ax][ay] == 0) continue;
			int tmp1 = copyFishInfo[copyMap[ax][ay]][2];
			int tmp2 = copyMap[ax][ay];
			int tmp3 = copySharkInfo[0];
			int tmp4 = copySharkInfo[1];
			int tmp5 = copySharkInfo[2];
			copySharkInfo[0] = ax;
			copySharkInfo[1] = ay;
			copySharkInfo[2] = copyFishInfo[copyMap[ax][ay]][2];
			copyFishInfo[tmp2][2] = -1;
			copyMap[ax][ay] = 0;
			solve(totalEat + tmp2, copyMap, copySharkInfo, copyFishInfo);
			copySharkInfo[0] = tmp3;
			copySharkInfo[1] = tmp4;
			copySharkInfo[2] = tmp5;
			
			copyMap[ax][ay] = tmp2;
			copyFishInfo[copyMap[ax][ay]][2] = tmp1;
		}
	}

	static void fishMove(int[][] map, int[] sharkInfo, int[][] fishInfo) {
		for (int fishNum = 1; fishNum < 17; fishNum++) {
			if (fishInfo[fishNum][2] == -1)
				continue;
			int x = fishInfo[fishNum][0];
			int y = fishInfo[fishNum][1];
			int dir = fishInfo[fishNum][2];

			int ax = -1;
			int ay = -1;

			for (int k = 0; k < 8; k++) {
				ax = x + dx[dir];
				ay = y + dy[dir];
				if (ax < 1 || ax > 4 || ay < 1 || ay > 4 || (ax == sharkInfo[0] && ay == sharkInfo[1])) {
					dir = (dir + 1) % 8;
				} else {
					fishInfo[fishNum][0] = ax;
					fishInfo[fishNum][1] = ay;
					fishInfo[fishNum][2] = dir;
					if (map[ax][ay] != 0) {
						fishInfo[map[ax][ay]][0] = x;
						fishInfo[map[ax][ay]][1] = y;
					}
					
					int tmp = map[x][y];
					map[x][y] = map[ax][ay];
					map[ax][ay] = tmp;

					break;
				}
			}
		}
	}

	static int[] copyShark(int[] from) {
		int[] to = new int[3];
		for (int i = 0; i < 3; i++) {
			to[i] = from[i];
		}
		return to;
	}

	static int[][] copyFish(int[][] from) {
		int[][] to = new int[17][3];
		for (int i = 1; i < 17; i++) {
			for (int j = 0; j < 3; j++) {
				to[i][j] = from[i][j];
			}
		}
		return to;
	}

	static int[][] copyMap(int[][] from) {
		int[][] to = new int[5][5];
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				to[i][j] = from[i][j];
			}
		}
		return to;
	}
}
