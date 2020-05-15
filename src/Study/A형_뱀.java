package Study;

import java.util.Scanner;

public class A형_뱀 {
	static int N, headIdx, tailIdx, head_Dir;
	static int appleCnt, orderCnt,cnt;
	static int[][] snake = new int[10001][2];
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 }; // �� �� �� ��
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		appleCnt = sc.nextInt();

		map = new int[N + 1][N + 1];

		for (int i = 0; i < appleCnt; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			map[n1][n2] = -1;
		}
		snake[headIdx][0] = snake[headIdx][1] = 1;
		snake[tailIdx][0] = snake[tailIdx][1] = 1;
		map[1][1] = 1;
		orderCnt = sc.nextInt();
		int orderNum = 0;
		int orderDir = 0;
		for (int i = 1; i <= orderCnt+1; i++) {
			if(i == orderCnt+1) {
				orderNum = 99999;
			}else {
				orderNum = sc.nextInt();
				orderDir = sc.next().charAt(0);
			}
			
			while(true) {
				if(cnt == orderNum) {
					break;
				}
				cnt++;
				int ax = snake[headIdx][0] + dx[head_Dir];
				int ay = snake[headIdx][1] + dy[head_Dir];
				
				if(ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] == 1) {
					System.out.println(cnt);
					System.exit(0);
				}
				if(map[ax][ay] != -1) {
					map[snake[tailIdx][0]][snake[tailIdx][1]] = 0;
					tailIdx++;
				}
				map[ax][ay] = 1;
				headIdx++;
				snake[headIdx][0] = ax;
				snake[headIdx][1] = ay;
			}
			if(orderDir == 'D') {
				head_Dir = (head_Dir + 1)%4;
			}else {
				head_Dir = head_Dir - 1 == -1 ? 3 : head_Dir - 1;
			}
			
		}
		sc.close();
	}
}
