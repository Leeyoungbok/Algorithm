package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class coin {
	int coin01_X;
	int coin01_Y;
	int coin02_X;
	int coin02_Y;

	coin(int coin01_X, int coin01_Y, int coin02_X, int coin02_Y) {
		this.coin01_X = coin01_X;
		this.coin01_Y = coin01_Y;
		this.coin02_X = coin02_X;
		this.coin02_Y = coin02_Y;
	}
}

public class 두동전 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] used;
	static Deque<coin> queue = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N + 1][M + 1];
		used = new boolean[N+1][M+1][N+1][M+1];
		int n1, n2, n3, n4, cnt;
		n1 = n2 = n3 = n4 = cnt = 0;
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
				if (map[i][j] == 'o') {
					cnt++;
					if (cnt == 1) {
						n1 = i;
						n2 = j;
					}
					if (cnt == 2) {
						n3 = i;
						n4 = j;
					}

				}
			}
		}
		queue.add(new coin(n1, n2, n3, n4));
		used[n1][n2][n3][n4] = true;
		used[n3][n4][n1][n2] = true;

		bfs();
		sc.close();
	}

	static void bfs() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			if(cnt > 10) {
				System.out.println(-1);
				return;
			}
			for (int s = 0; s < size; s++) {
				coin c = queue.poll();
//				System.out.println(c.coin01_X + " " + c.coin01_Y + " " + c.coin02_X + " " + c.coin02_Y + " " + cnt);
				for (int k = 0; k < 4; k++) {
					int ax01 = c.coin01_X + dx[k];
					int ay01 = c.coin01_Y + dy[k];
					int ax02 = c.coin02_X + dx[k];
					int ay02 = c.coin02_Y + dy[k];

					if (ax01 == ax02 && ay01 == ay02)
						continue;
					
					boolean check01 = false;
					boolean check02 = false;
					boolean check03 = false;
					boolean check04 = false;

					if (ax01 >= 1 && ax01 <= N && ay01 >= 1 && ay01 <= M) {
						if(map[ax01][ay01] == '#') {
							ax01 = c.coin01_X;
							ay01 = c.coin01_Y;
							check03 = true;
						}
							
					}else
						check01 = true;

					if (ax02 >= 1 && ax02 <= N && ay02 >= 1 && ay02 <= M) {
						if(map[ax02][ay02] == '#') {
							ax02 = c.coin02_X;
							ay02 = c.coin02_Y;
							check04 = true;
						}
					}else
						check02 = true;
					
					if(check01 && check02) // 둘다 떨어지는 경우
						continue;
					
					if(check03 && check04) // 둘다 막히는 경우
						continue;
					
					if((check01 && !check02) || (!check01 && check02)) { // 둘중하나만 떨어진 경우
						System.out.println(cnt);
						return;
					}
					
					if((used[ax01][ay01][ax02][ay02] || used[ax02][ay02][ax01][ay01]))
						continue;
					
					queue.add(new coin(ax01,ay01,ax02,ay02));
					used[ax01][ay01][ax02][ay02] = true;
					used[ax02][ay02][ax01][ay01] = true;
				}
			}

		}
		System.out.println(-1);
	}
}

//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= M ; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();