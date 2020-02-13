package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class square {
	int x;
	int y;
	int cnt;

	square(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_2583 {
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<square> queue = new LinkedList<square>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		used = new boolean[N + 1][M + 1];
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			int n4 = Integer.parseInt(st.nextToken());

			for (int j = n1; j <= n3; j++) {
				for (int k = n2; k <= n4; k++) {
					map[j][k] = 1;
				}
			}
		}
		for(int i = 0 ; i<= N ;i++) {
			for(int j = 0 ; j <=M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}		
		int groupNum = 0;
		for(int i = 0 ; i <= N ; i++) {
			for(int j = 0 ; j <=M ; j++) {
				if(map[i][j]==0 && !used[i][j]) {
					queue.add(new square(i,j));
					groupNum++;
					map[i][j] = groupNum;
					used[i][j] = true;
					while(!queue.isEmpty()) {
						square s = queue.poll();
						
						for(int k = 0 ; k < 3 ; k++) {
							int ax = s.x + dx[k];
							int ay = s.y + dy[k];
							if(ax < 1 || ax > N || ay < 1 || ay > M) continue;
							if(map[ax][ay] == -1 || used[ax][ay]) continue;
							map[ax][ay] = groupNum;
							used[ax][ay] = true;
							queue.add(new square(ax,ay));
						}
					}
				}
			}
		}
		
		int[] ans = new int[groupNum+1];
		for(int i = 0 ; i<= N ;i++) {
			for(int j = 0 ; j <=M ; j++) {
				if(map[i][j] == -1) continue;
				ans[map[i][j]] ++;
			}
		}
		Arrays.sort(ans);
		System.out.println(Arrays.toString(ans));
		System.out.println(groupNum);
		for(int i = 1 ; i <= groupNum ; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
