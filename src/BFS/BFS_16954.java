package BFS;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_16954 {
	static boolean[][] map, used;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new boolean[9][9];
		
		for(int i = 1 ; i <= 8 ; i++) {
			String input = sc.next();
			for(int j = 1 ; j <= 8 ; j++) {
				map[i][j] = input.charAt(j - 1) == '.' ? true : false;
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(8, 1));
		
		while(!queue.isEmpty()) {
			used = new boolean[9][9];
			int size = queue.size();
			for(int s = 0 ; s < size ; s++) {
				Point point = queue.poll();
				if(!map[point.x][point.y]) {
					continue;
				}
				
				if(s == 0) {
					queue.add(new Point(point.x, point.y));
					used[point.x][point.y] = true;
				}
				
				for(int k = 0 ; k < 8 ; k++) {
					int ax = point.x + dx[k];
					int ay = point.y + dy[k];
					
					if(ax < 1 || ax > 8 || ay < 1 || ay > 8 || used[ax][ay]) continue;
					if(!map[ax][ay]) continue;
					
					if(ax == 1 && ay == 8) {
						System.out.println(1);
						System.exit(0);
					}
					
					queue.add(new Point(ax, ay));
					used[ax][ay] = true;
				}
			}
			
			wallChange();
		}
		
		System.out.println(0);
	}
	
	private static void wallChange() {
		boolean[][] tmp = new boolean[9][9];
		
		for(int i = 1 ; i <= 8 ; i++) {
			for(int j = 1 ; j <= 8 ; j++) {
				if(i == 1) {
					tmp[i][j] = true;
				}else {
					tmp[i][j] = map[i - 1][j];
				}
			}
		}
		
		for(int i = 1 ; i <= 8 ; i++) {
			for(int j = 1 ; j <= 8 ; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}

}
