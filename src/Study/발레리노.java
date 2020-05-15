package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 발레리노 {
	
	static class Jump implements Comparable<Jump>{
		int x, y, cnt;
		Jump(int x, int y, int cnt){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Jump o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[][][] used;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][M+1];
		used = new int[N+1][M+1][10000000];
		PriorityQueue<Jump> queue = new PriorityQueue<>();
		
		int endX = 0;
		int endY = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 3) {
					queue.add(new Jump(i,j,0));
					used[i][j][0] = 1;
				}
				if(map[i][j] == 4) {
					endX = i;
					endY = j;
				}
			}
		}
		int max = Integer.MAX_VALUE;
		int ret1 = 0;
		while(!queue.isEmpty()) {
			Jump jump = queue.poll();
			System.out.println(jump.x + " " + jump.y + " " + jump.cnt);
			
			if(jump.cnt == max && jump.x == endX && jump.y == endY) {
				ret1++;
				continue;
			}
			if(max == Integer.MAX_VALUE && jump.x == endX && jump.y == endY) {
				max = jump.cnt;
				ret1++;
				break;
			}
			for(int k = 0 ; k < 8 ; k++) {
				int ax = jump.x + dx[k];
				int ay = jump.y + dy[k];
				
				if(ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == 3) continue;
				if(used[ax][ay][jump.cnt] != 0 && map[ax][ay] == 1) {
					used[ax][ay][jump.cnt] += used[jump.x][jump.y][jump.cnt];
				}else if(used[ax][ay][jump.cnt] == 0 && map[ax][ay] == 1) {
					queue.add(new Jump(ax,ay,jump.cnt));
					used[ax][ay][jump.cnt] += used[jump.x][jump.y][jump.cnt]; 
				}else if(used[ax][ay][jump.cnt+1] == 0 && map[ax][ay] != 1) {
					queue.add(new Jump(ax,ay,jump.cnt+1));
					used[ax][ay][jump.cnt+1] += used[jump.x][jump.y][jump.cnt];
				}else if(used[ax][ay][jump.cnt+1] != 0 && map[ax][ay] != 1) {
					used[ax][ay][jump.cnt+1] += used[jump.x][jump.y][jump.cnt];
				}
			}
		}
		if(ret1 == 0)
			System.out.println(-1);
		else {
			System.out.println(ret1);
			System.out.println(used[endX][endY][ret1]);
		}
		
		
	}

}
