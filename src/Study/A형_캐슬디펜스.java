package Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class enermy implements Comparable<enermy>{
	int x;
	int y;
	enermy(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(enermy o) {
		return this.y - o.y;
	}
}
public class A형_캐슬디펜스 {
	static int N, M, D, ans;
	static int[][] map;
	static int[][] copyMap;
	static int res[];
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0}; // 상 좌 우 하
	static boolean[][] used;
	static Deque<enermy> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N+2][M+1]; // 맨 윗칸에는 0 내려옴
		copyMap = new int[N+2][M+1];
		res = new int[M];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(0, 0);
		System.out.println(ans);
		sc.close();
	}
	
	static void solve(int idx, int k) {
		if(idx == 3) {
			int cnt = play();
			ans = cnt > ans ? cnt : ans;
			return;
		}
		
		for(int i = k ; i < M ; i++) {
				res[i] = 1;
				solve(idx+1, i+1);
				res[i] = 0;
		}
	}
	
	static int play() {
		int cnt = N;
		int ret = 0;
		copy();
		while(cnt > 0) {
			ret += bfs();
			down();
			cnt--;
		}
		return ret;
	}
	
	static int bfs() {
		int ret = 0;
		ArrayList<enermy> list = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			if(res[i] == 1) {
				int cnt = 0;
				list = new ArrayList<>();
				used = new boolean[N+1][M+1];
				queue.add(new enermy(N+1,i+1)); // 0부터 시작이니 +1해서 집어넣음
				loop : while(!queue.isEmpty()) {
					int size = queue.size();
					cnt++;
					for(int s = 0 ; s < size ; s++) {
						enermy e = queue.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int ax = e.x + dx[k];
							int ay = e.y + dy[k];
							if(ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay]) continue;
							if(copyMap[ax][ay] == 1 || copyMap[ax][ay] == -1) {
								list.add(new enermy(ax,ay));
							}
							queue.add(new enermy(ax,ay));
							used[ax][ay] = true;
						}
					}
					if(list.size() != 0) {
						Collections.sort(list);
						enermy a = list.remove(0);
						if(copyMap[a.x][a.y] == 1) {
							ret++;
							copyMap[a.x][a.y] = -1; 
						}
						queue.clear();
						break loop;
					}
					if(cnt==D) {
						queue.clear();
						break loop;
					}
						
				}
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				if(copyMap[i][j] == -1)
					copyMap[i][j] = 0;
			}
		}
		return ret;
	}
	
	static void down() {
		for(int i = N ; i > 0 ; i--) {
			for(int j = 1 ; j <= M ; j++) {
				copyMap[i][j] = copyMap[i-1][j];
			}
		}
	}
	
	static void copy() {
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
