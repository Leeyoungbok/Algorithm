package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class wall{
	int x;
	int y;
	int destroyNum;
	wall(int x, int y, int destroyNum){
		this.x = x;
		this.y = y;
		this.destroyNum = destroyNum;
	}
}

public class 벽부수고이동하기2 {
	static int N, M, K, ans=1;
	static int[][] map;
	static boolean[][][] used;
	static Deque<wall> queue = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		used = new boolean[N+1][M+1][K+1];
		for(int i = 1 ; i <= N ; i++) {
			String str = br.readLine();
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}
		if(N == 1 && M == 1) {
			System.out.println(1);
			System.exit(0);
		}
		queue.add(new wall(1, 1, 0));
		used[1][1][0] = true;
		if(!bfs()) {
			System.out.println(-1);
		}
	}
	
	static boolean bfs() {
		while(!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			
			for(int s = 0 ; s < size ; s++) {
				wall w = queue.poll();
				for(int k = 0 ; k < 4 ; k++) {
					int ax = w.x + dx[k];
					int ay = w.y + dy[k];
					
					if(ax < 1 || ax > N || ay < 1 || ay > M) continue;
					
					if(ax == N && ay == M) {
						System.out.println(ans);
						System.exit(0);
					}
					if(map[ax][ay] == 0 && !used[ax][ay][w.destroyNum]) {
						queue.add(new wall(ax,ay,w.destroyNum));
						used[ax][ay][w.destroyNum] = true;
					}
					if(w.destroyNum < K) {
						if(map[ax][ay] == 1 && !used[ax][ay][w.destroyNum +1]) {
							queue.add(new wall(ax,ay,w.destroyNum+1));
							used[ax][ay][w.destroyNum+1] = true;
						}
					}
				}
			}
		}
		
		return false;
	}
}

//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1; j <= M ; j++) {
//				System.out.print(map[i][j] + " " );
//			}
//			System.out.println();
//		}
//		System.out.println();