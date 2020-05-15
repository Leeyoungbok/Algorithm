package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Sepo implements Comparable<Sepo>{
	int x, y, power, time, cnt;
	boolean check;
	Sepo(int x, int y, int power, int time, int cnt, boolean check){
		this.x = x;
		this.y = y;
		this.power = power;
		this.time = time;
		this.cnt = cnt;
		this.check = check;
	}
	@Override
	public int compareTo(Sepo o) {
		if(this.cnt > o.cnt)
			return 1;
		if(this.cnt < o.cnt)
			return -1;
		else
			return o.power - this.power;
	}
}

public class SWEA_줄기세포배양 {
	static int N, M, K;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[2*K+N+1][2*K+M+1];
			PriorityQueue<Sepo> queue = new PriorityQueue<>();
			
			for(int i = K+1 ; i <= K+N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = K+1 ; j <= K+M ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						queue.add(new Sepo(i, j, map[i][j], 0, 0, false));
					}
				}
			}
			int cnt = 0;
			while(!queue.isEmpty() && cnt < K) {
				cnt++;
				int Size = queue.size();
				for(int size = 0 ; size < Size ; size++) {
					Sepo s = queue.poll();
					if(!s.check && s.time < s.power) {
						if(s.time+1 == s.power) {
							queue.add(new Sepo(s.x, s.y, s.power, s.time+1, cnt, true));
						}else
							queue.add(new Sepo(s.x, s.y, s.power, s.time+1, cnt, false));
					}else if(s.check && s.time == s.power) {
						if(s.time != 1)
							queue.add(new Sepo(s.x, s.y, s.power, s.time-1, cnt, true));
						for(int k = 0 ; k < 4 ; k++) {
							int ax = s.x + dx[k];
							int ay = s.y + dy[k];
							if(ax < 0 || ax > 2*K+N || ay < 0 || ay > 2*K+M || map[ax][ay] != 0) continue;
							map[ax][ay]=s.power;
							queue.add(new Sepo(ax, ay, s.power, 0, cnt, false));
						}
					}else if(s.check && s.time > 0) {
						if(s.time != 1)
							queue.add(new Sepo(s.x, s.y, s.power, s.time-1, cnt, true));
					}
				}
			}
			System.out.println("#" + tc + " " + queue.size());
		}
	}
}


