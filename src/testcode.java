import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class testcode {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int[][] map;
	static boolean[][] used;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int ans = 0;
		for(int tc = 1 ; tc <= TC ; tc++) {
			map = new int[11][11];
			used = new boolean[11][11];
			Deque<Point> queue = new LinkedList<>();
			ans = 0;
			for(int i = 1 ; i <= 10 ; i++) {
				for(int j = 1 ; j <= 10 ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 1 ; i <= 10 ; i++) {
				for(int j = 1 ; j <= 10 ; j++) {
					if(used[i][j] || map[i][j] == 0) continue;
					queue.add(new Point(i,j));
					used[i][j] = true;
					ans++;
					while(!queue.isEmpty()) {
						Point p = queue.poll();
						
						for(int k = 0 ; k < 8 ; k++) {
							int ax = p.x + dx[k];
							int ay = p.y + dy[k];
							
							if(ax < 1 || ax > 10 || ay < 1 || ay > 10 || used[ax][ay] || map[ax][ay] == 0) continue;
							
							queue.add(new Point(ax,ay));
							used[ax][ay] = true;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}
}
