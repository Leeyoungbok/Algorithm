package Study;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_무선충전 {
	static int N, M;
	static int[][][] map;
	static int[][] dir;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			map = new int[11][11][9];
			N = sc.nextInt(); M = sc.nextInt();
			dir = new int[N][2];
			for(int i = 0 ; i < N ; i++) {
				dir[i][0] = sc.nextInt();
			}
			for(int i = 0 ; i < N ; i++) {
				dir[i][1] = sc.nextInt();
			}
			int[] battery = new int[M+1];
			for(int i = 1 ; i <= M ; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int n3 = sc.nextInt();
				int n4 = sc.nextInt();
				battery[i] = n4;
				
				Deque<Point> queue = new LinkedList<>();
				boolean[][] used = new boolean[11][11];
				map[n2][n1][i] = i;
				queue.add(new Point(n2,n1));
				used[n2][n1] = true;
				while(!queue.isEmpty()) {
					int Size = queue.size();
					if(n3-- == 0)
						break;
					for(int size = 0 ; size < Size ; size++) {
						Point p = queue.poll();
						for(int k = 1 ; k < 5 ; k++) {
							int ax = p.x + dx[k];
							int ay = p.y + dy[k];
							if(ax < 1 || ax > 10 || ay < 1 || ay > 10 || used[ax][ay]) continue;
							map[ax][ay][i] = i;
							used[ax][ay] = true;
							queue.add(new Point(ax, ay));
						}
					}
				}
			}
//			
//			for(int k = 1 ; k <= 3 ; k++) {
//				for(int i = 1 ; i <= 10 ; i++) {
//					for(int j = 1 ; j <= 10 ; j++) {
//						System.out.print(map[i][j][k] +  " ");
//					}System.out.println();
//				}System.out.println();
//			}
			int[] memo = new int[16];
			int[] memoVal = new int[16];
			int ax = 1, ay = 1, bx = 10, by = 10, max = 0;
			for(int i = 0 ; i < N+1 ; i++) {
				int maxVal = 0;
				for(int j = 0 ; j < M ; j++) {
					memo[j] = map[ax][ay][j+1];
					memoVal[j] = battery[map[ax][ay][j+1]];
					memo[j+M] = map[bx][by][j+1];
					memoVal[j+M] = battery[map[bx][by][j+1]];
				}
				
			
				for(int j = 0 ; j < M ; j++) {
					for(int k = M ; k < 2*M ; k++) {
						if(memo[j] != memo[k]) {
							maxVal = maxVal < memoVal[j] + memoVal[k] ? memoVal[j] + memoVal[k] : maxVal;
						}
					}
				}
				max += maxVal;
				if(i == N) break;
				ax += dx[dir[i][0]];
				ay += dy[dir[i][0]];
				bx += dx[dir[i][1]];
				by += dy[dir[i][1]];
//				System.out.println(ax + " " + ay + " " + bx + " " + by + " " + max);
			}
			System.out.println("#"+tc + " " + max);
		}
	}
}
