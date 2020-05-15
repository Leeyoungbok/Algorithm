package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static boolean[][][] used;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][M+1];
		used = new boolean[N+1][M+1][1 << 6];
		Deque<Moon> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			String str = br.readLine();
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = str.charAt(j-1);
				if(map[i][j] == '0') {
					queue.add(new Moon(i, j, 0));
					used[i][j][0] = true;
				}
			}
		}
		int cnt = 0;
		while(!queue.isEmpty()) {
			int Size = queue.size();
			for(int size = 0 ; size < Size ; size++) {
				Moon moon = queue.poll();
//				System.out.println(moon.x + " " + moon.y + " " + moon.cur);
				
				for(int k = 0 ; k < 4 ; k++) {
					int ax = moon.x + dx[k];
					int ay = moon.y + dy[k];
					if(ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay][moon.cur] || map[ax][ay] == '#') continue;
					
					if(map[ax][ay] == '1') {
						System.out.println(cnt+1);
						return;
					}
					
					int key = moon.cur;
					
					if('A' <= map[ax][ay] && map[ax][ay] <= 'Z') {
						if((key & 1<<(map[ax][ay]-'A')) == 0) continue;
					}else if('a' <= map[ax][ay] && map[ax][ay] <= 'z') {
						key = key | 1<<(map[ax][ay]-'a');
					}
					
					used[ax][ay][key] = true;
					queue.add(new Moon(ax, ay, key));
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}
	static class Moon{
		int x, y, cur;
		Moon(int x, int y, int cur){
			this.x = x;
			this.y = y;
			this.cur = cur;
		}
	}

}
