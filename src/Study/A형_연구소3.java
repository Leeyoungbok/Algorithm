package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class virus{
	int x;
	int y;
	virus(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class A형_연구소3 {
	static int N, M, ans=Integer.MAX_VALUE;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] used;
	static ArrayList<virus> list = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) { // 만약에 그 자리가 비활성 바이러스면 -3,
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		copyMap = new int[N+1][N+1];
		used = new boolean[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)
					map[i][j] = -1;
				if(map[i][j] == 2) {
					map[i][j] = -2;
					list.add(new virus(i,j));
				}
			}
		}
		solve(0,0);
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
		sc.close();
	}	
	
	static void solve(int idx, int cnt) {
		if(cnt == list.size() - M) {
			copy();
			bfs();
			int max = count();
			if(max != -1)
				ans = ans > max ? max : ans;
			return;
		}
		
		for(int i = idx ; i < list.size() ; i++) {
			map[list.get(i).x][list.get(i).y] = -3;
			solve(i+1, cnt+1);
			map[list.get(i).x][list.get(i).y] = -2;
		}
	}
	
	static void bfs() {
		Deque<virus> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(copyMap[i][j] == -2) {
					queue.add(new virus(i,j));
					copyMap[i][j] = 0;
					used[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			virus v = queue.poll();
			for(int k = 0 ; k < 4 ; k++) {
				int ax = v.x + dx[k];
				int ay = v.y + dy[k];
				if(ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] == 1) continue;
				if(copyMap[ax][ay] == -3) {
					used[ax][ay] = true;
					queue.add(new virus(ax, ay));
					copyMap[ax][ay] = copyMap[v.x][v.y] + 1;
				}else if(copyMap[ax][ay] == 0 && !used[ax][ay]) {
					queue.add(new virus(ax,ay));
					copyMap[ax][ay] = copyMap[v.x][v.y] + 1; 
				}
			}
		}
	}
	
	
	
	static void copy() { // mapCopy
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	
	static int count() {
		int ret = 0;
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(used[i][j]) {
					used[i][j] = false;
					continue;
				}
				if(copyMap[i][j] == 0)
					return -1;
				if(copyMap[i][j] > ret) {
					ret = copyMap[i][j];
				}
			}
		}
		return ret;
	}
}
