package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A형_아기상어_ver2 {
	static int N, cnt = 0, ans = 0;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		PriorityQueue<Shark> queue = new PriorityQueue<>();
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0 && map[i][j] != 9)
					cnt++;
				if(map[i][j] == 9) {
					map[i][j] = 0;
					queue.add(new Shark(i, j, 2, 0, 0));
				}
			}
		}
		boolean[][] used = new boolean[N+1][N+1];
		bfs : while(!queue.isEmpty()) {
			int Size = queue.size();
			for(int size = 0 ; size < Size ; size++) {
				if(cnt == 0 ) break bfs;
				Shark s = queue.poll();
				used[s.x][s.y] = true;
				if(map[s.x][s.y] != 0 && map[s.x][s.y] < s.size ) {
					map[s.x][s.y] = 0; 
					ans += s.dist;
					cnt--;
					used = new boolean[N+1][N+1];
					queue.clear();
					if(s.eatCnt + 1 == s.size) {
						queue.add(new Shark(s.x, s.y, s.size + 1, 0, 0));
					}else {
						queue.add(new Shark(s.x, s.y, s.size, s.eatCnt+1, 0));
					}
					break;
				}
				for(int k = 0 ; k < 4 ; k++) {
					int ax = s.x + dx[k];
					int ay = s.y + dy[k];
					if(ax < 1 || ax > N || ay < 1 || ay > N || used[ax][ay] || map[ax][ay] > s.size) continue; // ���� ����� ���
					queue.add(new Shark(ax, ay, s.size, s.eatCnt, s.dist+1));
					used[ax][ay] = true;
				}
			}
		}
		System.out.println(ans);
	}
	
	static class Shark implements Comparable<Shark>{
		int x, y, size, eatCnt, dist;
		Shark(int x, int y, int size, int eatCnt, int dist){
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatCnt = eatCnt;
			this.dist = dist;
		}
		@Override
		public int compareTo(Shark o) {
			if(this.dist > o.dist) return 1;
			if(this.dist < o.dist) return -1; 
			if(this.x > o.x) return 1;
			if(this.x < o.x) return -1;
			return this.y - o.y;
		}
	}
	
}
