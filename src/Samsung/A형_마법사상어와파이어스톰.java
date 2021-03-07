package Samsung;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A형_마법사상어와파이어스톰 {

	static int inputN, N, Q;
	static int[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		inputN = sc.nextInt();
		Q = sc.nextInt();

		N = (int) Math.pow(2, inputN);
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < Q; i++) {
			int L = (int) Math.pow(2, sc.nextInt());
			turn(L);
			melting();
		}
		
		
		
		// Q1. total sum
		// Q2. bfs
		Queue<Point> queue = new LinkedList<>();
		boolean[][] used = new boolean[N][N];
		int maxGroup = 0;
		int total = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 0 || used[i][j]) continue;
				
				queue.add(new Point(i, j));
				used[i][j] = true;
				int groupCnt = 0;
				while(!queue.isEmpty()) {
					Point point = queue.poll();
					total += map[point.x][point.y];
					groupCnt++;
					
					for(int k = 0 ; k < 4 ; k++) {
						int ax = point.x + dx[k];
						int ay = point.y + dy[k];
						
						if(ax < 0 || ax >= N || ay < 0 || ay >= N || used[ax][ay] || map[ax][ay] == 0) continue;
						
						used[ax][ay] = true;
						queue.add(new Point(ax, ay));
					}
				}
				if(groupCnt == 0) continue;
				
				maxGroup = maxGroup < groupCnt ? groupCnt : maxGroup;
			}
		}
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
		System.out.println(total + "\n" + maxGroup);
	}

	private static void turn(int L) {
		if(L == 1) return;
		
		int[][] temp = new int[N][N];
		for(int outerI = 0 ; outerI < N ; outerI += L) {
			for(int outerJ = 0 ; outerJ < N ; outerJ += L) {
		
				for(int i = 0 ; i < L ; ++i) {
					for(int j = 0 ; j < L ; ++j) {
						temp[j][L - 1 - i] = map[outerI + i][outerJ + j];
					}
				}
				
				for(int i = 0 ; i < L ; ++i) {
					for(int j = 0 ; j < L ; ++j) {
						map[outerI + i][outerJ + j] = temp[i][j];
					}
				}
				
			}
		}
		
	}

	private static void melting() {
		int[][] temp = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 0;
				
				for(int k = 0 ; k < 4 ; k++) {
					int ax = i + dx[k];
					int ay = j + dy[k];
					
					if(ax < 0 || ax >= N || ay < 0 || ay >= N || temp[ax][ay] == 0) continue;
					
					cnt++;
				}
				
				if(cnt >= 3) continue;
				map[i][j]--;
			}
		}
	}
}
