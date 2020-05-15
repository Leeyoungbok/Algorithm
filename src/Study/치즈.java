package Study;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 치즈 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		int totalCnt = 0, memoAns;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) totalCnt++;
			}
		}
		
		boolean[][] used;
		int round = 0;
		Deque<Point> queue = new LinkedList<>();
		while(true) {
			round++;
			used = new boolean[N+1][M+1];
			queue.add(new Point(1,1));
			used[1][1] = true;
			memoAns = 0;
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				for(int k = 0 ; k < 4 ; k++) {
					int ax = p.x + dx[k];
					int ay = p.y + dy[k];
					
					if(ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay]) continue;
					if(map[ax][ay] == 1) {
						used[ax][ay] = true;
						totalCnt--;
						map[ax][ay] = 0;
						memoAns++;
					}else if(map[ax][ay] == 0) {
						used[ax][ay] = true;
						queue.add(new Point(ax, ay));
					}
				}
			}
//			System.out.println(totalCnt);
//			for(int i = 1 ; i <= N ; i++) {
//				for(int j=  1; j <=M ; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}System.out.println();
//			if(round == 3)
//				break;
			if(totalCnt == 0) {
				System.out.println(round + "\n" + memoAns);
				break;
			}
		}
	}
}
