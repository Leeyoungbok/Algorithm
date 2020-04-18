package Competition;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Programmers_게임맵최단거리 {
	static int[][] map;
	static boolean[][] used;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[6	][6];
		used = new boolean[6][6];
		System.out.println(map.length);
		System.out.println(map[0].length);
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j =1; j <=5 ;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		Deque<Point> queue = new LinkedList<>();
		
		queue.add(new Point(1,1));
		used[1][1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			answer++;
			for(int s = 0 ; s < size ; s++) {
				Point p = queue.poll();
				
				for(int k = 0 ; k < 4 ; k++) {
					int ax = p.x + dx[k];
					int ay = p.y + dy[k];
					
					if(ax < 1 || ax > map.length-1 || ay < 1 || ay > map[ax].length-1 || used[ax][ay] ||map[ax][ay] == 0) continue;
					
					if(ax == map.length-1 && ay == map[ax].length-1) {
						System.out.println(answer+1);
					}
					queue.add(new Point(ax, ay));
					used[ax][ay] = true;
				}
			}
		}
		System.out.println(-1);
		
	}
	

}
