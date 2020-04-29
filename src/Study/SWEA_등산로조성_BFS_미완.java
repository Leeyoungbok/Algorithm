package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_등산로조성_BFS_미완 {
	static int N, K, Ans;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static boolean[][][] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt(); K = sc.nextInt(); Ans = 0; map = new int[N+1][N+1];
			used = new boolean[N+1][N+1][K+2];
			int max = 0;
			Deque<Mountain> queue = new LinkedList<>(); 
			
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					map[i][j] = sc.nextInt();
					max = max < map[i][j] ? map[i][j] : max;
				}
			}
			
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(map[i][j] == max) {
						used[i][j][0] = true;
						queue.add(new Mountain(i, j, max, false));
					}
				}
			}
			
			while(!queue.isEmpty()) {
				Ans++;
				int Size = queue.size();
				
				for(int size = 0 ; size < Size ; size++) {
					Mountain m = queue.poll();
//					System.out.println(Ans + " " + m.x + " " + m.y + " " + m.cur);
					for(int k = 0 ; k < 4 ; k++) {
						int ax = m.x + dx[k];
						int ay = m.y + dy[k];
						
						if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
						
						if(m.check) {
							if(map[ax][ay] < m.cur && !used[ax][ay][K+1]) {
								queue.add(new Mountain(ax, ay, map[ax][ay], true));
								used[ax][ay][K+1] = true;
							}
						}else if(!m.check) {
							if(map[ax][ay] < m.cur && !used[ax][ay][0]) {
								queue.add(new Mountain(ax, ay, map[ax][ay], false));
								used[ax][ay][0] = true;
							}
							if(map[ax][ay] >= m.cur) {
								for(int a = 1 ; a <= K ; a++) {
									if(map[ax][ay] - a < m.cur) {
										queue.add(new Mountain(ax, ay, map[ax][ay] - a, true));
										used[ax][ay][a] = true;
									}
								}
							}
						}
					}
					
				}
			}
			System.out.println("#" + tc + " " + Ans);
		}
		
	}
	
	public static class Mountain{
		int x, y, cur;
		boolean check;
		Mountain(int x, int y, int cur, boolean check){
			this.x = x;
			this.y = y;
			this.cur = cur;
			this.check = check;
		}
	}

}

/*
 * 
 * 9
 * 4 4
8 3 9 5
4 6 8 5
8 1 5 1
4 9 5 5
 * 
 * */
