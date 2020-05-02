package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AÇü_±¸½½Å»Ãâ2 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] used;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N+1][M+1];
		used = new boolean[N+1][M+1][N+1][M+1];
		Deque<Ball> queue = new LinkedList<>();
		int n1 = 0, n2 = 0, n3 = 0, n4 = 0, endX = 0, endY = 0, cnt = 0;
		for (int i = 1; i <= N; i++) {
			String input = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1);
				if(map[i][j] == 'R') {
					n1 = i;
					n2 = j;
				}else if(map[i][j] == 'B') {
					n3 = i;
					n4 = j;
				}else if(map[i][j] == 'O') {
					endX = i;
					endY = j;
				}
			}
		}
		
		queue.add(new Ball(n1, n2, n3, n4));
		used[n1][n2][n3][n4] = true;
		
		while(!queue.isEmpty()) {
			if(cnt++ == 10) break;
			int Size = queue.size();
			for(int size = 0 ; size < Size ; size++) {
				Ball b = queue.poll();
				for(int k = 0 ; k < 4 ; k++) {
					boolean rCheck = false, bCheck = false;
					boolean rEndCheck = false, bEndCheck = false;
					int rx = b.rx, ry = b.ry, bx = b.bx, by = b.by;
					while(true) {
						if(rCheck && bCheck) {
							if(bEndCheck) break;
							if(rEndCheck) {
								System.out.println(cnt);
								return;
							}
							if(!used[rx][ry][bx][by]) {
								queue.add(new Ball(rx,ry,bx,by));
								used[rx][ry][bx][by] = true;
							}
							break;
						}
						
						if(!bCheck) {
							if(map[bx+dx[k]][by+dy[k]] == '#') {
								bCheck = true;
							}else if(map[bx+dx[k]][by+dy[k]] == 'O') {
								bCheck = true;
								bEndCheck = true;
								continue;
							}else {
								bx += dx[k];
								by += dy[k];
							}
						}
						
						if(!rCheck) {
							if(map[rx+dx[k]][ry+dy[k]] == '#' || (rx+dx[k] == bx && ry+dy[k] == by)) 
								rCheck = true;
							else if(map[rx+dx[k]][ry+dy[k]] == 'O') {
								rCheck = true;
								rEndCheck = true;
							}else {
								rx += dx[k];
								ry += dy[k];
							}
						}
						if(rCheck && !rEndCheck && rx == bx && ry == by) {
							bx -= dx[k];
							by -= dy[k];
							bCheck = true;
						}
						
						
					}
				}
			}
		}
		System.out.println(-1);
	}

	static class Ball {
		int rx, ry, bx, by;

		Ball(int rx, int ry, int bx, int by) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
}
