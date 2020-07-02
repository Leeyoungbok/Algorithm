package Study;

import java.util.Scanner;

public class A형_청소년상어 {
	static class Fish {
		int x, y, dir;
		boolean aliveCheck;
		
		Fish(int x, int y, int dir, boolean aliveCheck) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.aliveCheck = aliveCheck;
		}
	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int[][] map = new int[4][4];
	static int[][] copyMap = new int[4][4];
	static Fish[] fish = new Fish[17];
	static int[] shark = new int[4];
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int fishNum = sc.nextInt();
				int dir = sc.nextInt() - 1;

				if (i == 0 && j == 0) {
					ans = fishNum;
					shark[0] = fishNum;
					shark[1] = i;
					shark[2] = j;
					shark[3] = dir;
					fish[fishNum] = new Fish(0, 0, dir, false);
					map[i][j] = fishNum;
					continue;
				}
				fish[fishNum] = new Fish(i, j, dir, true);
				map[i][j] = fishNum;
			}
		}

		solve(ans, false);
		System.out.println(ans);
	}

	static void solve(int eat, boolean endCheck) {
		if (endCheck)
			return;

		if (eat > ans)
			ans = eat;

		// 물고기가 움직인다
		
		// 기존의 맵을 복사해놓음 - 원상태로 복구하기 위해서.
		
		for(int i = 0 ; i < 4 ; i ++) {
			copyMap[i] = map[i].clone();
		}
		
		for (int i = 1; i < 17; i++) {
			// 1. 한칸만 움직임.
			// 2. 이동할 수 있는 칸은 빈칸 or 다른 물고기가 있는 칸
			// 3. 이동할 수 없는 칸은 상어가 있거나 공간의 경계를 넘는 칸
			for(int j = 0 ; j < 8 ; j ++) { // 총 8 번만 발생할 수 있음
				if (i == shark[0] || !fish[i].aliveCheck)
					continue;
				
				int curDir = fish[i].dir;
				
				int ax = fish[i].x + dx[curDir];
				int ay = fish[i].y + dy[curDir];
				
				if (ax < 0 || ax > 4 || ay < 0 || ay > 4 || map[ax][ay] == shark[0]) {
					curDir = curDir - 1 == -1 ? 7 : curDir - 1;
					continue;
				}
				
				
				Fish exchangeFish = fish[map[ax][ay]];
				if(exchangeFish.aliveCheck) {
					int[] exchangeFishInfo = new int[4];
					
					exchangeFishInfo[0] = i;
					exchangeFishInfo[1] = fish[i].x;
					exchangeFishInfo[2] = fish[i].y;
					exchangeFishInfo[3] = curDir;

					map[fish[i].x][fish[i].y] = map[ax][ay];
					map[ax][ay] = exchangeFishInfo[0];
					
					fish[i].x = exchangeFish.x;
					fish[i].y = exchangeFish.y;
					fish[i].dir = exchangeFish.dir;
					
					exchangeFish.x = exchangeFishInfo[1];
					exchangeFish.y = exchangeFishInfo[2];
					exchangeFish.dir = exchangeFishInfo[3];
					break;
				}
			}
		}
		// 상어가 움직인다
		int moveCnt = 0;
		for(int i = 0 ; i < 4 ; i ++) {
			
		}
		// 재귀로 넘어간다

		// 원래 상태로 돌려준다!
	}
	
}
