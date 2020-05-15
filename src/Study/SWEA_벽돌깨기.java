package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class stone {
	int x, y, cnt;

	stone(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class SWEA_벽돌깨기 {
	static int K, N, M, ans,a,b,c;
	static int[] res;
	static int[][] map, copyMap;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			K = sc.nextInt();
			M = sc.nextInt();
			N = sc.nextInt();
			ans = N*M;
			map = new int[N][M];
			copyMap = new int[N][M];
			res = new int[K];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			solve(0);
			System.out.println("#" + tc + " " + ans);
			sc.close();
		}
	}

	static void solve(int idx) {
		if (idx == K) {
			if(ans == 0)
				return;
//			if(res[0] == 4 && res[1] == 5 && res[2] == 4) {
				getCopy();
				operation();
				getAns();
//			}
			return;
		}

		for (int i = 0; i < M; i++) {
			res[idx] = i;
			solve(idx + 1);
		}
	}

	static void operation() {
		Deque<stone> queue = new LinkedList<>();
		for (int k = 0; k < K; k++) {
			for (int i = 0 ; i < N ; i++) {
				if (copyMap[i][res[k]] != 0) {
					queue.add(new stone(i, res[k], copyMap[i][res[k]]));
					copyMap[i][res[k]] = 0;
					while (!queue.isEmpty()) {
						stone s = queue.poll();
						for (int ii = 0; ii < 4; ii++) {
							int x = s.x;
							int y = s.y;
							for (int j = 1; j < s.cnt; j++) {
								int ax = x + dx[ii];
								int ay = y + dy[ii];
								if(ax < 0 || ax > N-1 || ay < 0 || ay > M-1) continue;
								if(copyMap[ax][ay] != 0)
									queue.add(new stone(ax,ay,copyMap[ax][ay]));
									copyMap[ax][ay] = 0;
								x = ax;
								y = ay;
							}
						}
					}
				break;
				}
			}
			stoneDown();
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < M ; j++) {
//					System.out.print(copyMap[i][j] + " ");
//				}System.out.println();
//			}System.out.println();
		}
	}

	static void getAns() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] != 0)
					sum++;
			}
		}
		ans = ans > sum ? sum : ans;
//		if(sum == 5) {
//			System.out.println(res[0] + " " + res[1] + " " + res[2]);
//		}
			
	}

	static void stoneDown() {
		for(int j = 0 ; j < M ; j++) {
			boolean check = false;
			for(int i = 0 ; i < N ; i++) {
				if(check && copyMap[i][j] == 0) {
					for(int k = i ; k > 0 ; k--) {
						copyMap[k][j] = copyMap[k-1][j];
					}
					copyMap[0][j] = 0;
				}
				if(copyMap[i][j] != 0) 
					check = true;
			}
		}
	}
	
	static void getCopy() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}


