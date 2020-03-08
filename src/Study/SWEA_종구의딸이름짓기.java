package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Naming implements Comparable<Naming>{
	int x;
	int y;
	int cnt;
	char ch;
	Naming(int x, int y, int cnt, char ch){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.ch = ch;
	}
	@Override
	public int compareTo(Naming o) {
		// TODO Auto-generated method stub
		if(this.cnt == o.cnt)
			return o.ch - this.ch;
		return this.cnt - o.cnt;
	}
	
	
}
public class SWEA_Á¾±¸ÀÇµþÀÌ¸§Áþ±â {
	static int N, M;
	static char[][] map;
	static boolean[][] used;
	static String ans;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N+1][M+1];
			used = new boolean[N+1][M+1];
			ans = "";
			PriorityQueue<Naming> queue = new PriorityQueue<>();
			
			for(int i = 1 ; i <= N ; i++) {
				String str = br.readLine();
				for(int j = 1 ; j <= M ; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			ans += map[1][1];
			queue.add(new Naming(1,1,0,map[1][1]));
			int memoSize = 1;
			boolean check = false;
			while(!queue.isEmpty()) {
				int size = memoSize;
				memoSize = 0;
				char ch = '{';
				for(int s = 0 ; s < size ; s++) {
					Naming name = queue.poll();
					for(int k = 0 ; k < 2 ; k++) {
						int ax = name.x + dx[k];
						int ay = name.y + dy[k];
						
						if( ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay]) continue;
						if((int)ch > (int)map[ax][ay]){
							ch = map[ax][ay];
							memoSize = 1;
							used[ax][ay] = true;
							queue.add(new Naming(ax,ay,name.cnt+1,map[ax][ay]));
						}else if((int)ch == (int)map[ax][ay]) {
							memoSize++;
							used[ax][ay] = true;
							queue.add(new Naming(ax,ay,name.cnt+1,map[ax][ay]));
						}
						if(ax == N && ay == M)
							check = true;
					}
				}
				if(ch != '{')
					ans += ch;
				if(check)
					break;
				int n1 = queue.size();
				for(int i = 0 ; i < n1 - memoSize; i++) {
					queue.poll();
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
