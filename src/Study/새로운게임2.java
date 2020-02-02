package Study;

import java.util.Scanner;

public class 새로운게임2 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int K;
	static int[][] chessMap;
	static int[] horse_X;
	static int[] horse_Y;
	static int[] horse_Dir; // 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
	static int[][][] ridingHorse;

	public static void main(String[] args) {
//		첫째 줄에 체스판의 크기 N, 말의 개수 K가 주어진다. 둘째 줄부터 N개의 줄에 체스판의 정보가 주어진다. 체스판의 정보는 정수로 이루어져 있고, 각 정수는 칸의 색을 의미한다. 0은 흰색, 1은 빨간색, 2는 파란색이다.
//
//		다음 K개의 줄에 말의 정보가 1번 말부터 순서대로 주어진다. 말의 정보는 세 개의 정수로 이루어져 있고, 순서대로 행, 열의 번호, 이동 방향이다. 행과 열의 번호는 1부터 시작하고, 
//		
//		이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
//		
//		같은 칸에 말이 두 개 이상 있는 경우는 입력으로 주어지지 않는다.

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		chessMap = new int[N + 1][N + 1];
		horse_X = new int[K + 1];
		horse_Y = new int[K + 1];
		horse_Dir = new int[K + 1]; // 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
		ridingHorse = new int[N + 1][N + 1][K + 1];
		int roundCnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chessMap[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= K; i++) {
			horse_X[i] = sc.nextInt();
			horse_Y[i] = sc.nextInt();
			horse_Dir[i] = sc.nextInt() - 1;
			ridingHorse[horse_X[i]][horse_Y[i]][1] = i;
		}
		loop: while (roundCnt <= 1000) {
			roundCnt++; // round 증가
//			System.out.println(roundCnt);
			for (int i = 1; i <= K; i++) { // round에 따른 1~K 말의 의동
				int ax = horse_X[i] + dx[horse_Dir[i]];
				int ay = horse_Y[i] + dy[horse_Dir[i]];
//				System.out.println(i+"가 여기로" + ax + " " + ay + " " + horse_Dir[i]);
				if (ax == 0 || ax == N + 1 || ay == 0 || ay == N + 1 || chessMap[ax][ay] == 2) {
//					System.out.println(i+"내가 들어왔다.");
					horse_Dir[i] = swapDir(horse_Dir[i]);
//					System.out.println(i+"내가 들어왔다.");
				}
				ax = horse_X[i] + dx[horse_Dir[i]];
				ay = horse_Y[i] + dy[horse_Dir[i]]; // 이거 두개 위의 if문에 올려도됨
//				System.out.println(i + "번째" + ax + " " + ay + "방향은" + horse_Dir[i]);

				if (ax == 0 || ax == N + 1 || ay == 0 || ay == N + 1 || chessMap[ax][ay] == 2)
					continue;
				
//				System.out.println(ax + " " + ay + " " + "나는" + i+"번째입니다.");
				if (chessMap[ax][ay] == 0) { // 0번 흰색의 경우
					whiteMap(horse_X[i], horse_Y[i], ax, ay, i);
				} else if (chessMap[ax][ay] == 1) { // 1번 빨간색인 경우
					redMap(horse_X[i], horse_Y[i], ax, ay, i);
				}
				
				if (endCheck(ax, ay)) { // 말이 모두 올라가있는 상태면 break; -1 출력
					break loop;
				}
//				System.out.println(ridingHorse[1][1][1] + " "+ridingHorse[1][1][2] + " "+ridingHorse[1][1][3] + " "+ridingHorse[1][1][4] + " ");
//				System.out.println(ridingHorse[1][2][1] + " "+ridingHorse[1][2][2] + " "+ridingHorse[1][2][3] + " "+ridingHorse[1][2][4] + " ");
//				System.out.println(ridingHorse[1][3][1] + " "+ridingHorse[1][3][2] + " "+ridingHorse[1][3][3] + " "+ridingHorse[1][3][4] + " ");
//				System.out.println(ridingHorse[1][4][1] + " "+ridingHorse[1][4][2] + " "+ridingHorse[1][4][3] + " "+ridingHorse[1][4][4] + " ");
//				
//				System.out.println(1+" " + horse_X[1] + " " + horse_Y[1] + "방향은" + horse_Dir[1]);
//				System.out.println( horse_X[2] + " " + horse_Y[2] + "방향은" + horse_Dir[2]);
//				System.out.println(horse_X[3] + " " + horse_Y[3] + "방향은" + horse_Dir[3]);
//				System.out.println( horse_X[4] + " " + horse_Y[4] + "방향은" + horse_Dir[4]);
				System.out.println(roundCnt);
				System.out.println(i);
				for (int j = 1; j <= K; j++) {
					System.out.println(j + "번째" + horse_X[j] + " " + horse_Y[j] + " " + horse_Dir[j]);
				}
				System.out.println();
				
			}
		}
		System.out.println(roundCnt);
	}

	static void whiteMap(int x, int y, int ax, int ay, int horse) {
//		A번 말이 이동하려는 칸이
//		흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
//		A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
//		예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.

		int cnt = 0;
		int cnt2 = 0;
//		System.out.println(" ++ " +ridingHorse[x][y][1]);
//		System.out.println(ridingHorse[ax][ay][1]);
//		System.out.println(horse);
		for (int i = 1; i <= K; i++) {
			if (ridingHorse[x][y][i] == horse)
				break;
			cnt++;
		}
		for (int i = 1; i <= K; i++) {
			if (ridingHorse[ax][ay][i] == 0)
				break;
			cnt2++;
		}
//		System.out.println(cnt);
//		System.out.println(cnt2);
		for (int i = 1; i <= K; i++) {
			if (ridingHorse[x][y][i + cnt] == 0)
				break;
			ridingHorse[ax][ay][i + cnt2] = ridingHorse[x][y][i + cnt];
			horse_X[ridingHorse[x][y][i + cnt]] = ax;
			horse_Y[ridingHorse[x][y][i + cnt]] = ay;
			ridingHorse[x][y][i + cnt] = 0;
		}
	}

	static void redMap(int x, int y, int ax, int ay, int horse) { // 얘가 이상한거같다.
//		빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
//		A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
//		A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
		int cnt = 0;
		int cnt2 = 0;
		int cnt3 = 1;
		for (int i = 1; i <= K; i++) {
			if (ridingHorse[x][y][i] == horse)
				break;
			cnt++;
		}
		for(int i =1 ; i <=K ; i++) {
			if(ridingHorse[x][y][i] == 0)
				break;
			cnt3++;
		}
		for (int i = 1; i <= K; i++) {
			if (ridingHorse[ax][ay][i] == 0)
				break;
			cnt2++;
		}
		for (int i = 1 + cnt; i <= (cnt3 - cnt) / 2; i++) { // 하나밖에 없는데 엉뚱한게 돌아가고 있어. 지금 이 경우는 뒤에 꽉 차있을 경우잖아.
			int tmp = ridingHorse[x][y][i];
			ridingHorse[x][y][i] = ridingHorse[x][y][cnt3 + 1 - i];
			ridingHorse[x][y][cnt3 + 1 - i] = tmp;
		}
		for (int i = 1; i <= K; i++) {
			System.out.println("1  " +ridingHorse[x][y][1]);
			if (ridingHorse[x][y][i + cnt] == 0)
				break;
			ridingHorse[ax][ay][i + cnt2] = ridingHorse[x][y][i + cnt];
			horse_X[ridingHorse[x][y][i + cnt]] = ax;
			horse_Y[ridingHorse[x][y][i + cnt]] = ay;
			ridingHorse[x][y][i + cnt] = 0;
		}
		
	}

	static boolean endCheck(int x, int y) {
		if (ridingHorse[x][y][K] != 0) {
			return true;
			}
		return false;
	}

	static int swapDir(int horse_Dir) {
		if (horse_Dir == 0)
			return 1;
		if (horse_Dir == 1)
			return 0;
		if (horse_Dir == 2)
			return 3;
		if (horse_Dir == 3)
			return 2;
		return -1;
	}

}
