package Competition;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersLev3Prob2 {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(solution(m, n, puddles));
	}

	private static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m];
		boolean[][] used = new boolean[n][m];
		int[] dx = {0,1};
		int[] dy = {1,0};
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0 ; i < puddles.length ; i++) {
			map[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
//		System.out.println(map[n-1][m-1]);
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < m ; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
		queue.add(new Point(0, 0));
		map[0][0] = 1;
		used[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int k = 0 ; k < 2 ; k++) {
				int ax = point.x + dx[k];
				int ay = point.y + dy[k];
				
				if(ax < 0 || ax >= n || ay < 0 || ay >= m || map[ax][ay] == -1) continue;
				map[ax][ay] = (map[point.x][point.y] + map[ax][ay]) % 1000000007;
				if(!used[ax][ay]) {
					queue.add(new Point(ax, ay));
					used[ax][ay] = true;
				}
			}
		}
//		System.out.println(map[n-1][m-1]);
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < m ; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
		
		return map[n-1][m-1];
	}
}
