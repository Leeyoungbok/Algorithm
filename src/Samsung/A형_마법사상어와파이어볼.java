package Samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class A형_마법사상어와파이어볼 {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, K;

	static ArrayList<Fire>[][] listMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		listMap = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				listMap[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			Fire fire = new Fire(r, c, m, s, d, false);
			listMap[r][c].add(fire);
		}

		for (int k = 0; k < K; k++) {
			move();
			sum();
		}
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				for(Fire f : listMap[i][j]) {
					ans += f.m;
				}
			}
		}
		System.out.println(ans);
	}

	static private void move() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(!listMap[i][j].isEmpty()) {
					for(int k = 0 ; k < listMap[i][j].size() ; k++) {
						if(listMap[i][j].get(k).alive) continue;
						Fire fire = listMap[i][j].remove(k--);
						int r = fire.r + dx[fire.d]*fire.s;
						int c = fire.c + dy[fire.d]*fire.s;
						r = r > N ? r % N : r;
						r = r < 1 ? N - (r * -1 % N) : r;
						c = c > N ? c % N : c;
						c = c < 1 ? N - (c * -1 % N) : c;
						fire.r = r;
						fire.c = c;
						fire.alive = true;
						listMap[r][c].add(fire);
					}
				}
			}
		}
	}
	static private void sum() {
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1; j <= N ; j++) {
				if(listMap[i][j].size() == 1) {
					listMap[i][j].get(0).alive = false;
				} else if(listMap[i][j].size() >= 2) {
					int size = listMap[i][j].size();
					int m = 0;
					int s = 0;
					int d = -1;
					boolean check = false;
					for(int k = 0 ; k < listMap[i][j].size() ; k++) {
						Fire fire = listMap[i][j].remove(k--);
						m += fire.m;
						s += fire.s;
						if(d == -1) {
							d = fire.d % 2;
						}else {
							if(d != fire.d%2) {
								check = true;
							}
						}
					}
					if(m / 5 == 0) continue;
					if(check) d = 1; else d = 0;
					for(int k = 0 ; k < 4 ; k++) {
						Fire fire = new Fire(i,j,m/5,s/size,d + k*2,false);
						listMap[i][j].add(fire);
					}
				}
			}
		}
	}

	static class Fire {
		int r, c, m, s, d;
		boolean alive;
		public Fire(int r, int c, int m, int s, int d, boolean alive) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.alive = alive;
		}
	}
}