package SW_Expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_탈주범검거 {
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] used;
	
	static int[][] dx = {{-1,1,0,0},{1,-1},{0,0},{-1,0},{0,1},{0,1},{-1,0}};
	static int[][] dy = {{0,0,-1,1},{0,0},{1,-1},{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N+1][M+1];
			used = new boolean[N+1][M+1];
			
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= M ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(R+1, C+1));
			int cnt = 1;
			used[R+1][C+1] = true;
			while(!queue.isEmpty()) {
				int queueSize = queue.size();
				if(cnt++ == L) break;
				for(int size = 0 ; size < queueSize ; size++) {
					Point p = queue.poll();
					int dir = map[p.x][p.y]-1;
					for(int k = 0 ; k < dx[dir].length ; k++) {
						int ax = p.x + dx[dir][k];
						int ay = p.y + dy[dir][k];
						
						if(ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay] || map[ax][ay] == 0) continue;
						
						boolean check = false;
						int checkDir = map[ax][ay]-1;
						for(int checkK = 0 ; checkK < dx[checkDir].length ; checkK++) {
							int checkX = ax + dx[checkDir][checkK];
							int checkY = ay + dy[checkDir][checkK];
							if(checkX < 1 || checkX > N || checkY < 1 || checkY > M) continue;
							if(checkX == p.x && checkY == p.y) {
								check = true;
								break;
							}
							
						}
						if(check) {
							queue.add(new Point(ax, ay));
							used[ax][ay] = true;
						}
					}
				}
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(used[i][j]) ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
