package Study;

import java.util.Scanner;

public class ���ο����2 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int K;
	static int[][] chessMap;
	static int[] horse_X;
	static int[] horse_Y;
	static int[] horse_Dir; // 1���� ������� ��, ��, ��, ���� �ǹ̸� ���´�.
	static int[][][] ridingHorse;

	public static void main(String[] args) {
//		ù° �ٿ� ü������ ũ�� N, ���� ���� K�� �־�����. ��° �ٺ��� N���� �ٿ� ü������ ������ �־�����. ü������ ������ ������ �̷���� �ְ�, �� ������ ĭ�� ���� �ǹ��Ѵ�. 0�� ���, 1�� ������, 2�� �Ķ����̴�.
//
//		���� K���� �ٿ� ���� ������ 1�� ������ ������� �־�����. ���� ������ �� ���� ������ �̷���� �ְ�, ������� ��, ���� ��ȣ, �̵� �����̴�. ��� ���� ��ȣ�� 1���� �����ϰ�, 
//		
//		�̵� ������ 4���� �۰ų� ���� �ڿ����̰� 1���� ������� ��, ��, ��, ���� �ǹ̸� ���´�.
//		
//		���� ĭ�� ���� �� �� �̻� �ִ� ���� �Է����� �־����� �ʴ´�.

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		chessMap = new int[N + 1][N + 1];
		horse_X = new int[K + 1];
		horse_Y = new int[K + 1];
		horse_Dir = new int[K + 1]; // 1���� ������� ��, ��, ��, ���� �ǹ̸� ���´�.
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
			roundCnt++; // round ����
//			System.out.println(roundCnt);
			for (int i = 1; i <= K; i++) { // round�� ���� 1~K ���� �ǵ�
				int ax = horse_X[i] + dx[horse_Dir[i]];
				int ay = horse_Y[i] + dy[horse_Dir[i]];
//				System.out.println(i+"�� �����" + ax + " " + ay + " " + horse_Dir[i]);
				if (ax == 0 || ax == N + 1 || ay == 0 || ay == N + 1 || chessMap[ax][ay] == 2) {
//					System.out.println(i+"���� ���Դ�.");
					horse_Dir[i] = swapDir(horse_Dir[i]);
//					System.out.println(i+"���� ���Դ�.");
				}
				ax = horse_X[i] + dx[horse_Dir[i]];
				ay = horse_Y[i] + dy[horse_Dir[i]]; // �̰� �ΰ� ���� if���� �÷�����
//				System.out.println(i + "��°" + ax + " " + ay + "������" + horse_Dir[i]);

				if (ax == 0 || ax == N + 1 || ay == 0 || ay == N + 1 || chessMap[ax][ay] == 2)
					continue;
				
//				System.out.println(ax + " " + ay + " " + "����" + i+"��°�Դϴ�.");
				if (chessMap[ax][ay] == 0) { // 0�� ����� ���
					whiteMap(horse_X[i], horse_Y[i], ax, ay, i);
				} else if (chessMap[ax][ay] == 1) { // 1�� �������� ���
					redMap(horse_X[i], horse_Y[i], ax, ay, i);
				}
				
				if (endCheck(ax, ay)) { // ���� ��� �ö��ִ� ���¸� break; -1 ���
					break loop;
				}
//				System.out.println(ridingHorse[1][1][1] + " "+ridingHorse[1][1][2] + " "+ridingHorse[1][1][3] + " "+ridingHorse[1][1][4] + " ");
//				System.out.println(ridingHorse[1][2][1] + " "+ridingHorse[1][2][2] + " "+ridingHorse[1][2][3] + " "+ridingHorse[1][2][4] + " ");
//				System.out.println(ridingHorse[1][3][1] + " "+ridingHorse[1][3][2] + " "+ridingHorse[1][3][3] + " "+ridingHorse[1][3][4] + " ");
//				System.out.println(ridingHorse[1][4][1] + " "+ridingHorse[1][4][2] + " "+ridingHorse[1][4][3] + " "+ridingHorse[1][4][4] + " ");
//				
//				System.out.println(1+" " + horse_X[1] + " " + horse_Y[1] + "������" + horse_Dir[1]);
//				System.out.println( horse_X[2] + " " + horse_Y[2] + "������" + horse_Dir[2]);
//				System.out.println(horse_X[3] + " " + horse_Y[3] + "������" + horse_Dir[3]);
//				System.out.println( horse_X[4] + " " + horse_Y[4] + "������" + horse_Dir[4]);
				System.out.println(roundCnt);
				System.out.println(i);
				for (int j = 1; j <= K; j++) {
					System.out.println(j + "��°" + horse_X[j] + " " + horse_Y[j] + " " + horse_Dir[j]);
				}
				System.out.println();
				
			}
		}
		System.out.println(roundCnt);
	}

	static void whiteMap(int x, int y, int ax, int ay, int horse) {
//		A�� ���� �̵��Ϸ��� ĭ��
//		����� ��쿡�� �� ĭ���� �̵��Ѵ�. �̵��Ϸ��� ĭ�� ���� �̹� �ִ� ��쿡�� ���� ���� A�� ���� �÷����´�.
//		A�� ���� ���� �ٸ� ���� �ִ� ��쿡�� A�� ���� ���� �ִ� ��� ���� �̵��Ѵ�.
//		���� ���, A, B, C�� �׿��ְ�, �̵��Ϸ��� ĭ�� D, E�� �ִ� ��쿡�� A�� ���� �̵��� �Ŀ��� D, E, A, B, C�� �ȴ�.

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

	static void redMap(int x, int y, int ax, int ay, int horse) { // �갡 �̻��ѰŰ���.
//		�������� ��쿡�� �̵��� �Ŀ� A�� ���� �� ���� �ִ� ��� ���� �׿��ִ� ������ �ݴ�� �ٲ۴�.
//		A, B, C�� �̵��ϰ�, �̵��Ϸ��� ĭ�� ���� ���� ��쿡�� C, B, A�� �ȴ�.
//		A, D, F, G�� �̵��ϰ�, �̵��Ϸ��� ĭ�� ���� E, C, B�� �ִ� ��쿡�� E, C, B, G, F, D, A�� �ȴ�.
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
		for (int i = 1 + cnt; i <= (cnt3 - cnt) / 2; i++) { // �ϳ��ۿ� ���µ� �����Ѱ� ���ư��� �־�. ���� �� ���� �ڿ� �� ������ ����ݾ�.
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
